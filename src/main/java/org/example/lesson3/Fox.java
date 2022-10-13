package org.example.lesson3;

import java.io.Serializable;

public class Fox extends WildAnimals implements Serializable {

    public Fox (String size,int weight, String name){
        super(size,weight, name);
    }

    @Override
    public String toString() {
        return "Fox{" +
                "size='" + size + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", this animal can bite you"+
                '}';
    }
}
