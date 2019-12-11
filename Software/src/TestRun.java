import Classes.*;

public class TestRun
{
  public static void main(String[] args)
  {
    Classroom classroom0 = new Classroom("213A",40, true);
    Classroom classroom1 = new Classroom("213B",50, false);
    Classroom classroom2 = new Classroom("213C",60, true);
    ClassroomList classroomList = new ClassroomList();
    classroomList.addClassroom(classroom0);
    classroomList.addClassroom(classroom1);
    classroomList.addClassroom(classroom2);

    System.out.println(classroomList.getClassroomsWithProjectors());

    GroupList groupList = new GroupList();
    groupList.addGroup("IT1Z");
    groupList.addGroup("IT2X");
    groupList.addGroup("SE5Y");
    groupList.removeGroup(2);
    groupList.getGroup(10);

    TestTaker testTaker1 = new TestTaker("Paul0", "123", groupList.getGroup("IT1Z"),"romania");
    TestTaker testTaker2 = new TestTaker("Paul1", "1234", groupList.getGroup("IT1Z"),"moldova");
    TestTaker testTaker3 = new TestTaker("Paul2", "12345", groupList.getGroup("SE5Y"),"EN");
    TestTaker testTaker4 = new TestTaker("Paul3", "123456", groupList.getGroup("SE5Y"),"RO");

    TestTakerList testTakerList = new TestTakerList();
    testTakerList.addTestTaker(testTaker1);
    testTakerList.addTestTaker(testTaker2);
    testTakerList.addTestTaker(testTaker3);
    testTakerList.addTestTaker("Paul4", "1234567", groupList.getGroup("IT1Z"), "RO");

    Course course0 = new Course("SDJ1");
    Course course1 = new Course("RWD2");
    Course course2 = new Course("SEP5");
    CourseList courseList = new CourseList();
    courseList.addCourse(course0);
    courseList.addCourse("RWD1");
    courseList.addCourse(course1);
    courseList.addCourse(course2);
    courseList.addCourse("RWD1");
    courseList.removeCourse("RWD1");
    courseList.removeCourse(course0);

    Examiner examiner1 = new Examiner("Nicolai Sand");
    examiner1.setCourse(course1);
    Date date1 = new Date(6,12);
//    Exam exam = new Exam("RWDI", date1, course0, 3, classroom0, examiner1, testTakerList);
//    exam.setCoExaminer("Bob");
//    ExamList examList = new ExamList();
//    examList.addExam(exam);
//
//    System.out.println(exam);
  }
}
