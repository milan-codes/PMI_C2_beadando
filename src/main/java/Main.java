import view.Menu;
import view.MenuType;
import view.submenu.SchoolClassSubMenu;

public class Main {
    private static final Menu menu = Menu.getInstance();

    public static void main(String[] args) {
        do {
            int mainMenu = menu.show(MenuType.MAIN);
            switch (mainMenu) {
                case 1:
                    handleClasses();
                    break;
                case 2:
                    handleAssignments();
                    break;
                case 3:
                    handleExams();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        } while (true);
    }

    static void handleClasses() {
        SchoolClassSubMenu schoolClassSubMenu = new SchoolClassSubMenu();
        do {
            int classesMenu = menu.show(MenuType.CLASS);
            switch (classesMenu) {
                case 1:
                    schoolClassSubMenu.onGetAll();
                    break;
                case 2:
                    schoolClassSubMenu.onGetByName();
                    break;
                case 3:
                    schoolClassSubMenu.onCreate();
                    break;
                case 4:
                    schoolClassSubMenu.onUpdate();
                    break;
                case 5:
                    schoolClassSubMenu.onDelete();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid input");
            }
        } while (true);

    }

    static void handleAssignments() {
        do {
            int assignmentsMenu = menu.show(MenuType.ASSIGNMENT);
            switch (assignmentsMenu) {
                case 1:
                    System.out.println("TODO: Show all assignments");
                    break;
                case 2:
                    System.out.println("TODO: Add assignment");
                    break;
                case 3:
                    System.out.println("TODO: Edit assignment");
                    break;
                case 4:
                    System.out.println("TODO: Remove assignment");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid input");
            }
        } while (true);
    }

    static void handleExams() {
        do {
            int examsMenu = menu.show(MenuType.EXAM);
            switch (examsMenu) {
                case 1:
                    System.out.println("TODO: Show all exams");
                    break;
                case 2:
                    System.out.println("TODO: Add exam");
                    break;
                case 3:
                    System.out.println("TODO: Edit exam");
                    break;
                case 4:
                    System.out.println("TODO: Remove exam");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid input");
            }
        } while (true);
    }
}
