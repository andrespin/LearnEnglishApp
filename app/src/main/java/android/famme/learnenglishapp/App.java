package android.famme.learnenglishapp;

import android.app.Application;
import android.famme.learnenglishapp.data.di.AppComponent;
import android.famme.learnenglishapp.data.di.AppModule;
import android.famme.learnenglishapp.data.di.DaggerAppComponent;

public class App extends Application {

    public static App instance;

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
