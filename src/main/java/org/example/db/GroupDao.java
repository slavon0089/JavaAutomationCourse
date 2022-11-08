package org.example.db;

import org.example.db.Connection.Connection;
import org.example.db.entities.Dao;
import org.example.db.entities.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupDao implements Dao<Group> {

    @Override
    public Group get(int group_id) {
        String sql = "SELECT * FROM GROUPS ";
        Group group = null;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, group_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                group = new Group(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getInt(3));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("exception during the statement execution");
        }
        Connection.close();


        return group;
    }

    @Override
    public Group get(int student_id, String student_name) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        List<Group> groups = new ArrayList<>();

        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groups");

            while (resultSet.next()) {
                groups.add(new Group(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getInt(3)));

            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
        if (groups.size()==0){
            System.out.println("No groups in the list");
        }
        return groups;
    }



    public void addGroup() {

        System.out.println("Add group name");
        Scanner input = new Scanner(System.in);
        String groupName = input.nextLine();

        System.out.println("Add university ID");
        Scanner input2 = new Scanner(System.in);
        int university_ID = input2.nextInt();


        String sql = "INSERT INTO groups ( group_name, university_id) VALUES (?, ?);";
        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1,groupName);
            statement.setInt(2, university_ID);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
    }

    @Override
    public void add() {
        try (Statement statement = Connection.getConnection().createStatement()) {
            statement.executeUpdate("INSERT INTO groups ( group_name, university_id) VALUES ('BSU Group', 1);");
            statement.executeUpdate("INSERT INTO groups ( group_name, university_id) VALUES ('BSUT GomelUni Grup', 2);");
            statement.executeUpdate("INSERT INTO groups ( group_name, university_id) VALUES ('BSUIR Group', 3);");
            statement.executeUpdate("INSERT INTO groups ( group_name, university_id) VALUES ('BNTU Group', 4);");
            statement.executeUpdate("INSERT INTO groups ( group_name, university_id) VALUES ('VSTU VitUni1', 5);");
            statement.executeUpdate("INSERT INTO groups ( group_name, university_id) VALUES ('SU GomelUni1', 5);");

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();
    }

    public List<Group> findSomeGroups() {
        List<Group> foundGroups = new ArrayList<>();

        System.out.println("Add IDs to find the group in the format '(1,2,3,4...)'");
        Scanner input = new Scanner(System.in);
        String list = input.nextLine();

        try (Statement statement = Connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groups WHERE group_id in "+ list+";");

            while (resultSet.next()) {
                foundGroups.add(new Group(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getInt(3)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during the statement execution");
        }
        Connection.close();

        return foundGroups;
    }

}
