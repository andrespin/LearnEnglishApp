package android.famme.learnenglishapp.ui.profile;

import android.app.Activity;
import android.famme.learnenglishapp.data.storage.IPreferences;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.firebase.IAuthFirebase;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.view.View;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    @Inject
    IPreferences iPrefs;

    @Inject
    IAuthFirebase authFirebase;

    @Inject
    INavigator navigator;

    public void deleteProfile(View view) {
        iPrefs.deleteLoginAndPass();
        authFirebase.deleteUser();
        navigator.navigateMainAppToAuth(view);
    }

    public void logOut(View view) {
        iPrefs.deleteLoginAndPass();
        authFirebase.signOut();
        navigator.navigateMainAppToAuth(view);
    }

}
