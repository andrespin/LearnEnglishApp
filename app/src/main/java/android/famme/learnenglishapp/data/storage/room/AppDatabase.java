package android.famme.learnenglishapp.data.storage.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ResultEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ResultDao resultDao();
}
