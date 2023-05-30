package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.InformationTable;
import model.SolarTable;
import model.ThermalTable;

import java.time.LocalDate;
import java.util.ArrayList;

import java.sql.*;
import java.util.List;

// PLEASE NOTE: For the connection to properly establish, use
// "postgresql-42.2.5.jar" in external libraries

public class DatabaseConnector
{
  private Connection connection;
  public String informationTable = "InformationTable";
  public String thermalTable = "ThermalTable";
  public String solarTable = "SolarTable";
  public String quotes = "\"";

  public void connect(String host, int portNo, String userName, String password)
  {
    // Establishing a PostgreSQL database connection
    String databaseUrl =
        "jdbc:postgresql://" + host + ":" + portNo + "/" + userName;

    try
    {
      connection = DriverManager.getConnection(databaseUrl, userName, password);
      System.out.println("Connection established to: " + databaseUrl);
    }
    catch (Exception exception)
    {
      System.out.println("Connection failed");
      exception.printStackTrace();
    }
  }

  private Timestamp convertToSqlTimestamp(java.util.Date uDate)
  {
    Timestamp timestamp = new Timestamp(uDate.getTime());
    return timestamp;
  }

  public void storeInformation(InformationTable information)
  {
    String sql =
        "INSERT INTO public." + quotes + informationTable + quotes + " (" + "\""
            + "manufacturer" + "\"" + ",\"" + "placementrow" + "\"," + "\""
            + "placementcolumn" + "\"," + "\"" + "installdate" + "\"," + "\""
            + "contactinfoemail" + "\"," + "\"" + "contactinfophone" + "\""
            + ",\"type\"" + ") VALUES (" + "'" + information.getManufacturer()
            + "'" + "," + "'" + information.getPlacementRow() + "'" + "," + "'"
            + information.getPlacementColumn() + "'" + "," + "'"
            + convertToSqlTimestamp(information.getInstallDate()) + "'" + ","
            + "'" + information.getContactInfoEmail() + "'" + "," + "'"
            + information.getContactInfoPhone() + "','" + information.getType()
            + "')";

    try
    {
      Statement statement = connection.createStatement();
      statement.executeUpdate(sql);
      System.out.println("Succesfully executed SQL statement");
    }
    catch (SQLException e)
    {
      System.out.println(
          "Error trying to insert new information in InformationTable");
      e.printStackTrace();
    }
  }

  public ObservableList<ThermalTable> retrieveThermalTable()
  {
    ObservableList<ThermalTable> result = FXCollections.observableArrayList();

    String sql = "SELECT * FROM public." + quotes + thermalTable + quotes;

    try
    {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql); // use the executeQuery() function when a result is expected

      while (resultSet.next())
      { // Goes to the next row of data if available
        ThermalTable thTable = new ThermalTable(resultSet.getTimestamp(1),
            resultSet.getFloat(2), resultSet.getFloat(3), resultSet.getFloat(4),
            resultSet.getFloat(5));
        result.add(thTable);
      }

    }
    catch (SQLException e)
    {
      System.out.println("Error trying to generate table of Thermal Panels");
      e.printStackTrace();
    }
    return result;
  }

  public ObservableList<SolarTable> retrieveSolarTable()
  {
    ObservableList<SolarTable> result = FXCollections.observableArrayList();

    String sql = "SELECT * FROM public." + quotes + solarTable + quotes;

    try
    {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next())
      { // Goes to the next row of data if available
        SolarTable slTable = new SolarTable(resultSet.getFloat(1),
            resultSet.getFloat(2), resultSet.getFloat(3), resultSet.getDate(4));
        result.add(slTable);
      }

    }
    catch (SQLException e)
    {
      System.out.println("Error trying to generate table of Solar Panels");
      e.printStackTrace();
    }
    return result;
  }

  public ObservableList<InformationTable> retrieveInformationTable()
  {
    ObservableList<InformationTable> result = FXCollections.observableArrayList();

    String sql = "SELECT * FROM public." + quotes + informationTable + quotes;

    try
    {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
          sql); // use the executeQuery() function when a result is expected

      while (resultSet.next())
      { // Goes to the next row of data if available
        InformationTable inTable = new InformationTable(resultSet.getInt(1),
            resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),
            resultSet.getDate(5), resultSet.getString(7), resultSet.getInt(6),
            resultSet.getString(8));
        result.add(inTable);
      }

    }
    catch (SQLException e)
    {
      System.out.println(
          "Error trying to generate table of Information Panels");
      e.printStackTrace();
    }
    return result;
  }

  public void updateInformation(InformationTable information)
  {
    String sql =
        "UPDATE public.\"InformationTable\" SET (manufacturer, placementrow, placementcolumn, "
            + "contactinfoemail, contactinfophone, type) = ('"
            + information.getManufacturer() + "',"
            + information.getPlacementRow() + ","
            + information.getPlacementColumn() + ",'"
            + information.getContactInfoEmail() + "',"
            + information.getContactInfoPhone() + ",'"
            + information.getType() + "')"
            + " WHERE id = " + information.getId() + ";";

    try
    {
      Statement statement = connection.createStatement();
      statement.executeUpdate(sql);
      System.out.println(
          "Succesfully executed SQL statement - update information");
    }
    catch (SQLException e)
    {
      System.out.println(
          "Error trying to update information in InformationTable");
      e.printStackTrace();
    }
  }

  //    public void deleteInformation(InformationTable information)
  //    {
  //        String sql = "DELETE FROM public.\"InformationTable\" WHERE (manufacturer, placementrow, placementcolumn, "
  //            + "contactinfoemail, contactinfophone) = ('" + information.getManufacturer()
  //            + "'," + information.getPlacementRow() + "," + information.getPlacementColumn()
  //            + ",'" + information.getContactInfoEmail() + "'," + information.getContactInfoPhone() + ")";
  //
  //        try {
  //            Statement statement = connection.createStatement();
  //            statement.executeUpdate(sql);
  //            System.out.println("Succesfully executed SQL statement - delete information");
  //        } catch (SQLException e) {
  //            System.out.println("Error trying to delete information in InformationTable");
  //            e.printStackTrace();
  //        }
  //    }

  public void deleteInformation(int id)
  {
    String deleteSQL =
        "DELETE FROM public." + quotes + informationTable + quotes
            + " WHERE \"manufacturer\" = 'manufacturer'";

    try (Statement mhh = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement(deleteSQL))
    {
      statement.setInt(1, id);
      int rowsAffected = statement.executeUpdate();

      if (rowsAffected > 0)
      {
        System.out.println("Data deleted successfully");
      }
      else
      {
        System.out.println("No data found matching the given criteria");
      }
    }
    catch (SQLException ex)
    {
      System.out.println("Error trying to delete data");
      ex.printStackTrace();
    }
  }

  public List<Double> getGraphTP(LocalDate FromDate, LocalDate ToDate)
  {
    List<Double> graphList = new ArrayList<>();

    String sql = "select tempOut from public.\"ThermalTable\"" + "where"
        + "\"ThermalTable\"" + ".datestamp between '" + FromDate + "' and '"
        + ToDate + "';";

    // select tempOut from "ThermalTable" where "ThermalTable".datestamp between '2022-01-01' and '2023-05-01';

    try
    {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      while (resultSet.next())
      {
        graphList.add(resultSet.getDouble("tempOut"));
      }
    }
    catch (SQLException e)
    {
      return graphList;
    }
    return graphList;
  }

  public ObservableList<InformationTable> getInfoLog()
  {
    ObservableList<InformationTable> result = FXCollections.observableArrayList();

    String sql =
        "select manufacturer, placementrow, placementcolumn, installdate, contactinfophone, type, contactinfoemail from "
            + "public.\"InformationTable_log\";";

    try
    {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next())
      {
        InformationTable informationTable1 = new InformationTable(
            resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3),
            resultSet.getDate(4), resultSet.getString(7),
            resultSet.getInt(5), resultSet.getString(6));
        result.add(informationTable1);
      }
    }
    catch (SQLException e)
    {
      System.out.println("Selection of information failed");
      e.printStackTrace();
    }
    return result;
  }

  public List<Double> getGraphSP(LocalDate fromDate, LocalDate toDate) {
    List<Double> graphList = new ArrayList<>();

    String sql = "select watt from public.SolarTable where SolarTable.date between '" + fromDate + "' and '"
        + toDate + "';";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setDate(1, Date.valueOf(fromDate));
      statement.setDate(2, Date.valueOf(toDate));

      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          graphList.add(resultSet.getDouble("watt"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return graphList;
  }

  public void close()
  {
    try
    {
      connection.close();
      System.out.println("Connection closed");
    }
    catch (SQLException exception)
    {
      System.out.println("Connection closing failed");
      exception.printStackTrace();
    }
  }
}

//    public void saveInformation(InformationTable information) {
//        try (Connection connection = DriverManager.getConnection("kandula.db.elephantsql.com")) {
//            String sql = "INSERT INTO information_table (manufacturer, placement_row, placement_column, install_date, contact_info_email, contact_info_phone) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            statement.setString(1, information.getManufacturer());
//            statement.setInt(2, information.getPlacementRow());
//            statement.setInt(3, information.getPlacementColumn());
//            statement.setDate(4, new java.sql.Date(information.getInstallDate().getTime()));
//            statement.setString(5, information.getContactInfoEmail());
//            statement.setInt(6, information.getContactInfoPhone());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Failed to save information to the database: " + e.getMessage());
//        }


