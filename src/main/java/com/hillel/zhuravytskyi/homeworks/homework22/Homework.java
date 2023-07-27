package com.hillel.zhuravytskyi.homeworks.homework22;

public class Homework {
    private final int id;
    private final String name;
    private final String description;

    public Homework(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {

    }

    public void setName(String name) {

    }

    public void setDescription(String description) {


    }
}
