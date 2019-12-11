package Classes;

import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams = null;

  public ExamList(){
    this.exams = new ArrayList<Exam>();
  }

  public boolean examValidator(Exam exam){
    String coExaminer = exam.getCoExaminer();
    String examName = exam.getName();
    Date auxDate = exam.getDate();
    int day = auxDate.getDay();
    int month = auxDate.getMonth();
    int year = auxDate.getYear();
    if(examName.equals("")) return false;
    if(coExaminer.matches(".*\\d.*")) return false;
    for(Exam aux: exams){
      if(aux.getName().equals(exam.getName()))
      {
        return false;
      }
    }
    return true;
  }

  public void addExam(Exam exam){     //TODO verify if date coincides
    for(Exam aux: exams){
      if(aux.getDate().equals(exam.getDate()))
      {
        //System.out.println("Classes.Exam on this date already exists!");     //Add warning on enter
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
