package edu.cnm.deepdive.edgeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.model.entity.Service;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface BarberDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Barber barber);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Barber> barbers);

  @Update
  Single<Integer> update(Barber barber);

  @Delete
  Single<Integer> delete(Barber... barbers);

  @Query("SELECT * FROM Barber ORDER BY name")
  LiveData<List<Barber>> select();

  @Query("SELECT * FROM Barber WHERE barber_id = :id")
  Single<Barber> select(long id);

}
