package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.ui.MainActivity;
import android.famme.learnenglishapp.ui.auth.AuthFragment;
import android.famme.learnenglishapp.ui.auth.AuthViewModel;
import android.famme.learnenglishapp.ui.profile.ProfileFragment;
import android.famme.learnenglishapp.ui.profile.ProfileViewModel;
import android.famme.learnenglishapp.ui.progress.ProgressFragment;
import android.famme.learnenglishapp.ui.progress.ProgressViewModel;
import android.famme.learnenglishapp.ui.themes.ThemesFragment;
import android.famme.learnenglishapp.ui.themes.ThemesViewModel;
import android.famme.learnenglishapp.ui.themes.exercises.ExercisesFragment;
import android.famme.learnenglishapp.ui.themes.exercises.ExercisesViewModel;
import android.famme.learnenglishapp.ui.themes.theme.ThemeFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                DataModule.class,
                UtilsModule.class,
                FirebaseModule.class,
                InteractorModule.class
        }
)
public interface AppComponent {

    void inject(ExercisesViewModel exercisesViewModel);

    void inject(ExercisesFragment exercisesFragment);

    void inject(ProgressViewModel progressViewModel);

    void inject(ProgressFragment progressFragment);

    void inject(ThemesFragment themesFragment);

    void inject(ThemesViewModel themesViewModel);

    void inject(ThemeFragment themeFragment);

    void inject(MainActivity mainActivity);

    void inject(AuthViewModel authViewModel);

    void inject(AuthFragment authFragment);

    void inject(ProfileViewModel profileViewModel);

    void inject(ProfileFragment profileFragment);

    void inject(App app);

}



