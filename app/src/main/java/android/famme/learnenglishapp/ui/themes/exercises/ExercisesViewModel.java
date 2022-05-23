package android.famme.learnenglishapp.ui.themes.exercises;

import android.content.Context;
import android.famme.learnenglishapp.data.storage.preferences.IPreferences;
import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.data.storage.room.ResultEntity;
import android.famme.learnenglishapp.data.storage.tasks.Books;
import android.famme.learnenglishapp.data.storage.tasks.Clothes;
import android.famme.learnenglishapp.data.storage.tasks.Culture;
import android.famme.learnenglishapp.data.storage.tasks.Education;
import android.famme.learnenglishapp.data.storage.tasks.Family;
import android.famme.learnenglishapp.data.storage.tasks.Life;
import android.famme.learnenglishapp.data.storage.tasks.Lifestyle;
import android.famme.learnenglishapp.data.storage.tasks.Personality;
import android.famme.learnenglishapp.data.storage.tasks.Shopping;
import android.famme.learnenglishapp.data.storage.tasks.Summer;
import android.famme.learnenglishapp.data.storage.tasks.Task;
import android.famme.learnenglishapp.utils.themes.Results;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExercisesViewModel extends ViewModel {

    private int exNumber = 0;

    private int countRightAnswers = 0;

    private final String tag = "ExercisesViewModel";

    MutableLiveData<Boolean> eventReturnToAudio = new MutableLiveData<>();

    MutableLiveData<Boolean> eventReturnToThemes = new MutableLiveData<>();

    MutableLiveData<Integer> eventDisplayTask = new MutableLiveData<>();

    @Inject
    ResultDao resultDao;

    @Inject
    IPreferences prefs;

    @Inject
    Results results;

    public Task getThemeTask(String theme, Context context) {

        Task task = null;

        Log.d(tag, theme);
        switch (theme) {
            case "personality":
                task = new Personality(context);
                break;
            case "shopping":
                task = new Shopping(context);
                break;
            case "education":
                task = new Education(context);
                break;
            case "summer":
                task = new Summer(context);
                break;
            case "lifestyle":
                task = new Lifestyle(context);
                break;
            case "life":
                task = new Life(context);
                break;
            case "family":
                task = new Family(context);
                break;
            case "culture":
                task = new Culture(context);
                break;
            case "clothes":
                task = new Clothes(context);
                break;
            case "books":
                task = new Books(context);
                break;
            default:
                //   task = new Personality(context);
                break;
        }
        return task;
    }

    public void goBack() {
        if (exNumber != 11) {
            exNumber--;
        }
        if (exNumber == 0) {
            eventReturnToAudio.postValue(true);
        } else if (exNumber < 11) {
            eventDisplayTask.postValue(exNumber);
        } else {

        }
    }

    public void goForward() {
        exNumber++;
        if (exNumber < 12) {
            eventDisplayTask.postValue(exNumber);
        } else {
            eventReturnToThemes.postValue(true);
        }
    }

    public void checkTask(String userAnswer, String rightAnswer) {
        if (userAnswer.equals(rightAnswer)) {
            countRightAnswers++;
            System.out.println("countRightAnswers " + countRightAnswers);
        }
    }

    public void saveResult(String theme) {
        String login = prefs.getLogin();

        Completable
                .complete()
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        ResultEntity resultEntity = resultDao.getResultByLogin(login);

                        if (resultEntity == null) {
                            resultEntity = results.getNewResultEntity(login);
                        }

                        ResultEntity r = results.setTheme(theme, countRightAnswers, resultEntity);

                        System.out.println("r " + r.getLifestyle() );

                        try {
                            resultDao.insert(r);
                            Log.d(tag, "data inserted");
                        } catch (android.database.sqlite.SQLiteConstraintException e) {
                            e.printStackTrace();
                            resultDao.update(r);
                            Log.d(tag, "data updated");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }


    public int getResult() {
        return countRightAnswers;
    }

}
