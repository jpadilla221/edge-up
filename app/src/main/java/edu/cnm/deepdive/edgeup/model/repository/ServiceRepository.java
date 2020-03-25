package edu.cnm.deepdive.edgeup.model.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.edgeup.model.dao.ServiceDao;
import edu.cnm.deepdive.edgeup.model.entity.Service;
import edu.cnm.deepdive.edgeup.service.EdgeUpDatabase;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ServiceRepository {

  private final EdgeUpDatabase database;
  private final Context context;

  public ServiceRepository(Context context) {
    this.database = EdgeUpDatabase.getInstance();

    this.context = context;
  }

  public LiveData<List<Service>> getAll() {
    ServiceDao dao = database.getServiceDao();
    return dao.select();
  }

  public LiveData<Service> get(long id) {
    ServiceDao dao = database.getServiceDao();
    return dao.select(id);
  }

  public Completable save(Service service) {
    ServiceDao dao = database.getServiceDao();
    if (service.getId() == 0) {
      return Completable.fromSingle(
          dao.insert(service)
              .subscribeOn(Schedulers.io())
      );
    } else {
      return Completable.fromSingle(
          dao.update(service)
              .subscribeOn(Schedulers.io())
      );
    }
  }

  public Completable remove(Service service) {
    ServiceDao dao = database.getServiceDao();
    return Completable.fromSingle(
        dao.delete(service)
    );
  }
}
