package android.famme.learnenglishapp.utils.test;

import android.app.Activity;

import io.reactivex.rxjava3.subjects.PublishSubject;

public interface IAuthFirebase {

    PublishSubject<AuthData> getEventAuth();

    void signIn(String email, String password, Activity activity);

    void singUp(String email, String password, Activity activity);

    void resetPass(String email, Activity activity);

}
