package android.famme.learnenglishapp.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.data.storage.preferences.IPreferences;
import android.famme.learnenglishapp.data.storage.preferences.Preferences;
import android.famme.learnenglishapp.data.storage.themes.IThemes;
import android.famme.learnenglishapp.data.storage.themes.Themes;


import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    IPreferences getPreferences(SharedPreferences prefs) {
        return new Preferences(prefs);
    }

    @Provides
    SharedPreferences sharedPreferences(App app) {
        return app.getSharedPreferences("...", Context.MODE_PRIVATE);
    }

    @Provides
    IThemes getThemes() {
        return new Themes();
    }

}
