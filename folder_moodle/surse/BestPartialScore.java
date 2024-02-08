import java.util.Collection;

public class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Student student = null;
        Double score = 0.0;
        for (Grade grade : grades) {
            if (grade.getPartialScore() > score) {
                score = grade.getPartialScore();
                student = grade.getStudent();
            }
        }
        return student;
    }
}

