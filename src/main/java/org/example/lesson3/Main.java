package org.example.lesson3;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(1, "Barsik");
        Dog dog = new Dog(2, "Perl");
        Bear bear = new Bear("big",300,"Potapich");
        Fox fox = new Fox ("small", 20,"Kitty");

        System.out.println(cat);
        cat.kindOfFood();
        cat.climb();
        System.out.println(dog);
        dog.kindOfFood();
        HomeAnimals.sweetDreams();
        System.out.printf("We have 2 home animals: %s with %d year " +
                "and %s with %d years old\n", cat.getName(),cat.getAge(),dog.getName(),dog.getAge());
        WildAnimals.agressiveAnimals();
        System.out.println(bear);
        bear.kindOfFood();
        bear.climb();
        System.out.println(fox);
        fox.kindOfFood();

    }
}
