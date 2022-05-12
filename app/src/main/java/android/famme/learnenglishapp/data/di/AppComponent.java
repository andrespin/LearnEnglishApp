package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.ui.MainActivity;
import android.famme.learnenglishapp.ui.auth.AuthFragment;
import android.famme.learnenglishapp.ui.auth.AuthViewModel;
import android.famme.learnenglishapp.ui.profile.ProfileFragment;
import android.famme.learnenglishapp.ui.profile.ProfileViewModel;
import android.famme.learnenglishapp.ui.splash.SplashFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                DataModule.class,
                UtilsModule.class,
                FirebaseModule.class
        }
)
public interface AppComponent {

    void inject(SplashFragment splashFragment);

    void inject(MainActivity mainActivity);

    void inject(AuthViewModel authViewModel);

    void inject(AuthFragment authFragment);

    void inject(ProfileViewModel profileViewModel);

    void inject(ProfileFragment profileFragment);

    void inject(App app);

}



