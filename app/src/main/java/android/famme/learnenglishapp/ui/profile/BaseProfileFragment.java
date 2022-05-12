package android.famme.learnenglishapp.ui.profile;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.databinding.FragmentProfileBinding;
import android.famme.learnenglishapp.ui.auth.AuthFragment;
import android.famme.learnenglishapp.ui.auth.AuthViewModel;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

abstract class BaseProfileFragment extends Fragment {

    ProfileViewModel model;

    View view;

    protected void initView(View view) {
        this.view = view;
    }

    protected void initViewModel(ProfileFragment fragment) {
        model = new ViewModelProvider(fragment).get(ProfileViewModel.class);
    }

    protected void inject(ProfileFragment fragment, ProfileViewModel model) {
        injectViewModel(model);
        injectFragment(fragment);
    }

    protected void initListeners(FragmentProfileBinding binding) {
        initBtnLogOutListener(binding);
        initBtnDeleteProfileListener(binding);
    }

    private void initBtnDeleteProfileListener(FragmentProfileBinding binding) {
        binding.btnDeleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.deleteProfile(view);
            }
        });
    }

    private void initBtnLogOutListener(FragmentProfileBinding binding) {
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.logOut(view);
            }
        });
    }

    private void injectViewModel(ProfileViewModel model) {
        App.instance.appComponent.inject(model);
    }

    private void injectFragment(ProfileFragment fragment) {
        App.instance.appComponent.inject(fragment);
    }


}
