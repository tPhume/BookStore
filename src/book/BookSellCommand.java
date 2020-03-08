package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookSellCommand implements InventoryCommand {
    private Integer id;
    private String name;
    private int num;

    public BookSellCommand(Integer id, int num) {
        this.id = id;
        this.num = num;
        this.name = null;
    }

    public BookSellCommand(String name, int num) {
        this.id = null;
        this.num = num;
        this.name = name;
    }

    @Override
    public void execute(Inventory inventory) {
        if (this.id != null) {
            inventory.sell(this.id, this.num);
        } else {
            inventory.sell(this.name, this.num);
        }
    }
}
