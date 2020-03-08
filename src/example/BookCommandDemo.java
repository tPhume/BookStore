package example;

import book.Book;
import book.BookCreateCommand;
import book.BookInventory;
import book.BookUpdateCommand;

public class BookCommandDemo {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();

        // create new product
        Book animalBook = new Book(1, "Animal Book", 400, 0);

        BookCreateCommand createCommand = new BookCreateCommand(animalBook);
        createCommand.execute(inventory);

        // update price of product
        BookUpdateCommand updateCommand = new BookUpdateCommand(1, 100);

        // have not executed the update command yet
        System.out.println("---- BEFORE UPDATE EXECUTION ----");
        System.out.println(inventory.find(1));

        System.out.println();

        // after executing
        updateCommand.execute(inventory);
        System.out.println("---- AFTER UPDATE EXECUTION ----");
        System.out.println(inventory.find(1));
    }
}
