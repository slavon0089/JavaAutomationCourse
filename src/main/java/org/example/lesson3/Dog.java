package org.example.lesson3;

public class Dog extends HomeAnimals{
    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
