package android.famme.learnenglishapp.ui.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentAuthBinding;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

public class AuthFragment extends BaseAuthFragmentInit {

    @Inject
    INavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewModel(this);
        injectViewModel(model);
        injectFragment(this);
        model.checkAuth();
        initListeners();
    }

    private void initListeners() {
        initPassRecoverListeners();
        initRegListeners();
        initAuthListeners();
        initViewModelListeners();
    }


    private void initRegListeners() {

        binding.regLayout.imgBtnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String email = binding.regLayout.txtEnterLogin.getText().
                        toString().replace( " ", "");

                String pass = binding.regLayout.txtEnterPass.getText()
                        .toString().replace( " ", "");

                String passRepeat = binding.regLayout.txtRepeatPass.getText()
                        .toString().replace( " ", "");

                model.checkLoginAndPass(email, pass, passRepeat);

            }
        });

        binding.regLayout.imgShowHidePass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isPassRegVisible) {
                    setRegLayoutPassInvisible(binding);
                } else {
                    setRegLayoutPassVisible(binding);
                }
            }
        });

        binding.regLayout.imgShowHidePassRepeat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isPassRegRepeatVisible) {
                    setRegLayoutRepeatPassVisible(binding);
                } else {
                    setRegLayoutRepeatPassInvisible(binding);
                }
            }
        });

        binding.regLayout.imgLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAuthLayout(binding);
            }
        });

    }

    private void initAuthListeners() {

        binding.authLayout.imgBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegLayout(binding);
            }
        });

        binding.authLayout.imgBtnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String login = binding.authLayout.txtEnterLogin.getText().toString()
                        .replace(" ", "");

                String pass = binding.authLayout.txtEnterPass.getText().toString()
                        .replace(" ", "");
                model.checkLoginAndPass(login, pass);
            }
        });


        binding.authLayout.imgShowHidePass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isPassVisible) {
                    setAuthLayoutPassInvisible(binding);
                } else {
                    setAuthLayoutPassVisible(binding);
                }
            }
        });

        binding.authLayout.txtRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRecoverLayout(binding);
            }
        });
    }

    private void initPassRecoverListeners() {

        binding.recoverLayout.imgBtnRecover.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = binding.recoverLayout.txtEnterLogin.getText().toString();

                String login = binding.recoverLayout.txtEnterLogin
                        .getText().toString().replace(" ", "");

                model.checkLoginAndPass(login);

            }
        });

        binding.recoverLayout.imgBtnLogInAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAuthLayout(binding);
            }
        });
    }


    private void initViewModelListeners() {


        model.eventShowRegLoading.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {


                showResetLoading(binding);
                hideResetIncorrectLoginField(binding);


            }
        });


        model.eventShowResetLoading.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showResetLoading(binding);
                hideResetIncorrectLoginField(binding);
            }
        });

        model.eventIncorrectLoginResetError.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hideResetLoading(binding);
                showIncorrectResetLoginTxt(s, binding);
            }
        });

        model.eventIncorrectPassError.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showIncorrectLoginOrPasswordTxt(s, binding);
            }
        });

        model.eventIncorrectLoginError.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showIncorrectLoginOrPasswordTxt(s, binding);
                showAuthIncorrectLoginField(binding);
            }
        });

        model.eventIncorrectPassError.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showIncorrectLoginOrPasswordTxt(s, binding);
                showAuthIncorrectPassField(binding);
            }
        });

        model.eventShowLoading.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showAuthLoading(binding);
                hideAuthIncorrectLoginField(binding);
                hideAuthIncorrectPassField(binding);
            }
        });

        model.eventOpenApp.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                navigator.navigateToMainApp(view);
//                Navigation.findNavController(view).popBackStack(R.id.auth, true);
//                Navigation.findNavController(view).navigate(R.id.view_pager);
            }
        });

        model.eventToastMessage.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireActivity(), s,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

}