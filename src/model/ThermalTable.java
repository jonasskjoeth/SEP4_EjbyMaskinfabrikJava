package model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class ThermalTable
{
    private int id;
    private Timestamp datestamp;
    private float time;
    private float tempOut;
    private float tempCONTROL;
    private float tempIn;

    public ThermalTable(Timestamp datestamp, float time, float tempOut, float tempCONTROL, float tempIn)
    {
      this(-1, datestamp, time, tempOut, tempCONTROL, tempIn);
    }

    public ThermalTable(int id, Timestamp datestamp, float time, float tempOut, float tempCONTROL, float tempIn)
  {
    this.id = id;
    this.datestamp = datestamp;
    this.time = time;
    this.tempOut = tempOut;
    this.tempCONTROL = tempCONTROL;
    this.tempIn = tempIn;
  }

  public Date getDatestamp() {
    return datestamp;
  }

  public void setDatestamp(Timestamp datestamp) {
    this.datestamp = datestamp;
  }

  public float getTime()
  {
    return time;
  }

  public void setTime(float time)
  {
    this.time = time;
  }

  public float getTempOut()
  {
    return tempOut;
  }

  public void setTempOut(float tempOut)
  {
    this.tempOut = tempOut;
  }

  public float getTempCONTROL()
  {
    return tempCONTROL;
  }

  public void setTempCONTROL(float tempCONTROL)
  {
    this.tempCONTROL = tempCONTROL;
  }

  public float getTempIn()
  {
    return tempIn;
  }

  public void setTempIn(float tempIn)
  {
    this.tempIn = tempIn;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String toString() {
    if (id > -1) {
      return "model.Observation [id=" + id + ", datestamp=" + datestamp + ", time=" + time + ", tempOut=" + tempOut + ", tempIn="
              + tempIn + ", tempCONTROL=" + tempCONTROL + "]";
    } else {
      return "model.Observation [id=unspecified, datestamp=" + datestamp + ", time=" + time + ", tempOut=" + tempOut + ", tempIn="
              + tempIn + ", tempCONTROL=" + tempCONTROL + "]";
    }
  }
}
