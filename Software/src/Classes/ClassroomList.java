package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassroomList implements Serializable
{
  private ArrayList<Classroom> classrooms = null;

  public ClassroomList(){
    classrooms = new ArrayList<Classroom>();
  }

  public boolean classroomValidator(Classroom classroom){
    if(classroom.getName().equals("")) return false;
    if(classroom.getCapacity()<1 && classroom.getCapacity()>200) return false;
    for(Classroom aux: classrooms){
      if(aux.getName().equals(classroom.getName()))
      {
        return false;
      }
    }
    return true;
  }

  public void addClassroom(Classroom classroom){
    classrooms.add(classroom);
  }

  public void addClassroom(String name, int capacity, boolean hasProjector){
    Classroom aux = new Classroom(name, capacity, hasProjector);
    for(Classroom classroom: classrooms){
      if(classroom.getName().equals(aux.getName()))
      {
        System.out.println("Classes.Classroom with same name already exists!");     //Add warning on enter
        return;
      }
    }
    classrooms.add(aux);
  }

  public void removeClassroom(String name){
    for(Classroom classroom: classrooms){
      if(classroom.getName().equals(name)){
        classrooms.remove(classroom);
        break;
      }
    }
  }

  public void removeClassroom(Classroom classroom){
    classrooms.remove(classroom);
  }

  public ArrayList<Classroom> getClassroomsWithMinCapacityOf(int minCapacity){
    ArrayList<Classroom> aux = new ArrayList<Classroom>();
    for (Classroom classroom: classrooms)
    {
      if(classroom.getCapacity()>=minCapacity){
        aux.add(classroom);
      }
    }
    return aux;
  }

  public ArrayList<Classroom> getClassrooms()
  {
    return classrooms;
  }

  public ArrayList<Classroom> getClassroomsWithProjectors(){
    ArrayList<Classroom> aux = new ArrayList<Classroom>();
    for (Classroom classroom: classrooms)
    {
      if(classroom.getHasProjector()){
        aux.add(classroom);
      }
    }
    return aux;
  }

  @Override public String toString()
  {
    String aux = "";
    for (Classroom classroom: classrooms)
    {
      aux += classroom + "\n";
    }
    return aux;
  }
}
