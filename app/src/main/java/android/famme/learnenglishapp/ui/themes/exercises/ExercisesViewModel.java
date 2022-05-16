package android.famme.learnenglishapp.ui.themes.exercises;

import android.content.Context;
import android.famme.learnenglishapp.data.storage.tasks.Personality;
import android.famme.learnenglishapp.data.storage.tasks.Task;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExercisesViewModel extends ViewModel {

    private int exNumber = 0;

    private int countRightAnswers = 0;

    MutableLiveData<Boolean> eventReturnToAudio = new MutableLiveData<>();

    MutableLiveData<Boolean> eventReturnToThemes = new MutableLiveData<>();

    MutableLiveData<Integer> eventDisplayTask = new MutableLiveData<>();

    public Task getThemeTask(String theme, Context context) {

        Task task = null;

        switch (theme) {
            case "personality":
                task = new Personality(context);
                break;
            default:
                task = new Personality(context);
                break;
        }
        return task;
    }

    public void goBack() {
        if (exNumber != 11) {
            exNumber--;
        }
        if (exNumber == 0) {
            eventReturnToAudio.postValue(true);
        } else if (exNumber < 11) {
            eventDisplayTask.postValue(exNumber);
        } else {

        }
    }

    public void goForward() {
        exNumber++;
        if (exNumber < 12) {
            eventDisplayTask.postValue(exNumber);
        } else {
            eventReturnToThemes.postValue(true);
        }
    }

    public void checkTask(String userAnswer, String rightAnswer) {
        if (userAnswer.equals(rightAnswer)) {
            countRightAnswers++;
            System.out.println("countRightAnswers " + countRightAnswers);
        }
    }

    public int getResult() {
        return countRightAnswers;
    }

}
