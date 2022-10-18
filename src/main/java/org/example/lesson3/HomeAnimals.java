package org.example.lesson3;

import java.io.Serializable;
import java.util.Objects;

public class HomeAnimals extends Animals implements Serializable {
    boolean canEatYou = false;
    int age;
    String name;

    public HomeAnimals() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeAnimals that = (HomeAnimals) o;
        return canEatYou == that.canEatYou && age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canEatYou, age, name);
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
