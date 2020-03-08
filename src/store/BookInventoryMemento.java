package store;

import inventory.Product;
import memento.Memento;

import java.util.ArrayList;

public class BookInventoryMemento implements Memento {
    private ArrayList<Book> bookList;

    BookInventoryMemento(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public ArrayList<Product> getState() {
        return new ArrayList<>(this.bookList);
    }
}
