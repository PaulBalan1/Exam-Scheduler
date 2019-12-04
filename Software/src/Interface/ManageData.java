package Interface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ManageData
{
  @FXML Button backButton;
  @FXML static public ChoiceBox<String> choiceBoxButton = new ChoiceBox<>();


  public void pushBackButton(ActionEvent event)
      throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("MainMenu.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, 700,500);
    Stage menu = (Stage) ((Node)event.getSource()).getScene().getWindow();
    menu.setScene(scene);
    menu.show();
  }
}
