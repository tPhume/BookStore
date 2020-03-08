package store;

import inventory.Inventory;
import inventory.Product;

import java.util.ArrayList;


public class BookInventory implements Inventory {
    private ArrayList<Book> bookList;

    public BookInventory() {
        this.bookList = new ArrayList<>();
    }

    @Override
    public boolean add(int id, int num) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                book.setStock(book.getStock() + num);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean add(String name, int num) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                book.setStock(book.getStock() + num);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean create(Product prod) {
        // check for duplicate
        for (Book book : this.bookList) {
            if (book.getId() == prod.getId() || book.getName().equals(prod.getName())) {
                return false;
            }
        }

        // type cast then add to our list
        Book book = (Book) prod;
        this.bookList.add(book);

        return true;
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
    public boolean sell(int id, int num) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                book.setStock(book.getStock() - num);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean sell(String name, int num) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                book.setStock(book.getStock() - num);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean update(int id, int price) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                book.setPrice(price);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean update(String name, int price) {
        for (Book book : this.bookList) {
            if (book.getName().equals(name)) {
                book.setPrice(price);

                return true;
            }
        }

        return false;
    }
}
