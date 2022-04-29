# PMI-C2-beadando

Final project for one of my university courses.
The purpose of this project is to give users a way to keep track of their classes, tasks & exams
and therefore make them more productive. This project does not have a GUI, users have to use the console.

## Table of contents
- [Project architecture](#project-architecture)
- [XML architecture](#xml-architecture)
- [Data models](#data-models)
  - [SchoolClass](#schoolclass)
  - [Exam](#exam)
  - [Task](#task)
- [Usage](#usage)
- [Notes](#notes)

## Project architecture
The project contains four packages in the source directory and the entry point `Main.java`. The packages are: `model`, `view`, `controller` and `utils`.
- `model` contains the classes that handle data logic
- `view` contains the classes that display the information from the model to the user
- `controller` contains the classes that represent the logic behind the application, controls data flow and updates views when data changes
- `utils` contains a class that has some utility functions

## XML architecture
The project creates three xml files to store data. These are:
- `classes.xml`: stores classes
- `exams.xml`: stores exams
- `tasks.xml`: stores tasks

The architecture of these files is as follows:
1. ``classes.xml``
```xml
<schoolclass-root> <!-- root element -->
    <schoolclass> <!-- root of individual objects -->
        <Name>Name of the class</Name>
        <Time>Time of the class</Time>
        <Day>The day on which the class is held</Day>
        <Teacher>Teacher of the class</Teacher>
        <Classroom>The classroom in which the class is held</Classroom>
    </schoolclass>
</schoolclass-root>
```
2. ``exams.xml``
```xml
<exam-root> <!-- root element -->
    <exam> <!-- root of individual objects -->
        <Name>Name of the exam</Name>
        <Time>Time of the exam</Time>
        <Description>Description of the exam</Description>
        <Duration>Duration of the exam in minutes</Duration>
        <Classroom>The classroom in which the exam will be held</Classroom>
        <Date>Date of the exam in dd/MM/yyyy format</Date>
    </exam>
</exam-root>
```
3. ``tasks.xml``
```xml
<task-root> <!-- root element -->
    <task> <!-- root of individual objects -->
        <Name>Name of the task</Name>
        <Status>Status of the task</Status>
        <Description>Description of the task</Description>
        <DueDate>Due date of the task in dd/MM/yyyy format</DueDate>
    </task>
</task-root>
```

## Data models
The following section describes the attributes of data models.

### SchoolClass
- `name`: The name of the class
- `teacher`: The teacher of the class
- `classroom`: The classroom in which the class is held
- `day`: The day on which the class is held
- `time`: The time of the class

### Exam
- `name`: The name of the exam
- `description`: The description of the exam
- `classroom`: The classroom in which the exam will be held
- `duration`: The duration of the exam in minutes
- `date`: The date of the exam in dd/MM/yyyy format
- `time`: The time of the exam

### Task
- `name`: The name of the task
- `description`: The description of the task
- `dueDate`: The due date of the task in dd/MM/yyyy format
- `status`: The status of the task

## Usage
The entry point of the application is `Main.java`. After running the `Main` class, users are greeted with a menu:
```
Hello, Friend!
MANAGE MAIN
-------------------------
<1> Manage classes
<2> Manage tasks
<3> Manage exams
<4> Exit program
-------------------------
Enter your choice: 
```

- `MANAGE MAIN` is the header of the menu. It displays the type of data that the user is currently working with, or `MAIN` when in the main menu.
- This is followed by a list of options users will have to choose from. In order to select one of the options users should enter its number.
Let's say the user wants to manage classes. After they press `<1>` a submenu will be printed. The menu will look like this:
```
MANAGE CLASS
-------------------------
<1> Show all
<2> Get by name
<3> Add
<4> Edit
<5> Remove
<6> Go back
-------------------------
Enter your choice: 
```
The options are:
1. `Show all`: Prints only the names of all saved classes.
2. `Get by name`: Asks for a name, and then searches for a class with that name. If found, it prints all available information about that particular class. If a class with that name is not found, it prints an error message.
3. `Add`: Prints a form to the user, and then saves the class with the retrieved information to the database.
4. `Edit`: Prints the name of the saved classes. Users then will have to enter the name of the class they want to edit. After that the flow is the same as option `<3>`.
5. `Remove`: Prints the name of the saved classes. Users then will have to enter the name of the class they want to remove.
6. `Go back`: Returns to the main menu.

The same applies when working with exams and tasks.

## Notes
- Minimum JDK: 14
- Documentation of what each method, in a specific class, does can be found inside the files.