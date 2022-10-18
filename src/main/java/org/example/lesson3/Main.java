package org.example.lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    static ArrayList<Animals> animals = new ArrayList<Animals>();

    public static void main(String[] args) {
        menuRun();
    }

    public static void segregationToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(".\\src\\main\\resources\\object.txt"))) {
            out.writeObject(new Dog(2, "Boss"));
            out.writeObject(new Cat(1, "Barsik"));
            out.writeObject(new Bear("big", 300, "Potapich"));
            out.writeObject(new Fox("small", 20, "Kitty"));

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

    public static void addNewObjectToCollection() {
        System.out.println("Add new object to collection (Cat, Dog, Bear or Fox)");
        Scanner input = new Scanner(System.in);
        String animalType = input.nextLine();
        System.out.println("Add name for your animal");
        String name = input.nextLine();
        System.out.println("Add weight for your animal");
        int weight = input.nextInt();
        System.out.println("Add age for your animal");
        int age = input.nextInt();
        if (animalType.equalsIgnoreCase("Cat")) {
            animals.add(new Cat(age, name));
        } else if (animalType.equalsIgnoreCase("Dog")) {
            animals.add(new Dog(age, name));
        } else if (animalType.equalsIgnoreCase("Fox")) {
            animals.add(new Fox("small", weight, name));
        } else if (animalType.equalsIgnoreCase("Bear")) {
            animals.add(new Bear("big", weight, name));
        } else System.out.println("wrong animal type");
        for (Animals animal : animals) {
            System.out.println(animal + "has haschcode: " + animal.hashCode());
        }
    }

    public static ArrayList<Animals> deleteAnimal() {
        System.out.println("this is the list of your animals");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + 1 + ") " + animals.get(i));
        }
        System.out.println("put number witch you'd like to delete");
        Scanner input = new Scanner(System.in);
        int numberDeletedAnimal = input.nextInt();
        animals.remove(numberDeletedAnimal - 1);
        return animals;
    }

    public static ArrayList<Animals> readAllAnimals() {
        System.out.println(animals.toString());
        return animals;
    }

    public static ArrayList<Animals> changeAnimal() {
        System.out.println("this is the list of your animals");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + 1 + ") " + animals.get(i));
        }
        System.out.println("put number witch you'd like to change");
        Scanner input = new Scanner(System.in);
        int numberChangeAnimal = input.nextInt();
        System.out.println(animals.get(numberChangeAnimal - 1));
        Scanner input2 = new Scanner(System.in);
        System.out.println("Add name for your animal");
        String name = input2.nextLine();
        System.out.println("Add age for your animal");
        int age = input.nextInt();
        animals.get(numberChangeAnimal - 1).setAge(age);
        animals.get(numberChangeAnimal - 1).setName(name);
        System.out.println(animals);
        return animals;
    }

    public static int menu() {
        int selection = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your options");
        System.out.println("-------------------------");
        System.out.println("1 - Save a new object to a file");
        System.out.println("2 - read all the objects from file and show them in console");
        System.out.println("3 - Add new object to collection");
        System.out.println("4 - Remove an object from collection");
        System.out.println("5 - Read all objects from collection");
        System.out.println("6 - Update an object in the collection");
        System.out.println("0 - Quit");


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
            choice = menu();
            switch (choice) {
                case 1:
                    segregationToFile();
                    break;
                case 2:
                    segregationFromFile();
                    break;
                case 3:
                    addNewObjectToCollection();
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
