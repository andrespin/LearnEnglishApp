package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.utils.authentication_data_checker.IAuthChecker;
import android.famme.learnenglishapp.utils.converter.Converter;
import android.famme.learnenglishapp.utils.converter.IConverter;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.famme.learnenglishapp.utils.navigator.Navigator;
import android.famme.learnenglishapp.utils.authentication_data_checker.AuthChecker;
import android.famme.learnenglishapp.utils.themes.Results;
import android.famme.learnenglishapp.utils.themes.ResultsSetter;

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

    @Provides
    Results getResultsSetter() {
        return new ResultsSetter();
    }

    @Provides
    IConverter getConverter() {
        return new Converter();
    }

}
