package org.example.lesson3;

import java.io.Serializable;

public class Cat extends HomeAnimals implements Activities, Serializable {
    Cat(int age, String name) {
        super(age, name);
    }

    public Cat() {
        super();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public void climb() {
        System.out.println("Can climb on the tree so fast");
    }

    public class Pedigree implements Serializable{
        private String parentName;
        private String medals;

        public Pedigree() {

        }

        @Override
        public String toString() {
            return "Pedigree{" +
                    "parentName='" + parentName + '\'' +
                    ", medals='" + medals + '\'' +
                    ", hierarchy='" + hierarchy + '\'' +
                    '}';
        }

        private String hierarchy;

        public Pedigree(String parentName, String medals, String hierarchy) {
            this.parentName = parentName;
            this.medals = medals;
            this.hierarchy = hierarchy;
        }
    }
}
