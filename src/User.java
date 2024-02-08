import java.util.ArrayList;

public abstract class User {
    private String firstName, lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " +  lastName;
    }
}

class Parent extends User implements Observer{
    ArrayList<Notification> notifications;
    public Parent(){
        super("Doru", "Constantin");
        this.notifications = new ArrayList<>();
    }

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
        this.notifications = new ArrayList<>();
    }

    @Override
    public void update(Notification notification) {
        this.notifications.add(notification);
    }
}



class Student extends User{
    private Parent mother;
    private Parent father;

    public Student(){
        super("Radu", "Constantin");
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }



    public void setMother(Parent mother){
     this.mother = mother;
    }

    public void setFather(Parent father){
     this.father = father;
    }

    public boolean isParent(Observer observer) {
        if (observer == father || observer == mother) {
            return true;
        }
        return false;
    }
}

class Assistant extends User implements Element{

    public Assistant(){
        super("Alex", "Popescu");
    }

    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Teacher extends User implements Element{

    public Teacher(){
        super("Carmen", "Odubasteanu");
    }

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class UserFactory {
    public static User createUser (String userName, String firstName, String lastName) {
        if (userName.equals("Parent"))
            return new Parent(firstName, lastName);
        if (userName.equals("Student"))
            return new Student(firstName, lastName);
        if (userName.equals("Assistant"))
            return new Assistant(firstName, lastName);
        if (userName.equals("Teacher"))
            return new Teacher(firstName, lastName);
        return null;
    }
}
