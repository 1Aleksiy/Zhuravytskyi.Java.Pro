package com.hillel.zhuravytskyi.homeworks.homework22;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Приклад використання LessonDao

        // Створюємо об'єкт LessonDao
        LessonDao lessonDao = new LessonDao();

        // Створюємо об'єкти Homework і Lesson
        Homework homework1 = new Homework();
        homework1.setId(1);
        homework1.setName("Homework 1");
        homework1.setDescription("Description for Homework 1");

        Lesson lesson1 = new Lesson();
        lesson1.setId(1);
        lesson1.setName("Lesson 1");
        lesson1.setHomework(homework1);

        // Додаємо урок у базу даних
        lessonDao.addLesson(lesson1);

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

        // Видаляємо урок за ID
        lessonDao.deleteLesson(1);

        // Повторно отримуємо всі уроки
        List<Lesson> updatedLessons = lessonDao.getAllLessons();
        System.out.println("\nУсі уроки після видалення:");
        for (Lesson lesson : updatedLessons) {
            System.out.println(lesson);
        }
    }
}
