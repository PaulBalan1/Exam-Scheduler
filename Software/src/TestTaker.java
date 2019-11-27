public class TestTaker
{
  private String name;
  private String studyNumber;
  private String nationality;
  private Group group;

  public TestTaker(String name, String studyNumber, Group group, String nationality){
    this.name = name;
    this.studyNumber = studyNumber;
    this.group = group;
    this.nationality = nationality;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setNationality(String nationality)
  {
    this.nationality = nationality;
  }

  public void setStudyNumber(String studyNumber)
  {
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
