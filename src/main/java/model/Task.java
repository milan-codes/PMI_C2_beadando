package model;

public class Task {
    private String name;
    private String description;
    private String dueDate;
    private String status;

    public Task() {
    }

    public Task(String name, String description, String dueDate, String status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String setDueDate(String dueDate) {
        return this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        return this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Due Date: ").append(dueDate).append("\n");
        sb.append("Status: ").append(status).append("\n");
        return sb.toString();
    }

    public static class TaskFactory implements Factory<Task> {
        public Task factory() {
            return new Task();
        }
    }
}
