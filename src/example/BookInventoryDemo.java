package example;

import inventory.Product;
import memento.Caretaker;
import store.*;

public class BookInventoryDemo {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        BookInventory inventory = new BookInventory();

        // add a new book
        Book animalBook = new Book(1, "Animal Book", 30, 1);
        inventory.create(animalBook);

        // add memento to caretaker - state 0
        caretaker.add(inventory.save());

        // add another book
        Book insectBook = new Book(2, "Insect Book", 30, 1);
        inventory.create(insectBook);

        // add memento to caretaker - state 1
        caretaker.add(inventory.save());

        // load state 0
        inventory.restore(caretaker.get(0));

        System.out.println("---- LOADED FROM STATE 0 ----");

        Product prod = inventory.find(1);
        System.out.printf("Product 1: %s\n", prod.getName());

        prod = inventory.find(2);
        System.out.printf("Product 2: %s\n\n", prod);

        // load state 1
        inventory.restore(caretaker.get(1));

        System.out.println("---- LOADED FROM STATE 1 ----");

        prod = inventory.find(1);
        System.out.printf("Product 1: %s\n", prod.getName());

        prod = inventory.find(2);
        System.out.printf("Product 2: %s\n\n", prod.getName());
    }
}
