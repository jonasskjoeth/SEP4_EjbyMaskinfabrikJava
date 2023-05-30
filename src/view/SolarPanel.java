package view;

import javafx.event.ActionEvent;

public class SolarPanel
{
  private ViewHandler viewHandler;
  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
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
