package android.famme.learnenglishapp.ui.themes.theme;

import android.famme.learnenglishapp.R;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThemeViewModel extends ViewModel {

    MutableLiveData<Integer> eventGetRoad = new MutableLiveData<>();

    public void getAudioRoad(String audio) {
        switch (audio) {
            case "personality":
                eventGetRoad.postValue(R.raw.personality);
                break;
            case "shopping":
                eventGetRoad.postValue(R.raw.shopping);
                break;
            case "education":
                eventGetRoad.postValue(R.raw.education);
                break;
            case "family":
                eventGetRoad.postValue(R.raw.family);
                break;
            case "lifestyle":
                eventGetRoad.postValue(R.raw.lifestyle);
                break;
            case "clothes":
                eventGetRoad.postValue(R.raw.clothes);
                break;
            case "books":
                eventGetRoad.postValue(R.raw.books);
                break;
            case "culture":
                eventGetRoad.postValue(R.raw.culture);
                break;
            case "life":
                eventGetRoad.postValue(R.raw.life);
                break;
            case "summer":
                eventGetRoad.postValue(R.raw.summer);
                break;
        }
    }


}
