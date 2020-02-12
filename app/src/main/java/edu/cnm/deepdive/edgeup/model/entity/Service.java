package edu.cnm.deepdive.edgeup.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Service {

  @ColumnInfo(name = "service_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "name", collate = ColumnInfo.NOCASE)
  private String name;

  private int duration;

  private String description;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
