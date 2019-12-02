package Classes;

public class Course
{
  private String name;

  public Course(String name){
    setName(name);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  @Override public String toString()
  {
    return name;
  }
}
