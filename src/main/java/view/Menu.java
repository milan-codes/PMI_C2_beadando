package view;

import java.util.Scanner;

/**
 * This class is the main menu of the program.
 * The class is singleton to ensure that only one instance is created during runtime.
 */
public class Menu {

    private static Menu instance = null;
    private final Scanner scanner = new Scanner(System.in);

    private final String[] mainMenuText = {"<1> Manage classes", "<2> Manage tasks", "<3> Manage exams", "<4> Exit program"};
    private final String[] subMenuText = {"<1> Show all", "<2> Add", "<3> Edit", "<4> Remove", "<5> Go back"};

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
        System.out.printf("MANAGE %s\n", type.name());
        System.out.println("-------------------------");
        if(type != MenuType.MAIN) {
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
        return scanner.nextInt();
    }
}
