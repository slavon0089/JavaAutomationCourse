package org.example.lesson3;

public class Cat extends HomeAnimals implements Activities{
    Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public void climb() {
        System.out.println("Can climb on the tree so fast");
    }
}
