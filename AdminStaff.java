
import java.time.LocalDateTime;
import java.util.List;

public class AdminStaff extends Person{

    public AdminStaff(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
    
    public void addCoursToTeacher(Cours cours, Teacher teacher){
        teacher.addCours(cours);
        cours.setTeacher(teacher);
    }

    public void removeCoursFromTeacher(Cours cours, Teacher teacher){
        teacher.removeCours(cours);
        cours.setTeacher(null);
    }
    
    public void addCoursToTeacher(List<Cours> cours, Teacher teacher){
        teacher.addCours(cours);
        for (Cours cour : cours) {
            cour.setTeacher(teacher);
        }
    }

    public void removeCoursFromTeacher(List<Cours> cours, Teacher teacher){
        teacher.removeCours(cours);
        //{label : java, teache : { fistname: theo}}
        // [{label : java, teache : { fistname: theo}, {label : java, teache : { fistname: theo}]
        for (Cours cour : cours) {
            cour.setTeacher(null);
        }
    }

    public void setSalaryToTeacher(double salary, Teacher teacher){
        teacher.setSalary(salary );
    }

    public void createCours(String label , LocalDateTime startTime, LocalDateTime endTime, Teacher teacher, List<Student> students, Classe level){
        Cours cours = new Cours(label, teacher, startTime, endTime, level);
        cours.addStudent(students);
    }

    public void addStudentToCours(Student student, Cours cours){
        cours.addStudent(student);
    }

    public void removeStudentFromCours(Student student, Cours cours){
        cours.removeStudent(student);
    }

        public void addStudentToCours(List<Student> student, Cours cours){
        cours.addStudent(student);
    }

    public void removeStudentFromCours(List<Student> student, Cours cours){
        cours.removeStudent(student);
    }

}
