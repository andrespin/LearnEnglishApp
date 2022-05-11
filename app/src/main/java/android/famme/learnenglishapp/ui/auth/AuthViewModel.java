package android.famme.learnenglishapp.ui.auth;

import android.app.Activity;
import android.famme.learnenglishapp.data.storage.IPreferences;
import android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassesAreNotSameException;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.firebase.IAuthFirebase;
import android.util.Log;


import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;


public class AuthViewModel extends BaseAuthViewModel {

    @Inject
    IPreferences iPrefs;

    @Inject
    IAuthFirebase authFirebase;

    @Inject
    IAuthChecker authChecker;

    public void subscribeFirebase() {
        authFirebase.getEventAuth().subscribe(observerFirebase);
    }

    public void checkLoginAndPass(String login, String pass, String repeatPass, String name, Activity activity) {
        try {
            if (authChecker.areThePassesSame(pass, repeatPass)) {
                try {
                    eventShowLoading.postValue(true);

                    if (authChecker.isLoginCorrectlyWritten(login)) {

                        try {
                            if (authChecker.isPassCorrectlyWritten(pass)) {
                                authFirebase.signUp(login, pass, activity);
                                authFirebase.saveUserName(login, name);
                            }

                        } catch (ThePassIsIncorrectlyWrittenException e) {
                            e.printStackTrace();
                            String s =
                                    "android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException:";
                            eventShowTxtError.postValue(
                                    e.toString().replace(s, "")
                            );
                        }
                    }
                } catch (TheLoginIsIncorrectlyWrittenException e) {
                    e.printStackTrace();
                    String s =
                            "android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException:";
                    eventShowTxtError.postValue(
                            e.toString().replace(s, "")
                    );
                }
            }
        } catch (ThePassesAreNotSameException e) {
            e.printStackTrace();
            String s = "";
            eventShowTxtError.postValue(
                    e.toString().replace(s, "")
            );
        }
    }

    public void checkLoginAndPass(String login, String pass, Activity activity) {

        try {
            eventShowLoading.postValue(true);
            if (authChecker.isLoginCorrectlyWritten(login)) {
                try {

                    System.out.println("authChecker.isPassCorrectlyWritten(pass): "+authChecker.isPassCorrectlyWritten(pass));
                    if (authChecker.isPassCorrectlyWritten(pass)) {
                      //  eventOpenApp.postValue(true);
                        // Тут выполняется Firebase
                        Log.d("event", "signInFirebase");
                        iPrefs.setLogin(login);
                        iPrefs.setPass(pass);
                        authFirebase.signIn(login, pass, activity);
                    }
                } catch (ThePassIsIncorrectlyWrittenException e) {
                    e.printStackTrace();
                    Log.d("event", "signInFirebase error");
                    String s = "android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException:";
                    eventShowTxtError.postValue(
                            e.toString().replace(s, "")
                    );
                }
            }
        } catch (TheLoginIsIncorrectlyWrittenException e) {
            e.printStackTrace();
            String s =
                    "android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException:";
            eventShowTxtError.postValue(
                    e.toString().replace(s, "")
            );
        }
    }

    public void checkLoginAndPass(String login) {
        try {
            eventShowLoading.postValue(true);
            if (authChecker.isLoginCorrectlyWritten(login)) {
                authFirebase.resetPass(login);
            }
        } catch (TheLoginIsIncorrectlyWrittenException e) {
            e.printStackTrace();
            String s =
                    "android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException:";
            eventIncorrectLoginResetError.postValue(
                    e.toString().replace(s, "")
            );
        }
    }


    public void init() {

    }

    public void checkAuth() {
        System.out.println("iPrefs.getLogin() " + iPrefs.getLogin());
        if (iPrefs.getLogin() != null && !iPrefs.getLogin().equals("")) {
            eventOpenApp.postValue(true);
        }
    }


    MutableLiveData<Boolean> eventShowRegister = new MutableLiveData<>();

    public void showRegister() {
        eventShowRegister.postValue(true);
    }

    MutableLiveData<Boolean> eventShowAuth = new MutableLiveData<>();

    public void showAuth() {
        eventShowAuth.postValue(true);
    }

    MutableLiveData<Boolean> eventShowAuthAfterReg = new MutableLiveData<>();

    public void showAuthAfterReg() {
        eventShowAuthAfterReg.postValue(true);
    }

}
