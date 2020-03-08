package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookFindCommand implements InventoryCommand {
    private int id;
    private String name;

    public BookFindCommand(int id) {
        this.id = id;
        this.name = null;
    }

    public BookFindCommand(String name) {
        this.id = -1;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.name != null) {
            inventory.find(this.name);
        } else {
            inventory.find(this.id);
        }
    }
}
