import view.Menu;
import view.MenuType;
import view.submenu.ExamSubMenu;
import view.submenu.SchoolClassSubMenu;
import view.submenu.TaskSubMenu;

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
                    handleTasks();
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

    static void handleTasks() {
        TaskSubMenu taskSubMenu = new TaskSubMenu();
        do {
            int tasksMenu = menu.show(MenuType.TASK);
            switch (tasksMenu) {
                case 1:
                    taskSubMenu.onGetAll();
                    break;
                case 2:
                    taskSubMenu.onGetByName();
                    break;
                case 3:
                    taskSubMenu.onCreate();
                    break;
                case 4:
                    taskSubMenu.onUpdate();
                    break;
                case 5:
                    taskSubMenu.onDelete();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid input");
            }
        } while (true);
    }

    static void handleExams() {
        ExamSubMenu examSubMenu = new ExamSubMenu();
        do {
            int examsMenu = menu.show(MenuType.EXAM);
            switch (examsMenu) {
                case 1:
                    examSubMenu.onGetAll();
                    break;
                case 2:
                    examSubMenu.onGetByName();
                    break;
                case 3:
                    examSubMenu.onCreate();
                    break;
                case 4:
                    examSubMenu.onUpdate();
                    break;
                case 5:
                    examSubMenu.onDelete();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid input");
            }
        } while (true);
    }
}
