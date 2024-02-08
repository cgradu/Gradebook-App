import java.util.*;

public class PartialCourse extends Course {
    public PartialCourse(PartialCourseBuilder builder){
        super.name = builder.name;
        super.teacher = builder.teacher;
        super.assistants = builder.assistants;
        super.grades = builder.grades;
        super.groups = builder.groups;
        super.credits = builder.credits;
        super.strategy = builder.strategy;
    }
    @Override
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> stud = new ArrayList<>();
        for(Grade grade : grades) {
            if (grade != null && grade.getTotal() >= 5d)
                stud.add(grade.getStudent());
        }
            return stud;
    }
    @Override
    public Student getBestStudent() {
        return super.strategy.getBestStudent(super.grades);
    }

    static class PartialCourseBuilder extends CourseBuilder{
        public PartialCourseBuilder(String name) {
            super(name);
        }

        @Override
        public PartialCourseBuilder teacher(Teacher teacher) {
            super.teacher(teacher);
            return this;
        }

        @Override
        public PartialCourseBuilder assistants(HashSet<Assistant> assistants) {
            super.assistants(assistants);
            return this;
        }

        @Override
        public PartialCourseBuilder grades(ArrayList<Grade> grades) {
            super.grades(grades);
            return this;
        }

        @Override
        public PartialCourseBuilder groups(HashMap<String, Group> groups) {
            super.groups(groups);
            return this;
        }
        @Override
        public PartialCourseBuilder credits(Integer credits) {
            super.credits(credits);
            return this;
        }
        @Override
        public PartialCourseBuilder strategy(Strategy strategy) {
            super.strategy(strategy);
            return this;
        }

        public PartialCourse build(){
            return new PartialCourse(this);
        }
    }
}