# JAVA-files-JUnit
Continue Developing the Application from the Previous Assignment

## Non-functional Requirements
- The requirements defined in Assignment A2 remain unchanged.
  
## Requirements for the Next Lab
- Implement new repository classes for storing domain entities. These must be derived from the generic in-memory Repository implementation created in Assignment A2.
- One of these repository classes should store entities in a text file (e.g., TextFileRepository).
- The other should store entities in a binary file (e.g., BinaryFileRepository), using Java's object serialization mechanism.
- Each domain entity should have its own repository instance.
- The program must be able to start using any of these repository implementations, while the upper layers of the application (services, user interface) should remain independent of the repository implementation used.
- The choice of repository type and the file storage location (for file-based implementations) should be configured using a settings file (e.g., settings.properties). This file should be read by the program using the Java Properties class. See the example below:
  
  ``Repository = binary``\
  ``Patients = “patients.bin”``\
  ``Appointments = “appointments.bin”``
  
- The user interface must allow CRUD operations (Create, Read, Update, Delete) for all domain entities.
- Errors occurring during application usage (e.g., duplicate IDs, file saving/loading errors, data validation errors) should be handled using Java's exception mechanism, with a custom Java exception hierarchy (e.g., classes such as `RepositoryException`, `DuplicateIDException`, `ObjectNotFoundException`).

## Unit Testing Requirements
- Implement unit tests using JUnit.
- The test coverage must be above 90%, except for user interface classes.
  
## Bonus (0.1p) – JSON Repository
- Implement an additional repository type that allows saving entities in JSON format.
  
## Bonus (0.1p) – XML Repository
- Implement an additional repository type that allows saving entities in XML format.
