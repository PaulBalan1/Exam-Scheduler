import java.util.ArrayList;

public class GroupList
{
  private ArrayList<Group> groups = null;

  public GroupList(){
    groups = new ArrayList<Group>();
  }

  public void addGroup(String groupName){
    Group aux = new Group(groupName);
    groups.add(aux);
  }

  public void removeGroup(String groupName){
    for (Group group: groups)
    {
      if(group.getGroupName().equals(groupName)){
        groups.remove(group);
        return;
      }
    }
  }

  public void removeGroup(int index){
    groups.remove(index);
  }

  public Group getGroup(int index){
    return groups.get(index);
  }

  public Group getGroup(String groupName){
    for (Group group: groups)
    {
      if(group.toString().equals(groupName)) return group;
    }
    return null;
  }

  public String toString(){
    String aux = "";
    for (Group group: groups)
    {
      aux += group + "\n";
    }
    return aux;
  }
}
