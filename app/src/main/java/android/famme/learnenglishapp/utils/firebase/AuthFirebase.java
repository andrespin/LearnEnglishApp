package android.famme.learnenglishapp.utils.firebase;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class AuthFirebase implements IAuthFirebase {

    PublishSubject<AuthData> eventAuth;

    public AuthFirebase(PublishSubject<AuthData> eventAuth) {
        this.eventAuth = eventAuth;
    }

    @Override
    public PublishSubject<AuthData> getEventAuth() {
        return eventAuth;
    }

    @Override
    public void signIn(String email, String password, Activity activity) {
        com.google.firebase.auth.FirebaseAuth auth
                = com.google.firebase.auth.FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // String email, String pass, AuthEvent authEvent, String msg
                        if (task.isSuccessful()) {
                            AuthData data = new AuthData(
                                    email,
                                    password,
                                    AuthEvent.LogIn,
                                    ""
                            );
                            eventAuth.onNext(data);
                            System.out.println("success");
                        } else {
                            // String error, AuthEvent authEvent, String msg
                            String error = "Authentication failed" + task.getException();
                            AuthData data = new AuthData(
                                    error,
                                    AuthEvent.LogIn,
                                    ""
                            );
                            eventAuth.onNext(data);
                            System.out.println("Authentication failed" + task.getException());
                        }
                    }
                });
    }

    @Override
    public void singUp(String email, String password, Activity activity) {
        com.google.firebase.auth.FirebaseAuth auth
                = com.google.firebase.auth.FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        System.out.println("createUserWithEmail:onComplete:");
                        if (task.isSuccessful()) {
                            AuthData data = new AuthData(
                                    AuthEvent.LogIn,
                                    "Регистрация прошла успешно"
                            );
                            eventAuth.onNext(data);

                        } else {
                            String error = "Authentication failed" + task.getException();
                            AuthData data = new AuthData(
                                    error,
                                    AuthEvent.LogIn,
                                    ""
                            );
                            eventAuth.onNext(data);
                            System.out.println("Authentication failed" + task.getException());
                        }
                    }
                });
    }

    @Override
    public void resetPass(String email, Activity activity) {
        com.google.firebase.auth.FirebaseAuth auth
                = com.google.firebase.auth.FirebaseAuth.getInstance();
        // String e = "andrespin@mail.ru";
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            AuthData data = new AuthData(
                                    AuthEvent.ResetPass,
                                    "Информация для смены пароля отправлена вам на почту"
                            );
                            eventAuth.onNext(data);
                        } else {
                            String error = "Authentication failed" + task.getException();
                            AuthData data = new AuthData(
                                    error,
                                    AuthEvent.LogIn,
                                    ""
                            );
                            eventAuth.onNext(data);
                        }
                    }
                });
    }
}
