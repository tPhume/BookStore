package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookUpdateCommand implements InventoryCommand {
    private Integer id;
    private String name;
    private int price;

    public BookUpdateCommand(Integer id, int price) {
        this.id = id;
        this.price = price;
        this.name = null;
    }

    public BookUpdateCommand(String name, int price) {
        this.id = null;
        this.price = price;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.id != null) {
            inventory.update(this.id, this.price);
        } else {
            inventory.update(this.name, this.price);
        }
    }
}
