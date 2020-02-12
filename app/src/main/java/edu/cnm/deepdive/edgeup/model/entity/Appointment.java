package edu.cnm.deepdive.edgeup.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import java.util.Date;

@Entity(
  foreignKeys = {
      @ForeignKey(
          entity = Barber.class,
          parentColumns = "barber_id",
          childColumns = "barber_id",
          onDelete = ForeignKey.CASCADE

      ),
      @ForeignKey(
          entity = Service.class,
          parentColumns = "service_id",
          childColumns = "service_id",
          onDelete = ForeignKey.CASCADE
      )

  }

)
public class Appointment {

  @ColumnInfo(name = "appointment_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "barber_id", index = true)
  private long barberId;

  @ColumnInfo(name = "service_id", index = true)
  private long serviceId;

  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  private String client;

  @ColumnInfo(index = true)
  private Date date;

  private int duration;

  private Status status;

  private String notes;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getBarberId() {
    return barberId;
  }

  public void setBarberId(long barberId) {
    this.barberId = barberId;
  }

  public long getServiceId() {
    return serviceId;
  }

  public void setServiceId(long serviceId) {
    this.serviceId = serviceId;
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public enum Status {
    PENDING, CANCELLED, COMPLETED, NO_SHOW, LATE;

    @TypeConverter
    public static Integer toInteger(Status value) {
      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static Status toMediaType(Integer value) {
      return (value != null) ? Status.values()[value]: null;
    }

  }

}
