package android.famme.learnenglishapp.ui.profile;

import android.app.Activity;
import android.famme.learnenglishapp.data.storage.IPreferences;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.firebase.IAuthFirebase;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {


    @Inject
    IPreferences iPrefs;

    @Inject
    IAuthFirebase authFirebase;

    @Inject
    IAuthChecker authChecker;


    public void setNewUserName(String name, Activity activity) {
        iPrefs.setNameLogin(name);
    }

    public void setNewPass(String pass, Activity activity) {
        iPrefs.setPass(pass);
    }


    public void setNewLogin(String login, Activity activity) {
        iPrefs.setLogin(login);
    }


    public void deleteProfile(Activity activity) {
        iPrefs.deleteLoginAndPass();
        authFirebase.deleteUser();
        activity.finish();
    }

    public void logOut(Activity activity) {
        iPrefs.deleteLoginAndPass();
        authFirebase.signOut();
        activity.finish();
    }

}
