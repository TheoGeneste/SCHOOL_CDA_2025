public class App{
    public static void main(String[] args) {
        System.out.println(Class.SIXIEME.getValue());
        Student student = new Student("Théo", "BIALASIK", 24);
        System.out.println(student.toString());
        // Suppression de l'object
        student = null;
    }
}