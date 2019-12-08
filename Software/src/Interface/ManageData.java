package Interface;

import Classes.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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

  //dropdowns
  @FXML ChoiceBox<String> choiceBoxExaminer;
  @FXML ChoiceBox<String> choiceBoxCourseExam;
  @FXML ChoiceBox<String> choiceBoxGroupTestTaker;

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
  String lastCourseSelectedName;
  CourseList courseList = new CourseList();
  ObservableList<Course> courseObservableList = FXCollections.observableArrayList();

  //groups
  @FXML TextField groupName;
  @FXML TableView groupTableView;
  @FXML TableColumn groupNameCol;
  String lastGroupSelectedName;
  GroupList groupList = new GroupList();
  ObservableList<Group> groupObservableList = FXCollections.observableArrayList();

  //classrooms
  @FXML TextField classroomName;
  @FXML TextField capacity;
  @FXML CheckBox HDMI;
  @FXML TableView classroomTableView;
  @FXML TableColumn classroomNameCol;
  @FXML TableColumn classroomCapacityCol;
  @FXML TableColumn classroomHDMICol;
  String lastClassroomSelectedName;
  ClassroomList classroomList = new ClassroomList();
  ObservableList<Classroom> classroomObservableList = FXCollections.observableArrayList();

  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    choiceBoxButton.getItems().addAll("Courses", "Classrooms", "Groups", "Examiners", "Test-takers", "Exams");
    choiceBoxButton.setValue("Courses");
    initializeCourses();
    initializeGroups();
    initializeClassrooms();
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
      addClassroom();
    }
    else if(containerName.equals("Groups")){
      addGroup();
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
      modifyCourse();
    }else if(containerName.equals("Classrooms")){
      modifyClassroom();
    }
    else if(containerName.equals("Groups")){
      modifyGroup();
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
      removeCourse();
    }else if(containerName.equals("Classrooms")){
      removeClassroom();
    }
    else if(containerName.equals("Groups")){
      removeGroup();
    }
    else if(containerName.equals("Examiners")){

    }
    else if(containerName.equals("Test-takers")){

    }
    else if(containerName.equals("Exams")){

    }
  }

  //Classroom logic

  public void initializeClassrooms(){
    classroomNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    classroomCapacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
    classroomHDMICol.setCellValueFactory(new PropertyValueFactory<>("hasProjector"));
    classroomTableView.setItems(classroomObservableList);
    selectClassroom();
  }

  public void addClassroom(){
    Classroom aux = new Classroom(classroomName.getText(), Integer.parseInt(capacity.getText()), HDMI.isSelected());
    if(classroomList.classroomValidator(aux)){
      classroomList.addClassroom(aux);
      classroomObservableList.add(aux);
      classroomName.clear();
      capacity.clear();
      HDMI.setSelected(false);
    }else{
      classroomAlert();
    }
  }

  public void selectClassroom(){
    classroomTableView.getSelectionModel().setCellSelectionEnabled(true);
    ObservableList selectedCells = classroomTableView.getSelectionModel().getSelectedItems();

    selectedCells.addListener(new ListChangeListener() {
      @Override
      public void onChanged(Change c) {
        if(selectedCells.size()>0)
        {
          Classroom aux = (Classroom)selectedCells.get(0);
          classroomName.setText(aux.getName());
          capacity.setText(""+aux.getCapacity());
          HDMI.setSelected(aux.getHasProjector());
          lastClassroomSelectedName = classroomName.getText();
        }
      }
    });
  }

  public void modifyClassroom(){
    String auxName = classroomName.getText();
    int index = 0;
    for (Classroom classroom: classroomList.getClassrooms())
    {
      if(classroom.getName().equals(lastClassroomSelectedName)){
        classroom.setName(auxName);
        classroom.setCapacity(Integer.parseInt(capacity.getText()));
        classroom.setHasProjector(HDMI.isSelected());
        classroomObservableList.get(index).setName(auxName);
        classroomObservableList.get(index).setCapacity(Integer.parseInt(capacity.getText()));
        classroomObservableList.get(index).setHasProjector(HDMI.isSelected());
        lastClassroomSelectedName = classroomName.getText();
        classroomTableView.refresh();
        break;
      }
      index++;
    }
  }


  public void removeClassroom(){
    for (Classroom classroom: classroomList.getClassrooms())
    {
      int index = 0;
      if(classroom.getName().equals(classroomName.getText())){
        classroomObservableList.remove(index);
        classroomList.removeClassroom(classroom);
        classroomName.clear();
        classroomTableView.refresh();
        return;
      }
      index++;
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
      choiceBoxExaminer.getItems().add(aux.toString());
      choiceBoxCourseExam.getItems().add(aux.toString());
      courseName.clear();
    }else{
      nameAlert();
    }
  }

  public void selectCourse(){
    courseTableView.getSelectionModel().setCellSelectionEnabled(true);
    ObservableList selectedCells = courseTableView.getSelectionModel().getSelectedCells();

      selectedCells.addListener(new ListChangeListener() {
      @Override
      public void onChanged(Change c) {
        if(selectedCells.size()>0)
        {
          TablePosition tablePosition = (TablePosition) selectedCells.get(0);
          Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
          courseName.setText(val.toString());
          lastCourseSelectedName = courseName.getText();
        }
      }
    });
  }

  public void modifyCourse(){
    String auxName = courseName.getText();
    int index = 0;
    for (Course course: courseList.getCourses())
    {
      if(course.getName().equals(lastCourseSelectedName)){
        course.setName(auxName);
        courseObservableList.get(index).setName(auxName);
        courseTableView.refresh();
        break;
      }
      index++;
    }
  }

  public void removeCourse(){
    for (Course course: courseList.getCourses())
    {
      if(course.getName().equals(courseName.getText())){
        courseObservableList.remove(course);
        courseList.removeCourse(course);
        courseName.clear();
        choiceBoxExaminer.getItems().remove(course.toString());
        choiceBoxCourseExam.getItems().remove(course.toString());
        return;
      }
    }
  }

  //Groups

  public void initializeGroups(){
    groupNameCol.setCellValueFactory(new PropertyValueFactory<>("groupName"));
    groupTableView.setItems(groupObservableList);
    selectGroup();
  }

  public void addGroup(){
    Group aux = new Group(groupName.getText());
    if(groupList.groupNameValidator(aux)){
      choiceBoxGroupTestTaker.getItems().add(aux.toString());
      groupList.addGroup(groupName.getText());
      groupObservableList.add(aux);
      groupName.clear();
    }else{
      nameAlert();
    }
  }

  public void selectGroup(){
    groupTableView.getSelectionModel().setCellSelectionEnabled(true);
    ObservableList selectedCells = groupTableView.getSelectionModel().getSelectedCells();

    selectedCells.addListener(new ListChangeListener() {
      @Override
      public void onChanged(Change c) {
        if(selectedCells.size()>0)
        {
          TablePosition tablePosition = (TablePosition) selectedCells.get(0);
          Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
          groupName.setText(val.toString());
          lastGroupSelectedName = groupName.getText();
        }
      }
    });
  }

  public void modifyGroup(){
    String auxName = groupName.getText();
    int index = 0;
    for (Group group: groupList.getGroups())
    {
      if(group.getGroupName().equals(lastGroupSelectedName)){
        group.setGroupName(auxName);
        groupObservableList.get(index).setGroupName(auxName);
        groupTableView.refresh();
        break;
      }
      index++;
    }
  }

  public void removeGroup(){
    int index = 0;
    for (Group group: groupList.getGroups())
    {
      if(group.getGroupName().equals(groupName.getText())){
        choiceBoxGroupTestTaker.getItems().remove(group.toString());
        groupObservableList.remove(index);
        groupList.removeGroup(group);
        groupName.clear();
        groupTableView.refresh();
        break;
      }
      index++;
    }
  }

  //Alerts

  public void nameAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid name");
    alert.setHeaderText("Object with this name already exists or name contains illegal characters!");
    alert.showAndWait();
  }

  public void classroomAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid classroom input");
    alert.setHeaderText("Classroom with this name already exists or capacity is invalid!");
    alert.showAndWait();
  }
}
