package example;

import inventory.Product;
import memento.Memento;
import store.*;

public class BookInventoryDemo {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();

        // add a new book
        Book animalBook = new Book(1, "Animal Book", 30, 1);
        inventory.create(animalBook);


        Memento memento = inventory.save();

        // add another book
        Book insectBook = new Book(2, "Insect Book", 30, 1);
        inventory.create(insectBook);

        // load state from memento
        inventory.restore(memento);

        Product prod = inventory.find(2);
        System.out.printf("Product is null because we loaded state from memento: %s\n", prod);

        prod = inventory.find(1);
        System.out.printf("Product 1 is Animal Book: %s\n", prod.getName());
    }
}
