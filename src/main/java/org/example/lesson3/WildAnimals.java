package org.example.lesson3;

import java.io.Serializable;
import java.util.Objects;

public class WildAnimals extends Animals implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WildAnimals that = (WildAnimals) o;
        return weight == that.weight && angry == that.angry && canEatYou == that.canEatYou && size.equals(that.size) && type.equals(that.type) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, weight, type, name, angry, canEatYou);
    }

    String size;
    int weight;
    String type;
    String name;
    boolean angry = true;
    private final boolean canEatYou = true;

    public WildAnimals(String size, int weight,  String name) {
        this.size = size;
        this.weight = weight;
        this.name = name;
    }

    public static void agressiveAnimals(){
        System.out.println("Be careful, those animals can be dangerous:");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void kindOfFood() {
        System.out.println("Those animals eat only meat");
    }
}
