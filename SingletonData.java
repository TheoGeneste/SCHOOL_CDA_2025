
import java.util.ArrayList;
import java.util.List;

public class SingletonData {

    private static SingletonData instance;
    private List<Student> students;

    private SingletonData() {
        students = new ArrayList<>();
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
}
