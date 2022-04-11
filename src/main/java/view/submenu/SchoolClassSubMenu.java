package view.submenu;

import controller.SchoolClassController;
import model.SchoolClass;
import view.MenuType;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolClassSubMenu extends BaseSubMenu<SchoolClass> {
    private final SchoolClassController controller = new SchoolClassController();
    private ArrayList<SchoolClass> classes;

    public SchoolClassSubMenu() {
        this.classes = controller.getAll();
    }

    @Override
    public void onGetAll() {
        classes = controller.getAll();
        for (SchoolClass schoolClass : classes) {
            System.out.println(schoolClass.getName());
        }
    }

    @Override
    public void onGetByName() {
        String target = getTargetName(MenuType.CLASS);
        SchoolClass result = controller.getByName(target);
        if (result != null) {
            System.out.println("CLASS FOUND");
            System.out.println(result);
        } else {
            System.out.println("No class found with name: " + target);
        }
    }

    @Override
    public void onCreate() {
        SchoolClass userClass = getNewObj();
        controller.create(userClass);
        System.out.println("CLASS CREATED");
    }

    @Override
    public void onUpdate() {
        classes = controller.getAll();
        for (SchoolClass schoolClass : classes) {
            System.out.println(schoolClass.getName());
        }
        String target = getTargetName(MenuType.CLASS);
        SchoolClass classToEdit = controller.getByName(target);
        if (classToEdit != null) {
            System.out.println("EDITING CLASS " + classToEdit.getName());
            SchoolClass editedClass = getNewObj();
            controller.update(classToEdit, editedClass);
        } else {
            System.out.println("No class found with name: " + target);
        }
    }

    @Override
    public void onDelete() {
        classes = controller.getAll();
        for (SchoolClass schoolClass : classes) {
            System.out.println(schoolClass.getName());
        }
        String target = getTargetName(MenuType.CLASS);
        SchoolClass classToDelete = controller.getByName(target);
        if (classToDelete != null) {
            System.out.println("DELETING CLASS " + classToDelete.getName());
            controller.delete(classToDelete.getName());
        } else {
            System.out.println("No class found with name: " + target);
        }
    }

    @Override
    SchoolClass getNewObj() {
        Scanner scanner = new Scanner(System.in);
        SchoolClass schoolClass = new SchoolClass();

        System.out.print("Enter class name: ");
        schoolClass.setName(scanner.nextLine());

        System.out.print("Enter class teacher: ");
        schoolClass.setTeacher(scanner.nextLine());

        System.out.print("Enter class room: ");
        schoolClass.setClassroom(scanner.nextLine());

        System.out.print("Enter a day on which the class is held: ");
        schoolClass.setDay(scanner.nextLine());

        System.out.print("Enter the time on which the class starts: ");
        schoolClass.setTime(scanner.nextLine());

        return schoolClass;
    }
}
