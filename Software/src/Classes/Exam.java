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
  private TestTakerList testTakers;

  private String[] types = {"written", "oral"};

  public Exam(String name, Date date, Course course, int typeIndex, Classroom classroom, Examiner examiner, TestTakerList testTakers){
    setName(name);
    setDate(date);
    setCourse(course);
    setType(typeIndex);    // 0 for written , 1 for oral
    setClassroom(classroom);
    setExaminer(examiner);
    setTestTakers(testTakers);
    coExaminer = "";
  }

  public Exam(String name, int day, int month, int year, Course course, int typeIndex, Classroom classroom, Examiner examiner, TestTakerList testTakers){
    setName(name);
    Date aux = new Date(day,month,year);
    setDate(aux);
    setCourse(course);
    setType(typeIndex);    // 0 for written , 1 for oral
    setClassroom(classroom);
    setExaminer(examiner);
    setTestTakers(testTakers);
  }

  public String getName()
  {
    return name;
  }

  public Course getCourse()
  {
    return course;
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

  public TestTakerList getTestTakers()
  {
    return testTakers;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setType(int typeIndex)
  {
    if(typeIndex!=0 && typeIndex!=1){
      System.out.println("Enter valid exam type (0 or 1)!");
      return;
    }
    this.type = types[typeIndex];
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

  public void setTestTakers(TestTakerList testTakers)
  {
    this.testTakers = testTakers;
  }

  @Override public String toString()
  {
    return "Classes.Exam{" + "name='" + name + '\'' + ", date=" + date + ", course="
        + course + ", classroom=" + classroom + ", examiner=" + examiner
        + ", coExaminer='" + coExaminer + '\'' + ", testTakers=" + testTakers
        + '}';
  }
}
