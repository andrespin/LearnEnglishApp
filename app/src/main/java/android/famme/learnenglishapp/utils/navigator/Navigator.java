package android.famme.learnenglishapp.utils.navigator;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.ui.MainActivity;
import android.view.View;

import androidx.navigation.Navigation;

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

}
