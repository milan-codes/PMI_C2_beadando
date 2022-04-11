package model;

public class Exam {
    private String name;
    private String description;
    private String classroom;
    private String duration;
    private String date;
    private String time;

    public Exam() {
    }

    public Exam(String name, String description, String classroom, String duration, String date, String time) {
        this.name = name;
        this.description = description;
        this.classroom = classroom;
        this.duration = duration;
        this.date = date;
        this.time = time;
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

    public String getClassroom() {
        return classroom;
    }

    public String setClassroom(String classroom) {
        return this.classroom = classroom;
    }

    public String getDuration() {
        return duration;
    }

    public String setDuration(String duration) {
        return this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public String setDate(String date) {
        return this.date = date;
    }

    public String getTime() {
        return time;
    }

    public String setTime(String time) {
        return this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Classroom: ").append(classroom).append("\n");
        sb.append("Duration: ").append(duration).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Time: ").append(time).append("\n");

        return sb.toString();
    }

    public static class ExamFactory implements Factory<Exam> {
        public Exam factory() {
            return new Exam();
        }
    }
}
