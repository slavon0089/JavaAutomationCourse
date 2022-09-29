package org.example.lesson3;

public class CustomPedigree extends Cat.Pedigree {

    public CustomPedigree(){
        new Cat().super();
    }

    public CustomPedigree(String parentName, String medals, String hierarchy) {
        new Cat().super(parentName, medals, hierarchy);
    }
}
