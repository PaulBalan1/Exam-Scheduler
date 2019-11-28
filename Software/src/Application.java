public class Application
{
  public static void main(String[] args)
  {
    Classroom classroom0 = new Classroom("213A",40, true);
    Classroom classroom1 = new Classroom("213B",50, false);
    Classroom classroom2 = new Classroom("213C",60, true);
    ClassroomList classrooms = new ClassroomList();
    classrooms.addClassroom(classroom0);
    classrooms.addClassroom(classroom1);
    classrooms.addClassroom(classroom2);

    System.out.println(classrooms.getClassroomsWithProjectors());

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

    System.out.println(testTakerList);
  }
}
