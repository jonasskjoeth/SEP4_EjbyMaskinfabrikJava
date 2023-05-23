package view;

import java.awt.event.ActionEvent;

public class SolarData
{
  private ViewHandler viewHandler;
  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void information(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.INFORMATION);
  }

  public void thermalPanel(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.THERMAL_PANEL);
  }

  public void solarPanel(ActionEvent e)
  {
    viewHandler.changeScene(ViewHandler.SOLAR_PANEL);
  }
}
