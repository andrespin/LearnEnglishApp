package android.famme.learnenglishapp.ui.auth;

import static android.famme.learnenglishapp.utils.firebase.AuthEvent.LogIn;

import android.famme.learnenglishapp.utils.firebase.AuthData;
import android.famme.learnenglishapp.utils.firebase.AuthEvent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

abstract class BaseAuthViewModel extends ViewModel {

    MutableLiveData<String> eventShowTxtError = new MutableLiveData<>();

    MutableLiveData<String> eventShowTxtSuccess = new MutableLiveData<>();

    MutableLiveData<Boolean> eventIncorrectPassFieldError = new MutableLiveData<>();

    MutableLiveData<Boolean> eventIncorrectLoginFieldError = new MutableLiveData<>();

    MutableLiveData<String> eventIncorrectLoginResetError = new MutableLiveData<>();

    MutableLiveData<Boolean> eventShowLoading = new MutableLiveData<>();

    MutableLiveData<Boolean> eventOpenApp = new MutableLiveData<>();

    MutableLiveData<Boolean> eventShowAuth = new MutableLiveData<>();

    Observer<AuthData> observerFirebase = new Observer<AuthData>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {
            Log.d("TAG", " First onSubscribe : " + d.isDisposed());
        }

        @Override
        public void onNext(@NonNull AuthData authData) {
            Log.d("TAG", " First onNext value : " + authData.getMessage());
            AuthEvent event = authData.getAuthEvent();
            switch (event) {
                case Registration:
                    eventShowTxtSuccess.postValue(authData.getMessage());
                    break;
                case ResetPass:
                    eventShowTxtSuccess.postValue(authData.getMessage());
                    break;
                case LogIn:
                    eventShowTxtSuccess.postValue(authData.getMessage());
                    eventOpenApp.postValue(true);
                    break;
                case Error:
                    eventShowTxtError.postValue(authData.getMessage());
                    break;
            }
        }

        @Override
        public void onError(@NonNull Throwable e) {
            Log.d("TAG", " First onError : " + e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.d("TAG", " First onComplete");
        }
    };


}
