package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.App;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    App getApp() {
        return app;
    }

}
