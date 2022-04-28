package view.submenu;

import controller.SchoolClassController;
import model.SchoolClass;
import view.MenuType;

import java.util.ArrayList;
import java.util.Scanner;
import static utils.UtilFunctions.isValidDay;
import static utils.UtilFunctions.isValidTime;

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
    protected SchoolClass getNewObj() {
        Scanner scanner = new Scanner(System.in);
        SchoolClass schoolClass = new SchoolClass();

        System.out.print("Enter class name: ");
        schoolClass.setName(scanner.nextLine());

        System.out.print("Enter class teacher: ");
        schoolClass.setTeacher(scanner.nextLine());

        System.out.print("Enter class room: ");
        schoolClass.setClassroom(scanner.nextLine());

        String day;
        do {
            System.out.print("Enter a day on which the class is held: ");
            day = scanner.nextLine();

            if (!isValidDay(day)) {
                System.out.println("Invalid day");
            }
        } while (!isValidDay(day));
        schoolClass.setDay(day);

        String time;
        do {
            System.out.print("Enter the time on which the class starts in HH:mm format: ");
            time = scanner.nextLine();

            if (!isValidTime(time)) {
                System.out.println("Invalid time");
            }
        } while (!isValidTime(time));
        schoolClass.setTime(time);

        return schoolClass;
    }
}
