package org.example.lesson3;
import java.io.*;
import java.util.ArrayList;
import static org.example.lesson3.Collection.animals;

public class Segregation {
    public static void segregationToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(".\\src\\main\\resources\\object.txt"))) {
            out.writeObject(animals);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void segregationFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\src\\main\\resources\\object.txt"))) {
            ArrayList<Animals> animals = (ArrayList<Animals>) in.readObject();
            System.out.println(animals);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
