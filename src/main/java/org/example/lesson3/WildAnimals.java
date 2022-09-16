package org.example.lesson3;

public class WildAnimals extends Animals{

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
