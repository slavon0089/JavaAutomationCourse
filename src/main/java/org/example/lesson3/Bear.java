package org.example.lesson3;

public class Bear extends WildAnimals implements Activities{

    public Bear (String size,int weight, String name){
        super(size,weight, name);
    }

    @Override
    public String toString() {
        return "Bear{" +
                "size='" + size + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", this animal can eat you"+
                '}';
    }

    @Override
    public void climb() {
        System.out.println("Can climb on the tree");
    }
}
