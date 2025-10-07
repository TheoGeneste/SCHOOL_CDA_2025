
import java.util.ArrayList;
import java.util.List;

public class SingletonData {

    private static SingletonData instance;
    private List<Student> students;
    private List<Teacher> teachers;

    private SingletonData() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public static SingletonData getInstance() {
        if (instance == null) {
            instance = new SingletonData();
        }
        return instance;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }
    
}
