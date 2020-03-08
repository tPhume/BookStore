package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookSellCommand implements InventoryCommand {
    private int id;
    private String name;
    private int num;

    public BookSellCommand(int id, int num) {
        this.id = id;
        this.num = num;
        this.name = null;
    }

    public BookSellCommand(String name, int num) {
        this.id = -1;
        this.num = num;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.id != -1) {
            inventory.sell(this.id, this.num);
        } else {
            inventory.sell(this.name, this.num);
        }
    }
}
