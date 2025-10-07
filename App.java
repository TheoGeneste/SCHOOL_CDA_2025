
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // System.out.println(Class.SIXIEME.getValue());
        // Student student = new Student("Théo", "BIALASIK", 24);
        // System.out.println(student.toString());
        // Suppression de l'object
        // student = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que voulez vous gérer?");
            System.out.println("1 - Gestions des étudiants");
            System.out.println("2 - Gestions des formateurs");
            System.out.println("3 - Gestions des cours");
            System.out.println("4 - Gestions des inscriptons");
            System.out.println("5 - Gestions des Notes");
            System.out.println("6 - Exit");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1:
                        Student.manageStudent();
                        break;
                    case 2:
                        Teacher.manageTeacher();
                        break;
                    case 3:
                        Cours.manageCours();
                        break;
                    case 4:
                        Cours.manageInscription();
                        break;
                    case 5:
                        Notes.manageNotes();1
                        
                        break;
                    case 6:
                        System.out.println("Au revoir");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Que voulez vous gérer? (Saississez le nombre associé a votre choix)");
                        System.out.println("1 - Gestions des étudiants");
                        System.out.println("2 - Gestions des formateurs");
                        System.out.println("3 - Gestions des cours");
                        System.out.println("4 - Gestions des inscriptons");
                        System.out.println("5 - Gestions des Notes");
                        System.out.println("6 - Exit");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Votre choix doit-être un chiffre");
            }
        }
    }
;
}
