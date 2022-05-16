package android.famme.learnenglishapp.ui.progress;

import android.annotation.SuppressLint;
import android.famme.learnenglishapp.data.storage.preferences.IPreferences;
import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.data.storage.room.ResultEntity;
import android.famme.learnenglishapp.utils.converter.IConverter;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ProgressViewModel extends ViewModel {

    private String tag = "ProgressViewModel";

    MutableLiveData<List<String>> eventGetResults = new MutableLiveData<>();

    @Inject
    ResultDao resultDao;

    @Inject
    IPreferences prefs;

    @Inject
    IConverter converter;

    void getAllResults() {

        String login = prefs.getLogin();
        Completable
                .complete()
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        ResultEntity result = resultDao.getResultByLogin(login);
                        eventGetResults.postValue(
                                converter.convertResultEntityToListOfResults(result)
                        );
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }


}
