import java.util.*;

public class FullCourse extends Course {
    public FullCourse(FullCourseBuilder builder){
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
            if (grade != null && grade.getExamScore() >= 2d && grade.getPartialScore() >= 3)
                stud.add(grade.getStudent());
        }
        return stud;
    }
    @Override
    public Student getBestStudent() {
        return super.strategy.getBestStudent(super.grades);
    }

    static class FullCourseBuilder extends CourseBuilder{
        public FullCourseBuilder(String name) {
            super(name);
        }

        @Override
        public FullCourseBuilder teacher(Teacher teacher) {
            super.teacher(teacher);
            return this;
        }

        @Override
        public FullCourseBuilder assistants(HashSet<Assistant> assistants) {
            super.assistants(assistants);
            return this;
        }

        @Override
        public FullCourseBuilder grades(ArrayList<Grade> grades) {
            super.grades(grades);
            return this;
        }

        @Override
        public FullCourseBuilder groups(HashMap<String, Group> groups) {
            super.groups(groups);
            return this;
        }

        @Override
        public FullCourseBuilder credits(Integer credits) {
            super.credits(credits);
            return this;
        }

        @Override
        public FullCourseBuilder strategy(Strategy strategy) {
            super.strategy(strategy);
            return this;
        }

        public FullCourse build(){
            return new FullCourse(this);
        }
    }
}
