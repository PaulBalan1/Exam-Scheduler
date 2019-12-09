package Classes;

public class TestTaker
{
  private String name;
  private String studyNumber;
  private String nationality;
  private Group group;

  public TestTaker(String name, String studyNumber, Group group, String nationality){
    setStudyNumber(studyNumber);
    setName(name);
    this.group = group;
    setNationality(nationality);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setNationality(String nationality)                    //Takes first 2 chars and makes them uppercase
  {
    if(nationality.length()<2) this.nationality = nationality;
    else this.nationality = nationality.substring(0,2).toUpperCase();
  }

  public void setStudyNumber(String studyNumber)
  {
    TestTakerList.studyNumbers.add(studyNumber);
    this.studyNumber = studyNumber;
  }

  public void setGroup(String groupName)
  {
    this.group = new Group(groupName);
  }

  public void setGroup(Group group)
  {
    this.group = group;
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
