package android.famme.learnenglishapp.ui.progress;

import android.annotation.SuppressLint;
import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.data.storage.room.ResultEntity;
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

    void getAllResults() {

        Completable
                .complete()
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        List<ResultEntity> results = resultDao.getAll();
                        eventGetResults.postValue(convertToListStr(results));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    private ArrayList<String> convertToListStr(List<ResultEntity> resList) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < resList.size(); i++) {
            String str = resList.get(0).theme + " -" + resList.get(0).result + "/10";
            list.add(str);
        }
        return list;
    }

}
