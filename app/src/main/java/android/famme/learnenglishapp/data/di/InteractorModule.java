package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.data.storage.room.ResultDao;
import android.famme.learnenglishapp.ui.interactor.MainInteractor;
import android.famme.learnenglishapp.utils.firebase.IAuthFirebase;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    MainInteractor getProfileInteractor(ResultDao resultDao, IAuthFirebase iAuthFirebase) {
        return new MainInteractor(resultDao, iAuthFirebase);
    }

}
