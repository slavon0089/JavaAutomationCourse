package org.example.lesson3;

import java.io.Serializable;
import java.util.Objects;

abstract public class Animals implements Serializable {
    String placeOfLive;
    String wool;
    int age;
    String name;
    int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return age == animals.age && weight == animals.weight && placeOfLive.equals(animals.placeOfLive) && wool.equals(animals.wool) && name.equals(animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeOfLive, wool, age, name, weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPlaceOfLive() {
        return placeOfLive;
    }

    public void setPlaceOfLive(String placeOfLive) {
        this.placeOfLive = placeOfLive;
    }

    public String getWool() {
        return wool;
    }

    public void setWool(String wool) {
        this.wool = wool;
    }

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

    public void sound(){
        System.out.printf("can say:");
    };

    public void kindOfFood(){
        System.out.println("animal can eat meat");
    }
}
