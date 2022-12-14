package org.example.lesson3;

import java.io.Serializable;

public class Dog extends HomeAnimals implements Serializable {
    public Dog(int age, String name) {
      super(age, name);

    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static class NameComparator {
        public boolean compare(Dog dog1, Dog dog2){
            return dog1.getName().equals(dog2.getName());
        }
    }

}
