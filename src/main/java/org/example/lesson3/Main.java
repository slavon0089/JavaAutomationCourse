package org.example.lesson3;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Cat cat = new Cat(1, "Barsik");
    static Dog dog = new Dog(2, "Boss");
    static Bear bear = new Bear("big", 300, "Potapich");
    static Fox fox = new Fox("small", 20, "Kitty");
    Cat.Pedigree pedigree = cat.new Pedigree("Boss", "1st place", "Boss->Max->Chrome");

    public static void main(String[] args) {
        menuRun();

    }

    public static void segregationToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(".\\src\\main\\resources\\object.txt"))) {
            out.writeObject(dog);
            out.writeObject(cat);
            out.writeObject(bear);
            out.writeObject(fox);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void segregationFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\src\\main\\resources\\object.txt"))) {
            Dog newDog = (Dog) in.readObject();
            Cat newCat = (Cat) in.readObject();
            Bear newBear = (Bear) in.readObject();
            Fox newFox = (Fox) in.readObject();
            System.out.println(newDog);
            System.out.println(newCat);
            System.out.println(newBear);
            System.out.println(newFox);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void menuRun() throws MenuException {
        int choice = -1;
        while (choice != 3) {
            choice = menu();
            switch (choice) {
                case 1:
                    segregationToFile();
                    break;
                case 2:
                    segregationFromFile();
                    break;
                case 3:
                    System.out.println("Bye");
                    break;
                default:
                    break;

            }

        }
    }

    public static int menu() {
        int selection = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your options");
        System.out.println("-------------------------");
        System.out.println("1 - Save a new object to a file");
        System.out.println("2 - read all the objects from file and show them in console");
        System.out.println("3 - Quit");
        try {
            selection = input.nextInt();
                if(selection<1 ||selection>3){
                   throw new MenuException();
                }
        } catch (MenuException e) {
            System.out.println("incorrect enter, please choose correct number");
        } catch (InputMismatchException e){
            System.out.println("only numbers are available to enter");
        }
        return selection;
    }
}
