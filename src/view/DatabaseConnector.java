package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.InformationTable;
import model.ThermalTable;

import java.util.Date;

import java.sql.*;

// PLEASE NOTE: For the connection to properly establish, use
// "postgresql-42.2.5.jar" in external libraries

public class DatabaseConnector {
    private Connection connection;
    public String informationTable = "InformationTable";
    public String thermalTable = "ThermalTable";
    public String quotes = "\"";

    public void connect(String host, int portNo, String userName, String password) {
        // Establishing a PostgreSQL database connection
        String databaseUrl = "jdbc:postgresql://" + host + ":" + portNo + "/" + userName;

        try {
            connection = DriverManager.getConnection(databaseUrl, userName, password);
            System.out.println("Connection established to: " + databaseUrl);
        } catch (Exception exception) {
            System.out.println("Connection failed");
            exception.printStackTrace();
        }
    }

    private Timestamp convertToSqlTimestamp(java.util.Date uDate) {
        Timestamp timestamp = new Timestamp(uDate.getTime());
        return timestamp;
    }


    public void storeInformation(InformationTable information) {
        String sql = "INSERT INTO public." + quotes + informationTable + quotes + " (" + "\"" + "manufacturer" + "\"" + ",\"" +
                "placementrow" + "\"," + "\"" + "placementcolumn" + "\"," + "\"" +
                "installdate" + "\"," + "\"" + "contactinfoemail" + "\"," + "\"" + "contactinfophone" + "\"" + ") VALUES (" + "'" + information.getManufacturer() + "'" + "," + "'" + information.getPlacementRow() + "'" + "," +
                "'" + information.getPlacementColumn() + "'" + "," + "'" + convertToSqlTimestamp(information.getInstallDate()) + "'" + "," + "'" + information.getContactInfoEmail()
                + "'" + "," + "'" + information.getContactInfoPhone() + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Succesfully executed SQL statement");
        } catch (SQLException e) {
            System.out.println("Error trying to insert new information in InformationTable");
            e.printStackTrace();
        }
    }

    public ObservableList<ThermalTable> retrieveThermalTable() {
        ObservableList<ThermalTable> result = FXCollections.observableArrayList();

        String sql = "SELECT * FROM public." + quotes + thermalTable + quotes;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); // use the executeQuery() function when a result is expected

            while (resultSet.next()) { // Goes to the next row of data if available
                ThermalTable thTable = new ThermalTable(resultSet.getDate(1), resultSet.getFloat(2),
                        resultSet.getFloat(3), resultSet.getFloat(4), resultSet.getFloat(5));
                result.add(thTable);
            }

        } catch (SQLException e) {
            System.out.println("Error trying to generate table of Thermal Panels");
            e.printStackTrace();
        }
        return result;
    }

    public ObservableList<InformationTable> retrieveInformationTable() {
        ObservableList<InformationTable> result = FXCollections.observableArrayList();

        String sql = "SELECT * FROM public." + quotes + informationTable + quotes;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); // use the executeQuery() function when a result is expected

            while (resultSet.next()) { // Goes to the next row of data if available
                InformationTable inTable = new InformationTable(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6));
                result.add(inTable);
            }

        } catch (SQLException e) {
            System.out.println("Error trying to generate table of Information Panels");
            e.printStackTrace();
        }
        return result;
    }

    public void updateInformation(InformationTable information)
    {
        String sql = "UPDATE public.\"InformationTable\" SET (manufacturer, placementrow, placementcolumn, "
            + "contactinfoemail, contactinfophone) = ('" + information.getManufacturer()
            + "'," + information.getPlacementRow() + "," + information.getPlacementColumn()
            + ",'" + information.getContactInfoEmail() + "'," + information.getContactInfoPhone() + ")"
            + " WHERE manufacturer = '" + information.getManufacturer() + "'";


        // UPDATE public."InformationTable" SET (manfuacturer, placementR
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Succesfully executed SQL statement");
        } catch (SQLException e) {
            System.out.println("Error trying to update information in InformationTable");
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException exception) {
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


