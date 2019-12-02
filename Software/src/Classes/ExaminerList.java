package Classes;

import java.util.ArrayList;

public class ExaminerList {
    private ArrayList<Examiner> examiners = null;

    public ExaminerList(){
        examiners = new ArrayList<Examiner>();
    }

    public void addExaminer(Examiner examiner){
        examiners.add(examiner);
    }

    public void addExaminer(String name){
        Examiner aux = new Examiner(name);
        examiners.add(aux);
    }

    public void addExaminer(String name, Course course){
        Examiner aux = new Examiner(name, course);
        examiners.add(aux);
    }

    public void removeExaminer(Examiner examiner){
        examiners.remove(examiner);
    }

    public void removeExaminer(String name){
        for(Examiner examiner: examiners){
            if(examiner.getName().equals(name)){
                examiners.remove(examiner);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for (Examiner examiner: examiners)
        {
            aux += examiner + "\n";
        }
        return aux;
    }
}
