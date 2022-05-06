package android.famme.learnenglishapp.data.di;

import android.famme.learnenglishapp.utils.test.AuthData;
import android.famme.learnenglishapp.utils.test.IAuthFirebase;
import android.famme.learnenglishapp.utils.test.AuthFirebase;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.subjects.PublishSubject;

@Module
public class FirebaseModule {

    @Provides
    PublishSubject<AuthData> createEventAuth() {
        return PublishSubject.create();
    }

    @Provides
    IAuthFirebase getTest(PublishSubject<AuthData> eventAuth) {
        return new AuthFirebase(eventAuth);
    }

}