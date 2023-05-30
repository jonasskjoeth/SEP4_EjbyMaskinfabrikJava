package model;

import java.sql.Date;

public class SolarTable
{
  private int id;
  private float volt;
  private float ampere;
  private float watt;
  private Date date;

  public SolarTable(float volt, float ampere, float watt, Date date)
  {
    this(-1, volt, ampere, watt, date);
  }

  public SolarTable(int id, float volt, float ampere, float watt, Date date)
  {
    this.id = id;
    this.volt = volt;
    this.ampere = ampere;
    this.watt = watt;
    this.date = date;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public float getVolt()
  {
    return volt;
  }

  public void setVolt(float volt)
  {
    this.volt = volt;
  }

  public float getAmpere()
  {
    return ampere;
  }

  public void setAmpere(float ampere)
  {
    this.ampere = ampere;
  }

  public float getWatt()
  {
    return watt;
  }

  public void setWatt(float watt)
  {
    this.watt = watt;
  }
}
