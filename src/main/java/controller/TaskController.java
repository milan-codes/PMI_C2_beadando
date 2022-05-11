package controller;

import model.Task;
import utils.XMLReader;
import utils.XMLWriter;

import java.util.ArrayList;

public class TaskController extends BaseController<Task> {
    private ArrayList<Task> tasks;

    public TaskController() {
        tasks = new ArrayList<>();
    }

    private void updateTasksList() {
        XMLReader<Task> reader = new XMLReader<>("src/main/resources/tasks.xml", new Task.TaskFactory());
        reader.read();
        tasks = reader.getList();
    }

    private void saveTasksList() {
        XMLWriter<Task> writer = new XMLWriter<>("src/main/resources/tasks.xml", new Task.TaskFactory(), tasks);
        writer.write();
    }

    @Override
    public ArrayList<Task> getAll() {
        updateTasksList();
        return tasks;
    }

    @Override
    public Task getByName(String name) {
        updateTasksList();
        return tasks.stream().filter(task -> task.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Task create(Task newObj) {
        tasks.add(newObj);
        saveTasksList();
        return newObj;
    }

    @Override
    public Task update(Task oldObj, Task newObj) {
        updateTasksList();
        tasks.removeIf(task -> task.getName().equals(oldObj.getName()));
        tasks.add(newObj);
        saveTasksList();

        return newObj;
    }

    @Override
    public void delete(String name) {
        updateTasksList();
        tasks.removeIf(task -> task.getName().equals(name));
        saveTasksList();
    }
}
