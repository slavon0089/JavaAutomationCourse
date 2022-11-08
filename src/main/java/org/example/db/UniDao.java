package org.example.db;

import org.example.db.Connection.Connection;
import org.example.db.entities.Dao;
import org.example.db.entities.University;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniDao implements Dao<University> {

    @Override
    public University get(int university_id) {
        String sql = "SELECT * FROM UNIVERSITY ";
        University university = null;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, university_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                university = new University(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim());
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("exception during the statement execution");
        }
        Connection.close();


        return university;
    }

    @Override
    public University get(int student_id, String student_name) {
        return null;
    }

    @Override
    public List<University> getAll() {
        List<University> universities = new ArrayList<>();

        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM university");

            while (resultSet.next()) {
                universities.add(new University(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim()));

            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
        if (universities.size()==0){
            System.out.println("No universities in the list");
        }
        return universities;
    }


    public void addUniversity() {
        String sql = "INSERT INTO university (uni_name, address) VALUES (?, ?);";

        System.out.println("Add university name");
        Scanner input = new Scanner(System.in);
        String uniName = input.nextLine();

        System.out.println("Add university address");
        Scanner input2 = new Scanner(System.in);
        String uniAddress = input2.nextLine();


        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, uniName);
            statement.setString(2, uniAddress);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
    }

    public void updateUniversity() {
        System.out.println("choose university by id");
        Scanner input2 = new Scanner(System.in);
        int id = input2.nextInt();

        System.out.println("Change university name");
        Scanner input = new Scanner(System.in);
        String uniName = input.nextLine();


        try (Statement statement = Connection.getConnection().createStatement()) {
            String sql = "UPDATE university SET uni_name = '" + uniName + "' WHERE university_id = " + id;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
    }


    @Override
    public void add() {
        try (Statement statement = Connection.getConnection().createStatement()) {
            statement.executeUpdate("INSERT INTO university (uni_name, address) VALUES ( 'Belarusian State University', 'K. Marksa, 31');");
            statement.executeUpdate("INSERT INTO university (uni_name, address) VALUES ( 'Belarusian State University of Transport', 'Kirova, 34');");
            statement.executeUpdate("INSERT INTO university (uni_name, address) VALUES ( 'Belarusian State University of Informatics and Radioelectronics', 'P. Brovki, 6');");
            statement.executeUpdate("INSERT INTO university (uni_name, address) VALUES ( 'Belarusian National Technological University', 'Nezavisimosti, 65');");
            statement.executeUpdate("INSERT INTO university (uni_name, address) VALUES ( 'Vitebsk State Technological University', 'Moskovskiy Avenue, 72');");
            statement.executeUpdate("INSERT INTO university (uni_name, address) VALUES ( 'Gomel State University after F Skorina', 'Kirova, 119');");

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
    }

    public List<University> findSomeUniversities() {
        List<University> foundUniversities = new ArrayList<>();

        System.out.println("Add university name or part name");
        Scanner input = new Scanner(System.in);
        String list = input.nextLine();


        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM UNIVERSITY WHERE uni_name like  '%" + list + "%';");

            while (resultSet.next()) {
                foundUniversities.add(new University(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim()));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();

        return foundUniversities;
    }

}
