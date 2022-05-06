package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.famme.learnenglishapp.utils.navigator.Navigator;
import android.famme.learnenglishapp.utils.authentication_data_checker.AuthChecker;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    INavigator getNavigator() {
        return new Navigator();
    }

    @Provides
    IAuthChecker getAuthChecker(App app) {
        return new AuthChecker(app);
    }

}
