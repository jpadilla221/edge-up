package edu.cnm.deepdive.edgeup.model.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.edgeup.model.dao.AppointmentDao;
import edu.cnm.deepdive.edgeup.model.entity.Appointment;
import edu.cnm.deepdive.edgeup.service.EdgeUpDatabase;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class AppointmentRepository {

  private final EdgeUpDatabase database;
  private final Context context;

  public AppointmentRepository(Context context) {
    this.database = EdgeUpDatabase.getInstance();

    this.context = context;
  }

  public LiveData<List<Appointment>> getAll() {
    AppointmentDao dao = database.getAppointmentDao();
    return dao.select();
  }

  public LiveData<Appointment> get(long id) {
    AppointmentDao dao = database.getAppointmentDao();
    return dao.select(id);
  }

  public Completable save(Appointment appointment) {
    AppointmentDao dao = database.getAppointmentDao();
    if (appointment.getId() == 0) {
      return Completable.fromSingle(
          dao.insert(appointment)
              .subscribeOn(Schedulers.io())
      );
    } else {
      return Completable.fromSingle(
          dao.update(appointment)
              .subscribeOn(Schedulers.io())
      );
    }
  }

  public Completable remove(Appointment appointment) {
    AppointmentDao dao = database.getAppointmentDao();
    return Completable.fromSingle(
        dao.delete(appointment)
    );
  }

}
