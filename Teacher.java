
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

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

}
