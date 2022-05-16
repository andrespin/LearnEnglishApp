package android.famme.learnenglishapp.ui.profile;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.databinding.FragmentProfileBinding;
import android.famme.learnenglishapp.ui.auth.AuthFragment;
import android.famme.learnenglishapp.ui.auth.AuthViewModel;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

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

    protected void observeViewModel() {
        model.eventTxtMessage
                .observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getActivity(), s,
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    protected void initListeners(FragmentProfileBinding binding) {
        initBtnLogOutListener(binding);
        initBtnDeleteProfileListener(binding);
        initBtnChangeProfileListener(binding);
    }

    private void initBtnChangeProfileListener(FragmentProfileBinding binding) {
        binding.btnChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.changeData(
                        binding.txtUserName.getText().toString(),
                        binding.txtLogin.getText().toString(),
                        binding.txtPass.getText().toString(),
                        binding.txtRepeatPass.getText().toString()
                );
            }
        });
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
