package Interface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu{
  @FXML Button manageDataButton;
  @FXML Button scheduleExamButton;

//  public void pushButtonManageData (ActionEvent event) throws IOException {
//    FXMLLoader loader = new FXMLLoader();
//    loader.setLocation(getClass().getResource("FxmlFiles/ManageData.fxml"));
//    Parent root = loader.load();
//    Scene scene = new Scene(root);
//    Stage menu = (Stage) ((Node)event.getSource()).getScene().getWindow();
//    menu.setScene(scene);
//    menu.show();
//  }

  public void pushButtonManageData(javafx.event.ActionEvent event)
      throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("ManageData.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, 700,500);
    Stage menu = (Stage) ((Node)event.getSource()).getScene().getWindow();
    menu.setScene(scene);
    menu.show();
  }
}

