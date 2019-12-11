package Classes;

import java.io.Serializable;

public class Course implements Serializable
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
