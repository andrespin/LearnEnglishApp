package android.famme.learnenglishapp.ui.auth;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentAuthBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;


abstract class BaseAuthFragmentListeners extends BaseAuthFragmentInit {

    protected void initAuthLayoutImgBtnRegisterClick(FragmentAuthBinding binding) {
        binding.authLayout.imgBtnRegister
                .setImageResource(R.drawable.back_image_button_green_clicked);
        Completable
                .complete()
                .delay(200, TimeUnit.MILLISECONDS)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        binding.authLayout.imgBtnRegister
                                .setImageResource(R.drawable.back_image_button_green);
                        model.showRegister();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }


    protected void initAuthLayoutImgLogInClick(FragmentAuthBinding binding) {

        binding.authLayout.imgLogIn
                .setImageResource(R.drawable.back_image_button_purple_clicked);
        Completable
                .complete()
                .delay(200, TimeUnit.MILLISECONDS)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        binding.authLayout.imgLogIn
                                .setImageResource(R.drawable.back_image_button_purple);
                        String login = binding.authLayout.txtEnterLogin.getText().toString()
                                .replace(" ", "");

                        String pass = binding.authLayout.txtEnterPass.getText().toString()
                                .replace(" ", "");
                        model.checkLoginAndPass(login, pass, getActivity());

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }


    protected void initRecoverLayoutImgLogInClick(FragmentAuthBinding binding) {

        binding.recoverLayout.imgBtnRecover
                .setImageResource(R.drawable.back_image_button_green_clicked);
        Completable
                .complete()
                .delay(200, TimeUnit.MILLISECONDS)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        binding.recoverLayout.imgBtnRecover
                                .setImageResource(R.drawable.back_image_button_green);
                        String login = binding.recoverLayout.txtEnterLogin
                                .getText().toString().replace(" ", "");
                        model.checkLoginAndPass(login);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }


    protected void initRecoverLayoutImgBtnLogInAgainClick(FragmentAuthBinding binding) {

        binding.recoverLayout.imgBtnLogInAgain
                .setImageResource(R.drawable.back_image_button_purple_clicked);
        Completable
                .complete()
                .delay(200, TimeUnit.MILLISECONDS)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        binding.recoverLayout.imgBtnLogInAgain
                                .setImageResource(R.drawable.back_image_button_purple);
                        model.showAuth();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }


    protected void initRegLayoutImgBtnRegisterClick(FragmentAuthBinding binding) {

        binding.regLayout.imgBtnRegister
                .setImageResource(R.drawable.back_image_button_green_clicked);
        Completable
                .complete()
                .delay(200, TimeUnit.MILLISECONDS)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        binding.regLayout.imgBtnRegister
                                .setImageResource(R.drawable.back_image_button_green);
                        String email = binding.regLayout.txtEnterLogin.getText().
                                toString().replace(" ", "");

                        String pass = binding.regLayout.txtEnterPass.getText()
                                .toString().replace(" ", "");

                        String passRepeat = binding.regLayout.txtRepeatPass.getText()
                                .toString().replace(" ", "");

                        String name = binding.regLayout.editEnterName.getText()
                                .toString().replace(" ", "");

                        model.checkLoginAndPass(email, pass, passRepeat, name, getActivity());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }


    protected void initRegLayoutImgLogInClick(FragmentAuthBinding binding) {

        binding.regLayout.imgLogIn
                .setImageResource(R.drawable.back_image_button_purple_clicked);
        Completable
                .complete()
                .delay(200, TimeUnit.MILLISECONDS)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        binding.regLayout.imgLogIn
                                .setImageResource(R.drawable.back_image_button_purple);
                        clearTxtInfo(binding);
                        clearRegFields(binding);
                        model.showAuth();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }


}
