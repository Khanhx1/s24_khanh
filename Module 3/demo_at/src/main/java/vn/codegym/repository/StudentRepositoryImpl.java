package vn.codegym.repository;

import vn.codegym.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 12/29/2023
 */
public class StudentRepositoryImpl implements IStudentRepository {

    private static final String SELECT_FROM_STUDENT = "select * from student";

    //JDBC
    @Override
    public List<Student> findAll() {
        Connection connection = DBConnection.getConnection(); //
        PreparedStatement statement = null; //nap lenhj sql
        ResultSet resultSet = null; //nhan ket qua tra ve
        List<Student> studentList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_FROM_STUDENT);
                resultSet = statement.executeQuery();

                Student student = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int gender = resultSet.getInt("gender");
                    int point = resultSet.getInt("point");
                    String image = resultSet.getString("image");

                    student = new Student(id, name, gender, point, image);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection(); //
        PreparedStatement statement = null; //nap lenhj sql

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into student(id, name, gender, point, image) " +
                        " value (?, ?, ?, ?, ?)");
                statement.setInt(1, student.getId());
                statement.setString(2, student.getName());
                statement.setInt(3, student.getGender());
                statement.setInt(4, student.getPoint());
                statement.setString(5, student.getImage());

                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }
}