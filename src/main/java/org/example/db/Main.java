package org.example.db;

import static org.example.db.Menus.*;

public class Main {

    public static void main(String[] args) {
        menuRun();
    }

    public static void menuRun() {
        StudentDao studentDao = new StudentDao();
        GroupDao groupDao = new GroupDao();
        UniDao uniDao = new UniDao();

        int choice = -1;
        while (choice != 0) {
            menu();
            choice = inputMenu();
            switch (choice) {
                case 1:
                    int stMenu = -1;
                    while (stMenu != 0) {
                        studentsMenu();
                        stMenu = inputMenu();
                        switch (stMenu) {
                            case 1:
                                studentDao.getAll().stream().forEach(System.out::println);
                                break;
                            case 2:
                                studentDao.add();
                                System.out.println("list of students added");
                                break;
                            case 3:
                                studentDao.addStudent();
                                break;
                            case 4:
                                studentDao.deleteStudent();
                                break;
                            case 5:
                                studentDao.deleteAllStudents();
                                break;
                            case 6:
                                studentDao.findMaxMarkStudents().stream().forEach(System.out::println);
                                break;
                            case 7:
                                studentDao.findSomeStudents().stream().forEach(System.out::println);
                                break;
                            case 8:
                                studentDao.totalStudents();
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    int grMenu = -1;
                    while (grMenu != 0) {
                        groupMenu();
                        grMenu = inputMenu();
                        switch (grMenu) {
                            case 1:
                                groupDao.getAll().stream().forEach(System.out::println);
                                break;
                            case 2:
                                groupDao.add();
                                System.out.println("list of groups added");
                                break;
                            case 3:
                                groupDao.addGroup();
                                break;
                            case 4:
                                groupDao.findSomeGroups().stream().forEach(System.out::println);
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }

                    }
                    break;
                case 3:
                    int uniMenu = -1;
                    while (uniMenu != 0) {
                        UniversityMenu();
                        uniMenu = inputMenu();
                        switch (uniMenu) {
                            case 1:
                                uniDao.getAll().stream().forEach(System.out::println);
                                break;
                            case 2:
                                uniDao.add();
                                System.out.println("list of universities added");
                                break;
                            case 3:
                                uniDao.addUniversity();
                                break;
                            case 4:
                                uniDao.findSomeUniversities().stream().forEach(System.out::println);
                                break;
                            case 5:
                                uniDao.updateUniversity();
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
                default:
                    break;
            }
        }
    }
}
