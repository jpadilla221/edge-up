package edu.cnm.deepdive.edgeup;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.edgeup.service.EdgeUpDatabase;
import io.reactivex.schedulers.Schedulers;

public class EdgeUpApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    EdgeUpDatabase.setContext(this);
    EdgeUpDatabase.getInstance().getAppointmentDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
