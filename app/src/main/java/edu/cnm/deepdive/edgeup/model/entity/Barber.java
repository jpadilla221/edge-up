package edu.cnm.deepdive.edgeup.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = "name", unique = true)
    }
)
public class Barber {

  @ColumnInfo(name = "barber_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name;

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
}
