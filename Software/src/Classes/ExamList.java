package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class ExamList implements Serializable
{
  private ArrayList<Exam> exams = null;

  public ExamList(){
    this.exams = new ArrayList<Exam>();
  }

  public boolean examValidator(Exam exam){
    String coExaminer = exam.getCoExaminer();
    String examName = exam.getName();
    if(examName.equals("")) return false;
    if(exam.getCourse().equals(null) || exam.getGroup().equals(null) || exam.getClassroom().equals(null) || exam.getExaminer().equals(null)) return false;
    if(coExaminer.matches(".*\\d.*")){
      return false;
    }
    return true;
  }

  public ArrayList<Exam> getExams()
  {
    return exams;
  }

  public void addExam(Exam exam){
    exams.add(exam);
  }

  public void removeExam(Exam exam){
    exams.remove(exam);
  }

  @Override public String toString()
  {
    String aux = "";
    for (Exam exam: exams)
    {
      aux += exam + "\n";
    }
    return aux;
  }
}
