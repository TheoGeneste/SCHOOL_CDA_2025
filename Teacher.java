
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person {

    public static void showTeachers() {
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    private static void createTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom :");
        String lastName = scanner.nextLine();
        System.out.println("Prenom :");
        String firstName = scanner.nextLine();
        System.out.println("Age :");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Salaire :");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Teacher teacher = new Teacher(firstName, lastName, age, salary);
        SingletonData.getInstance().addTeacher(teacher);
    }

    private static void updateTeacher() {
        showTeachers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel formateur voulez-vous modifier (nom) ?");
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        for (Teacher teacher : teachers) {
            if (teacher.lastName.equals(teacherChoice)) {
                System.out.println("Nouveau nom : (" + teacher.lastName + ")");
                String newLastName = scanner.nextLine();
                System.out.println("Nouveau prenom : (" + teacher.firstName + ")");
                String newFirstName = scanner.nextLine();
                System.out.println("Nouvel age : ( " + teacher.age + ")");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nouveau salaire :");
                double newSalary = scanner.nextDouble();
                scanner.nextLine();
                teacher.setLastName(newLastName);
                teacher.setFirstName(newFirstName);
                teacher.setAge(newAge);
                teacher.setSalary(newSalary);
                return;
            }
        }
    }

    private static void deleteTeacher() {
        showTeachers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel formateur voulez-vous supprimer (nom) ?");
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        for (Teacher teacher : teachers) {
            if (teacher.lastName.equals(teacherChoice)) {
                for (Cours c : teacher.cours) {
                    c.setTeacher(null);
                }
                SingletonData.getInstance().removeTeacher(teacher);
                return;
            }
        }
    }

    private static void showCoursByTeacher() {
        Scanner scanner = new Scanner(System.in);
        showTeachers();
        System.out.println("Choisissez le formateur (nom) :");
        String teacherChoice = scanner.nextLine();
        List<Teacher> teachers = SingletonData.getInstance().getTeachers();
        for (Teacher t : teachers) {
            if (t.lastName.equals(teacherChoice)) {
                t.printCours();
                return;
            }
        }

    }

    private List<Cours> cours;
    private double salary;

    public Teacher(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.cours = new ArrayList<>();
    }

    public Teacher(String firstName, String lastName, int age, double salary) {
        super(firstName, lastName, age);
        this.cours = new ArrayList<>();
        this.salary = salary;
    }

    public void addCours(Cours cours) {
        this.cours.add(cours);
    }

    public void addCours(List<Cours> cours) {
        this.cours.addAll(cours);
    }

    public void removeCours(Cours cours) {
        this.cours.remove(cours);
    }

    public void removeCours(List<Cours> cours) {
        this.cours.removeAll(cours);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void manageTeacher() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            System.out.println("Que voulez-vous faire?");
            System.out.println("1 - Afficher les formateurs");
            System.out.println("2 - Creation d'un formateur");
            System.out.println("3 - Modification d'un formateur");
            System.out.println("4 - Suppression d'un formateur");
            System.out.println("5 - Afficher les cours d'un formateur");
            System.out.println("6 - Retour");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                isInt = true;
                switch (userChoice) {
                    case 1:
                        showTeachers();
                        break;
                    case 2:
                        createTeacher();
                        break;
                    case 3:
                        updateTeacher();
                        break;
                    case 4:
                        deleteTeacher();
                        break;
                    case 5:
                        showCoursByTeacher();
                        break;
                    case 6:
                        System.out.println("Retour");
                        return;
                    default:
                        System.out.println("Que voulez-vous faire?");
                        System.out.println("1 - Afficher les formateurs");
                        System.out.println("2 - Creation d'un formateur");
                        System.out.println("3 - Modification d'un formateur");
                        System.out.println("4 - Suppression d'un formateur");
                        System.out.println("5 - Retour");
                        isInt = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veullez rentrer un nombre");
            }
        }
    }

    public String getLastName() {
       return lastName;
    }

    private void printCours() {
        for (Cours c : cours) {
            System.out.println(c.toString());
        }
    }

}
