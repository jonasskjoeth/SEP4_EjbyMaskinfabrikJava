package view;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.SolarTable;

import java.awt.event.ActionEvent;
import java.util.Date;

public class SolarData
{
  @FXML CategoryAxis x;
  @FXML NumberAxis y;
  @FXML LineChart<?, ?> lineChart;

  @FXML private TableView<SolarTable> solarDataTableView;
  @FXML private TableColumn<SolarData, Float> volt;
  @FXML private TableColumn<SolarData, Float> ampere;
  @FXML private TableColumn<SolarData, Float> watt;
  @FXML private TableColumn<SolarData, Date> date;

  private ViewHandler viewHandler;
  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void updateView()
  {
    volt.setCellValueFactory(new PropertyValueFactory<>("volt"));
    ampere.setCellValueFactory(new PropertyValueFactory<>("ampere"));
    watt.setCellValueFactory(new PropertyValueFactory<>("watt"));
    date.setCellValueFactory(new PropertyValueFactory<>("date"));

    solarDataTableView.setItems(viewHandler.getConnection().retrieveSolarTable());
  }

  public void initialize()
  {
    XYChart.Series series = new XYChart.Series();

    series.getData().add(new XYChart.Data("1", 71893));
    series.getData().add(new XYChart.Data("2", 71501));
    series.getData().add(new XYChart.Data("3", 71111));
    series.getData().add(new XYChart.Data("4", 70723));
    series.getData().add(new XYChart.Data("5", 70337));
    series.getData().add(new XYChart.Data("6", 69952));
    series.getData().add(new XYChart.Data("7", 69570));
    series.getData().add(new XYChart.Data("8", 69190));
    series.getData().add(new XYChart.Data("9", 68811));
    series.getData().add(new XYChart.Data("10", 34239));
    series.getData().add(new XYChart.Data("11", 68060));
    series.getData().add(new XYChart.Data("12", 67687));
    series.getData().add(new XYChart.Data("13", 67316));
    series.getData().add(new XYChart.Data("14", 66947));
    series.getData().add(new XYChart.Data("15", 66580));
    series.getData().add(new XYChart.Data("16", 66215));
    series.getData().add(new XYChart.Data("17", 65851));
    series.getData().add(new XYChart.Data("18", 65489));
    series.getData().add(new XYChart.Data("19", 65129));
    series.getData().add(new XYChart.Data("20", 30575));
    series.getData().add(new XYChart.Data("21", 64415));
    series.getData().add(new XYChart.Data("22", 64060));
    series.getData().add(new XYChart.Data("23", 63707));
    series.getData().add(new XYChart.Data("24", 63356));
    series.getData().add(new XYChart.Data("25", 63007));

    XYChart.Series series2 = new XYChart.Series();

    series2.getData().add(new XYChart.Data("1", -511005));
    series2.getData().add(new XYChart.Data("2", -439504));
    series2.getData().add(new XYChart.Data("3", -368393));
    series2.getData().add(new XYChart.Data("4", -297670));
    series2.getData().add(new XYChart.Data("5", -227333));
    series2.getData().add(new XYChart.Data("6", -157380));
    series2.getData().add(new XYChart.Data("7", -87809));
    series2.getData().add(new XYChart.Data("8", -18619));
    series2.getData().add(new XYChart.Data("9", 50192));
    series2.getData().add(new XYChart.Data("10", 84431));
    series2.getData().add(new XYChart.Data("11", 152492));
    series2.getData().add(new XYChart.Data("12", 220180));
    series2.getData().add(new XYChart.Data("13", 287497));
    series2.getData().add(new XYChart.Data("14", 354445));
    series2.getData().add(new XYChart.Data("15", 421025));
    series2.getData().add(new XYChart.Data("16", 487240));
    series2.getData().add(new XYChart.Data("17", 553092));
    series2.getData().add(new XYChart.Data("18", 618582));
    series2.getData().add(new XYChart.Data("19", 683711));
    series2.getData().add(new XYChart.Data("20", 714287));
    series2.getData().add(new XYChart.Data("21", 778703));
    series2.getData().add(new XYChart.Data("22", 842763));
    series2.getData().add(new XYChart.Data("23", 906471));
    series2.getData().add(new XYChart.Data("24", 969828));
    series2.getData().add(new XYChart.Data("25", 1032836));

    this.lineChart.getData().addAll(series, series2);
  }

  public void information(javafx.event.ActionEvent event)
  {
    viewHandler.changeScene(ViewHandler.INFORMATION);
  }

  public void solarPanel(javafx.event.ActionEvent event)
  {
    viewHandler.changeScene(ViewHandler.SOLAR_PANEL);
  }

  public void thermalPanel(javafx.event.ActionEvent event)
  {
    viewHandler.changeScene(ViewHandler.THERMAL_PANEL);
  }
  public void back(javafx.event.ActionEvent event)
  {
    viewHandler.changeScene(ViewHandler.SOLAR_PANEL);
  }
}
