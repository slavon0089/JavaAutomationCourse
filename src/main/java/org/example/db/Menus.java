package org.example.db;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    public static void menu() {
        System.out.println("Welcome to our university");
        System.out.println("-------------------------");
        System.out.println("1 - students");
        System.out.println("2 - groups");
        System.out.println("3 - universities");
        System.out.println("0 - Quit");
    }

    public static void studentsMenu() {
        System.out.println("work with Students");
        System.out.println("-------------------------");
        System.out.println("1 - check all students");
        System.out.println("2 - add a few random students");
        System.out.println("3 - add a student");
        System.out.println("4 - delete student");
        System.out.println("5 - delete all students");
        System.out.println("6 - find best students");
        System.out.println("7 - find some students");
        System.out.println("8 - total students");
        System.out.println("0 - Back");
    }

    public static void groupMenu() {
        System.out.println("work with groups");
        System.out.println("-------------------------");
        System.out.println("1 - check all groups");
        System.out.println("2 - add a few random groups");
        System.out.println("3 - add a group");
        System.out.println("4 - find some group");
        System.out.println("0 - Back");
    }

    public static void UniversityMenu() {
        System.out.println("work with university");
        System.out.println("-------------------------");
        System.out.println("1 - check all universities");
        System.out.println("2 - add a few random universities");
        System.out.println("3 - add a university");
        System.out.println("4 - find some university");
        System.out.println("5 - Edit university name");
        System.out.println("0 - Back");
    }

    public static int inputMenu() {
        Scanner input = new Scanner(System.in);
        int selection = -1;
        try {
            selection = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("only numbers are available to enter");

        }
        return selection;
    }
}
