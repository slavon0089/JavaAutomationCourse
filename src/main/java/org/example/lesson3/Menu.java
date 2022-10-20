package org.example.lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.lesson3.Collection.*;
import static org.example.lesson3.Segregation.segregationFromFile;
import static org.example.lesson3.Segregation.segregationToFile;

public class Menu {
    public static void menu() {
        System.out.println("Choose your options");
        System.out.println("-------------------------");
        System.out.println("1 - Save a new object to a file");
        System.out.println("2 - read all the objects from file and show them in console");
        System.out.println("3 - Add new object to collection");
        System.out.println("4 - Remove an object from collection");
        System.out.println("5 - Read all objects from collection");
        System.out.println("6 - Update an object in the collection");
        System.out.println("0 - Quit");
    }
    public static int inputMenu() {
        Scanner input = new Scanner(System.in);
        int selection = -1;
        try {
            selection = input.nextInt();
            if (selection < 0 || selection > 6) {
                throw new MenuException();
            }
        } catch (MenuException e) {
            System.out.println("incorrect enter, please choose correct number");
        } catch (InputMismatchException e) {
            System.out.println("only numbers are available to enter");

        }
        return selection;
    }
    public static void menuRun() throws MenuException {
        int choice = -1;
        while (choice != 0) {
            menu();
            choice = inputMenu();
            switch (choice) {
                case 1:
                    segregationToFile();
                    break;
                case 2:
                    segregationFromFile();
                    break;
                case 3:
                    addNewAnimalToCollection();
                    break;
                case 4:
                    deleteAnimal();
                    break;
                case 5:
                    readAllAnimals();
                    break;
                case 6:
                    changeAnimal();
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
