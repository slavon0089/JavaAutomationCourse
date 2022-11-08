package org.example.db.entities;

import java.util.List;

public interface Dao <T>{
    T get(int student_id);
    T get(int student_id, String student_name);
    List <T> getAll();
    //void add(T object);
    void add();


}
