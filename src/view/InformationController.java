package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.InformationTable;

import java.util.Date;

public class InformationController
{
  @FXML private TableView<InformationTable> informationTableView;
  @FXML private TableColumn<InformationTable, String> manufacturer;
  @FXML private TableColumn<InformationTable, Integer> placementRow;
  @FXML private TableColumn<InformationTable, Integer> placementColumn;
  @FXML private TableColumn<InformationTable, Date> installDate;
  @FXML private TableColumn<InformationTable, String> contactInfoEmail;
  @FXML private TableColumn<InformationTable, Integer> contactInfoPhone;
  @FXML private TableColumn<InformationTable, String> type;

  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void add(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.ADD);
  }

  public void edit(ActionEvent e) {
    editInformation();
  }

  public void editInformation() {
    InformationTable selectedInformation = informationTableView.getSelectionModel().getSelectedItem();
    if (selectedInformation != null) {
      viewHandler.getEditController().setInformation(selectedInformation);
      viewHandler.changeScene(ViewHandler.EDIT);
    }
  }

  public void delete(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.DELETE);
  }

  public void  information(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.FRONT_PAGE);
  }

  public void solarPanel(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.SOLAR_PANEL);
  }

  public void thermalPanel(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.THERMAL_PANEL);
  }

  public void updateView()
  {
    manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    placementRow.setCellValueFactory(new PropertyValueFactory<>("placementRow"));
    placementColumn.setCellValueFactory(new PropertyValueFactory<>("placementColumn"));
    installDate.setCellValueFactory(new PropertyValueFactory<>("installDate"));
    contactInfoEmail.setCellValueFactory(new PropertyValueFactory<>("contactInfoEmail"));
    contactInfoPhone.setCellValueFactory(new PropertyValueFactory<>("contactInfoPhone"));
    type.setCellValueFactory(new PropertyValueFactory<>("type"));


    informationTableView.setItems(viewHandler.getConnection().retrieveInformationTable());

  }
//  public void updateButton()
//  {
//    informationTableView.setItems(viewHandler.getConnection().updateInformation(information(););
//  }

//  public void deleteInformation(ActionEvent event) {
//    InformationTable selectedInformation = informationTableView.getSelectionModel().getSelectedItem();
//    if (selectedInformation != null) {
//
//      viewHandler.getConnection().deleteInformation(selectedInformation);
//
//      selectedInformation.remove();
//    }
//  }
}

