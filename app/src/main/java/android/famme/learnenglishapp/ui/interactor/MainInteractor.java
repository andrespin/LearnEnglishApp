package android.famme.learnenglishapp.ui.interactor;

import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.utils.firebase.IAuthFirebase;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainInteractor {

    private ResultDao resultDao;
    private IAuthFirebase firebase;

    public MainInteractor(ResultDao resultDao,
                          IAuthFirebase firebase
    ) {
        this.resultDao = resultDao;
        this.firebase = firebase;
    }

    public void deleteAllData() {
        Completable
                .complete()
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        resultDao.deleteAllResults();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

}
