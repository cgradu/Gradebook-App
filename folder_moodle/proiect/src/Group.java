import java.security.Key;
import java.util.*;

public class Group extends ArrayList<Student> {
    String ID;
    Assistant assistant;

    public Group(String ID, Assistant assistant, Comparator<Student> comp){
        super();
        super.sort(comp);
        this.ID = ID;
        this.assistant = assistant;
    }

    public Group(String ID, Assistant assistant){
        super();
        this.ID = ID;
        this.assistant = assistant;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "; Assistant: " + assistant;
    }
}
