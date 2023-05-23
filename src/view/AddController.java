package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.InformationTable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddController {
  @FXML private TextField manufacturerField;
  @FXML private TextField placementRowField;
  @FXML private TextField placementColumnField;
  @FXML private TextField installDateField;
  @FXML private TextField contactInfoEmailField;
  @FXML private TextField contactInfoPhoneField;

  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  public void thermalPanel(ActionEvent e) {
    viewHandler.changeScene(ViewHandler.THERMAL_PANEL);
  }

  public void information(ActionEvent e) {
    viewHandler.changeScene(ViewHandler.INFORMATION);
  }

  public void solarPanel(ActionEvent e) {
    viewHandler.changeScene(ViewHandler.SOLAR_PANEL);
  }

  public void addInformation(ActionEvent event) {
    String manufacturer = manufacturerField.getText();
    int placementRow = Integer.parseInt(placementRowField.getText());
    int placementColumn = Integer.parseInt(placementColumnField.getText());
    Date installDate = parseDate(installDateField.getText()); // Get the installation date as text
    String contactInfoEmail = contactInfoEmailField.getText();
    int contactInfoPhone = Integer.parseInt(contactInfoPhoneField.getText());

    InformationTable information = new InformationTable(manufacturer, placementRow, placementColumn,
            installDate, contactInfoEmail, contactInfoPhone);

    // You should have a method in your database connector class to save the information
    viewHandler.getConnection().storeInformation(information);

    viewHandler.changeScene(ViewHandler.INFORMATION);

    manufacturerField.clear();
    placementRowField.clear();
    placementColumnField.clear();
    installDateField.clear();
    contactInfoEmailField.clear();
    contactInfoPhoneField.clear();
  }

  public void back(ActionEvent event)
  {
    viewHandler.changeScene(ViewHandler.INFORMATION);
  }
  private Date parseDate(String dateString) {
    return new Date();
  }
}



