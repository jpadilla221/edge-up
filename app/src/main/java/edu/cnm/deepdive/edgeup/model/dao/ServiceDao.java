package edu.cnm.deepdive.edgeup.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.edgeup.model.entity.Service;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ServiceDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert (Service service);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert (Collection<Service> services);

  @Update
  Single<Integer> update(Service service);

  @Delete
  Single<Integer> delete(Service... services);

  @Query("SELECT * FROM Service ORDER BY name")
  LiveData<List<Service>> select();

  @Query("SELECT * FROM Service WHERE service_id = :id")
  Single<Service> select(long id);
}

