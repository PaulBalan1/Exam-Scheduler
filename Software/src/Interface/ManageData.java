package Interface;

import Classes.Course;
import Classes.CourseList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageData implements Initializable
{
  //header
  @FXML Button backButton;
  @FXML ChoiceBox<String> choiceBoxButton;

  //Panes
  @FXML Pane courses;
  @FXML Pane classrooms;
  @FXML Pane groups;
  @FXML Pane examiners;
  @FXML Pane testTakers;
  @FXML Pane exams;


  //3 buttons
  @FXML Button add, modify, remove;

  //course
  @FXML TextField courseName;
  @FXML TableView courseTableView;
  @FXML TableColumn courseNameCol;


  CourseList courseList = new CourseList();
  ObservableList<Course> courseObservableList = FXCollections.observableArrayList();

  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    choiceBoxButton.getItems().addAll("Courses", "Classrooms", "Groups", "Examiners", "Test-takers", "Exams");
    choiceBoxButton.setValue("Courses");
    initializeCourses();

  }

  //header logic

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

  public void pushBackButton(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("MainMenu.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, Launcher.getSizeX(),Launcher.getSizeY());
    Stage menu = (Stage) ((Node)event.getSource()).getScene().getWindow();
    menu.setScene(scene);
    menu.show();
  }

  //Add/modify/remove buttons

  public void addButtonSelector(){
    String containerName = choiceBoxButton.getValue();
    if(containerName.equals("Courses")){
      addCourse();
    }else if(containerName.equals("Classrooms")){

    }
    else if(containerName.equals("Groups")){

    }
    else if(containerName.equals("Examiners")){

    }
    else if(containerName.equals("Test-takers")){

    }
    else if(containerName.equals("Exams")){

    }
  }

  public void modifyButtonSelector(){
    String containerName = choiceBoxButton.getValue();
    if(containerName.equals("Courses")){

    }else if(containerName.equals("Classrooms")){

    }
    else if(containerName.equals("Groups")){

    }
    else if(containerName.equals("Examiners")){

    }
    else if(containerName.equals("Test-takers")){

    }
    else if(containerName.equals("Exams")){

    }
  }

  public void removeButtonSelector(){
    String containerName = choiceBoxButton.getValue();
    if(containerName.equals("Courses")){

    }else if(containerName.equals("Classrooms")){

    }
    else if(containerName.equals("Groups")){

    }
    else if(containerName.equals("Examiners")){

    }
    else if(containerName.equals("Test-takers")){

    }
    else if(containerName.equals("Exams")){

    }
  }

  //Course logic

  public void initializeCourses(){
    courseNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    courseTableView.setItems(courseObservableList);
    selectCourse();
  }

  public void addCourse(){
    Course aux = new Course(courseName.getText());
    if(courseList.courseNameValidator(aux)){
      courseList.addCourse(aux);
      courseObservableList.add(courseList.getCourses().get(courseList.size()-1));
      courseName.clear();
    }else{
      nameAlert();
    }
  }

  public void selectCourse(){
    courseTableView.getSelectionModel().selectedItemProperty().addListener(
        (observableValue, oldValue, newValue) -> {
          if(courseTableView.getSelectionModel().getSelectedItem() != null)
          {
            TableView.TableViewSelectionModel selectionModel = courseTableView.getSelectionModel();
            ObservableList selectedCells = selectionModel.getSelectedCells();
            TablePosition tablePosition = (TablePosition) selectedCells.get(0);
            Object val = tablePosition.getTableColumn().getCellData(newValue);
            courseName.setText(val.toString());
          }
        });

  }

  //Alerts

  public void nameAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid name");
    alert.setHeaderText("Object with this name already exists or name contains illegal characters!");
    alert.showAndWait();
  }

}
