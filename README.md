# Gradebook App

The Gradebook App is an electronic gradebook designed for object-oriented programming courses. It integrates various design patterns and focuses on comprehensive testing.

## Architecture Overview

### `Catalog` Class
- **Singleton Design Pattern**: Ensures a single instance of the catalog.
- **Observer Pattern**: Manages a list of observers (parents notified upon their child's grading) and a list of courses.
- **Functionality**: Methods for adding/removing courses, observers, and accessing the singleton instance.

### `User` Class Hierarchy
- **Abstract Base**: Defines common attributes for all users (students, parents, teachers, assistants).
- **Inheritance**: Creates specific user types through subclasses.

#### Specific User Types
- **Student**: Implements Observer pattern, holds parent references for notifications.
- **Parent**: Receives grade notifications for their children.
- **Teacher** & **Assistant**: Implements Visitor pattern, allowing grade modifications.

### `UserFactory`
- Simplifies instantiation of User subclasses based on type.

### `Grade` Class
- Holds partial and final exam grades, course name, and the associated student.
- Supports grade comparisons, cloning, and total grade calculations.

### `Group` Class
- Represents a list of students, with group ID and assigned assistant.

### `Course` Class Hierarchy
- **Abstract Base**: For full and partial courses.
- **Design Patterns**: Strategy for course management.

## Design Patterns Explained

- **Observer Pattern**: Manages notifications for grade changes.
- **Strategy Pattern**: Allows dynamic changes in course management strategies.
- **Visitor Pattern**: Enables modifications by teachers and assistants through visiting.

This architecture facilitates a flexible and scalable gradebook system, incorporating best practices in object-oriented design and design patterns.

