import java.util.ArrayList;

public class ClassroomList
{
  private ArrayList<Classroom> classrooms = null;

  public ClassroomList(){
    classrooms = new ArrayList<Classroom>();
  }

  public void addClassroom(Classroom classroom){
    if(classrooms.contains(classroom)) {
      System.out.println("Classroom with same name already exists!");     //Add warning on enter
      return;
    }
    classrooms.add(classroom);
  }

  public void addClassroom(String name, int capacity, boolean hasProjector){
    Classroom aux = new Classroom(name, capacity, hasProjector);
    if(classrooms.contains(aux)) {
      System.out.println("Classroom with same name already exists!");     //Add warning on enter
      return;
    }
    classrooms.add(aux);
  }

  public void removeClassroom(String name){
    for(Classroom classroom: classrooms){
      if(classroom.getName().equals(name)) classrooms.remove(classroom);
      break;
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

  public ArrayList<Classroom> getClassroomsWithProjectors(){
    ArrayList<Classroom> aux = new ArrayList<Classroom>();
    for (Classroom classroom: classrooms)
    {
      if(classroom.hasProjector()){
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
