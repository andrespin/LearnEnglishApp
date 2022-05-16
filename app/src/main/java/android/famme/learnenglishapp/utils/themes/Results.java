package android.famme.learnenglishapp.utils.themes;

import android.famme.learnenglishapp.data.storage.room.ResultEntity;

public interface Results {

    ResultEntity setTheme(String theme, int result, ResultEntity resultEntity);

    ResultEntity getNewResultEntity(String login);

}
