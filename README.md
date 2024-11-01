# Gradebook App

The Gradebook App is an electronic gradebook designed for object-oriented programming courses. It integrates various design patterns and focuses on comprehensive testing.

## Architecture Overview

### `Catalog` Class
- **Singleton Design Pattern**: Ensures a single instance of the catalog is used throughout the application, which is crucial for maintaining a consistent and centralized state of courses and observer lists.
- **Observer Pattern**: Manages notifications efficiently, automating the process of informing parents about their child's grades without requiring manual updates.

### `User` Class Hierarchy
- **Abstract Base**: Serves as a foundation for user types, promoting code reuse and reducing redundancy.

#### Specific User Types
- **Student**: Key player in the Observer pattern, linking grade notifications directly to parents, demonstrating a practical application of this pattern in educational settings.
- **Parent**: Benefits from the Observer pattern by automatically receiving updates, improving communication and engagement in the educational process.
- **Teacher** & **Assistant**: Facilitate dynamic grading strategies via the Visitor pattern, allowing for flexible grade assessment methods.

### `UserFactory`
- Simplifies the process of creating user objects, reducing the complexity of instantiations and making the code more maintainable.

### `Grade` Class
- Provides essential functionalities like grade calculation and comparison, showcasing the importance of encapsulating grade logic within a single, cohesive class.

### `Group` Class
- Represents a collection of students, highlighting the need for organizing students into manageable groups for educational purposes.

### `Course` Class Hierarchy
- **Strategy Pattern**: Allows the application to switch between different course management strategies dynamically, reflecting real-world scenarios where course requirements might change.

## Design Patterns Explained

- **Observer Pattern**: Vital for maintaining a low-coupling, high-cohesion design by allowing subjects and observers to interact without being tightly bound.
- **Strategy Pattern**: Offers flexibility in how courses are managed, accommodating various teaching methods and assessment strategies without altering the system's core architecture.
- **Visitor Pattern**: Enables specific actions (like grade modifications) to be performed on elements of an object structure, making the system more adaptable and easier to extend with new functionalities.

This architecture facilitates a flexible and scalable gradebook system, incorporating best practices in object-oriented design and design patterns.

merge
