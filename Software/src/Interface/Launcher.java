package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application
{
  static int sizeX, sizeY;

  public static int getSizeX()
  {
    return sizeX;
  }

  public static int getSizeY()
  {
    return sizeY;
  }

  @Override
  public void start(Stage primaryStage) throws Exception{
    sizeX = 600;
    sizeY = 500;

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("MainMenu.fxml"));
    Parent root = loader.load();
    primaryStage.setTitle("Exam Scheduler");
    primaryStage.setScene(new Scene(root, getSizeX(), getSizeY()));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
