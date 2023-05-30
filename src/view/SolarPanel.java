package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

    public class SolarPanel
    {
      @FXML CategoryAxis xr;
      @FXML NumberAxis yr;
      @FXML LineChart<?, ?> lineChartRevenue;

      @FXML CategoryAxis xs;
      @FXML NumberAxis ys;
      @FXML LineChart<?, ?> lineChartSavings;

      @FXML CategoryAxis x;
      @FXML NumberAxis y;
      @FXML LineChart<?, ?> lineChart;

      private ViewHandler viewHandler;
      public void init(ViewHandler viewHandler)
      {
        this.viewHandler = viewHandler;
      }

      public void initialize()
      {
        XYChart.Series series = new XYChart.Series();
        ys.setAutoRanging(false);
        ys.setUpperBound(70000);
        ys.setLowerBound(60000);
        ys.setTickUnit(2000);

        yr.setAutoRanging(false);
        yr.setUpperBound(9000);
        yr.setLowerBound(7000);
        yr.setTickUnit(500);




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
        setLineChartSavings();
        setLineChartRevenue();
      }

      public void setLineChartRevenue()
      {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data("1", 8404));
        series.getData().add(new XYChart.Data("2", 8362));
        series.getData().add(new XYChart.Data("3", 8320));
        series.getData().add(new XYChart.Data("4", 8279));
        series.getData().add(new XYChart.Data("5", 8237));
        series.getData().add(new XYChart.Data("6", 8196));
        series.getData().add(new XYChart.Data("7", 8155));
        series.getData().add(new XYChart.Data("8", 8114));
        series.getData().add(new XYChart.Data("9", 8074));
        series.getData().add(new XYChart.Data("10", 8034));
        series.getData().add(new XYChart.Data("11", 7993));
        series.getData().add(new XYChart.Data("12", 7953));
        series.getData().add(new XYChart.Data("13", 7914));
        series.getData().add(new XYChart.Data("14", 7874));
        series.getData().add(new XYChart.Data("15", 7835));
        series.getData().add(new XYChart.Data("16", 7796));
        series.getData().add(new XYChart.Data("17", 7757));
        series.getData().add(new XYChart.Data("18", 7718));
        series.getData().add(new XYChart.Data("19", 7679));
        series.getData().add(new XYChart.Data("20", 7641));
        series.getData().add(new XYChart.Data("21", 7603));
        series.getData().add(new XYChart.Data("22", 7565));
        series.getData().add(new XYChart.Data("23", 7527));
        series.getData().add(new XYChart.Data("24", 7489));
        series.getData().add(new XYChart.Data("25", 7452));

        this.lineChartRevenue.getData().addAll(series);
      }

      public void setLineChartSavings()
      {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data("1", 69200));
        series.getData().add(new XYChart.Data("2", 68854));
        series.getData().add(new XYChart.Data("3", 68509));
        series.getData().add(new XYChart.Data("4", 68167));
        series.getData().add(new XYChart.Data("5", 67826));
        series.getData().add(new XYChart.Data("6", 67487));
        series.getData().add(new XYChart.Data("7", 67149));
        series.getData().add(new XYChart.Data("8", 66814));
        series.getData().add(new XYChart.Data("9", 66479));
        series.getData().add(new XYChart.Data("10", 66147));
        series.getData().add(new XYChart.Data("11", 65816));
        series.getData().add(new XYChart.Data("12", 65487));
        series.getData().add(new XYChart.Data("13", 65160));
        series.getData().add(new XYChart.Data("14", 64834));
        series.getData().add(new XYChart.Data("15", 64510));
        series.getData().add(new XYChart.Data("16", 64187));
        series.getData().add(new XYChart.Data("17", 63866));
        series.getData().add(new XYChart.Data("18", 63547));
        series.getData().add(new XYChart.Data("19", 63229));
        series.getData().add(new XYChart.Data("20", 62913));
        series.getData().add(new XYChart.Data("21", 62599));
        series.getData().add(new XYChart.Data("22", 62286));
        series.getData().add(new XYChart.Data("23", 61974));
        series.getData().add(new XYChart.Data("24", 61664));
        series.getData().add(new XYChart.Data("25", 61356));

        this.lineChartSavings.getData().addAll(series);
      }


  public void back(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.FRONT_PAGE);
  }

  public void solarData (ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.SOLAR_DATA);
  }

  public void information (ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.INFORMATION);
  }

  public void thermalPanel (ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.THERMAL_PANEL);
  }

  public void graph (ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.GRAPHSP);
  }
}
