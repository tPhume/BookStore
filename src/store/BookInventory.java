package store;

import inventory.Inventory;
import inventory.Product;

import memento.Memento;
import memento.Originator;

import java.util.ArrayList;


public class BookInventory implements Inventory, Originator {
    private ArrayList<Book> bookList;

    public BookInventory() {
        this.bookList = new ArrayList<>();
    }

    @Override
    public Memento save() {
        return new Memento(this.bookList);
    }

    @Override
    public void restore(Memento memento) {
        ArrayList<Book> newBookList = new ArrayList<>();
        ArrayList<Object> state = memento.getState();

        for (Object prod : state) {
            newBookList.add((Book) prod);
        }

        this.bookList = newBookList;
    }

    @Override
    public void add(int id, int num) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                book.setStock(book.getStock() + num);

                return;
            }
        }
    }

    @Override
    public void add(String name, int num) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                book.setStock(book.getStock() + num);

                return;
            }
        }
    }

    @Override
    public void create(Product prod) {
        // check for duplicate
        for (Book book : this.bookList) {
            if (book.getId() == prod.getId() || book.getName().equals(prod.getName())) {
                return;
            }
        }

        // type cast then add to our list
        Book book = (Book) prod;
        this.bookList.add(book);
    }

    @Override
    public Product find(int id) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Product find(String name) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                return book;
            }
        }

        return null;
    }

    @Override
    public void sell(int id, int num) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                book.setStock(book.getStock() - num);

                return;
            }
        }
    }

    @Override
    public void sell(String name, int num) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                book.setStock(book.getStock() - num);

                return;
            }
        }
    }

    @Override
    public void update(int id, int price) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                book.setPrice(price);

                break;
            }
        }
    }

    @Override
    public void update(String name, int price) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                book.setPrice(price);

                return;
            }
        }
    }
}
