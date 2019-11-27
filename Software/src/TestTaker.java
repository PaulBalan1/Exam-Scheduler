public class TestTaker
{
  private String name;
  private String studyNumber;
  private String nationality;
  private Group group;

  private boolean studyNumberDuplicate;

  public TestTaker(String name, String studyNumber, Group group, String nationality){
    studyNumberDuplicate = false;
    setStudyNumber(studyNumber);
    if(studyNumberDuplicate) return;            // TODO Study number duplicate error
    setName(name);
    this.group = group;
    setNationality(nationality);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setNationality(String nationality)      //Takes first 2 chars and makes them uppercase
  {
    this.nationality = nationality.substring(0,2).toUpperCase();
  }

  public void setStudyNumber(String studyNumber)
  {
    if(TestTakerList.studyNumbers.contains(studyNumber))
    {
      System.out.println("Study number already exists!");
      studyNumberDuplicate = true;
    }

    TestTakerList.studyNumbers.add(studyNumber);
    this.studyNumber = studyNumber;
  }

  public void setGroup(String groupName)
  {
    this.group = new Group(groupName);
  }

  public String getName()
  {
    return name;
  }

  public Group getGroup()
  {
    return group;
  }

  public String getNationality()
  {
    return nationality;
  }

  public String getStudyNumber()
  {
    return studyNumber;
  }

  public String toString(){
    return name + " " + studyNumber + " " + group + " " + nationality;
  }
}
