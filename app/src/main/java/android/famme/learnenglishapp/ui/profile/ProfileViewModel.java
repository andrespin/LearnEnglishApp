package android.famme.learnenglishapp.ui.profile;

import android.famme.learnenglishapp.data.storage.preferences.IPreferences;
import android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassesAreNotSameException;
import android.famme.learnenglishapp.ui.interactor.MainInteractor;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.firebase.IAuthFirebase;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    @Inject
    IPreferences iPrefs;

    @Inject
    IAuthFirebase authFirebase;

    @Inject
    INavigator navigator;

    @Inject
    MainInteractor interactor;

    @Inject
    IAuthChecker checker;


    MutableLiveData<String> eventTxtMessage = new MutableLiveData<>();

    public void changeData(String name, String login, String pass, String repeatPass) {
        try {
            if (checker.areThePassesSame(pass, repeatPass)) {
                try {
                    if (checker.isLoginCorrectlyWritten(login)) {
                        try {
                            if (checker.isPassCorrectlyWritten(pass)) {
                                authFirebase.updateLogin(login);
                                authFirebase.updatePass(login, pass);
                                authFirebase.saveUserName(login, name);
                            }
                        } catch (ThePassIsIncorrectlyWrittenException e) {
                            e.printStackTrace();
                            String s =
                                    "android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException:";
                            eventTxtMessage.postValue(e.toString().replace(s, ""));
                        }
                    }
                } catch (TheLoginIsIncorrectlyWrittenException e) {
                    e.printStackTrace();
                    eventTxtMessage.postValue("Логин неверно указан");
                }
            }
        } catch (ThePassesAreNotSameException e) {
            e.printStackTrace();
            eventTxtMessage.postValue("Пароли не совпадают");
        }
    }

    public void deleteProfile(View view) {
        iPrefs.deleteLoginAndPass();
        authFirebase.deleteUser();
        interactor.deleteAllData();
        navigator.navigateMainAppToAuth(view);
    }

    public void logOut(View view) {
        iPrefs.deleteLoginAndPass();
        authFirebase.signOut();
        navigator.navigateMainAppToAuth(view);
    }

}
