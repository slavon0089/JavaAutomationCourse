package org.example.lesson3;

public class Fox extends WildAnimals {

    public Fox (String size,int weight, String name){
        super(size,weight, name);
    }

    @Override
    public String toString() {
        return "Fox{" +
                "size='" + size + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", this animal can beat you"+
                '}';
    }
}
