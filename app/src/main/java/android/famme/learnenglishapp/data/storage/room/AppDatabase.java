package android.famme.learnenglishapp.data.storage.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ResultEntity.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ResultDao resultDao();
}
