package model;

import java.util.UUID;

public class SchoolClass {
    private final UUID id = UUID.randomUUID();
    private String name;
    private String teacher;
    private String classroom;
    private String day;
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

    public UUID getId() {
        return id;
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

    public static class SchoolClassFactory implements Factory<SchoolClass> {
        public SchoolClass factory() {
            return new SchoolClass();
        }
    }
}
