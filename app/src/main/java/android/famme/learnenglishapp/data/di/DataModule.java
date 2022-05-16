package android.famme.learnenglishapp.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.data.storage.preferences.IPreferences;
import android.famme.learnenglishapp.data.storage.preferences.Preferences;
import android.famme.learnenglishapp.data.storage.room.AppDatabase;
import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.data.storage.themes.IThemes;
import android.famme.learnenglishapp.data.storage.themes.Themes;


import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    private final String databaseName = "database_1.0.0";

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

    @Provides
    @Singleton
    AppDatabase createAppDatabase(App app) {
        return Room.databaseBuilder(app, AppDatabase.class, databaseName)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    ResultDao provideResultDao(App app) {
        return createAppDatabase(app).resultDao();
    }

}
