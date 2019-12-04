package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class  test extends Application
{
  @Override
  public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("MainMenu.fxml"));
    Parent root = loader.load();
    primaryStage.setTitle("Exam Scheduler");
    primaryStage.setScene(new Scene(root, 700, 500));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
