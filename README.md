# Gradebook-App
An electronic gradebook for an Object-Oriented Programming course, featuring core classes such as `Catalog` and `Course`, along with design patterns including Observer, Singleton, Factory Method, and comprehensive testing.

## Project Architecture:

### 1. Catalog Class
- This is a singleton class that also implements the Observer design pattern.
- Contains a list of observers (parents who will be notified when their children receive grades) and a list of courses within the catalog.
- Key methods include adding and retrieving courses, adding and retrieving observers, and retrieving the singleton instance of the catalog.

### 2. User Class
- An abstract class containing two strings, `firstName` and `lastName`.
- Used as a base class for four types of users (subclasses): `Student`, `Parent`, `Teacher`, and `Assistant`.

#### Student
- Contributes to the Observer pattern implementation.
- Minimal implementation with a constructor for name and two additional fields, `mother` and `father`, representing the student's parents who will be notified when the student receives grades.
- Methods include setters (to set the student’s mother and father) and a method to verify if a given observer is a parent of the student.

#### Parent
- Contributes to the Observer pattern implementation.
- Has a list of notifications that parents will receive when their children (students) get grades.
- Includes a constructor and an `update` method, which displays the grade received by the student.

#### Teacher
- Contributes to the Visitor pattern implementation.
- Methods include a constructor and `visit` to allow the course's lead teacher to modify grades.

#### Assistant
- Also contributes to the Visitor pattern.
- Methods include a constructor and `visit` to allow any assistant of the course's lead teacher to modify grades.

- Additionally, the `UserFactory` class simplifies the instantiation of these four types of `User` classes. It has a method that takes a string with the class name and creates a `User` of that type using the first and last names provided as parameters.

### 3. Grade Class
- Contains four fields: `midtermGrade`, `examGrade`, `courseName` (the name of the course for which the grade is assigned), and `student` (the student to whom the grade is assigned).
- Methods include `getTotal` (summing midterm and exam grades), getters and setters for field values, `toString`, `compareTo` (to compare two grades based on their total score), and `clone` (creates a `Grade` object with the same fields and values).

### 4. Group Class
- Extends a list of students.
- Contains two fields: `ID` (the group name) and `assistant` (the assistant assigned to that group).
- Methods include constructors and `toString`.

### 5. Course Class
- An abstract class with two subclasses: `FullCourse` and `PartialCourse`.
- Contributes to the Strategy design pattern.
- (Additional details of fields and methods can be added here.)

### 6. Observer Pattern
- Implements the Observer pattern to notify parents when their children receive grades.

### 7. Strategy Pattern
- Implements the Strategy pattern to provide flexible grading and course management.

### 8. Visitor Pattern
- Implements the Visitor pattern to allow course teachers and assistants to modify grades for students.

This project is built to demonstrate Object-Oriented Programming principles through practical applications in course and student management, allowing parents to stay updated on students’ performance and ensuring structured, maintainable code.
