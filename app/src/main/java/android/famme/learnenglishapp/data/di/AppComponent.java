package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.ui.auth.AuthFragment;
import android.famme.learnenglishapp.ui.auth.AuthViewModel;

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

    void inject(AuthViewModel authViewModel);

    void inject(AuthFragment authFragment);

    void inject(App app);
}



