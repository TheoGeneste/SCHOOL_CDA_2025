
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cours {

    private String label;
    private Teacher teacher;
    private List<Student> students;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Class level;

    public Cours(String label, Teacher teacher, List<Student> students, LocalDateTime startDate, LocalDateTime endDate, Class level) {
        this.label = label;
        this.teacher = teacher;
        this.students = students;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
    }

    public Cours(String label, Teacher teacher, LocalDateTime startDate, LocalDateTime endDate, Class level) {
        this.label = label;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        if(!students.contains(s)){
            students.add(s);
        }
    }

    public void addStudent(List<Student> s) {
        if (!students.containsAll(s)) {
            students.addAll(s);
        }
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void removeStudent(List<Student> s) {
        students.removeAll(s);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void printStudents (){
        for (Student student : students) {
            student.toString();
        }
    }
}
