package android.famme.learnenglishapp.utils.firebase;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

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
        System.out.println("signIn(String email, String password, Activity activity)");
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
                            String error = "????????????: " + task.getException();
                            AuthData data = new AuthData(
                                    AuthEvent.Error,
                                    error
                            );
                            eventAuth.onNext(data);
                            System.out.println("Authentication failed" + task.getException());
                        }
                    }
                });
    }

    @Override
    public void signUp(String email, String password, Activity activity) {
        com.google.firebase.auth.FirebaseAuth auth
                = com.google.firebase.auth.FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        System.out.println("createUserWithEmail:onComplete:");
                        if (task.isSuccessful()) {
                            AuthData data = new AuthData(
                                    AuthEvent.Registration,
                                    "?????????????????????? ???????????? ??????????????"
                            );
                            eventAuth.onNext(data);
                        } else {
                            String error = "????????????: " + task.getException();
                            AuthData data = new AuthData(
                                    AuthEvent.Error,
                                    error
                            );
                            eventAuth.onNext(data);
                            System.out.println("Authentication failed" + task.getException());
                        }
                    }
                });
    }

    @Override
    public void signOut() {
        com.google.firebase.auth.FirebaseAuth auth
                = com.google.firebase.auth.FirebaseAuth.getInstance();
        auth.signOut();
    }

    @Override
    public void resetPass(String email) {
        com.google.firebase.auth.FirebaseAuth auth
                = com.google.firebase.auth.FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            AuthData data = new AuthData(
                                    AuthEvent.ResetPass,
                                    "???????????????????? ?????? ?????????? ???????????? ???????????????????? ?????? ???? ??????????"
                            );
                            eventAuth.onNext(data);
                        } else {
                            String error = "????????????: " + task.getException();
                            AuthData data = new AuthData(
                                    AuthEvent.Error,
                                    error
                            );
                            eventAuth.onNext(data);
                        }
                    }
                });
    }

    @Override
    public void updatePass(String email, String newPass) {
        com.google.firebase.auth.FirebaseUser user
                = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();

        String newPassword = newPass;

        user.updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "User password updated.");
                        } else {

                        }
                    }
                });
    }

    @Override
    public void updateLogin(String email) {
        com.google.firebase.auth.FirebaseUser user
                = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();

        user.updateEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "User email updated");
                        } else {

                        }
                    }
                });
    }

    @Override
    public void deleteUser() {
        com.google.firebase.auth.FirebaseUser user
                = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "User account deleted.");
                        } else {

                        }
                    }
                });
    }

    @Override
    public void repeatAuth(String email, String password) {
        com.google.firebase.auth.FirebaseUser user
                = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential credential = EmailAuthProvider
                .getCredential(email, password);
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d("TAG", "User re-authenticated.");
                    }
                });
    }

    @Override
    public void saveUserName(String login, String name) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String loginOnlyLetters = login.replaceAll("\\P{L}+", "");
        DatabaseReference myRef = database.getReference(loginOnlyLetters + " :name");
        myRef.setValue(name).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("TAG", "Login updated");
                eventAuth.onNext(new AuthData(AuthEvent.NameUpdated, "?????? ???????????????????????? ??????????????????"));
            }
        });
    }

    @Override
    public List<String> getProfileResult() {
        return null;
    }

    @Override
    public void deleteProfileResult() {

    }

    @Override
    public void setProfileResult() {

    }

    @Override
    public void getUserName(String login) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String loginOnlyLetters = login.replaceAll("\\P{L}+", "");
        DatabaseReference myRef = database.getReference(loginOnlyLetters + " :name");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }
}
