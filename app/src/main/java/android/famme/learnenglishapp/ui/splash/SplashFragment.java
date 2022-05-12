package android.famme.learnenglishapp.ui.splash;

import android.famme.learnenglishapp.data.storage.IPreferences;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.famme.learnenglishapp.R;

import javax.inject.Inject;

public class SplashFragment extends Fragment {

    @Inject
    IPreferences iPrefs;

    @Inject
    INavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (iPrefs.getLogin() != null && !iPrefs.getLogin().equals("")) {
            navigator.navigateSplashToMainApp(view);
        } else {
            navigator.navigateSplashToAuth(view);
        }
    }
}