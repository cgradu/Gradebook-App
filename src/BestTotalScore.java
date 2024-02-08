import java.util.Collection;

public class BestTotalScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Student student = null;
        Double score = 0.0;
        for (Grade grade : grades) {
            if (grade.getTotal() > score) {
                score = grade.getTotal();
                student = grade.getStudent();
            }
        }
        return student;
    }
}
