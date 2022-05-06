package android.famme.learnenglishapp.ui.auth;

import android.app.Activity;
import android.famme.learnenglishapp.data.storage.IPreferences;
import android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassesAreNotSameException;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.test.IAuthFirebase;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;


public class AuthViewModel extends BaseAuthViewModel {

    private MutableLiveData<String> liveData = new MutableLiveData<>();

    MutableLiveData<Boolean> eventLoading = new MutableLiveData<>();

    MutableLiveData<View> eventRightRegData = new MutableLiveData<>();

    MutableLiveData<String> eventToastMessage = new MutableLiveData<>();

    MutableLiveData<String> eventIncorrectPassError = new MutableLiveData<>();

    MutableLiveData<String> eventIncorrectLoginError = new MutableLiveData<>();

    MutableLiveData<String> eventIncorrectLoginResetError = new MutableLiveData<>();




    MutableLiveData<String> eventIncorrectLoginRegError = new MutableLiveData<>();

    MutableLiveData<String> eventIncorrectPassRegError = new MutableLiveData<>();


    MutableLiveData<String> eventCorrectLogin = new MutableLiveData<>();

    MutableLiveData<String> eventCorrectPass = new MutableLiveData<>();

    MutableLiveData<Boolean> eventShowLoading = new MutableLiveData<>();

    MutableLiveData<Boolean> eventShowResetLoading = new MutableLiveData<>();

    MutableLiveData<Boolean> eventShowRegLoading = new MutableLiveData<>();

    MutableLiveData<Boolean> eventOpenApp = new MutableLiveData<>();

    @Inject
    IPreferences iPrefs;

    @Inject
    IAuthFirebase authFirebase;

    @Inject
    IAuthChecker authChecker;

    public void checkLoginAndPass(String login, String pass, String repeatPass) {
        try {
            if (authChecker.areThePassesSame(pass, repeatPass)) {
                try {
                    eventShowRegLoading.postValue(true);

                    if (authChecker.isLoginCorrectlyWritten(login)) {

                        try {
                            if (authChecker.isPassCorrectlyWritten(pass)) {
                                // выполнение регистрации тут вызывается Firebase для регистрации
                                // eventOpenApp.postValue(true);
                            }

                        } catch (ThePassIsIncorrectlyWrittenException e) {
                            e.printStackTrace();
                            String s =
                                    "android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException:";
                            eventIncorrectPassRegError.postValue(
                                    e.toString().replace(s, "")
                            );
                        }
                    }
                } catch (TheLoginIsIncorrectlyWrittenException e) {
                    e.printStackTrace();
                    String s =
                            "android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException:";
                    eventIncorrectLoginRegError.postValue(
                            e.toString().replace(s, "")
                    );
                }
            }
        } catch (ThePassesAreNotSameException e) {
            e.printStackTrace();
            String s = "";
            eventIncorrectPassRegError.postValue(
                    e.toString().replace(s, "")
            );
        }
    }

    public void checkLoginAndPass(String login, String pass) {
        try {
            eventShowLoading.postValue(true);
            if (authChecker.isLoginCorrectlyWritten(login)) {
                try {
                    if (authChecker.isPassCorrectlyWritten(pass)) {
                        eventOpenApp.postValue(true);

                        // Тут выполняется Firebase

                    }
                } catch (ThePassIsIncorrectlyWrittenException e) {
                    e.printStackTrace();
                    String s = "android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException:";
                    eventIncorrectPassError.postValue(
                            e.toString().replace(s, "")
                    );
                }
            }
        } catch (TheLoginIsIncorrectlyWrittenException e) {
            e.printStackTrace();
            String s =
                    "android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException:";
            eventIncorrectLoginError.postValue(
                    e.toString().replace(s, "")
            );
        }
    }

    public void checkLoginAndPass(String login)  {
        try {
            eventShowResetLoading.postValue(true);
            if (authChecker.isLoginCorrectlyWritten(login)) {
                // Тут выполняется Firebase
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
        if (iPrefs.getLogin() != null && !iPrefs.getLogin().equals("")) {
            eventOpenApp.postValue(true);
        }
    }

    public void singUp(String email, String password, Activity activity) {

    }

    public void signIn(String email, String password, Activity activity, View v) {

        eventRightRegData.postValue(v);

    }

    public void resetPass(String email) {

    }

}
