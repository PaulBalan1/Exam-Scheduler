package Interface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ManageData
{
  @FXML Button backButton;
  @FXML ChoiceBox<String> choiceBoxButton;

  @FXML Pane courses;
  @FXML Pane classrooms;
  @FXML Pane groups;
  @FXML Pane examiners;
  @FXML Pane testTakers;
  @FXML Pane exams;


  public void initialize()
  {
    choiceBoxButton.getItems().addAll("Courses", "Classrooms", "Groups", "Examiners", "Test-takers", "Exams");
    choiceBoxButton.setValue("Courses");
  }

  public void getSelectedOption(ActionEvent event){
     showSelectedContainer(choiceBoxButton.getValue());
  }

  public void showSelectedContainer(String containerName){
    if(containerName.equals("Courses")){
      setVisibilityToFalseForAll();
      courses.setVisible(true);
    }else if(containerName.equals("Classrooms")){
      setVisibilityToFalseForAll();
      classrooms.setVisible(true);
    }
    else if(containerName.equals("Groups")){
      setVisibilityToFalseForAll();
      groups.setVisible(true);
    }
    else if(containerName.equals("Examiners")){
      setVisibilityToFalseForAll();
      examiners.setVisible(true);
    }
    else if(containerName.equals("Test-takers")){
      setVisibilityToFalseForAll();
      testTakers.setVisible(true);
    }
    else if(containerName.equals("Exams")){
      setVisibilityToFalseForAll();
      exams.setVisible(true);
    }
  }

  public void setVisibilityToFalseForAll(){
    courses.setVisible(false);
    classrooms.setVisible(false);
    groups.setVisible(false);
    examiners.setVisible(false);
    testTakers.setVisible(false);
    exams.setVisible(false);
  }

  public void pushBackButton(ActionEvent event)
      throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("MainMenu.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, Launcher.getSizeX(),Launcher.getSizeY());
    Stage menu = (Stage) ((Node)event.getSource()).getScene().getWindow();
    menu.setScene(scene);
    menu.show();
  }

  public void addTestTaker(){
    String name =
  }
}
