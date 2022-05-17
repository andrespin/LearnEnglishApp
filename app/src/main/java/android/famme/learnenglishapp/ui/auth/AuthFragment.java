package android.famme.learnenglishapp.ui.auth;

import android.content.Context;
import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentAuthBinding;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import javax.inject.Inject;


/**
 * При запуске приложения неавторизированный пользователь видит экран
 * фрагмента AuthFragment, если выясняется, что пользователь авторизирован,
 * то у него отображается фрагмент ViewPagerFragment.
 * Пока приложение выяснет авторизирован или нет пользователь,
 * высвечивается SplashScreen с главным изображением.
 * Когда пользователь нажимает на кнопку Регистрации или надпись "Нажмите если забыл пароль", он
 * видит перед собой другой layout, а предыдущий становится невидимым.
 */

public class AuthFragment extends BaseAuthFragmentListeners {

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
        showSplashScreen();
        initView(view);
        initViewModel(this);
        injectViewModel(model);
        injectFragment(this);
        model.checkAuth();
        initListeners();
        hideKeyboardListener();
        model.subscribeFirebase();

    }

    private void showSplashScreen() {
        binding.splashLayout.getRoot().setVisibility(View.VISIBLE);
    }

    public void hideKeyboardListener() {
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
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
                initRegLayoutImgBtnRegisterClick(binding);
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
                    setRegLayoutRepeatPassInvisible(binding);
                } else {
                    setRegLayoutRepeatPassVisible(binding);
                }
            }
        });

        binding.regLayout.imgLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegLayoutImgLogInClick(binding);
            }
        });

    }

    private void initAuthListeners() {

        binding.authLayout.imgBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initAuthLayoutImgBtnRegisterClick(binding);
            }
        });

        binding.authLayout.imgLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAuthLayoutImgLogInClick(binding);
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
                clearTxtInfo(binding);
                clearAuthFields(binding);
                showRecoverLayout(binding);
            }
        });
    }

    private void initPassRecoverListeners() {

        binding.recoverLayout.imgBtnRecover.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                initRecoverLayoutImgLogInClick(binding);

            }
        });

        binding.recoverLayout.imgBtnLogInAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRecoverLayoutImgBtnLogInAgainClick(binding);
            }
        });
    }

    private void initViewModelListeners() {

        model.eventShowAuth.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showMainAuth();
                showAuthLayout(binding);
            }
        });

        model.eventShowAuthAfterReg.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                clearRegFields(binding);
                showAuthLayout(binding);
            }
        });

        model.eventShowAuth.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                clearTxtInfo(binding);
                clearRecoverFields(binding);
                showAuthLayout(binding);
            }
        });

        model.eventShowRegister.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                clearTxtInfo(binding);
                clearAuthFields(binding);
                showRegLayout(binding);
            }
        });

        model.eventShowTxtSuccess.observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                hideLoading(binding);
                binding.txtMainInfo.setText(s);
                binding.txtMainInfo.setTextColor(getActivity().getColor(R.color.item_green));
            }
        });

        model.eventShowTxtError.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hideLoading(binding);
                binding.txtMainInfo.setText(s);
                binding.txtMainInfo.setTextColor(getActivity().getColor(R.color.red));

            }
        });

        model.eventIncorrectLoginResetError.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hideLoading(binding);
                showIncorrectResetLoginTxt(s, binding);
            }
        });

        model.eventIncorrectLoginFieldError.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showAuthIncorrectLoginField(binding);
            }
        });

        model.eventIncorrectPassFieldError.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showAuthIncorrectPassField(binding);
            }
        });

        model.eventShowLoading.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showLoading(binding);
                hideAuthIncorrectLoginField(binding);
                hideAuthIncorrectPassField(binding);
            }
        });

        model.eventOpenApp.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                navigator.navigateToMainApp(view);
            }
        });
    }

    private void showMainAuth() {
        binding.splashLayout.getRoot().setVisibility(View.GONE);
        binding.progressBar.setVisibility(View.INVISIBLE);
        binding.imageView5.setVisibility(View.VISIBLE);
        binding.textView5.setVisibility(View.VISIBLE);
        binding.txtMainInfo.setVisibility(View.INVISIBLE);
    }

}