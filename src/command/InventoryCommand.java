package command;

import inventory.Inventory;

import java.io.Serializable;

public interface InventoryCommand extends Serializable {
    void execute(Inventory inventory);
}
