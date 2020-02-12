package edu.cnm.deepdive.edgeup.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.edgeup.model.dao.AppointmentDao;
import edu.cnm.deepdive.edgeup.model.dao.BarberDao;
import edu.cnm.deepdive.edgeup.model.dao.ServiceDao;
import edu.cnm.deepdive.edgeup.model.entity.Appointment;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.model.entity.Service;
import edu.cnm.deepdive.edgeup.service.EdgeUpDatabase.Converters;
import java.util.Date;


@Database(
    entities = {Barber.class, Appointment.class, Service.class},
      version = 1,
    exportSchema = true

)
 @TypeConverters({Converters.class, Appointment.Status.class})
public abstract class EdgeUpDatabase extends RoomDatabase {
  private static final String DB_NAME = "edgeup_db";

  private static Application context;

  public static void setContext (Application context) {EdgeUpDatabase.context = context;}

  public static EdgeUpDatabase getInstance() {return InstanceHolder.INSTANCE;}

  public abstract AppointmentDao getAppointmentDao();

  public abstract BarberDao getBarberDao();

  public abstract ServiceDao getServiceDao();

  private static class InstanceHolder {

    private static final EdgeUpDatabase INSTANCE = Room.databaseBuilder(
        context, EdgeUpDatabase.class, DB_NAME)
        .build();
  }

  public static class Converters {

    @TypeConverter
    public static Long fromDate(Date date) {
      return (date != null) ? date.getTime() : null;
    }
    @TypeConverter
    public static Date fromLong(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }

}
