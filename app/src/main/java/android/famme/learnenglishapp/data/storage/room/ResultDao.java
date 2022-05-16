package android.famme.learnenglishapp.data.storage.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ResultDao {

    @Insert
    void insert(ResultEntity resultEntity);

    @Query("SELECT * FROM result")
    List<ResultEntity> getAll();

    @Update
    void update(ResultEntity resultEntity);

    @Delete
    void delete(ResultEntity resultEntity);

    @Query("DELETE FROM result")
    void deleteAllResults();

}
