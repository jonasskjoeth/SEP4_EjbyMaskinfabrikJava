package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ViewHandler
{
  private Stage primaryStage;

  private Scene frontPage;
  private Scene solarPanelScene;
  private Scene thermalPanelScene;
  private Scene solarDataScene;
  private Scene thermalDataScene;
  private Scene informationScene;
  private Scene addScene;
  private Scene editScene;
  private FrontPage frontPageController;
  private SolarPanel solarPanelController;
  private ThermalPanel thermalPanelController;
  private SolarData solarDataController;
  private ThermalData thermalDataController;
  private InformationController informationController;
  private AddController addController;
  private EditController editController;

  public static final String FRONT_PAGE = "FRONT_PAGE";
  public static final String SOLAR_PANEL = "SOLAR_PANEL";
  public static final String THERMAL_PANEL = "THERMAL_PANEL";
  public static final String SOLAR_DATA = "SOLAR_DATA";
  public static final String THERMAL_DATA = "THERMAL_DATA";
  public static final String INFORMATION = "INFORMATION";
  public static final String ADD = "ADD";
  public static final String EDIT = "EDIT";
  public static final String BACK = "BACK";
  public static final String DELETE = "DELETE";

  private DatabaseConnector connector;

  public ViewHandler(Stage primaryStage, DatabaseConnector connector)
  {
    this.primaryStage = primaryStage;
    this.connector = connector;

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("frontPage.fxml"));
    try
    {
      frontPage = new Scene(loader.load());
      frontPageController = loader.getController();
      frontPageController.init(this);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load front-page.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("solarPanel.fxml"));
    try
    {
      solarPanelScene = new Scene(loader.load());
      solarPanelController = loader.getController();
      solarPanelController.init(this);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load solarpanel.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("ThermalPanel.fxml"));
    try
    {
      thermalPanelScene = new Scene(loader.load());
      thermalPanelController = loader.getController();
      thermalPanelController.init(this);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load thermalPanel.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("thermalDAta.fxml"));
    try
    {
      thermalDataScene = new Scene(loader.load());
      thermalDataController = loader.getController();
      thermalDataController.init(this);
    }
    catch (IOException e)
    {
      System.out.println("Loader stadig ikke");
      System.exit(1);
    }

//    loader = new FXMLLoader();
//    loader.setLocation(getClass().getResource("solarData.fxml"));
//    try {
//      solarDataScene = new Scene(loader.load());
//      solarDataController = loader.getController();
//      solarDataController.init(this);
//    }
//    catch (IOException e)
//    {
//      System.out.println("mmmhhh");
//      System.exit(1);
//    }

    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("informationPage.fxml"));
    try
    {
      informationScene = new Scene(loader.load());
      informationController = loader.getController();
      informationController.init(this);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load informationPage.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("add.fxml"));
    try {
      addScene = new Scene(loader.load());
      addController = loader.getController();
      addController.init(this);
    } catch (IOException e) {
      System.out.println("Failed to load add.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("edit.fxml"));
    try {
      editScene = new Scene(loader.load());
      editController = loader.getController();
      editController.init(this);
    } catch (IOException e) {
      System.out.println("edit scene could not load?");
      System.exit(1);
    }

    changeScene(FRONT_PAGE);
  }

  public void changeScene(String sceneName)
  {
    if (FRONT_PAGE.equals(sceneName))
    {
      primaryStage.setTitle("Front Page");
      primaryStage.setScene(frontPage);
      primaryStage.show();
    }
    else if (SOLAR_PANEL.equals(sceneName))
    {
      primaryStage.setTitle("Solar Panel");
      primaryStage.setScene(solarPanelScene);
      primaryStage.show();
     // solarPanelController.updateView();
    }
    else if (THERMAL_PANEL.equals(sceneName))
    {
      primaryStage.setTitle("Thermal Panel");
      primaryStage.setScene(thermalPanelScene);
      primaryStage.show();
    }
    else if (INFORMATION.equals(sceneName))
    {
      primaryStage.setTitle("Information");
      primaryStage.setScene(informationScene);
      primaryStage.show();
      informationController.updateView();
    }
//    else if (SOLAR_DATA.equals(sceneName))
//    {
//      primaryStage.setTitle("Solar Data");
//      primaryStage.setScene(solarDataScene);
//      primaryStage.show();
//      //solarDataController.updateView();
//    }
    else if (THERMAL_DATA.equals(sceneName))
    {
      primaryStage.setTitle("Thermal Data");
      primaryStage.setScene(thermalDataScene);
      primaryStage.show();
      thermalDataController.updateView();
    }
    else if (ADD.equals(sceneName)) {
      primaryStage.setTitle("Add");
      primaryStage.setScene(addScene);
      primaryStage.show();
    } else if (EDIT.equals(sceneName))
    {
      primaryStage.setTitle("Edit");
      primaryStage.setScene(editScene);
      primaryStage.show();
    }
    else if (BACK.equals(sceneName))
    {
      primaryStage.setTitle("Information");
      primaryStage.setScene(informationScene);
      primaryStage.show();
    }
  }

  public DatabaseConnector getConnection()
  {
    return connector;
  }
  public AddController getAddController() {
    return addController;
  }
  public void updateInformationView() {
    informationController.updateView(); // Call the updateView method on informationController
  }

  public EditController getEditController()
  {
    return editController;
  }
}
