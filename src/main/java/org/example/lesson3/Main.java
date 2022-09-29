package org.example.lesson3;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(1, "Barsik");
        Cat.Pedigree pedigree = cat.new Pedigree("Boss","1st place","Boss->Max->Chrome");
        Dog dog = new Dog(2, "Perl");
        Dog dog2 = new Dog(5, "Perl");
        Dog.NameComparator nameComparator = new Dog.NameComparator();
        Bear bear = new Bear("big",300,"Potapich");
        Fox fox = new Fox ("small", 20,"Kitty");

        System.out.println(cat);
        System.out.println(pedigree);
        cat.kindOfFood();
        cat.climb();
        System.out.println(dog);
        System.out.println( "Are your dogs have the same names? "+nameComparator.compare(dog,dog2));
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

        Animals animals = new Animals() {
            @Override
            public void sound() {
                System.out.println("animal voice");
            }
        };
        animals.sound();

    }
}
