package android.famme.learnenglishapp.utils.navigator;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.ui.MainActivity;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;
// https://habr.com/ru/post/416025/
public class Navigator implements INavigator {

    @Override
    public void navigateToMainApp(View view) {
        Navigation.findNavController(view).popBackStack(R.id.auth, true);
        Navigation.findNavController(view).navigate(R.id.view_pager);
    }

    @Override
    public void navigateSplashToAuth(View view) {
        Navigation.findNavController(view).popBackStack(R.id.splash, true);
        Navigation.findNavController(view).navigate(R.id.auth);
    }

    @Override
    public void navigateSplashToMainApp(View view) {
        Navigation.findNavController(view).popBackStack(R.id.splash, true);
        Navigation.findNavController(view).navigate(R.id.view_pager);
    }

    @Override
    public void navigateMainAppToAuth(View view) {
        Navigation.findNavController(view).popBackStack(R.id.view_pager, true);
        Navigation.findNavController(view).navigate(R.id.auth);
    }

    @Override
    public void navigateThemesToTheme(View view, String themeName) {
//        Bundle bundle = new Bundle();
//        bundle.putString("themeName", themeName);
//        Navigation.findNavController(view).navigate(R.id.theme);
    }

    @Override
    public void navigateThemeToThemes(View view) {
//        Navigation.findNavController(view).popBackStack(R.id.theme, true);
//        Navigation.findNavController(view).navigate(R.id.themes);
    }

    @Override
    public void navigateViewPagerToTheme(View view, String themeName) {
        Bundle bundle = new Bundle();
        bundle.putString("themeName", themeName);
        Navigation.findNavController(view).navigate(R.id.theme, bundle);
    }

    @Override
    public void navigateThemeToViewPager(View view) {
        Navigation.findNavController(view).popBackStack(R.id.theme, true);
        Navigation.findNavController(view).navigate(R.id.view_pager);
    }

}
