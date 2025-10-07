
import java.util.List;
import java.util.Scanner;

public class Notes {

    private static void addNote() {
        Scanner scanner = new Scanner(System.in);
        Student.showStudents();
        System.out.println("Pour quel étudiant voulez-vous ajouter une note (nom) ?");
        String studentChoice = scanner.nextLine();
        List<Student> students = SingletonData.getInstance().getStudents();
        Student student = null;
        for (Student s : students) {
            if (s.getLastName().equals(studentChoice)) {
                student = s;
            }
        }
        Teacher.showTeachers();
        System.out.println("Pour quel formateur voulez-vous ajouter une note (nom) ?");
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        Teacher teacher = null;
        for (Teacher t : teachers) {
            if (t.getLastName().equals(teacherChoice)) {
                teacher = t;
            }
        }
        System.out.println("Quelle note voulez-vous ajouter ?");
        double noteValue = scanner.nextDouble();
        scanner.nextLine();
        Notes note = new Notes(noteValue, student, teacher);
        SingletonData.getInstance().addNotes(note);
    }

    private static void updateNote() {
        Scanner scanner = new Scanner(System.in);
        Teacher.showTeachers();
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        Teacher teacher= null;
        for(Teacher t : teachers){
            if (t.getLastName().equals(teacherChoice)) {
                teacher = t;
            }
        }
        Student.showStudents();
        String studentChoice = scanner.nextLine();
        List<Student> students = SingletonData.getInstance().getStudents();
        Student student = null;
        for(Student s : students){
            if (s.getLastName().equals(studentChoice)) {
                student = s;
            }
        }
        List<Notes> notes = SingletonData.getInstance().getNotes();
        for (Notes n : notes) {
            if (n.student.equals(student) && n.teacher.equals(teacher)) {
                System.out.println("Quelle est la nouvelle note ? (actuelle : " + n.note + ")");
                double newNote = scanner.nextDouble();
                n.note = newNote;
                return;
            }
        }
    }

    private static void deleteNote() {
        Scanner scanner = new Scanner(System.in);
        Teacher.showTeachers();
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        Teacher teacher= null;
        for(Teacher t : teachers){
            if (t.getLastName().equals(teacherChoice)) {
                teacher = t;
            }
        }
        Student.showStudents();
        String studentChoice = scanner.nextLine();
        List<Student> students = SingletonData.getInstance().getStudents();
        Student student = null;
        for(Student s : students){
            if (s.getLastName().equals(studentChoice)) {
                student = s;
            }
        }
        List<Notes> notes = SingletonData.getInstance().getNotes();
        for (Notes n : notes) {
            if (n.student.equals(student) && n.teacher.equals(teacher)) {
                SingletonData.getInstance().removeNotes(n);
                return;
            }
        }
    }

    private static void showNoteByTeacher() {
        Teacher.showTeachers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour quel formateur voulez-vous voir les notes (nom) ?");
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        for (Teacher t : teachers) {
            if (t.getLastName().equals(teacherChoice)) {
                for (Notes n : SingletonData.getInstance().getNotes()) {
                    if (n.teacher.equals(t)) {
                        System.out.println("Note : " + n.note + " | Donnée à : " + n.student.getLastName());
                    }
                }
            }
        }
    }

    private static void showNoteByStudent() {
        Student.showStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour quel étudiant voulez-vous voir les notes (nom) ?");
        String studentChoice = scanner.nextLine();
        List<Student> students = SingletonData.getInstance().getStudents();
        for (Student s : students) {
            if (s.getLastName().equals(studentChoice)) {
                for (Notes n : SingletonData.getInstance().getNotes()) {
                    if (n.student.equals(s)) {
                        System.out.println("Note : " + n.note + " | Donnée par : " + n.teacher.getLastName());
                    }
                }
            }
        }
    }

    private double note;
    private Student student;
    private Teacher teacher;

    public Notes(double note, Student student, Teacher teacher) {
        this.note = note;
        this.student = student;
        this.teacher = teacher;
    }

    public static void manageNotes() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            System.out.println("Gestion des notes :");

            System.out.println("1 - Afficher les notes pour un étudiants");
            System.out.println("2 - Afficher les notes pour un formateur");
            System.out.println("3 - Ajouter une note");
            System.out.println("4 - Modifier une note");
            System.out.println("5 - Supprimer une note");
            System.out.println("6 - Retour");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                isInt = true;
                switch (userChoice) {
                    case 1:
                        showNoteByStudent();
                        break;
                    case 2:
                        showNoteByTeacher();
                        break;
                    case 3:
                        addNote();
                        break;
                    case 4:
                        updateNote();
                        break;
                    case 5:
                        deleteNote();
                        break;
                    case 6:
                        System.out.println("Retour");
                        return;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                        isInt = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
            }
        }
    }
}
