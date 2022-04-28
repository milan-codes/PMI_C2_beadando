package view.submenu;

import controller.ExamController;
import model.Exam;
import view.MenuType;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.UtilFunctions.isValidDate;
import static utils.UtilFunctions.isValidTime;

public class ExamSubMenu extends BaseSubMenu<Exam> {
    private final ExamController controller = new ExamController();
    private ArrayList<Exam> exams;

    public ExamSubMenu() {
        this.exams = controller.getAll();
    }

    @Override
    public void onGetAll() {
        exams = controller.getAll();
        for (Exam exam : exams) {
            System.out.println(exam.getName());
        }
    }

    @Override
    public void onGetByName() {
        String target = getTargetName(MenuType.EXAM);
        Exam result = controller.getByName(target);
        if (result != null) {
            System.out.println("EXAM FOUND");
            System.out.println(result);
        } else {
            System.out.println("No exam found with name: " + target);
        }
    }

    @Override
    public void onCreate() {
        Exam userExam = getNewObj();
        controller.create(userExam);
        System.out.println("EXAM CREATED");
    }

    @Override
    public void onUpdate() {
        exams = controller.getAll();
        for (Exam exam : exams) {
            System.out.println(exam.getName());
        }
        String target = getTargetName(MenuType.EXAM);
        Exam examToEdit = controller.getByName(target);
        if (examToEdit != null) {
            System.out.println("EDITING EXAM " + examToEdit.getName());
            Exam editedExam = getNewObj();
            controller.update(examToEdit, editedExam);
        } else {
            System.out.println("No exam found with name: " + target);
        }
    }

    @Override
    public void onDelete() {
        exams = controller.getAll();
        for (Exam exam : exams) {
            System.out.println(exam.getName());
        }
        String target = getTargetName(MenuType.EXAM);
        Exam examToDelete = controller.getByName(target);
        if (examToDelete != null) {
            System.out.println("DELETING EXAM " + examToDelete.getName());
            controller.delete(examToDelete.getName());
        } else {
            System.out.println("No exam found with name: " + target);
        }
    }

    @Override
    protected Exam getNewObj() {
        Scanner scanner = new Scanner(System.in);
        Exam exam = new Exam();

        System.out.print("Enter exam name: ");
        exam.setName(scanner.nextLine());

        System.out.print("Enter exam description: ");
        exam.setDescription(scanner.nextLine());

        System.out.print("Enter exam classroom: ");
        exam.setClassroom(scanner.nextLine());

        int num = -1;
        do {
            System.out.print("Enter exam duration in minutes: ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Input must be an integer");
            }
            if (num < 0) {
                System.out.println("Duration must be positive");
            }
        } while (num < 0);
        exam.setDuration(String.valueOf(num));

        String date;
        do {
            System.out.print("Enter exam date in dd/MM/yyyy format: ");
            date = scanner.nextLine();
            if (!isValidDate(date)) {
                System.out.println("Invalid date format");
            }
        } while(!isValidDate(date));
        exam.setDate(date);

        String time;
        do {
            System.out.print("Enter exam time in HH:mm format: ");
            time = scanner.nextLine();

            if (!isValidTime(time)) {
                System.out.println("Invalid time");
            }
        } while (!isValidTime(time));
        exam.setTime(time);

        return exam;
    }
}
