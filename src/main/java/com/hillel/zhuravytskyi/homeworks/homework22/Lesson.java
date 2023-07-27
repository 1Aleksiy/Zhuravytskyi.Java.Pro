package com.hillel.zhuravytskyi.homeworks.homework22;

public class Lesson {
    private final int id;
    private final String name;
    private final String updatedAt;
    private final Homework homework;

    public Lesson(int id, String name, String updatedAt, Homework homework) {
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
    public Homework getHomework() {
        return homework;
    }

    public void setName(String s) {

    }
}

