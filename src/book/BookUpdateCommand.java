package book;

import command.InventoryCommand;
import inventory.Inventory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    public void execute(Inventory inventory, String filename) {
        if (this.id != null) {
            inventory.update(this.id, this.price);
        } else {
            inventory.update(this.name, this.price);
        }

        if (!filename.equals("")) {
            try {
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

                objOut.writeObject(this);

                objOut.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
}
