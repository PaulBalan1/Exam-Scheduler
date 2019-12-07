package Classes;

import java.util.ArrayList;

public class CourseList
{
  private ArrayList<Course> courses = null;

  public CourseList(){
    courses = new ArrayList<Course>();
  }

  public ArrayList<Course> getCourses()
  {
    return courses;
  }

  public int size(){
    return courses.size();
  }

  public boolean courseNameValidator(Course course){
    if(course.getName().equals("")) return false;
    for(Course aux : courses){
      if(aux.getName().equals(course.getName()))
      {
        return false;
      }
    }
    return true;
  }

  public void addCourse(Course course){
    if(courseNameValidator(course)) courses.add(course);
  }

  public void addCourse(String name){
    for(Course course : courses){
      if(course.getName().equals(name))
      {
        System.out.println("Classes.Course with same name already exists!");     //Add warning on enter
        return;
      }
    }
    courses.add(new Course(name));
  }

  public void removeCourse(String name){
    for(Course course: courses){
      if(course.getName().equals(name)){
        courses.remove(course);
        break;
      }
    }
  }

  public void removeCourse(Course course){
    courses.remove(course);
  }

  @Override public String toString()
  {
    String aux = "";
    for (Course course : courses)
    {
      aux += course + "\n";
    }
    return aux;
  }
}
