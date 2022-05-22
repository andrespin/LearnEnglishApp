package android.famme.learnenglishapp.utils.navigator;

import android.view.View;

// https://habr.com/ru/post/416025/
public interface INavigator {

    void navigateToMainApp(View view);

    void navigateMainAppToAuth(View view);

    void navigateViewPagerToTheme(View view, String themeName);

    void navigateThemeToViewPager(View view);

    void navigateThemeToExercises(View view, String themeName);

    void navigateExercisesToTheme(View view, String themeName);

    void navigateExercisesToViewPager(View view);

    void navigateViewPagerToGraph(View view);

    void navigateGraphToViewPager(View view);

}
