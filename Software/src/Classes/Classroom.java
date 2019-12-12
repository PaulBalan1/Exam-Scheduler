package Classes;

public class Classroom
{
  private String name;
  private int capacity;
  private boolean hasProjector;

  public Classroom(String name, int capacity, boolean hasProjector){
    setName(name);
    setCapacity(capacity);
    setHasProjector(hasProjector);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setCapacity(int capacity)
  {
    this.capacity = capacity;
  }

  public void setHasProjector(boolean hasProjector)
  {
    this.hasProjector = hasProjector;
  }

  public String getName()
  {
    return name;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public boolean getHasProjector(){
    return hasProjector;
  }

  @Override public String toString()
  {
    return name + " cap=" + capacity + " HDMI=" + (hasProjector?"YES":"NO");
  }
}
