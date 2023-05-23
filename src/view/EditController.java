package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.InformationTable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EditController {
    @FXML
    private TableView<InformationTable> informationTableTableView;
    @FXML
    private TextField manufacturerField;
    @FXML
    private TextField placementRowField;
    @FXML
    private TextField placementColumnField;
    @FXML
    private TextField contactInfoEmailField;
    @FXML
    private TextField contactInfoPhoneField;

    private InformationTable information;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }

    public void setInformation(InformationTable information) {
        this.information = information;

        manufacturerField.setText(information.getManufacturer());
        placementRowField.setText(String.valueOf(information.getPlacementRow()));
        placementColumnField.setText(String.valueOf(information.getPlacementColumn()));
       contactInfoEmailField.setText(information.getContactInfoEmail());
       contactInfoPhoneField.setText(String.valueOf(information.getContactInfoPhone()));
    }

    public void save(ActionEvent e) {
        updateInformation();
    }

    public void updateInformation() {

        String manufacturer = manufacturerField.getText();
        int placementRow = Integer.parseInt(placementRowField.getText());
        int placementColumn = Integer.parseInt(placementColumnField.getText());
        String contactInfoEmail = contactInfoEmailField.getText();
        int contactInfoPhone = Integer.parseInt(contactInfoPhoneField.getText());


        information.setManufacturer(manufacturer);
        information.setPlacementRow(placementRow);
        information.setPlacementColumn(placementColumn);
        information.setContactInfoEmail(contactInfoEmail);
        information.setContactInfoPhone(contactInfoPhone);


        viewHandler.getConnection().updateInformation(information);

        // Return to the information scene
        viewHandler.changeScene(ViewHandler.INFORMATION);
    }


    public void cancel(ActionEvent event)
    {
        viewHandler.changeScene(ViewHandler.INFORMATION);
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
}


