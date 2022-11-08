package org.example.db;

import org.example.db.Connection.Connection;
import org.example.db.entities.Dao;
import org.example.db.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDao implements Dao<Student> {

    @Override
    public Student get(int student_id) {
        String sql = "SELECT * FROM STUDENT ";
        Student student = null;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, student_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("exception during the statement execution");
        }
        Connection.close();


        return student;
    }

    @Override
    public Student get(int student_id, String student_name) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();

        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)));
            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }

        Connection.close();

        if (students.size()==0){
            System.out.println("No students in the list");
        }
        return students;
    }


    public void addStudent() {
        System.out.println("Add student name");
        Scanner input = new Scanner(System.in);
        String studentName = input.nextLine();

        System.out.println("Add birthdate in format '1990-07-18' ");
        Scanner input1 = new Scanner(System.in);
        String birthdate = input1.nextLine();

        System.out.println("Add average mark of student");
        Scanner input2 = new Scanner(System.in);
        Double averageMark = input2.nextDouble();

        System.out.println("Add group ID (from 1 to 6)");
        Scanner input3 = new Scanner(System.in);
        int groupID = input3.nextInt();

        System.out.println("Add payment bonus");
        Scanner input4 = new Scanner(System.in);
        int bonus = input4.nextInt();

        String sql = "INSERT INTO students (student_name, birthday, averagemark, group_id, bonus) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, studentName);
            statement.setDate(2, Date.valueOf(birthdate));
            statement.setDouble(3, averageMark);
            statement.setDouble(4, groupID);
            statement.setInt(5, bonus);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution1");
        }
        Connection.close();

    }

    @Override
    public void add() {
        try (Statement statement = Connection.getConnection().createStatement()) {
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('BLAZEJ', CAST(N'1990-09-10' AS Date),  5,   5, 5);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('JUS%TIN', CAST(N'1988-04-21' AS Date), 4,   1, 500);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('DOMINIC', CAST(N'1987-10-11' AS Date), 4.3, 2, 100);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('OTTO', CAST(N'1990-07-12' AS Date),    3.8, 3, 50);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('JAMES', CAST(N'1983-04-19' AS Date),   3.1, 4, 500);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('NORMAN', CAST(N'1983-11-22' AS Date),  3,   5, 100);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('ALEX', CAST(N'1984-04-19' AS Date),    4.1, 6, 100);");
            statement.executeUpdate("INSERT INTO students ( student_name, birthday, averagemark, group_id, bonus) VALUES ('BILL', CAST(N'1985-01-24' AS Date),    4.3, 4, 500);");


        } catch (SQLException e) {
            System.out.println("Exception during the statement execution1");
        }
        Connection.close();
    }

    public void deleteStudent() {

        System.out.println("Choose student ID");
        Scanner input = new Scanner(System.in);
        int stID = input.nextInt();

        try (Statement statement = Connection.getConnection().createStatement()) {
            String sql = "DELETE FROM students WHERE student_id =" + stID;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();

        System.out.printf("Student with id %d is has been deleted", stID);
    }

    public void deleteAllStudents() {
        try (Statement statement = Connection.getConnection().createStatement()) {
            String sql = "DELETE FROM students";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();

        System.out.println("All students ahs been deletes");
    }

    public List<Student> findMaxMarkStudents() {
        List<Student> bestStudents = new ArrayList<>();

        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM students WHERE averagemark = (SELECT MAX (averagemark) FROM students)");

            while (resultSet.next()) {
                bestStudents.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();

        if(bestStudents.size()==0){
            System.out.println("student didn't found");
        }

        return bestStudents;
    }

    public List<Student> findSomeStudents() {
        List<Student> foundStudents = new ArrayList<>();

        System.out.println("lowest mark for searching");
        Scanner input = new Scanner(System.in);
        double lowMark = input.nextDouble();

        System.out.println("highest mark for searching");
        Scanner input1 = new Scanner(System.in);
        double highMark = input1.nextDouble();


        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS WHERE averagemark BETWEEN " + lowMark + " AND " + highMark + " ;");

            while (resultSet.next()) {
                foundStudents.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
        if(foundStudents.size()==0){
            System.out.println("student didn't found");
        }
        return foundStudents;
    }

    public int totalStudents() {

        int sum = 0;
        try (Statement statement = Connection.getConnection().createStatement()) {

            ResultSet totalStudents = statement.executeQuery("SELECT count(*)   FROM students");
            totalStudents.next();
            sum = totalStudents.getInt(1);
            totalStudents.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection.close();
        System.out.println("total students = " + sum);
        return sum;
    }

}
