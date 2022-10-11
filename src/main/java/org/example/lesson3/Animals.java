package org.example.lesson3;

import java.io.Serializable;

abstract public class Animals implements Serializable {
    String placeOfLive;
    String wool;



    public void sound(){
        System.out.printf("can say:");
    };

    public void kindOfFood(){
        System.out.println("animal can eat meat");
    }
}
