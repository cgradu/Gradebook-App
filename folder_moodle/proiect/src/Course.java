import java.util.*;

public abstract class Course {
    String name;
    Teacher teacher;
    HashSet<Assistant> assistants;
    ArrayList<Grade> grades;
    HashMap<String, Group> groups;
    Integer credits;
    Strategy strategy;

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public HashSet<Assistant> getAssistants() {
        return assistants;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public Integer getCredits() {
        return credits;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public void setGroups(HashMap<String, Group> groups) {
        this.groups = groups;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void addAssistant(String ID, Assistant assistant){
        if(!assistants.contains(assistant))
            assistants.add(assistant);
        Set<Map.Entry<String, Group> > entries = groups.entrySet();
        for(Map.Entry<String, Group> entry : entries){
            if(entry.getValue().ID.equals(ID))
                entry.getValue().assistant = assistant;
        }
    }

    public void addStudent(String ID, Student student){
        Set<Map.Entry<String, Group> > entries = groups.entrySet();
        for(Map.Entry<String, Group> entry : entries){
            if(entry.getValue().ID.equals(ID)) {
                if(!entry.getValue().contains(student))
                    entry.getValue().add(student);
            }
        }
    }

    public void addGroup(Group group){
        String ID = group.ID;
        groups.put(ID, group);
    }

    public void addGroup(String ID, Assistant assistant){
        Group aux = new Group(ID, assistant);
        groups.put(ID, aux);
    }

    public void addGroup(String ID, Assistant assistant, Comparator<Student> comp){
        Group aux = new Group(ID, assistant, comp);
        groups.put(ID, aux);
    }

    public Grade getGrade(Student student){
        for(Grade aux: grades){
            if(aux.getStudent().equals(student))
                return aux;
        }
        return null;
    }

    public void addGrade(Grade grade){
        if(!grades.contains(grade))
            grades.add(grade);
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> all = new ArrayList<>();
        Set<Map.Entry<String, Group> > entries = groups.entrySet();
        for(Map.Entry<String, Group> entry : entries){
            for(int i = 0 ; i < entry.getValue().size(); i++) {
                Student student = entry.getValue().get(i);
                if(!all.contains(student))
                    all.add(student);
            }
        }
        return all;
    }

    public HashMap<Student, Grade> getAllStudentGrades(){
        HashMap<Student, Grade> all = new HashMap<>();
        for(Grade grade : grades) {
            if (grade != null)
                all.put(grade.getStudent(), grade);
        }
        return all;
    }
    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }
    public abstract ArrayList<Student> getGraduatedStudents();

    @Override
    public String toString() {
        return name + " " + teacher.toString();
    }

    abstract static class CourseBuilder{
        String name;
        Teacher teacher;
        HashSet<Assistant> assistants;
        ArrayList<Grade> grades;
        HashMap<String, Group> groups;
        Integer credits;
        Strategy strategy;

        public CourseBuilder(String name) {
            this.name = name;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistants(HashSet<Assistant> assistants) {
            this.assistants = assistants;
            return this;
        }

        public CourseBuilder grades(ArrayList<Grade> grades) {
            this.grades = grades;
            return this;
        }

        public CourseBuilder groups(HashMap<String, Group> groups) {
            this.groups = groups;
            return this;
        }

        public CourseBuilder credits(Integer credits) {
            this.credits = credits;
            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

    }
}
