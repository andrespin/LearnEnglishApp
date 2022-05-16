package android.famme.learnenglishapp.utils.navigator;

import android.famme.learnenglishapp.ui.MainActivity;
import android.view.View;

public interface INavigator {

    void navigateToMainApp(View view);

    void navigateSplashToAuth(View view);

    void navigateSplashToMainApp(View view);

    void navigateMainAppToAuth(View view);

    void navigateViewPagerToTheme(View view, String themeName);

    void navigateThemeToViewPager(View view);

    void navigateThemeToExercises(View view, String themeName);

    void navigateExercisesToTheme(View view, String themeName);

    void navigateExercisesToViewPager(View view);

}
