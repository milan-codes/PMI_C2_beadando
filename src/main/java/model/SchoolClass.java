package model;

public class SchoolClass {
    /**
     * The name of the class.
     */
    private String name;
    /**
     * The teacher of the class.
     */
    private String teacher;
    /**
     * The room in which the class is held.
     */
    private String classroom;
    /**
     * The day of the week the class is held.
     */
    private String day;
    /**
     * The time of the class.
     */
    private String time;

    public SchoolClass() {
    }

    public SchoolClass(String name, String teacher, String classRoom, String day, String time) {
        this.name = name;
        this.teacher = teacher;
        this.classroom = classRoom;
        this.day = day;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Teacher: ").append(teacher).append("\n");
        sb.append("Classroom: ").append(classroom).append("\n");
        sb.append("Day: ").append(day).append("\n");
        sb.append("Time: ").append(time).append("\n");
        return sb.toString();
    }

    /**
     * Static class to create a school class without exposing the creation logic
     */
    public static class SchoolClassFactory implements Factory<SchoolClass> {
        public SchoolClass factory() {
            return new SchoolClass();
        }
    }
}
