package android.famme.learnenglishapp.ui.themes.exercises;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentExercisesBinding;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.famme.learnenglishapp.data.storage.tasks.Task;
import android.widget.RadioGroup;

import javax.inject.Inject;

public class ExercisesFragment extends Fragment {

    FragmentExercisesBinding binding;

    ExercisesViewModel model;

    private String themeName;

    Task task;

    View view;

    private String rightAnswer;

    private String userAnswerBool = null;

    @Inject
    INavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExercisesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initView(view);
        inject();
        themeName = getArguments().getString("themeName");
        observeViewModel();
        initListeners();
        initTask();
        model.goForward();
    }

    private void inject() {
        App.instance.appComponent.inject(this);
        App.instance.appComponent.inject(model);
    }

    private void initListeners() {
        binding.mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.goBack();
                binding.editTaskA.setText("");
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userAnswerBool == null) {
                    String userAnswer = binding.editTaskA.getText().toString();
                    model.checkTask(rightAnswer, userAnswer);
                    model.goForward();
                    binding.editTaskA.setText("");
                } else {
                    model.checkTask(rightAnswer, userAnswerBool);
                    model.goForward();
                }
            }
        });

        binding.radioGroup
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int id) {
                        switch (id) {
                            case R.id.radio_true:
                                userAnswerBool = "true";
                                break;
                            case R.id.radio_false:
                                userAnswerBool = "false";
                                break;
                            default:
                                break;
                        }
                    }
                });

    }

    private void observeViewModel() {

        model.eventDisplayTask.observe(getViewLifecycleOwner(), new Observer<Integer>() {

            @Override
            public void onChanged(Integer integer) {

                switch (integer) {

                    case 1:
                        rightAnswer = task.getTask1A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask1());
                        binding.txtTaskQ.setText(task.getTask1Q());
                        binding.editTaskA.setHint(task.getHint1());
                        break;
                    case 2:
                        rightAnswer = task.getTask2A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask2());
                        binding.txtTaskQ.setText(task.getTask2Q());
                        binding.editTaskA.setHint(task.getHint2());
                        break;
                    case 3:
                        rightAnswer = task.getTask3A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask3());
                        String str = task.getTask3Q();
                        Spanned txt = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY);
                        binding.txtTaskQ.setText(txt);
                        binding.editTaskA.setHint(task.getHint3());
                        break;
                    case 4:
                        rightAnswer = task.getTask4A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask4());
                        binding.txtTaskQ.setText(task.getTask4Q());
                        str = task.getTask4Q();
                        txt = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY);
                        binding.txtTaskQ.setText(txt);
                        binding.editTaskA.setHint(task.getHint4());
                        break;
                    case 5:
                        rightAnswer = task.getTask5A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask5());
                        str = task.getTask5Q();
                        txt = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY);
                        binding.txtTaskQ.setText(txt);
                        binding.editTaskA.setHint(task.getHint5());
                        break;
                    case 6:
                        rightAnswer = task.getTask6A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask6());
                        str = task.getTask6Q();
                        txt = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY);
                        binding.txtTaskQ.setText(txt);
                        binding.editTaskA.setHint(task.getHint6());
                        break;
                    case 7:
                        rightAnswer = task.getTask7A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask7());
                        str = task.getTask7Q();
                        txt = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY);
                        binding.txtTaskQ.setText(txt);
                        binding.editTaskA.setHint(task.getHint7());
                        break;
                    case 8:
                        rightAnswer = task.getTask8A();
                        binding.editTaskA.setVisibility(View.VISIBLE);
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask8());
                        str = task.getTask8Q();
                        txt = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY);
                        binding.txtTaskQ.setText(txt);
                        binding.editTaskA.setHint(task.getHint8());
                        break;
                    case 9:
                        rightAnswer = task.getTask9A().toString();
                        binding.radioGroup.setVisibility(View.VISIBLE);
                        binding.editTaskA.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask9());
                        binding.txtTaskQ.setText(task.getTask9Q());
                        System.out.println("task.getTask9A().toString() " + task.getTask9A().toString());
                        break;
                    case 10:
                        rightAnswer = task.getTask10A().toString();
                        System.out.println("task.getTask10A().toString() " + task.getTask10A().toString());
                        binding.radioGroup.setVisibility(View.VISIBLE);
                        binding.editTaskA.setVisibility(View.GONE);
                        binding.txtTask.setText(task.getTask10());
                        binding.txtTaskQ.setText(task.getTask10Q());
                        binding.editTaskA.setHint(task.getHint8());
                        binding.btnNext.setText("Проверить");
                        break;

                    case 11:
                        displayResult();
                        break;
                }
            }
        });

        model.eventReturnToThemes.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                model.saveResult(themeName);
                navigator.navigateExercisesToViewPager(view);
            }
        });

        model.eventReturnToAudio.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                navigator.navigateExercisesToTheme(view, themeName);
            }
        });

    }

    private void initTask() {
        task = model.getThemeTask(themeName.toLowerCase(), getContext());
        System.out.println("task" + task);
        binding.toolbarTitle.setText("Тема \"" + themeName + "\"");
    }

    private void displayResult() {
        int res = model.getResult();
        binding.txtResult.setVisibility(View.VISIBLE);
        binding.txtResult.setText("Ваш результат " + res + " верных из 10");
        binding.radioGroup.setVisibility(View.GONE);
        binding.editTaskA.setVisibility(View.GONE);
        binding.txtTask.setVisibility(View.GONE);
        binding.txtTaskQ.setVisibility(View.GONE);
        binding.editTaskA.setVisibility(View.GONE);
        binding.btnNext.setText("вернуться к темам");
    }

    private void initView(View view) {
        this.view = view;
    }

    protected void initViewModel() {
        model = new ViewModelProvider(this).get(ExercisesViewModel.class);
    }

}