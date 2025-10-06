
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student extends Person {

    private Map<Cours, Double> average;
    private Classe classUser;

    public Student(String firstName, String lastName, int age, Classe classUser) {
        super(firstName, lastName, age);
        this.classUser = classUser;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return super.toString() + " Etudiant : " + this.firstName + " " + this.lastName + " agé de " + this.age;
    }

    public static void createStudent() {
        List<Student> students = SingletonData.getInstance().getStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom :");
        String lastName = scanner.nextLine();
        System.out.println("Prenom :");
        String firstName = scanner.nextLine();
        System.out.println("Age :");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Classe de l'etudiant : ");
        for (Classe elem : Classe.values()) {
            System.out.println(elem);
        }
        String classStudent = scanner.nextLine();
        Classe class1 = Classe.valueOf(classStudent);
        SingletonData.getInstance().addStudent(new Student(firstName, lastName, age, class1));
        return ;
    }

    public static void showStudents() {
        List<Student> students = SingletonData.getInstance().getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void updateStudent() {
        List<Student> students = SingletonData.getInstance().getStudents();
        System.out.println("Choisissez l'étudiant a modifier");
        showStudents();
        Scanner scanner = new Scanner(System.in);
        String studentChoice = scanner.nextLine();
        for (Student student : students) {
            System.out.println(student.getLastName());
            if (student.getLastName().equals(studentChoice)) {
                System.out.println("Modification du nom (actuel : " + student.getLastName() + ")");
                String newLastName = scanner.nextLine();
                student.setLastName(newLastName);
                System.out.println("Modification du prénom (actuel : " + student.firstName + ")");
                String newFirstName = scanner.nextLine();
                student.setFirstName(newFirstName);
                System.out.println("Modification de l'age (actuel : " + student.age + ")");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                student.setAge(newAge);
            }
        }
    }

    public static void deleteStudent() {
        List<Student> students = SingletonData.getInstance().getStudents();
        System.out.println("Choisissez l'étudiant a supprimer");
        showStudents();
        Scanner scanner = new Scanner(System.in);
        String studentChoice = scanner.nextLine();
        for (Student student : students) {
            System.out.println(student.getLastName());
            if (student.getLastName().equals(studentChoice)) {
                students.remove(student);
                return;
            }
        }
    }

    public static void manageStudent() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            System.out.println("Que voulez-vous faire?");
            System.out.println("1 - Afficher les étudiants");
            System.out.println("2 - Creation d'un étudiant");
            System.out.println("3 - Modification d'un étudiant");
            System.out.println("4 - Suppression d'un étudiant");
            System.out.println("5 - Retour");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                isInt = true;
                switch (userChoice) {
                    case 1:
                        showStudents();
                        break;
                    case 2:
                        System.out.println("Création d'un étudiant");
                        createStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Retour");
                        return;
                    default:
                        System.out.println("Que voulez-vous faire?");
                        System.out.println("1 - Afficher les étudiants");
                        System.out.println("2 - Creation d'un étudiant");
                        System.out.println("3 - Modification d'un étudiant");
                        System.out.println("4 - Suppression d'un étudiant");
                        isInt = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veullez rentrer un nombre");
            }
        }
    }
}
