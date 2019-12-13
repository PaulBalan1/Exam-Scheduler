package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class GroupList implements Serializable
{
  private ArrayList<Group> groups = null;

  public GroupList()
  {
    groups = new ArrayList<Group>();
  }

  public void addGroup(String groupName)
  {
    Group aux = new Group(groupName);
    for (Group group : groups)
    {
      if (group.getGroupName().equals(groupName))
      {
        System.out.println("Group with this name already exists!");     //Add warning on enter
        return;
      }
    }

    groups.add(aux);
  }

  public boolean groupNameValidator(Group group){
    if(group.getGroupName().equals("")) return false;
    for(Group aux : groups){
      if(aux.getGroupName().equals(group.getGroupName()))
      {
        return false;
      }
    }
    return true;
  }

  public void removeGroup(Group group){
    groups.remove(group);
  }

  public void removeGroup(String groupName)
  {
    for (Group group : groups)
    {
      if (group.getGroupName().equals(groupName))
      {
        groups.remove(group);
        return;
      }
    }
  }

  public void removeGroup(int index)
  {
    try
    {
      groups.remove(index);
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("Index out of bounds. Enter valid index.");
    }
  }

  public ArrayList<Group> getGroups()
  {
    return groups;
  }

  public Group getGroup(int index)
  {
    try
    {
      groups.get(index);
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("Index out of bounds. Enter valid index.");
    }
    return null;
  }

  public Group getGroup(String groupName)
  {
    for (Group group : groups)
    {
      if (group.toString().equals(groupName)) return group;
    }
    return null;
  }

  public String toString()
  {
    String aux = "";
    for (Group group : groups)
    {
      aux += group + "\n";
    }
    return aux;
  }
}
