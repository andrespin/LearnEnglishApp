package android.famme.learnenglishapp.ui.themes.theme;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.databinding.FragmentThemeBinding;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.famme.learnenglishapp.R;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.inject.Inject;


/**
 * Данный фрагмент предназначен для проигрывания аудио, чтобы
 * понять для какой темы нужно проигрывать аудиодорожку,
 * вызывается команда model.getAudioRoad(themeName), где themeName - тема,
 * для которой нужно выбрать аудиодорожку.
 * В методе observeViewModel() подписываемся на объект LiveData, находящийся в
 * классе ViewModel, перемнная Integer i содержит в себе ссылку на нужную аудиодорожку:
 *
 *     private void observeViewModel() {
 *         model.eventGetRoad.observe(getViewLifecycleOwner(), new Observer<Integer>() {
 *             @Override
 *             public void onChanged(Integer i) {
 *                 MEDIA_RES_ID = i;
 *                 mPlayerAdapter.loadMedia(MEDIA_RES_ID);
 *                 Log.d(TAG, "getResourse");
 *             }
 *         });
 *     }
 */

public class ThemeFragment extends Fragment {

    FragmentThemeBinding binding;

    public static final String TAG = "ThemeFragment";
    private int MEDIA_RES_ID = 0;

    private ThemeViewModel model;

    private Boolean isPlaying = false;

    private String themeName;

    private TextView mTextDebug;
    private SeekBar mSeekbarAudio;
    private ScrollView mScrollContainer;
    private PlayerAdapter mPlayerAdapter;
    private boolean mUserIsSeeking = false;

    @Inject
    INavigator navigator;

    View _view;

    public ThemeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThemeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Theme fragment");
        initView(view);
        initViewModel();
        observeViewModel();
        App.instance.appComponent.inject(this);
        themeName = getArguments().getString("themeName");
        String l = themeName.toLowerCase();
        System.out.println("themeName: " + themeName);
        model.getAudioRoad(l);
        binding.toolbarTitle.setText("Тема \"" + themeName + "\"");

        initListeners();
        initializeUI();
        initializeSeekbar();
        initializePlaybackController();
    }

    private void initListeners() {
        binding.mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateThemeToViewPager(view);
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateThemeToExercises(view, themeName);
            }
        });
    }

    private void observeViewModel() {
        model.eventGetRoad.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                MEDIA_RES_ID = i;
                mPlayerAdapter.loadMedia(MEDIA_RES_ID);
                Log.d(TAG, "getResourse");
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: create MediaPlayer");
    }

    @Override
    public void onStop() {
        super.onStop();
        mPlayerAdapter.pause();
    }


    private void initializePlaybackController() {
        MediaPlayerHolder mMediaPlayerHolder = new MediaPlayerHolder(getActivity());
        Log.d(TAG, "initializePlaybackController: created MediaPlayerHolder");
        mMediaPlayerHolder.setPlaybackInfoListener(new PlaybackListener());
        mPlayerAdapter = mMediaPlayerHolder;
        Log.d(TAG, "initializePlaybackController: MediaPlayerHolder progress callback set");
    }

    private void initializeUI() {
        mSeekbarAudio = binding.seekbarAudio;

        binding.imgSpeaker.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isPlaying) {
                            isPlaying = false;
                            mPlayerAdapter.pause();
                            binding.imgSpeaker.setImageResource(R.drawable.ic_round_black);
                        } else {
                            isPlaying = true;
                            mPlayerAdapter.play();
                            binding.imgSpeaker.setImageResource(R.drawable.ic_round_color);
                        }
                    }
                });
    }

    private void initializeSeekbar() {
        mSeekbarAudio.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int userSelectedPosition = 0;

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        mUserIsSeeking = true;
                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            userSelectedPosition = progress;
                        }
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mUserIsSeeking = false;
                        mPlayerAdapter.seekTo(userSelectedPosition);
                    }
                });
    }

    protected void initView(View view) {
        this._view = view;
    }


    private void initViewModel() {
        model = new ViewModelProvider(this).get(ThemeViewModel.class);
    }


    public class PlaybackListener extends PlaybackInfoListener {

        @Override
        public void onDurationChanged(int duration) {
            mSeekbarAudio.setMax(duration);
            Log.d(TAG, String.format("setPlaybackDuration: setMax(%d)", duration));
        }

        @Override
        public void onPositionChanged(int position) {
            if (!mUserIsSeeking) {
                mSeekbarAudio.setProgress(position, true);
                mSeekbarAudio.getProgress();
                Log.d(TAG, String.format("setPlaybackPosition: setProgress(%d)", position));
            }
        }

        @Override
        public void onStateChanged(@State int state) {
            String stateToString = PlaybackInfoListener.convertStateToString(state);
            onLogUpdated(String.format("onStateChanged(%s)", stateToString));
        }

        @Override
        public void onPlaybackCompleted() {
        }

        @Override
        public void onLogUpdated(String message) {

        }

    }

}