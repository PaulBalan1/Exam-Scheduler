package Interface;

import Classes.*;
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

import java.io.*;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ManageData implements Initializable, Serializable
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


  //4 buttons
  @FXML Button add, modify, remove, save;

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

  //examiners
  @FXML TextField examinerName;
  @FXML ChoiceBox<Object> choiceBoxExaminer;
  @FXML TableView examinerTableView;
  @FXML TableColumn examinerNameCol;
  @FXML TableColumn examinerCourseCol;
  String lastExaminerSelectedName;
  ExaminerList examinerList = new ExaminerList();
  ObservableList<Examiner> examinerObservableList = FXCollections.observableArrayList();

  //test-takers
  @FXML TextField testTakerName;
  @FXML TextField studyNumber;
  @FXML TextField nationality;
  @FXML ChoiceBox<Object> choiceBoxGroupTestTaker;
  @FXML TableView testTakerTableView;
  @FXML TableColumn testTakerNameCol;
  @FXML TableColumn studyNumberCol;
  @FXML TableColumn nationalityCol;
  @FXML TableColumn testTakerGroupCol;
  String lastTestTakerSelectedNumber;
  TestTakerList testTakerList = new TestTakerList();
  ObservableList<TestTaker> testTakerObservableList = FXCollections.observableArrayList();

  //exams
  @FXML TableView examTableView;
  @FXML TableColumn examNameCol;
  @FXML TableColumn examDateCol;
  @FXML TableColumn examCourseCol;
  @FXML TableColumn examGroupCol;
  @FXML TableColumn examClassroomCol;
  @FXML TableColumn examExaminerCol;
  @FXML TableColumn coExaminerCol;
  @FXML TableColumn examTypeCol;
  @FXML TextField examName;
  @FXML TextField day;
  @FXML TextField month;
  @FXML TextField year;
  @FXML ChoiceBox<Object> choiceBoxCourseExam;
  @FXML ChoiceBox<Object> choiceBoxExaminerExam;
  @FXML ChoiceBox<Object> choiceBoxClassroomExam;
  @FXML ChoiceBox<Object> choiceBoxGroupExam;
  @FXML TextField coExaminer;
  @FXML ComboBox type;
  String lastExamNameSelected;
  ExamList examList = new ExamList();
  ObservableList<Exam> examObservableList = FXCollections.observableArrayList();


  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    choiceBoxButton.getItems().addAll("Courses", "Classrooms", "Groups", "Examiners", "Test-takers", "Exams");
    choiceBoxButton.setValue("Courses");
    type.getItems().addAll("Written", "Oral");
    type.setValue("Written");
    year.setText(""+Calendar.getInstance().get(Calendar.YEAR));
    month.setText(""+(Calendar.getInstance().get(Calendar.MONTH)+1));
    initializeCourses();
    initializeGroups();
    initializeClassrooms();
    intializeExaminers();
    initializeTestTakers();
    initializeExams();

    ObjectInputStream in = null;
    try {
      File course = new File("courseSaveFile.bin");
      FileInputStream fis = new FileInputStream(course);
      in = new ObjectInputStream(fis);
      try {
        courseList = (CourseList) in.readObject();
        for (Course course1:courseList.getCourses()){
          courseObservableList.add(course1);
        }
      }
      catch (EOFException | ClassNotFoundException  e){
        e.printStackTrace();
      }
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

  //header logic

  public void getSelectedOption(){
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
      addExaminer();
    }
    else if(containerName.equals("Test-takers")){
      addTestTaker();
    }
    else if(containerName.equals("Exams")){
      addExam();
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
      modifyExaminer();
    }
    else if(containerName.equals("Test-takers")){
      modifyTestTaker();
    }
    else if(containerName.equals("Exams")){
      modifyExam();
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
      removeExaminer();
    }
    else if(containerName.equals("Test-takers")){
      removeTestTaker();
    }
    else if(containerName.equals("Exams")){
      removeExam();
    }
  }

  //Exam logic

  public void initializeExams(){
    examNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    examDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    examCourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
    examGroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
    examTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    examClassroomCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));
    examExaminerCol.setCellValueFactory(new PropertyValueFactory<>("examiner"));
    coExaminerCol.setCellValueFactory(new PropertyValueFactory<>("coExaminer"));
    examTableView.setItems(examObservableList);
    selectExam();
  }

  public void addExam(){
    try{
      if((Integer.parseInt(day.getText())<1 || Integer.parseInt(day.getText())>31) || ((Integer.parseInt(month.getText())<1 || Integer.parseInt(month.getText())>12)) || (Integer.parseInt(year.getText())<Calendar.getInstance().get(Calendar.YEAR) || Integer.parseInt(year.getText())>2200)){
        examAlert();
        return;
      }
    }catch (NumberFormatException e){
      examAlert();
      return;
    }
    Date auxDate = new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));
    Exam aux = new Exam(examName.getText(), auxDate, (Course)choiceBoxCourseExam.getValue(), (Examiner)choiceBoxExaminerExam.getValue(), coExaminer.getText(), (Group)choiceBoxGroupExam.getValue(), (String)type.getValue(), (Classroom)choiceBoxClassroomExam.getValue());

    for(Exam exam: examList.getExams()){
      if(exam.getDate().equals(auxDate) && exam.getType().equals(aux.getType())){
        examSameDateAlert();
        return;
      }
    }

    if(examList.examValidator(aux)){
      examList.addExam(aux);
      examObservableList.add(aux);
      examName.clear();
      day.clear();
      month.setText(""+(Calendar.getInstance().get(Calendar.MONTH)+1));
      year.setText(""+Calendar.getInstance().get(Calendar.YEAR));
      choiceBoxCourseExam.setValue(null);
      choiceBoxExaminerExam.setValue(null);
      coExaminer.setText("");
      choiceBoxGroupExam.setValue(null);
      type.setValue("Written");
      choiceBoxClassroomExam.setValue(null);
    }else{
      testTakerAlert();
    }
  }

  public void selectExam(){
    examTableView.getSelectionModel().setCellSelectionEnabled(true);
    ObservableList selectedCells = examTableView.getSelectionModel().getSelectedItems();

    selectedCells.addListener(new ListChangeListener() {
      @Override
      public void onChanged(Change c) {
        if(selectedCells.size()>0)
        {
          Exam aux = (Exam) selectedCells.get(0);
          examName.setText(aux.getName());
          day.setText(""+aux.getDate().getDay());
          month.setText(""+aux.getDate().getMonth());
          year.setText(""+aux.getDate().getYear());
          choiceBoxCourseExam.setValue(aux.getCourse());
          choiceBoxExaminerExam.setValue(aux.getExaminer());
          coExaminer.setText(aux.getCoExaminer());
          choiceBoxGroupExam.setValue(aux.getGroup());
          type.setValue(aux.getType());
          choiceBoxClassroomExam.setValue(aux.getClassroom());
          lastExamNameSelected = examName.getText();
        }
      }
    });
  }

  public void modifyExam(){
    Date auxDate = new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));
    Exam aux = new Exam(examName.getText(), auxDate, (Course)choiceBoxCourseExam.getValue(), (Examiner)choiceBoxExaminerExam.getValue(), coExaminer.getText(), (Group)choiceBoxGroupExam.getValue(), (String)type.getValue(), (Classroom)choiceBoxClassroomExam.getValue());
    if(!examList.examValidator(aux)){
      examAlert();
      return;
    }
    //TODO verify if modification results in date / type duplication
    int index = 0;
    for (Exam exam: examList.getExams())
    {
      if(exam.getName().equals(lastExamNameSelected)){
        exam.setName(aux.getName());
        exam.setDate(aux.getDate());
        exam.setCourse(aux.getCourse());
        exam.setExaminer(aux.getExaminer());
        exam.setCoExaminer(aux.getCoExaminer());
        exam.setGroup(aux.getGroup());
        exam.setType(aux.getType());
        exam.setClassroom(aux.getClassroom());
        examObservableList.get(index).setName(aux.getName());
        examObservableList.get(index).setDate(aux.getDate());
        examObservableList.get(index).setCourse(aux.getCourse());
        examObservableList.get(index).setExaminer(aux.getExaminer());
        examObservableList.get(index).setCoExaminer(aux.getCoExaminer());
        examObservableList.get(index).setGroup(aux.getGroup());
        examObservableList.get(index).setType(aux.getType());
        examObservableList.get(index).setClassroom(aux.getClassroom());
        lastExamNameSelected = examName.getText();
        examTableView.refresh();
        break;
      }
      index++;
    }
  }

  public void removeExam(){
    int index = 0;
    for (Exam exam: examList.getExams())
    {
      if(exam.getName().equals(examName.getText())){
        examObservableList.remove(index);
        examList.removeExam(exam);
        examName.clear();
        day.clear();
        month.setText(""+(Calendar.getInstance().get(Calendar.MONTH)+1));
        year.setText(""+Calendar.getInstance().get(Calendar.YEAR));
        choiceBoxCourseExam.setValue(null);
        choiceBoxExaminerExam.setValue(null);
        coExaminer.setText("");
        choiceBoxGroupExam.setValue(null);
        type.setValue("Written");
        choiceBoxClassroomExam.setValue(null);
        return;
      }
      index++;
    }
  }

  //Test-taker logic

  public void initializeTestTakers(){
    testTakerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    studyNumberCol.setCellValueFactory(new PropertyValueFactory<>("studyNumber"));
    nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
    testTakerGroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
    testTakerTableView.setItems(testTakerObservableList);
    selectTestTaker();
  }

  public void addTestTaker(){
    TestTaker aux = new TestTaker(testTakerName.getText(), studyNumber.getText(), (Group)choiceBoxGroupTestTaker.getValue(), nationality.getText());
    if(testTakerList.testTakerValidator(aux)){
      testTakerList.addTestTaker(aux);
      testTakerObservableList.add(aux);
      testTakerName.clear();
      studyNumber.clear();
      nationality.clear();
      choiceBoxGroupTestTaker.setValue(null);
    }else{
      testTakerAlert();
    }
  }

  public void selectTestTaker(){
    testTakerTableView.getSelectionModel().setCellSelectionEnabled(true);
    ObservableList selectedCells = testTakerTableView.getSelectionModel().getSelectedItems();

    selectedCells.addListener(new ListChangeListener() {
      @Override
      public void onChanged(Change c) {
        if(selectedCells.size()>0)
        {
          TestTaker aux = (TestTaker) selectedCells.get(0);
          testTakerName.setText(aux.getName());
          studyNumber.setText(aux.getStudyNumber());
          nationality.setText(aux.getNationality());
          choiceBoxGroupTestTaker.setValue(aux.getGroup());
          lastTestTakerSelectedNumber = studyNumber.getText();
        }
      }
    });
  }

  public void modifyTestTaker(){
    TestTaker aux = new TestTaker(testTakerName.getText(), studyNumber.getText(), (Group)choiceBoxGroupTestTaker.getValue(), nationality.getText());
    int index = 0;
    for (TestTaker testTaker: testTakerList.getTestTakers())
    {
      if(testTaker.getStudyNumber().equals(lastTestTakerSelectedNumber)){
        testTaker.setName(aux.getName());
        testTaker.setStudyNumber(aux.getStudyNumber());
        testTaker.setNationality(aux.getNationality());
        testTaker.setGroup(aux.getGroup());
        testTakerObservableList.get(index).setName(aux.getName());
        testTakerObservableList.get(index).setStudyNumber(aux.getStudyNumber());
        testTakerObservableList.get(index).setNationality(aux.getNationality());
        testTakerObservableList.get(index).setGroup(aux.getGroup());
        lastTestTakerSelectedNumber = studyNumber.getText();
        testTakerTableView.refresh();
        break;
      }
      index++;
    }
  }

  public void removeTestTaker(){
    int index = 0;
    for (TestTaker testTaker: testTakerList.getTestTakers())
    {
      if(testTaker.getStudyNumber().equals(studyNumber.getText())){
        testTakerObservableList.remove(index);
        testTakerList.removeTestTaker(testTaker);
        testTakerName.clear();
        studyNumber.clear();
        nationality.clear();
        choiceBoxGroupTestTaker.setValue(null);
        return;
      }
      index++;
    }
  }

  //Examiner logic

  public void  intializeExaminers(){
    examinerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    examinerCourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
    examinerTableView.setItems(examinerObservableList);
    selectExaminer();
  }

  public void addExaminer(){
    Examiner aux = new Examiner(examinerName.getText(), (Course)choiceBoxExaminer.getValue());
    if(examinerList.examinerValidator(aux)){
      examinerList.addExaminer(aux);
      examinerObservableList.add(aux);
      examinerName.clear();
      choiceBoxExaminer.setValue(null);
      choiceBoxExaminerExam.getItems().add(aux);
    }else{
      nameAlert();
    }
  }

  public void selectExaminer(){
    examinerTableView.getSelectionModel().setCellSelectionEnabled(true);
    ObservableList selectedCells = examinerTableView.getSelectionModel().getSelectedItems();

    selectedCells.addListener(new ListChangeListener() {
      @Override
      public void onChanged(Change c) {
        if(selectedCells.size()>0)
        {
          Examiner aux = (Examiner) selectedCells.get(0);
          examinerName.setText(aux.getName());
          choiceBoxExaminer.setValue(aux.getCourse());
          lastExaminerSelectedName = examinerName.getText();
        }
      }
    });
  }

  public void modifyExaminer(){
    Examiner aux = new Examiner(examinerName.getText(), (Course)choiceBoxExaminer.getValue());
    String auxName = examinerName.getText();

    int index = 0;
    for (Examiner examiner: examinerList.getExaminers())
    {
      if(examiner.getName().equals(lastExaminerSelectedName)){
        examiner.setName(auxName);
        examiner.setCourse((Course)choiceBoxExaminer.getValue());
        examinerObservableList.get(index).setName(auxName);
        examinerObservableList.get(index).setCourse(examiner.getCourse());
        lastExaminerSelectedName = examinerName.getText();
        examinerTableView.refresh();
        choiceBoxExaminerExam.getItems().set(index,aux);
        break;
      }
      index++;
    }
  }

  public void removeExaminer(){
    int index = 0;
    for (Examiner examiner: examinerList.getExaminers())
    {
      if(examiner.getName().equals(examinerName.getText())){
        examinerObservableList.remove(index);
        examinerList.removeExaminer(examiner);
        examinerName.clear();
        choiceBoxExaminer.setValue(null);
        choiceBoxExaminerExam.getItems().remove(examiner);
        return;
      }
      index++;
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
    try{
      if(Integer.parseInt(capacity.getText())<0 || Integer.parseInt(capacity.getText())>200){
        classroomAlert();
        return;
      }
    }catch (NumberFormatException e){
      classroomAlert();
      return;
    }
    Classroom aux = new Classroom(classroomName.getText(), Integer.parseInt(capacity.getText()), HDMI.isSelected());
    if(classroomList.classroomValidator(aux)){
      choiceBoxClassroomExam.getItems().add(aux);
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
    try{
      if(Integer.parseInt(capacity.getText())<0 || Integer.parseInt(capacity.getText())>200){
        classroomAlert();
        return;
      }
    }catch (NumberFormatException e){
      classroomAlert();
      return;
    }
    String auxName = classroomName.getText();
    int index = 0;
    if(classroomList.classroomValidator(new Classroom(auxName, 10, true)))
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
          choiceBoxClassroomExam.getItems().set(index,classroom);
          break;
        }
        index++;
      }
      else{
        nameAlert();
        return;
      }
  }


  public void removeClassroom(){
    int index = 0;
    for (Classroom classroom: classroomList.getClassrooms())
    {
      if(classroom.getName().equals(classroomName.getText())){
        choiceBoxClassroomExam.getItems().remove(classroom);
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
      choiceBoxExaminer.getItems().add(aux);
      choiceBoxCourseExam.getItems().add(aux);
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
    if(courseList.courseNameValidator(new Course(auxName)))
    for (Course course: courseList.getCourses())
      {
        if(course.getName().equals(lastCourseSelectedName)){
          course.setName(auxName);
          courseObservableList.get(index).setName(auxName);
          courseTableView.refresh();
          choiceBoxExaminer.getItems().set(index,course);
          choiceBoxCourseExam.getItems().set(index,course);
          examinerTableView.refresh();
          break;
        }
        index++;
      }
    else{
      nameAlert();
      return;
    }
  }

  public void removeCourse(){
    for (Course course: courseList.getCourses())
    {
      if(course.getName().equals(courseName.getText())){
        courseObservableList.remove(course);
        courseList.removeCourse(course);
        courseName.clear();
        choiceBoxExaminer.getItems().remove(course);
        choiceBoxCourseExam.getItems().remove(course);
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
      choiceBoxGroupTestTaker.getItems().add(aux);
      choiceBoxGroupExam.getItems().add(aux);
      groupList.addGroup(groupName.getText());
      groupObservableList.add(aux);
      groupName.clear();
    }else{
      classroomAlert();
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
    if(groupList.groupNameValidator(new Group(auxName)))
      for (Group group: groupList.getGroups())
      {
        if(group.getGroupName().equals(lastGroupSelectedName)){
          group.setGroupName(auxName);
          groupObservableList.get(index).setGroupName(auxName);
          groupTableView.refresh();
          choiceBoxGroupTestTaker.getItems().set(index, group);
          choiceBoxGroupExam.getItems().set(index, group);
          testTakerTableView.refresh();
          break;
        }
        index++;
      }
    else{
      nameAlert();
      return;
    }
  }

  public void removeGroup(){
    int index = 0;
    for (Group group: groupList.getGroups())
    {
      if(group.getGroupName().equals(groupName.getText())){
        choiceBoxGroupTestTaker.getItems().remove(index);
        choiceBoxGroupExam.getItems().remove(index);
        groupObservableList.remove(index);
        groupList.removeGroup(group);
        groupName.clear();
        groupTableView.refresh();
        break;
      }
      index++;
    }
  }

  //Files

  public void saveButtonSelector(){
    String containerName = choiceBoxButton.getValue();
    if(containerName.equals("Courses")){
      saveCourse();
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

  public void saveCourse(){
    ObjectOutputStream out = null;
    try {
      File file = new File("courseSaveFile.bin");
      FileOutputStream fos = new FileOutputStream(file);
      out = new ObjectOutputStream(fos);
      try {
        out.writeObject(courseList);
      }
      catch (IOException e){
        e.printStackTrace();
      }
    }
    catch (IOException e){
      e.printStackTrace();
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

  public void testTakerAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid test-taker input");
    alert.setHeaderText("Test-taker has invalid name/nationality/group input or study number is duplicate!");
    alert.showAndWait();
  }

  public void examAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid exam input");
    alert.setHeaderText("Exam date might be invalid or Co-Examiner name might contain illegal characters!");
    alert.showAndWait();
  }

  public void examSameDateAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid exam date");
    alert.setHeaderText("Exam with this date and type already exists!");
    alert.showAndWait();
  }
} 
