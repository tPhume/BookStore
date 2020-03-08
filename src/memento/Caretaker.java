package memento;

import java.io.*;
import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> history;
    private String filename;

    public Caretaker(String filename) {
        history = new ArrayList<>();
        this.filename = filename;
    }

    public ArrayList<Memento> getHistory() {
        return history;
    }

    public void add(Memento memento) {
        history.add(memento);
        this.serialize(memento);
    }

    private void serialize(Memento memento) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(memento);

            objOut.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserialize() {
        this.history = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream(this.filename);
            ObjectInput objIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    this.history.add((Memento) objIn.readObject());
                } catch (Exception e) {
                    break;
                }
            }

            objIn.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
