public class Application
{
  public static void main(String[] args)
  {
    GroupList groupList = new GroupList();
    groupList.addGroup("IT1Z");
    groupList.addGroup("IT1Y");
    groupList.addGroup("IT2X");
    groupList.addGroup("SE5Y");

    TestTaker testTaker1 = new TestTaker("Paul0", "123", groupList.getGroup("IT1Z"),"RO");
    TestTaker testTaker2 = new TestTaker("Paul1", "1234", groupList.getGroup("IT1Z"),"MD");
    TestTaker testTaker3 = new TestTaker("Paul2", "12345", groupList.getGroup("SE5Y"),"EN");
    TestTaker testTaker4 = new TestTaker("Paul3", "123456", groupList.getGroup("SE5Y"),"RO");

    TestTakerList testTakerList = new TestTakerList();
    testTakerList.addTestTaker(testTaker1);
    testTakerList.addTestTaker(testTaker2);
    testTakerList.addTestTaker(testTaker3);
    testTakerList.addTestTaker("Paul4", "123456", groupList.getGroup("IT1Z"), "RO");

//    System.out.println(testTakerList);

  }
}
