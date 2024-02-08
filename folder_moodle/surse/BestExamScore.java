import java.util.Collection;

public class BestExamScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Student student = null;
        Double score = 0.0;
        for (Grade grade : grades) {
            if (grade.getExamScore() > score) {
                score = grade.getExamScore();
                student = grade.getStudent();
            }
        }
        return student;
    }
}
