package edu.cnm.deepdive.getback.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.getback.model.entity.Appointment;
import edu.cnm.deepdive.getback.model.entity.Service;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface AppointmentDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert (Appointment appointment);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Appointment> appointments);

  @Update
  Single<Integer> update (Appointment appointment);

  @Delete
  Single<Integer> delete (Appointment... appointments);

  @Query("SELECT * FROM Appointment ORDER BY date")
  LiveData<List<Appointment>> select();

}
