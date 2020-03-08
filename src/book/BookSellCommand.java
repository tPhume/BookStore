package book;

import command.InventoryCommand;
import inventory.Inventory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    public void execute(Inventory inventory, String filename) {
        if (this.id != null) {
            inventory.sell(this.id, this.num);
        } else {
            inventory.sell(this.name, this.num);
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
