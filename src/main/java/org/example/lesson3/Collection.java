package org.example.lesson3;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.lesson3.Menu.menuRun;


public class Collection {

    public static ArrayList<Animals> animals = new ArrayList<Animals>();

    public static void main(String[] args) {
        menuRun();
    }
    public static void addNewAnimalToCollection() {
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
            System.out.printf("%s has hashcode %10d \n", animal, animal.hashCode());
        }
    }

    public static void deleteAnimal() {
        System.out.println("this is the list of your animals");
        for (int i = 0; i < animals.size(); i++) {
            System.out.printf("%d) %s \n", i + 1, animals.get(i));
        }
        System.out.println("put number witch you'd like to delete");
        Scanner input = new Scanner(System.in);
        int numberDeletedAnimal = input.nextInt();
        animals.remove(numberDeletedAnimal - 1);
    }

    public static void readAllAnimals() {
        System.out.println(animals.toString());
    }

    public static void changeAnimal() {
        System.out.println("this is the list of your animals");
        for (int i = 0; i < animals.size(); i++) {
            System.out.printf("%d) %s \n", i + 1, animals.get(i));
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
    }


}
