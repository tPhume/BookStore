package example;

import book.Book;
import book.BookDecorator;
import book.BookInventory;
import memento.Caretaker;

public class BookStoreDemo {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker("demo.ser");

        BookInventory bookInventory = new BookInventory();
        BookDecorator bookDecorator = new BookDecorator(bookInventory, caretaker, "demo.command.ser");

        // create new product - Animal Book
        Book animalBook = new Book(1, "Animal Book", 500, 10);
        bookDecorator.create(animalBook);

        // Sell 5 copies of Animal Book
        bookDecorator.sell(1, 5);

        // create backup to file using caretaker and memento
        bookDecorator.save();

        // update file - but don't make memento
        Book insectBook = new Book(2, "Insect Book", 300, 5);
        bookDecorator.create(insectBook);

        System.out.println("---- Before restoration ----");
        System.out.println(bookDecorator.find(1));
        System.out.println(bookDecorator.find(2));

        System.out.println();

        // now assume that our program crash
        // we will instantiate book inventory and co to new variables to demonstrate restore and replay ability
        Caretaker newCaretaker = new Caretaker("demo.ser");

        BookInventory newBookInventory = new BookInventory();
        BookDecorator newBookDecorator = new BookDecorator(newBookInventory, newCaretaker, "demo.command.ser");

        newBookDecorator.restoreFromFile();

        System.out.println("---- After restoration ----");
        System.out.println(newBookDecorator.find(1));
        System.out.println(newBookDecorator.find(2));
    }
}
