public class Student extends Person {


    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
    
    @Override
    public String toString(){
        return super.toString() + " Etudiant : " + this.firstName +" " + this.lastName +" agé de "  + this.age ;
    }
}
