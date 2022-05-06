package android.famme.learnenglishapp.utils.navigator;

import android.famme.learnenglishapp.R;
import android.view.View;

import androidx.navigation.Navigation;

public class Navigator implements INavigator{

    @Override
    public void navigateToMainApp(View view) {
        Navigation.findNavController(view).popBackStack(R.id.auth, true);
        Navigation.findNavController(view).navigate(R.id.view_pager);
    }

}
