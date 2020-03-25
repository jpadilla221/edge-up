package edu.cnm.deepdive.edgeup.model.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.edgeup.model.dao.BarberDao;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.service.EdgeUpDatabase;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


public class BarberRepository {

  private final EdgeUpDatabase database;
  private final Context context;

  public BarberRepository(Context context) {
    this.database = EdgeUpDatabase.getInstance();

    this.context = context;
  }

  public LiveData<List<Barber>> getAll() {
    BarberDao dao = database.getBarberDao();
    return dao.select();
  }

  public LiveData<Barber> get(long id) {
    BarberDao dao = database.getBarberDao();
    return dao.select(id);
  }

  public Completable save(Barber barber) {
    BarberDao dao = database.getBarberDao();
    if (barber.getId() == 0) {
      return Completable.fromSingle(
          dao.insert(barber)
              .subscribeOn(Schedulers.io())
      );
    } else {
      return Completable.fromSingle(
          dao.update(barber)
              .subscribeOn(Schedulers.io())
      );
    }
  }

  public Completable remove(Barber barber) {
    BarberDao dao = database.getBarberDao();
    return Completable.fromSingle(
        dao.delete(barber)
    );
  }

}
