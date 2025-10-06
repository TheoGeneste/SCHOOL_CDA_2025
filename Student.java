
import java.util.Map;
import java.util.Scanner;

public class Student extends Person {

    private Map<Cours, Double> average;
    private Classe classUser;
    public Student(String firstName, String lastName, int age,Classe classUser) {
        super(firstName, lastName, age);
        this.classUser = classUser;
    }

    @Override
    public String toString() {
        return super.toString() + " Etudiant : " + this.firstName + " " + this.lastName + " agé de " + this.age;
    }

    public static Student createEtudiant(){
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
        return new Student(firstName, lastName, age, class1);
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
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                isInt = true;
                switch (userChoice) {
                    case 1:
                        System.out.println("Afficher liste etudiants");
                        break;
                    case 2:
                        System.out.println("Création d'un étudiant");
                        createEtudiant();
                        break;
                    case 3:
                        System.out.println("Modification d'un étudiant");
                        break;
                    case 4:
                        System.out.println("Suppression d'un étudiant");
                        break;

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
