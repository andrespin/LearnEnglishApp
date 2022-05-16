package android.famme.learnenglishapp.data.storage.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "result")
public class ResultEntity {

    @NonNull
    @PrimaryKey
    public String theme;

    public int result;

    public ResultEntity(String theme, int result) {
        this.theme = theme;
        this.result = result;
    }
}
