
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // System.out.println(Class.SIXIEME.getValue());
        // Student student = new Student("Théo", "BIALASIK", 24);
        // System.out.println(student.toString());
        // Suppression de l'object
        // student = null;
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        String messageUser = "";
        while (!isInt) {
            System.out.println("Que voulez vous gérer?");
            System.out.println("1 - Gestions des étudiants");
            System.out.println("2 - Gestions des formateurs");
            System.out.println("3 - Gestions des cours");
            System.out.println("4 - Gestions des inscriptons");
            System.out.println("5 - Gestions des Notes");
            System.out.println("6 - Exit");
            try {
                messageUser = scanner.nextLine();
                int userChoice = Integer.parseInt(messageUser);
                isInt = true;
                switch (userChoice) {
                    case 1:
                        Student.manageStudent();
                        break;
                    case 2:
                        System.out.println("Gestions des formateurs");
                        break;
                    case 3:
                        System.out.println("Gestions des cours");
                        break;
                    case 4:
                        System.out.println("Gestions des inscriptions");
                        break;
                    case 5:
                        System.out.println("Gestions des notes");
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Que voulez vous gérer? (Saississez le nombre associé a votre choix)");
                        System.out.println("1 - Gestions des étudiants");
                        System.out.println("2 - Gestions des formateurs");
                        System.out.println("3 - Gestions des cours");
                        System.out.println("4 - Gestions des inscriptons");
                        System.out.println("5 - Gestions des Notes");
                        System.out.println("6 - Exit");
                        isInt = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Votre choix doit-être un chiffre");
            }
        }

        scanner.close();
    }
;
}
