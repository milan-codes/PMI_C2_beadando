package view;

import model.SchoolClass;

import java.util.Scanner;

/**
 * This class is the main menu of the program.
 * The class is singleton to ensure that only one instance is created during runtime.
 */
public class Menu {

    private static Menu instance = null;
    private final Scanner scanner = new Scanner(System.in);

    private final String[] mainMenuText = {"<1> Manage classes", "<2> Manage tasks", "<3> Manage exams", "<4> Exit program"};
    private final String[] subMenuText = {"<1> Show all", "<2> Get by name", "<3> Add", "<4> Edit", "<5> Remove", "<6> Go back"};

    private Menu() {
        printGreeting();
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    private void printGreeting() {
        System.out.println("Hello, Friend!");
    }

    public int show(MenuType type) {
        int result = -1;
        System.out.printf("MANAGE %s\n", type.name());
        System.out.println("-------------------------");
        if (type != MenuType.MAIN) {
            for (String subMenuItem : subMenuText) {
                System.out.println(subMenuItem);
            }
        } else {
            for (String mainMenuItem : mainMenuText) {
                System.out.println(mainMenuItem);
            }
        }
        System.out.println("-------------------------");
        System.out.print("Enter your choice: ");
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
        }
        scanner.nextLine();
        return result;
    }

    public String getTargetName(MenuType type) {
        System.out.printf("Enter a %s name: ", type.name());
        return scanner.nextLine();
    }

    public SchoolClass getSchoolClass() {
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
