package view.submenu;

import controller.TaskController;
import model.Task;
import view.MenuType;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.UtilFunctions.isValidDate;

public class TaskSubMenu extends BaseSubMenu<Task> {
    private final TaskController controller = new TaskController();
    private ArrayList<Task> tasks;

    public TaskSubMenu() {
        this.tasks = controller.getAll();
    }

    @Override
    public void onGetAll() {
        printTasks();
    }

    @Override
    public void onGetByName() {
        String target = getTargetName(MenuType.TASK);
        Task result = controller.getByName(target);
        if (result != null) {
            System.out.println("TASK FOUND");
            System.out.println(result);
        } else {
            System.out.println("No task found with name: " + target);
        }
    }

    @Override
    public void onCreate() {
        Task newTask = getNewObj();
        controller.create(newTask);
        System.out.println("TASK CREATED");
    }

    @Override
    public void onUpdate() {
        printTasks();
        String target = getTargetName(MenuType.TASK);
        Task taskToEdit = controller.getByName(target);
        if (taskToEdit != null) {
            System.out.println("EDITING TASK: " + taskToEdit.getName());
            Task editedTask = getNewObj();
            controller.update(taskToEdit, editedTask);
        } else {
            System.out.println("No task found with name: " + target);
        }
    }

    @Override
    public void onDelete() {
        printTasks();
        String target = getTargetName(MenuType.TASK);
        Task taskToDelete = controller.getByName(target);
        if (taskToDelete != null) {
            System.out.println("DELETING TASK: " + taskToDelete.getName());
            controller.delete(taskToDelete.getName());
        } else {
            System.out.println("No task found with name: " + target);
        }
    }

    @Override
    protected Task getNewObj() {
        Scanner scanner = new Scanner(System.in);
        Task task = new Task();

        System.out.print("Enter task name:");
        task.setName(scanner.nextLine());

        System.out.print("Enter task description:");
        task.setDescription(scanner.nextLine());

        String date;
        do {
            System.out.print("Enter task due date in dd/MM/yyyy format: ");
            date = scanner.nextLine();
            if (!isValidDate(date)) {
                System.out.println("Invalid date format");
            }
        } while(!isValidDate(date));
        task.setDueDate(date);

        System.out.print("Enter task status:");
        task.setStatus(scanner.nextLine());

        return task;
    }

    private void printTasks() {
        tasks = controller.getAll();
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }
}
