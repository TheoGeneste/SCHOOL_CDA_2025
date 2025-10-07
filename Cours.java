
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cours {

    private static void showCours() {
        List<Cours> cours = SingletonData.getInstance().getCours();
        for (Cours c : cours) {
            System.out.println(c.toString());
        }
    }

    private static void createCours() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom du cours :");
        String label = scanner.nextLine();
        System.out.println("Date de début (format : yyyy-MM-ddTHH:mm) :");
        String userStartDate = scanner.nextLine();
        LocalDateTime startDate = LocalDateTime.parse(userStartDate);
        System.out.println("Date de fin (format : yyyy-MM-ddTHH:mm) :");
        String userEndDate = scanner.nextLine();
        LocalDateTime endDate = LocalDateTime.parse(userStartDate);
        System.out.println("Formateur du cours :");
        Teacher.showTeachers();
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        Teacher teacher = null;
        for (Teacher t : teachers) {
            if (t.getLastName().equals(teacherChoice)) {
                teacher = t;
            }
        }
        System.out.println("Level du cours : ");
        for (Classe elem : Classe.values()) {
            System.out.println(elem);
        }
        String classStudent = scanner.nextLine();
        Classe class1 = Classe.valueOf(classStudent);
        Cours newCours = new Cours(label, teacher, startDate, endDate, class1);
        SingletonData.getInstance().addCours(newCours);
        teacher.addCours(newCours);

    }

    private static void updateCours() {
        showCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel cours voulez-vous modifier (nom) ?");
        String coursChoice = scanner.nextLine();
        List<Cours> cours = SingletonData.getInstance().getCours();
        for (Cours c : cours) {
            if (c.label.equals(coursChoice)) {
                System.out.println("Nouveau nom : (" + c.label + ")");
                String newLabel = scanner.nextLine();
                System.out.println("Nouvelle date de début (format : yyyy-MM-ddTHH:mm) : (" + c.startDate + ")");
                String userStartDate = scanner.nextLine();
                LocalDateTime newStartDate = LocalDateTime.parse(userStartDate);
                System.out.println("Nouvelle date de fin (format : yyyy-MM-ddTHH:mm) : (" + c.endDate + ")");
                String userEndDate = scanner.nextLine();
                LocalDateTime newEndDate = LocalDateTime.parse(userEndDate);
                c.label = newLabel;
                c.startDate = newStartDate;
                c.endDate = newEndDate;
                return;
            }
        }
    }

    private static void deleteCours() {
        showCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel cours voulez-vous supprimer (nom) ?");
        String coursChoice = scanner.nextLine();
        List<Cours> cours = SingletonData.getInstance().getCours();
        for (Cours c : cours) {
            if (c.label.equals(coursChoice)) {
                c.teacher.removeCours(c);
                SingletonData.getInstance().removeCours(c);
                return;
            }
        }
    }

    private static void addStudentToCours() {
        showCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour quel cours voulez-vous ajouter un étudiant (nom) ?");
        String coursChoice = scanner.nextLine();
        List<Cours> cours = SingletonData.getInstance().getCours();
        for (Cours c : cours) {
            if (c.label.equals(coursChoice)) {
                Student.showStudents();
                System.out.println("Quel étudiant voulez-vous ajouter (nom) ?");
                String studentChoice = scanner.nextLine();
                List<Student> students = SingletonData.getInstance().getStudents();
                for (Student s : students) {
                    if (s.getLastName().equals(studentChoice)) {
                        if (!s.getClassUser().equals(c.level)) {
                            System.out.println("L'étudiant n'est pas dans la bonne classe pour ce cours");
                            return;
                        }
                        if (c.students.contains(s)) {
                            System.out.println("L'étudiant est déjà inscrit à ce cours");
                            return;
                        }
                        c.addStudent(s);
                        return;
                    }
                }
            }
        }
        return;
    }

    private static void showStudentsByCours() {
        showCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour quel cours voulez-vous afficher les étudiants inscrits (nom) ?");
        String coursChoice = scanner.nextLine();
        List<Cours> cours = SingletonData.getInstance().getCours();
        for (Cours c : cours) {
            if (c.label.equals(coursChoice)) {
                c.printStudents();
                return;
            }
        }
    }

    private static void removeStudentFromCours() {
        showCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour quel cours voulez-vous retirer un étudiant (nom) ?");
        String coursChoice = scanner.nextLine();
        List<Cours> cours = SingletonData.getInstance().getCours();
        for (Cours c : cours) {
            if (c.label.equals(coursChoice)) {
                c.printStudents();
                System.out.println("Quel étudiant voulez-vous retirer (nom) ?");
                String studentChoice = scanner.nextLine();
                List<Student> students = SingletonData.getInstance().getStudents();
                for (Student s : students) {
                    if (s.getLastName().equals(studentChoice)) {
                        if (!c.students.contains(s)) {
                            System.out.println("L'étudiant n'est pas inscrit à ce cours");
                            return;
                        }
                        c.removeStudent(s);
                        return;
                    }
                }
                return;
            }
        }
    }

    private String label;
    private Teacher teacher;
    private List<Student> students;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Classe level;

    public Cours(String label, Teacher teacher, List<Student> students, LocalDateTime startDate, LocalDateTime endDate, Classe level) {
        this.label = label;
        this.teacher = teacher;
        this.students = students;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
    }

    public Cours(String label, Teacher teacher, LocalDateTime startDate, LocalDateTime endDate, Classe level) {
        this.label = label;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
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

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void manageCours() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            System.out.println("Que voulez-vous faire?");
            System.out.println("1 - Afficher les cours");
            System.out.println("2 - Creation d'un cours ");
            System.out.println("3 - Modification d'un cours ");
            System.out.println("4 - Suppression d'un cours ");
            System.out.println("5 - Retour");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                isInt = true;
                switch (userChoice) {
                    case 1:
                        showCours();
                        break;
                    case 2:
                        createCours();
                        break;
                    case 3:
                        updateCours();
                        break;
                    case 4:
                        deleteCours();
                        break;
                    case 5:
                        System.out.println("Retour");
                        return;
                    default:
                        System.out.println("Que voulez-vous faire?");
                        System.out.println("1 - Afficher les cours");
                        System.out.println("2 - Creation d'un cours ");
                        System.out.println("3 - Modification d'un cours ");
                        System.out.println("4 - Suppression d'un cours ");
                        System.out.println("5 - Retour");
                        isInt = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veullez rentrer un nombre");
            }
        }
    }

    @Override
    public String toString() {
        return "Cours{" + "label=" + label + ", teacher=" + teacher + " , startDate=" + startDate + ", endDate=" + endDate + ", level=" + level + '}';
    }

    public static void manageInscription() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            System.out.println("Que voulez-vous faire?");
            System.out.println("1 - Afficher les èleves inscrits à un cours");
            System.out.println("2 - Ajouter un étudiant à un cours");
            System.out.println("3 - Retirer un étudiant d'un cours");
            System.out.println("4 - Retour");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                isInt = true;
                switch (userChoice) {
                    case 1:
                        showStudentsByCours();
                        break;
                    case 2:
                        addStudentToCours();
                        break;
                    case 3:
                        removeStudentFromCours();
                        return;
                    case 4:
                        System.out.println("Retour");
                        return;
                    default:
                        System.out.println("Que voulez-vous faire?");
                        System.out.println("1 - Afficher les èleves inscrits à un cours");
                        System.out.println("2 - Ajouter un étudiant à un cours");
                        System.out.println("3 - Retirer un étudiant d'un cours");
                        System.out.println("4 - Retour");
                        isInt = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veullez rentrer un nombre");
            }
        }
    }
}
