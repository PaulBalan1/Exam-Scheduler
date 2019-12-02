import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams = null;

  public ExamList(){
    this.exams = new ArrayList<Exam>();
  }

  public void addExam(Exam exam){     //TODO verify if date coincides
    for(Exam aux: exams){
      if(aux.getDate().equals(exam.getDate()))
      {
        System.out.println("Exam on this date already exists!");     //Add warning on enter
        return;
      }
    }
    exams.add(exam);
  }

  public void removeExam(Exam exam){
    exams.remove(exam);
  }

  public void removeExam(String name){
    for (Exam exam: exams)
    {
      if(exam.getName().equals(name)){
        exams.remove(exam);
        return;
      }
    }
  }

}
