import java.util.*;

public class Catalog implements Subject {
    private static Catalog single_instance = null;
    private ArrayList<Course> courses;
    private ArrayList<Observer> observers;


    private Catalog(){
        this.courses = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if (single_instance == null)
            single_instance = new Catalog();
        return single_instance;
    }

    public void addCourse(Course course){
        if(!courses.contains(course))
            courses.add(course);
    }

    public void removeCourse(Course course){
            courses.remove(course);
    }

    @Override
    public void addObserver(Observer observer) {
        if(!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (Observer observer : observers) {
            if (grade.getStudent().isParent(observer)) {
                observer.update(new Notification("Fiul tau / Fiica ta a luat nota " + grade.getTotal() + " la materia " + grade.getCourse()));
            }
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "courses=" + courses +
                ", observers=" + observers +
                '}';
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String course) {
        for (Course aux : courses)
            if (aux.name.equals(course))
                return aux;
        return null;
    }
}