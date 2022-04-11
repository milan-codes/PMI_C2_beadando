package view.submenu;

import controller.ExamController;
import model.Exam;
import view.MenuType;

import java.util.ArrayList;
import java.util.Scanner;

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
    Exam getNewObj() {
        Scanner scanner = new Scanner(System.in);
        Exam exam = new Exam();

        System.out.print("Enter exam name: ");
        exam.setName(scanner.nextLine());

        System.out.print("Enter exam description: ");
        exam.setDescription(scanner.nextLine());

        System.out.print("Enter exam classroom: ");
        exam.setClassroom(scanner.nextLine());

        System.out.print("Enter exam duration: ");
        exam.setDuration(scanner.nextLine());

        System.out.print("Enter exam date: ");
        exam.setDate(scanner.nextLine());

        System.out.print("Enter exam time: ");
        exam.setTime(scanner.nextLine());

        return exam;
    }
}
