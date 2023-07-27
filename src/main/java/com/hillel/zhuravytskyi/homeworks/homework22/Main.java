package com.hillel.zhuravytskyi.homeworks.homework22;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LessonDao lessonDao = new LessonDao();

        Homework homework1 = new Homework(1, "Homework 1", "Description for Homework 1");
        Lesson lesson1 = new Lesson(1, "Lesson 1", "2023-07-20", homework1);


        lessonDao.save(lesson1);
        List<Lesson> lessons = lessonDao.getAllLessons();
        System.out.println("Усі уроки:");
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }

        Lesson lessonById = lessonDao.getLessonById(1);
        System.out.println("\nУрок за ID 1:");
        System.out.println(lessonById);

        lesson1.setName("Lesson 1 - Updated");
        lessonDao.save(lesson1);
        List<Lesson> updatedLessons = lessonDao.getAllLessons();
        System.out.println("\nУсі уроки після оновлення:");
        for (Lesson lesson : updatedLessons) {
            System.out.println(lesson);
        }
        lessonDao.updateLesson(1);
        List<Lesson> lessonsAfterDeletion = lessonDao.getAllLessons();
        System.out.println("\nУсі уроки після видалення:");
        for (Lesson lesson : lessonsAfterDeletion) {
            System.out.println(lesson);
        }
    }
}
