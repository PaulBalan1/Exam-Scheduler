import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class TestTakerList
{
  private ArrayList<TestTaker> testTakers = null;
  static ArrayList<String> studyNumbers = new ArrayList<String>();    // Storing so we can check for duplicates, static because we want to access it outside


  public TestTakerList(){
    testTakers = new ArrayList<TestTaker>();
  }

  public void addTestTaker(TestTaker testTaker){
    testTakers.add(testTaker);
  }

  public void addTestTaker(String name, String studyNumber, Group group, String nationality){
    TestTaker aux = new TestTaker(name, studyNumber, group, nationality);
    testTakers.add(aux);
  }

  public TestTaker getTestTaker(String identifier){
    if(Character.isDigit(identifier.charAt(0))){  //Check if identifier is Study Number
      for (TestTaker testTaker: testTakers)
      {
        if(testTaker.getStudyNumber().equals(identifier)) return testTaker;
      }
    }
    if(Collections.frequency(testTakers, identifier)>1){  // If identifier is Student Name proceed here
      System.out.println("Warning! Several test-takers by the same name! First instance selected.");
    }
    for (TestTaker testTaker: testTakers)
    {
      if(testTaker.getName().equals(identifier)) return testTaker;
    }
    return null;
  }

  public ArrayList<TestTaker> getByNationality(String nationality){
    ArrayList<TestTaker> aux = new ArrayList<>();
    for (TestTaker testTaker: testTakers)
    {
      if (testTaker.getNationality().equals(nationality)) aux.add(testTaker);
    }
    return aux;
  }

  public ArrayList<TestTaker> getByGroup(String groupName){
    ArrayList<TestTaker> aux = new ArrayList<>();
    for (TestTaker testTaker: testTakers)
    {
      if (testTaker.getGroup().toString().equals(groupName)) aux.add(testTaker);
    }
    return aux;
  }

  public String toString(){
    String aux = "";
    for (TestTaker testTaker: testTakers)
    {
      aux += testTaker + "\n";
    }
    return aux;
  }
}
