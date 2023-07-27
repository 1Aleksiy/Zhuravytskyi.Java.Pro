package com.hillel.zhuravytskyi.homeworks.homework22;

public class Lesson {
    private int id;
    private String name;
    private String updatedAt;
    private Homework homework;

    public Lesson(int id, String name, String updatedAt, Homework homework) {
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
        this.homework = homework;
    }

    public Lesson() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", homework=" + homework +
                '}';
    }
}
