import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        //testare user
        User student1= UserFactory.createUser("Student", "Alexandra", "Popescu");
        System.out.println("Student1: " + student1 + "\n");
        User student2 = UserFactory.createUser("Student", "Sebastian", "Lutan");
        User student3 = UserFactory.createUser("Student", "Radu", "Constantin");
        User student4 = UserFactory.createUser("Student", "Andra", "Vlad");
        User student5 = UserFactory.createUser("Student", "Andrei", "Petrea");
        User student6 = UserFactory.createUser("Student", "Marian", "Popi");

        User mother = UserFactory.createUser("Parent", "Ionela", "Popescu");
        User father = UserFactory.createUser("Parent", "Ionel", "Popescu");

        User teacher = UserFactory.createUser("Teacher", "Alexandru", "Chiriac");
        User assistant1 = UserFactory.createUser("Assistant", "Georgiana", "Stanculescu");
        User assistant2 = UserFactory.createUser("Assistant", "Georgian", "Stanculescu");
        User assistant3 = UserFactory.createUser("Assistant", "Georgica", "Stanculescu");
        User assistant4 = UserFactory.createUser("Assistant", "Georgi", "Stanculescu");
        User assistant5 = UserFactory.createUser("Assistant", "Geo", "Stanculescu");

        //testare metode student
        ((Student) student1).setMother((Parent) mother);
        ((Student) student2).setFather((Parent) father);
        ((Student) student3).setMother((Parent) mother);

        //testare grade
        Grade grade1 = new Grade(2.5d, 3d,(Student) student1,"POO");
        grade1.setCourse("SO");
        grade1.setPartialScore(4.0d);
        grade1.setExamScore(5.0d);
        grade1.setStudent((Student) student3);
        grade1.setCourse("POO");


        System.out.println("Grade - Course: " + grade1.getCourse());
        System.out.println("Grade - Partial Score: " + grade1.getPartialScore());
        System.out.println("Grade - Exam Score: " + grade1.getExamScore());
        System.out.println("Grade - Total Score: " + grade1.getTotal());
        System.out.println("Grade - Student: " + grade1.getStudent() + "\n");

        Grade grade2 = new Grade(3d, 4d,(Student) student2,"POO");
        Grade grade3 = new Grade(1d, 2d,(Student) student5,"POO");

        //testare group
        Group group1 = new Group("321CC", (Assistant) assistant1);
        group1.add((Student) student1);
        group1.add((Student) student2);

        Group group2 = new Group("322CC", (Assistant) assistant2);
        group2.add((Student) student3);
        group2.add((Student) student4);

        Group group3 = new Group("323CC", (Assistant) assistant3);
        group3.add((Student) student5);
        group3.add((Student) student6);

        System.out.println(group1);
        for(Student student: group1)
            System.out.println(student);
        System.out.println();

        //testare builder
        HashSet<Assistant> Assistants = new HashSet<>();
        Assistants.add((Assistant) assistant1);
        Assistants.add((Assistant) assistant2);

        HashMap<String, Group> Groups= new HashMap<>();
        Groups.put(group1.ID, group1);
        Groups.put(group2.ID, group2);

        ArrayList<Grade> Grades = new ArrayList<>();
        Grades.add(grade1);
        Grades.add(grade2);

        //fullCourse
        Course fullCourse = new FullCourse.FullCourseBuilder("SO").teacher((Teacher) teacher).assistants(Assistants).grades(Grades).groups(Groups).credits(3).strategy(new BestExamScore()).build();
        fullCourse.setName("POO");
        fullCourse.setTeacher(new Teacher());
        fullCourse.setAssistants(Assistants);
        fullCourse.setGrades(Grades);
        fullCourse.setGroups(Groups);
        fullCourse.setCredits(5);
        fullCourse.setStrategy(new BestPartialScore());
        System.out.println("FullCourse - Course: " + fullCourse.getName());
        System.out.println("FullCourse - Teacher: " + fullCourse.getTeacher());
        System.out.println("FullCourse - Assistants: " + fullCourse.getAssistants());
        System.out.println("FullCourse - Grades: " + fullCourse.getGrades());
        System.out.println("FullCourse - Groups: " + fullCourse.getGroups());
        System.out.println("FullCourse - Credits: " + fullCourse.getCredits());
        System.out.println("FullCourse - Strategy: " + fullCourse.getStrategy());
        System.out.println("FullCourse - Grade: " + fullCourse.getGrade((Student) student2));
        System.out.println("FullCourse - Best Student: " + fullCourse.getBestStudent() + "\n");

        //partialCourse
        Course partialCourse = new PartialCourse.PartialCourseBuilder("POO").teacher((Teacher) teacher).assistants(Assistants).grades(Grades).groups(Groups).credits(2).strategy(new BestExamScore()).build();
        System.out.println("PartialCourse - Course: " + partialCourse.getName());
        System.out.println("PartialCourse - Teacher: " + partialCourse.getTeacher());
        System.out.println("PartialCourse - Assistants: " + partialCourse.getAssistants());
        System.out.println("PartialCourse - Grades: " + partialCourse.getGrades());
        System.out.println("PartialCourse - Groups: " + partialCourse.getGroups());
        System.out.println("PartialCourse - Credits: " + partialCourse.getCredits());
        System.out.println("PartialCourse - Strategy: " + partialCourse.getStrategy());
        System.out.println("PartialCourse - Best Student: " + partialCourse.getBestStudent());

        //metode course
        partialCourse.addAssistant("321CC", (Assistant) assistant3);
        System.out.println("PartialCourse - Assistants: " + partialCourse.getAssistants() + "\n");
        partialCourse.addStudent("322CC", (Student) student5);
        System.out.println(group2);
        for(Student student: group2)
            System.out.println(student);
        System.out.println();
        partialCourse.addGroup(group3);
        partialCourse.addGroup("324CC",(Assistant) assistant4);
        Comparator<Student> comp = new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };
        partialCourse.addGroup("325CC", (Assistant) assistant5, comp);
        System.out.println("PartialCourse - Groups: " + partialCourse.getGroups());
        Group aux = Groups.get("325CC");
        aux.add((Student) student1);
        aux.add((Student) student3);
        aux.add((Student) student5);
        for (Student student : aux)
            System.out.println(student);
        System.out.println();
        partialCourse.addGrade(grade3);
        System.out.println("PartialCourse - Grades: " + partialCourse.getGrades());
        ArrayList<Student> students;
        students = partialCourse.getAllStudents();
        System.out.println("PartialCourse - All Students: " + students);
        HashMap<Student, Grade> all;
        all = partialCourse.getAllStudentGrades();
        System.out.println("PartialCourse - All Students Grades: " + all);
        ArrayList<Student> graduated;
        graduated = partialCourse.getGraduatedStudents();
        System.out.println("PartialCourse - All Graduated Students: " + graduated);
        graduated = fullCourse.getGraduatedStudents();
        System.out.println("FullCourse - All Graduated Students: " + graduated);
        System.out.println();
        //testare catalog
        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(fullCourse);
        catalog.removeCourse(fullCourse);
        catalog.addCourse(fullCourse);
        catalog.addObserver((Parent) mother);
        catalog.addObserver((Parent) father);
        System.out.println(catalog);
        catalog.notifyObservers(grade1);
        System.out.println(((Parent) mother).notifications);
        catalog.removeObserver((Parent) father);
        System.out.println(catalog);

        //testare visitor
        ScoreVisitor scoreVisitor = new ScoreVisitor();
        scoreVisitor.addExamScore(partialCourse.teacher, (Student) student3, "POO", 1d);
        partialCourse.teacher.accept(scoreVisitor);
        System.out.println(((Parent) mother).notifications);
    }
}
