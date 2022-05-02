package android.famme.learnenglishapp.auth;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {


    private MutableLiveData<String> liveData = new MutableLiveData<>();

    MutableLiveData<Boolean> eventLoading = new MutableLiveData<>();

    MutableLiveData<View> eventRightRegData = new MutableLiveData<>();

    MutableLiveData<View> eventWrongRegData = new MutableLiveData<>();

    public void checkLoginAndPass(String login, String pass, View v) throws InterruptedException {
        eventRightRegData.postValue(v);
       // Thread.sleep(4000);

    }

    public void init() {

    }


}
