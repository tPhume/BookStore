package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookAddCommand implements InventoryCommand {
    private Integer id;
    private String name;
    private int num;

    public BookAddCommand(Integer id, int num) {
        this.id = id;
        this.num = num;
        this.name = null;
    }

    public BookAddCommand(String name, int num) {
        this.id = null;
        this.num = num;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.id != null) {
            inventory.add(this.id, this.num);
        } else {
            inventory.add(this.name, num);
        }
    }
}
