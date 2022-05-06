package android.famme.learnenglishapp.ui.auth;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentAuthBinding;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import androidx.fragment.app.Fragment;

abstract class BaseAuthFragment extends Fragment {

    protected boolean isPassVisible = false;

    protected boolean isPassRegVisible = false;

    protected boolean isPassRegRepeatVisible = false;

    protected View view;

    protected FragmentAuthBinding binding;

    protected AuthViewModel model;

    protected void showRecoverLayout(FragmentAuthBinding binding) {
        binding.authLayout.getRoot().setVisibility(View.GONE);
        binding.regLayout.getRoot().setVisibility(View.GONE);
        binding.recoverLayout.getRoot().setVisibility(View.VISIBLE);
    }

    protected void showAuthLayout(FragmentAuthBinding binding) {
        binding.authLayout.getRoot().setVisibility(View.VISIBLE);
        binding.regLayout.getRoot().setVisibility(View.GONE);
        binding.recoverLayout.getRoot().setVisibility(View.GONE);
    }

    protected void showRegLayout(FragmentAuthBinding binding) {
        binding.authLayout.getRoot().setVisibility(View.GONE);
        binding.regLayout.getRoot().setVisibility(View.VISIBLE);
        binding.recoverLayout.getRoot().setVisibility(View.GONE);
    }

    protected void setAuthLayoutPassVisible(FragmentAuthBinding binding) {
        binding.authLayout.txtEnterPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        binding.authLayout.imgShowHidePass.setImageResource(R.drawable.ic_eye_show);
        isPassVisible = true;
    }

    protected void setAuthLayoutPassInvisible(FragmentAuthBinding binding) {
        binding.authLayout.txtEnterPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        binding.authLayout.imgShowHidePass.setImageResource(R.drawable.ic_eye_hide);
        isPassVisible = false;
    }

    protected void setRegLayoutRepeatPassVisible(FragmentAuthBinding binding) {
        binding.regLayout.txtRepeatPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        binding.regLayout.imgShowHidePassRepeat.setImageResource(R.drawable.ic_eye_show);
        isPassRegRepeatVisible = true;
    }

    protected void setRegLayoutRepeatPassInvisible(FragmentAuthBinding binding) {
        binding.regLayout.txtRepeatPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        binding.regLayout.imgShowHidePassRepeat.setImageResource(R.drawable.ic_eye_hide);
        isPassRegRepeatVisible = false;
    }

    protected void setRegLayoutPassVisible(FragmentAuthBinding binding) {
        binding.regLayout.txtEnterPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        binding.regLayout.imgShowHidePass.setImageResource(R.drawable.ic_eye_show);
        isPassRegVisible = true;
    }

    protected void setRegLayoutPassInvisible(FragmentAuthBinding binding) {
        binding.regLayout.txtEnterPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        binding.regLayout.imgShowHidePass.setImageResource(R.drawable.ic_eye_hide);
        isPassRegVisible = false;
    }

    protected void showIncorrectLoginOrPasswordTxt(String s, FragmentAuthBinding binding) {
        binding.authLayout.txtIncorrectPassOrLogin.setVisibility(View.VISIBLE);
        binding.authLayout.txtIncorrectPassOrLogin.setText(s);
        hideAuthLoading(binding);
    }

    protected void showAuthIncorrectLoginField(FragmentAuthBinding binding) {
        binding.authLayout.imageEnterLogin.setImageResource(R.drawable.back_entrance_red);
    }

    protected void hideAuthIncorrectLoginField(FragmentAuthBinding binding) {
        binding.authLayout.imageEnterLogin.setImageResource(R.drawable.back_entrance);
    }

    protected void showAuthIncorrectPassField(FragmentAuthBinding binding) {
        binding.authLayout.imageEnterPass.setImageResource(R.drawable.back_entrance_red);
    }

    protected void hideAuthIncorrectPassField(FragmentAuthBinding binding) {
        binding.authLayout.imageEnterPass.setImageResource(R.drawable.back_entrance);
    }

    protected void showAuthLoading(FragmentAuthBinding binding) {
        binding.authLayout.progressBar.setVisibility(View.VISIBLE);
        binding.authLayout.txtIncorrectPassOrLogin.setVisibility(View.INVISIBLE);
    }

    protected void showIncorrectResetLoginTxt(String s, FragmentAuthBinding binding) {
        hideResetLoading(binding);
        binding.recoverLayout.txtIncorrectLogin.setVisibility(View.VISIBLE);
        binding.recoverLayout.txtIncorrectLogin.setText(s);
    }

    protected void showResetLoading(FragmentAuthBinding binding) {
        binding.recoverLayout.progressBar.setVisibility(View.VISIBLE);
        binding.recoverLayout.txtIncorrectLogin.setVisibility(View.INVISIBLE);
    }

    protected void hideResetLoading(FragmentAuthBinding binding) {
        binding.recoverLayout.progressBar.setVisibility(View.INVISIBLE);
        binding.recoverLayout.txtIncorrectLogin.setVisibility(View.VISIBLE);
    }

    protected void showResetIncorrectLoginField(FragmentAuthBinding binding) {
        binding.recoverLayout.imageEnterLogin.setImageResource(R.drawable.back_entrance_red);
    }

    protected void hideResetIncorrectLoginField(FragmentAuthBinding binding) {
        binding.recoverLayout.imageEnterLogin.setImageResource(R.drawable.back_entrance);
    }

    protected void hideAuthLoading(FragmentAuthBinding binding) {
        binding.authLayout.progressBar.setVisibility(View.INVISIBLE);
        binding.authLayout.txtIncorrectPassOrLogin.setVisibility(View.VISIBLE);
    }

    // --------------------

    protected void showRegLoading(FragmentAuthBinding binding) {
        binding.regLayout.progressBar.setVisibility(View.VISIBLE);
      //  binding.regLayout.txtIncorrectLogin.setVisibility(View.INVISIBLE);
    }

    protected void hideRegLoading(FragmentAuthBinding binding) {
        binding.recoverLayout.progressBar.setVisibility(View.INVISIBLE);
        binding.recoverLayout.txtIncorrectLogin.setVisibility(View.VISIBLE);
    }

}
