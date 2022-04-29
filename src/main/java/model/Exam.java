package model;

public class Exam {
    /**
     * The name of the exam.
     */
    private String name;
    /**
     * The description of the exam.
     */
    private String description;
    /**
     * The classroom in which the exam will be held.
     */
    private String classroom;
    /**
     * The duration of the exam.
     */
    private String duration;
    /**
     * The date of the exam.
     */
    private String date;
    /**
     * The time of the exam.
     */
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

    /**
     * Static class to create an exam without exposing the creation logic
     */
    public static class ExamFactory implements Factory<Exam> {
        public Exam factory() {
            return new Exam();
        }
    }
}
