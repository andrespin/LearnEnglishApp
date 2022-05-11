package android.famme.learnenglishapp.utils.firebase;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class TestRx {


  //  Observable<String> observable = Observable.from(new String[]{"one", "two", "three"});

    Observer<AuthData> observer = new Observer<AuthData>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull AuthData authData) {

        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };


}
