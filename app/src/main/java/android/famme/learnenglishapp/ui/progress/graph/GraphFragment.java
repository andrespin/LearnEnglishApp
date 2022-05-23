package android.famme.learnenglishapp.ui.progress.graph;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.data.storage.preferences.IPreferences;
import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.data.storage.room.ResultEntity;
import android.famme.learnenglishapp.databinding.FragmentGraphBinding;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class GraphFragment extends Fragment {

    FragmentGraphBinding binding;

    @Inject
    INavigator navigator;

    @Inject
    ResultDao resultDao;

    @Inject
    IPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGraphBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.instance.appComponent.inject(this);
        initListeners();

        String login = prefs.getLogin();

        Completable
                .complete()
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        ResultEntity res = resultDao.getResultByLogin(login);
                        try {
                            System.out.println("resultEntity.getPersonality()" + convertStrToInt(res.getPersonality()) + " " + res.getPersonality());
                            binding.imgGraph.setData(convertToResultsData(res));
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            binding.imgGraph.setData(getZeroResults());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }

    private ResultsData convertToResultsData(ResultEntity resultEntity) {
        return new ResultsData(
                convertStrToInt(resultEntity.getPersonality()),
                convertStrToInt(resultEntity.getShopping()),
                convertStrToInt(resultEntity.getEducation()),
                convertStrToInt(resultEntity.getFamily()),
                convertStrToInt(resultEntity.getLifestyle()),
                convertStrToInt(resultEntity.getClothes()),
                convertStrToInt(resultEntity.getBooks()),
                convertStrToInt(resultEntity.getCulture()),
                convertStrToInt(resultEntity.getLife()),
                convertStrToInt(resultEntity.getSummer())
        );
    }

    private ResultsData getZeroResults() {
        return new ResultsData(
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
    }

    private int convertStrToInt(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                Integer.parseInt(String.valueOf(c[i]));
                return Integer.parseInt(String.valueOf(c[i]));
            }
        }
        return 0;
    }

    private void initListeners() {
        binding.mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateGraphToViewPager(view);
            }
        });
    }
}
