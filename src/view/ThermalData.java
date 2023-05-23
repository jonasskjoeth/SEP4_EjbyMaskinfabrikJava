package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ThermalTable;

import java.sql.Timestamp;
import java.util.Date;


public class ThermalData
{
  @FXML private TableView<ThermalTable> thermalDataTableView;
  @FXML private TableColumn<ThermalData, Timestamp> date;
  @FXML private TableColumn<ThermalData, Float> time;
  @FXML private TableColumn<ThermalData, Float> tempOut;
  @FXML private TableColumn<ThermalData, Float> tempCONTROL;
  @FXML private TableColumn<ThermalData, Float> tempIn;


  private ViewHandler viewHandler;
  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void thermalPanel(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.THERMAL_PANEL);
  }

  public void solarpanel(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.SOLAR_PANEL);
  }

  public void information(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.INFORMATION);
  }

  public void updateView() {
    date.setCellValueFactory(new PropertyValueFactory<>("date"));
    time.setCellValueFactory(new PropertyValueFactory<>("time"));
    tempOut.setCellValueFactory(new PropertyValueFactory<>("tempOut"));
    tempCONTROL.setCellValueFactory(new PropertyValueFactory<>("tempCONTROL"));
    tempIn.setCellValueFactory(new PropertyValueFactory<>("tempIn"));

    thermalDataTableView.setItems(viewHandler.getConnection().retrieveThermalTable());
  }
}
