import LayoutClasses.MainMenu;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class test extends Application
{
  @Override
  public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("FxmlFiles/MainMenu.fxml"));
    Parent root = loader.load();//Hi you fuck
    //MainMenu model = new MainMenu();
    primaryStage.setTitle("Exam Scheduler");
    primaryStage.setScene(new Scene(root, 700, 500));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
