package memento;

import book.Book;

import java.io.Serializable;
import java.util.ArrayList;

public class Memento implements Serializable {
    private ArrayList<Object> state;

    public Memento(ArrayList<Book> state) {
        this.state = new ArrayList<>(state);
    }

    public ArrayList<Object> getState() {
        return new ArrayList<>(state);
    }
}
