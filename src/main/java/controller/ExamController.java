package controller;

import model.Exam;
import utils.XMLReader;
import utils.XMLWriter;

import java.util.ArrayList;

public class ExamController extends BaseController<Exam> {
    private ArrayList<Exam> exams;

    public ExamController() {
        updateExamsList();
    }

    private void updateExamsList() {
        XMLReader<Exam> reader = new XMLReader<>("src/main/resources/exams.xml", new Exam.ExamFactory());
        reader.read();
        exams = reader.getList();
    }

    private void saveExamsList() {
        XMLWriter<Exam> writer = new XMLWriter<>("src/main/resources/exams.xml", new Exam.ExamFactory(), exams);
        writer.write();
    }

    @Override
    public ArrayList<Exam> getAll() {
        updateExamsList();
        return exams;
    }

    @Override
    public Exam getByName(String name) {
        updateExamsList();
        return exams.stream().filter(exam -> exam.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Exam create(Exam newObj) {
        exams.add(newObj);
        saveExamsList();
        return newObj;
    }

    @Override
    public Exam update(Exam oldObj, Exam newObj) {
        updateExamsList();
        exams.removeIf(exam -> exam.getName().equals(oldObj.getName()));
        exams.add(newObj);
        saveExamsList();

        return newObj;
    }

    @Override
    public void delete(String name) {
        updateExamsList();
        exams.removeIf(exam -> exam.getName().equals(name));
        saveExamsList();
    }
}
