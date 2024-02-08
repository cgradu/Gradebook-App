import java.util.*;

public class ScoreVisitor implements Visitor{
    HashMap<Teacher, ArrayList<Triple<Student, String, Double>>> examScores;
    HashMap<Assistant, ArrayList<Triple<Student, String, Double>>> partialScores;
    //partialCourse.teacher.accept(scoreVisitor);
    private class Triple<A,B,C>{
       A student;
       B course;
       C grade;
       public Triple(A student, B course, C grade){
           this.student = student;
           this.course = course;
           this.grade = grade;
       }

        public A getStudent() {
            return student;
        }

        public void setStudent(A student) {
            this.student = student;
        }

        public B getCourse() {
            return course;
        }

        public void setCourse(B course) {
            this.course = course;
        }

        public C getGrade() {
            return grade;
        }

        public void setGrade(C grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Triple{" +
                    "student=" + student +
                    ", course=" + course +
                    ", grade=" + grade +
                    '}';
        }
    }

    public HashMap<Teacher, ArrayList<Triple<Student, String, Double>>> getExamScores() {
        return examScores;
    }

    public HashMap<Assistant, ArrayList<Triple<Student, String, Double>>> getPartialScores() {
        return partialScores;
    }

    public void setExamScores(HashMap<Teacher, ArrayList<Triple<Student, String, Double>>> examScores) {
        this.examScores = examScores;
    }

    public void setPartialScores(HashMap<Assistant, ArrayList<Triple<Student, String, Double>>> partialScores) {
        this.partialScores = partialScores;
    }

    public void addExamScore(Teacher teacher, Student student, String course, Double grade){
        if(this.examScores == null)
            this.examScores = new HashMap<>();
        if(!this.examScores.containsKey(teacher)){
            this.examScores.put(teacher, new ArrayList<>());
        }
        this.examScores.get(teacher).add(new Triple<>(student, course, grade));
    }

    public void addPartialScore(Assistant assistant, Student student, String course, Double grade){
        if(this.partialScores == null)
            this.partialScores = new HashMap<>();
        if(!this.partialScores.containsKey(assistant)){
            this.partialScores.put(assistant, new ArrayList<>());
        }
        this.partialScores.get(assistant).add(new Triple<>(student, course, grade));
    }

    public void visit(Assistant assistant){
        List<Triple<Student, String, Double>> tuples = partialScores.get(assistant);
        for(Triple<Student, String, Double> tuple : tuples){
            for(Course course : Catalog.getInstance().getCourses()){
                if(course.getName().equals(tuple.getCourse())) {
                    int ok = 0;
                    for (Grade g : course.grades) {
                        Student s = tuple.getStudent();
                        if (s.equals(g.getStudent())) {
                            ok = 1;
                            g.setPartialScore(tuple.getGrade());
                            Catalog.getInstance().notifyObservers(g);
                        }
                    }
                    if (ok == 0) {
                        Grade newGrade = new Grade(tuple.getGrade(), 0.0, tuple.getStudent(), course.name);
                        course.addGrade(newGrade);
                        Catalog.getInstance().notifyObservers(newGrade);
                    }
                }
            }
        }
    }

    public void visit(Teacher titular) {
        List<Triple<Student, String, Double>> tuples = examScores.get(titular);
        for (Triple<Student, String, Double> tuple : tuples) {
            Course course = Catalog.getInstance().getCourse(tuple.getCourse());
            int ok = 0;
            for (Grade g : course.grades) {
                Student s = tuple.getStudent();
                if (s.equals(g.getStudent())) {
                    ok = 1;
                    g.setPartialScore(tuple.getGrade());
                    Catalog.getInstance().notifyObservers(g);
                }
            }
            if (ok == 0) {
                Grade newGrade = new Grade(0.0,tuple.getGrade(), tuple.getStudent(), course.name);
                course.addGrade(newGrade);
                Catalog.getInstance().notifyObservers(newGrade);
            }
        }
    }
}
