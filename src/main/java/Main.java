import menu.Menu;
import menu.MenuType;

public class Main {
    private static final Menu menu = Menu.getInstance();

    public static void main(String[] args) {
        do {
            int mainMenu = menu.show(MenuType.MAIN);
            switch (mainMenu) {
                case 1: handleClasses(); break;
                case 2: handleAssignments(); break;
                case 3: handleExams(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid input");
            }
        } while(true);
    }

    static void handleClasses() {
        do {
            int classesMenu = menu.show(MenuType.CLASS);
            switch (classesMenu) {
                case 1:
                    System.out.println("TODO: Show all classes"); break;
                case 2:
                    System.out.println("TODO: Add class"); break;
                case 3:
                    System.out.println("TODO: Edit class"); break;
                case 4:
                    System.out.println("TODO: Remove class"); break;
                case 5: return;
                default: System.out.println("Invalid input");
            }
        } while(true);

    }
    static void handleAssignments() {
        do {
            int assignmentsMenu = menu.show(MenuType.ASSIGNMENT);
            switch (assignmentsMenu) {
                case 1:
                    System.out.println("TODO: Show all assignments"); break;
                case 2:
                    System.out.println("TODO: Add assignment"); break;
                case 3:
                    System.out.println("TODO: Edit assignment"); break;
                case 4:
                    System.out.println("TODO: Remove assignment"); break;
                case 5: return;
                default: System.out.println("Invalid input");
            }
        } while(true);
    }
    static void handleExams() {
        do {
            int examsMenu = menu.show(MenuType.EXAM);
            switch (examsMenu) {
                case 1:
                    System.out.println("TODO: Show all exams"); break;
                case 2:
                    System.out.println("TODO: Add exam"); break;
                case 3:
                    System.out.println("TODO: Edit exam"); break;
                case 4:
                    System.out.println("TODO: Remove exam"); break;
                case 5: return;
                default: System.out.println("Invalid input");
            }
        } while(true);
    }
}
