package edu.cnm.deepdive.edgeup.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.edgeup.model.entity.Appointment;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.model.entity.Service;
import edu.cnm.deepdive.edgeup.model.repository.AppointmentRepository;
import edu.cnm.deepdive.edgeup.model.repository.BarberRepository;
import edu.cnm.deepdive.edgeup.model.repository.ServiceRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

  private final BarberRepository barberRepository;
  private final ServiceRepository serviceRepository;
  private final AppointmentRepository appointmentRepository;
  private final MutableLiveData<Long> barberId;
  private final LiveData<Barber> barber;
  private final MutableLiveData<Long> serviceId;
  private final LiveData<Service> service;
  private final MutableLiveData<Long> appointmentId;
  private final LiveData<Appointment> appointment;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public MainViewModel(@NonNull Application application) {
    super(application);
    barberRepository = new BarberRepository(application);
    serviceRepository = new ServiceRepository(application);
    appointmentRepository = new AppointmentRepository(application);
    barberId = new MutableLiveData<>();
    barber = Transformations.switchMap(barberId, barberRepository::get);
    serviceId = new MutableLiveData<>();
    service = Transformations.switchMap(serviceId, (id) -> serviceRepository.get(id));
    appointmentId = new MutableLiveData<>();
    appointment = Transformations.switchMap(appointmentId, (id) -> appointmentRepository.get(id));
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LiveData<Barber> getBarber() {
    return barber;
  }

  public LiveData<Service> getService() {
    return service;
  }

  public LiveData<Appointment> getAppointment() {
    return appointment;
  }

  public void setBarberId(long id) {
    barberId.setValue(id);
  }

  public void setServiceId(long id) {
    serviceId.setValue(id);
  }

  public void setAppointmentId(long id) {
    appointmentId.setValue(id);
  }

  public LiveData<List<Barber>> getBarbers() {
    return barberRepository.getAll();
  }

  public LiveData<List<Service>> getServices() {
    return serviceRepository.getAll();
  }

  public LiveData<List<Appointment>> getAppointments() {
    return appointmentRepository.getAll();
  }

  public void save(Barber barber) {
    throwable.setValue(null);
    pending.add(
        barberRepository.save(barber)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }

  public void remove(Barber barber) {
    throwable.setValue(null);
    pending.add(
        barberRepository.remove(barber)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }

  public void save(Service service) {
    throwable.setValue(null);
    pending.add(
        serviceRepository.save(service)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }

  public void remove(Service service) {
    throwable.setValue(null);
    pending.add(
        serviceRepository.remove(service)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }

  public void save(Appointment appointment) {
    throwable.setValue(null);
    pending.add(
        appointmentRepository.save(appointment)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }

  public void remove(Appointment appointment) {
    throwable.setValue(null);
    pending.add(
        appointmentRepository.remove(appointment)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }
}

