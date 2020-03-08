package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookUpdateCommand implements InventoryCommand {
    private int id;
    private String name;
    private int price;

    public BookUpdateCommand(int id, int price) {
        this.id = id;
        this.price = price;
        this.name = null;
    }

    public BookUpdateCommand(String name, int price) {
        this.id = -1;
        this.price = price;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.id != -1) {
            inventory.update(this.id, this.price);
        } else {
            inventory.update(this.name, this.price);
        }
    }
}
