package com.hillel.zhuravytskyi.homeworks.homework22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    public void addLesson(Lesson lesson) {
        String query = "INSERT INTO Lesson (name, updatedAt, homework_id) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setString(2, lesson.getUpdatedAt());
            preparedStatement.setInt(3, lesson.getHomework().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLesson(int lessonId) {
        String query = "DELETE FROM Lesson WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, lessonId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT * FROM Lesson";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getInt("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setUpdatedAt(resultSet.getString("updatedAt"));
                int homeworkId = resultSet.getInt("homework_id");
                Homework homework = getHomeworkById(homeworkId);
                lesson.setHomework(homework);
                lessons.add(lesson);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public Lesson getLessonById(int lessonId) {
        Lesson lesson = null;
        String query = "SELECT * FROM Lesson WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, lessonId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                lesson = new Lesson();
                lesson.setId(resultSet.getInt("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setUpdatedAt(resultSet.getString("updatedAt"));
                int homeworkId = resultSet.getInt("homework_id");
                Homework homework = getHomeworkById(homeworkId);
                lesson.setHomework(homework);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesson;
    }

    private Homework getHomeworkById(int homeworkId) {
        Homework homework = null;
        String query = "SELECT * FROM Homework WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, homeworkId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                homework = new Homework();
                homework.setId(resultSet.getInt("id"));
                homework.setName(resultSet.getString("name"));
                homework.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homework;
    }
}
