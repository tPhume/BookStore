package book;

import command.InventoryCommand;
import inventory.Inventory;
import inventory.Product;
import memento.Caretaker;
import memento.Memento;
import memento.Originator;

import java.io.*;
import java.util.ArrayList;

// wrap over the BookInventory class
public class BookDecorator implements Inventory, Originator {
    private BookInventory inventory;
    private Caretaker caretaker;
    private String commandFile;

    public BookDecorator(BookInventory inventory, Caretaker caretaker, String commandFile) {
        this.inventory = inventory;
        this.caretaker = caretaker;
        this.commandFile = commandFile;
    }

    @Override
    public void add(Integer id, int num) {
        BookAddCommand addCommand = new BookAddCommand(id, num);
        addCommand.execute(inventory, this.commandFile);
    }

    @Override
    public void add(String name, int num) {
        BookAddCommand addCommand = new BookAddCommand(name, num);
        addCommand.execute(inventory, this.commandFile);
    }

    @Override
    public void create(Product prod) {
        BookCreateCommand createCommand = new BookCreateCommand((Book) prod);
        createCommand.execute(inventory, this.commandFile);
    }

    @Override
    public Product find(Integer id) {
        return inventory.find(id);
    }

    @Override
    public Product find(String name) {
        return inventory.find(name);
    }

    @Override
    public void sell(Integer id, int num) {
        BookSellCommand sellCommand = new BookSellCommand(id, num);
        sellCommand.execute(inventory, this.commandFile);
    }

    @Override
    public void sell(String name, int num) {
        BookSellCommand sellCommand = new BookSellCommand(name, num);
        sellCommand.execute(inventory, this.commandFile);
    }

    @Override
    public void update(Integer id, int price) {
        BookUpdateCommand updateCommand = new BookUpdateCommand(id, price);
        updateCommand.execute(inventory, this.commandFile);
    }

    @Override
    public void update(String name, int price) {
        BookUpdateCommand updateCommand = new BookUpdateCommand(name, price);
        updateCommand.execute(inventory, this.commandFile);
    }

    @Override
    public Memento save() {
        Memento memento = inventory.save();
        caretaker.add(memento);

        // this will clear our command file
        try {
            PrintWriter writer = new PrintWriter(this.commandFile);
            writer.print("");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return memento;
    }

    @Override
    public void restore(Memento memento) {
        inventory.restore(memento);
    }

    // restores the latest memento and replay the commands
    public void restoreFromFile() {
        // load from file
        caretaker.deserialize();
        ArrayList<Memento> history = caretaker.getHistory();

        // restore using last memento
        if (history.size() > 0) {
            inventory.restore(history.get(history.size() - 1));
        }

        // replay commands
        try {
            FileInputStream fileIn = new FileInputStream(this.commandFile);
            ObjectInput objIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    InventoryCommand command = (InventoryCommand) objIn.readObject();
                    command.execute(this.inventory, "");
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
