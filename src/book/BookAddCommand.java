package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookAddCommand implements InventoryCommand {
    private int id;
    private String name;
    private int num;

    public BookAddCommand(int id, int num) {
        this.id = id;
        this.num = num;
        this.name = null;
    }

    public BookAddCommand(String name, int num) {
        this.id = -1;
        this.num = num;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.id != -1) {
            inventory.add(this.id, this.num);
        } else {
            inventory.add(this.name, num);
        }
    }
}
