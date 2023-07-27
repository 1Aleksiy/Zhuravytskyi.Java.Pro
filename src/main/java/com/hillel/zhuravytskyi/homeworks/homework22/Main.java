package com.hillel.zhuravytskyi.homeworks.homework22;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LessonDao lessonDao = new LessonDao();

        Homework homework1 = new Homework(1, "Homework 1", "Description for Homework 1");
        Lesson lesson1 = new Lesson(1, "Lesson 1", "2023-07-20", homework1);


        lessonDao.save(lesson1);

        // Отримуємо всі уроки
        List<Lesson> lessons = lessonDao.getAllLessons();
        System.out.println("Усі уроки:");
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }

        // Отримуємо урок за ID
        Lesson lessonById = lessonDao.getLessonById(1);
        System.out.println("\nУрок за ID 1:");
        System.out.println(lessonById);

        // Змінюємо дані уроку
        lesson1.setName("Lesson 1 - Updated");
        lessonDao.save(lesson1);

        // Повторно отримуємо всі уроки
        List<Lesson> updatedLessons = lessonDao.getAllLessons();
        System.out.println("\nУсі уроки після оновлення:");
        for (Lesson lesson : updatedLessons) {
            System.out.println(lesson);
        }

        // Видаляємо урок за ID
        lessonDao.updateLesson(1);

        // Повторно отримуємо всі уроки після видалення
        List<Lesson> lessonsAfterDeletion = lessonDao.getAllLessons();
        System.out.println("\nУсі уроки після видалення:");
        for (Lesson lesson : lessonsAfterDeletion) {
            System.out.println(lesson);
        }
    }
}
