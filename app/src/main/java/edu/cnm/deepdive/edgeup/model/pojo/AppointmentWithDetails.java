package edu.cnm.deepdive.edgeup.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.edgeup.model.entity.Appointment;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.model.entity.Service;

public class AppointmentWithDetails extends Appointment {

  @Relation(entity = Barber.class, entityColumn = "barber_id", parentColumn = "barber_id")
  private Barber barber;

  @Relation(entity = Service.class, entityColumn = "service_id", parentColumn = "service_id")
  private Service service;

  public Barber getBarber() {
    return barber;
  }

  public void setBarber(Barber barber) {
    this.barber = barber;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }
}
