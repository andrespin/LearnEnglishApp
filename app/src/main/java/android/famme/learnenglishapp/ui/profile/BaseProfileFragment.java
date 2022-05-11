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

    protected void initViewModel(ProfileFragment fragment) {
        model = new ViewModelProvider(fragment).get(ProfileViewModel.class);
    }

    protected void inject(ProfileFragment fragment ,ProfileViewModel model) {
        injectViewModel(model);
        injectFragment(fragment);
    }

    protected void initListeners(FragmentProfileBinding binding) {
        initBtnNewUserNameListener(binding);
        initBtnSetNewPassListener(binding);
        initBtnSetNewLoginListener(binding);
        initBtnLogOutListener(binding);
        initBtnDeleteProfileListener(binding);
    }

    private void initBtnDeleteProfileListener(FragmentProfileBinding binding) {
        binding.btnDeleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.deleteProfile(getActivity());
            }
        });
    }

    private void initBtnLogOutListener(FragmentProfileBinding binding) {
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.logOut(getActivity());
            }
        });
    }

    private void initBtnSetNewLoginListener(FragmentProfileBinding binding) {
        binding.btnSetNewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newLogin = binding.editSetNewLogin.getText()
                        .toString().replace(" ", "");
                model.setNewLogin(newLogin, getActivity());
            }
        });
    }


    private void initBtnNewUserNameListener(FragmentProfileBinding binding) {
        binding.btnSetNewUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName= binding.editSetNewUserName.getText()
                        .toString().replace(" ", "");
                model.setNewUserName(newName, getActivity());
            }
        });
    }

    private void initBtnSetNewPassListener(FragmentProfileBinding binding) {
        binding.btnSetNewPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass= binding.editSetNewPass.getText()
                        .toString().replace(" ", "");
                model.setNewPass(newPass, getActivity());
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
