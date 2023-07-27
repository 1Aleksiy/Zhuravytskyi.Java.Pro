package com.hillel.zhuravytskyi.homeworks.homework22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class LessonDao {

        public void save(Lesson lesson) {
            if (lesson.getId() == 0) {
                insertLesson(lesson);
            } else {
                updateLesson(lesson);
            }
        }

        private void insertLesson(Lesson lesson) {
            String query = "INSERT INTO Lesson (name, homework_id) VALUES (?, ?)";
            try (Connection connection = DataBaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, lesson.getName());
                preparedStatement.setInt(2, lesson.getHomework().getId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateLesson(Lesson lesson) {
            String query = "UPDATE Lesson SET name=?, homework_id=? WHERE id=?";
            try (Connection connection = DataBaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, lesson.getName());
                preparedStatement.setInt(2, lesson.getHomework().getId());
                preparedStatement.setInt(3, lesson.getId());
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
                    Lesson lesson = createLessonFromResultSet(resultSet);
                    lessons.add(lesson);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return lessons;
        }

        public Lesson getLessonById(int lessonId) {
            String query = "SELECT * FROM Lesson WHERE id = ?";
            try (Connection connection = DataBaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setInt(1, lessonId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return createLessonFromResultSet(resultSet);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Lesson createLessonFromResultSet(ResultSet resultSet) throws SQLException {
            int lessonId = resultSet.getInt("id");
            String lessonName = resultSet.getString("name");
            String updatedAt = resultSet.getString("updatedAt");
            int homeworkId = resultSet.getInt("homework_id");
            Optional<Homework> homework = getHomeworkById(homeworkId);

            return new Lesson(lessonId, lessonName, updatedAt, homework.orElse(null));
        }

        private Optional<Homework> getHomeworkById(int homeworkId) {
            String query = "SELECT * FROM Homework WHERE id = ?";
            try (Connection connection = DataBaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setInt(1, homeworkId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Homework homework = new Homework(1, "Homework 1", "Description for Homework 1");
                    homework.setId(resultSet.getInt("id"));
                    homework.setName(resultSet.getString("name"));
                    homework.setDescription(resultSet.getString("description"));
                    return Optional.of(homework);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }

    public void updateLesson(int i) {

    }
}
