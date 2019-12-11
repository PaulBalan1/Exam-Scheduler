package Classes;

public class Exam
{
  private String name;
  private Date date;
  private Course course;
  private String type;
  private Classroom classroom;
  private Examiner examiner;
  private String coExaminer;
  private Group group;

  public Exam(String name, Date date, Course course, Examiner examiner, String coExaminer, Group group, String type, Classroom classroom){
    setName(name);
    setDate(date);
    setCourse(course);
    setType(type);
    setClassroom(classroom);
    setExaminer(examiner);
    setGroup(group);
    setCoExaminer(coExaminer);
  }

  public String getName()
  {
    return name;
  }

  public Course getCourse()
  {
    return course;
  }

  public Group getGroup()
  {
    return group;
  }

  public String getType()
  {
    return type;
  }

  public Classroom getClassroom()
  {
    return classroom;
  }

  public Date getDate()
  {
    return date;
  }

  public Examiner getExaminer()
  {
    return examiner;
  }

  public String getCoExaminer()
  {
    return coExaminer;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void setClassroom(Classroom classroom)
  {
    this.classroom = classroom;
  }

  public void setCoExaminer(String coExaminer)
  {
    this.coExaminer = coExaminer;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public void setExaminer(Examiner examiner)
  {
    this.examiner = examiner;
  }

  public void setGroup(Group group)
  {
    this.group = group;
  }

  @Override public String toString()
  {
    return "Classes.Exam{" + "name='" + name + '\'' + ", date=" + date + ", course="
        + course + ", classroom=" + classroom + ", examiner=" + examiner
        + ", coExaminer='" + coExaminer + '\'' + ", group=" + group
        + '}';
  }
}
