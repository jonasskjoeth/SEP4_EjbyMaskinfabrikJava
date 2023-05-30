package model;

import java.sql.Timestamp;
import java.util.Date;

public class InformationTable
{
  private String type;
  private int id;
  private String manufacturer;
  private int placementRow;
  private int placementColumn;
  private Date installDate;
  private String contactInfoEmail;
  private int contactInfoPhone;
  private Timestamp logDate;

  public InformationTable(String manufacturer, int placementRow,
      int placementColumn, Date installDate, String contactInfoEmail,
      int contactInfoPhone, String type)
  {
    this(-1, manufacturer, placementRow, placementColumn, installDate,
        contactInfoEmail, contactInfoPhone, type);
  }

  public InformationTable(int id, String manufacturer, int placementRow,
      int placementColumn, Date installDate, String contactInfoEmail,
      int contactInfoPhone, String type, Timestamp logDate)
  {
    this.manufacturer = manufacturer;
    this.placementRow = placementRow;
    this.placementColumn = placementColumn;
    this.installDate = installDate;
    this.contactInfoEmail = contactInfoEmail;
    this.contactInfoPhone = contactInfoPhone;
    this.type = type;
    this.logDate = logDate;
  }

  public InformationTable(int id, String manufacturer, int placementRow,
      int placementColumn, Date installDate, String contactInfoEmail,
      int contactInfoPhone, String type)
  {
    this.manufacturer = manufacturer;
    this.placementRow = placementRow;
    this.placementColumn = placementColumn;
    this.installDate = installDate;
    this.contactInfoEmail = contactInfoEmail;
    this.contactInfoPhone = contactInfoPhone;
    this.type = type;
    this.id = id;
  }
  public Timestamp getLogDate()
  {
    return logDate;
  }

  public void setLogDate(Timestamp logDate)
  {
    this.logDate = logDate;
  }

  public String getManufacturer()
  {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer)
  {
    this.manufacturer = manufacturer;
  }

  public int getPlacementRow()
  {
    return placementRow;
  }

  public void setPlacementRow(int placementRow)
  {
    this.placementRow = placementRow;
  }

  public int getPlacementColumn()
  {
    return placementColumn;
  }

  public void setPlacementColumn(int placementColumn)
  {
    this.placementColumn = placementColumn;
  }

  public Date getInstallDate()
  {
    return installDate;
  }

  public void setInstallDate(Date installDate)
  {
    this.installDate = installDate;
  }

  public String getContactInfoEmail()
  {
    return contactInfoEmail;
  }

  public void setContactInfoEmail(String contactInfoEmail)
  {
    this.contactInfoEmail = contactInfoEmail;
  }

  public int getContactInfoPhone()
  {
    return contactInfoPhone;
  }

  public void setContactInfoPhone(int contactInfoPhone)
  {
    this.contactInfoPhone = contactInfoPhone;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String toString()
  {
    if (id > -1)
    {
      return "model.InformationTable [id=" + id + ", manufacturer="
          + manufacturer + ", placementRow=" + placementRow
          + ", placementColumn=" + placementColumn + ", Installationdate="
          + installDate + ", contactInfoEmail=" + contactInfoEmail
          + ", contactInfoPhone=" + contactInfoPhone + ", type=" + type + "]";
    }
    else
    {
      return "model.InformationTable [id=unspecified, manufacturer="
          + manufacturer + ", placementRow=" + placementRow
          + ", placementColumn=" + placementColumn + ", Installationdate="
          + installDate + ", contactInfoEmail=" + contactInfoEmail
          + ", contactInfoPhone=" + contactInfoPhone + ", type=" + type + "]";
    }
  }
}
