package org.example.lesson3;

import java.io.Serializable;

public class HomeAnimals extends Animals implements Serializable {
    boolean canEatYou = false;
    int age;
    String name;

    public HomeAnimals() {

    }

    public static void  sweetDreams(){
        System.out.println("Those animals likes to live at home");
    }

    @Override
    public void kindOfFood() {
        System.out.println("Those animals can eat meat and other kind of human food");
    }

    public HomeAnimals(int age, String name) {
        this.age = age;
        this.name = name; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
