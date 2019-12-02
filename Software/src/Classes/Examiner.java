package Classes;

public class Examiner {
    private String name;
    private Course course;

    public Examiner(String name, Course course){
        setName(name);
        setCourse(course);
    }

    public Examiner(String name){
        setName(name);
        setCourse(null);
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Classes.Examiner{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}