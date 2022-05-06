package android.famme.learnenglishapp.ui.auth;

import android.famme.learnenglishapp.App;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

abstract class BaseAuthFragmentInit extends BaseAuthFragment {

    protected void initView(View view) {
        this.view = view;
    }

    protected void initViewModel(AuthFragment fragment) {
        model = new ViewModelProvider(fragment).get(AuthViewModel.class);
    }

    protected void injectViewModel(AuthViewModel model) {
        App.instance.appComponent.inject(model);
    }

    protected void injectFragment(AuthFragment fragment) {
        App.instance.appComponent.inject(fragment);
    }

}
