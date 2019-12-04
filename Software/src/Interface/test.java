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
<<<<<<< HEAD:Software/src/test.java
    loader.setLocation(getClass().getResource("FxmlFiles/MainMenu.fxml"));
    Parent root = loader.load();
    //MainMenu model = new MainMenu();
=======
    loader.setLocation(getClass().getResource("MainMenu.fxml"));
    Parent root = loader.load();
>>>>>>> e14e164b424e4989ff0e0ceb86b1addb0e72a5fc:Software/src/Interface/test.java
    primaryStage.setTitle("Exam Scheduler");
    primaryStage.setScene(new Scene(root, 700, 500));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
