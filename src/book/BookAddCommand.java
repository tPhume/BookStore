package book;

import command.InventoryCommand;
import inventory.Inventory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    public void execute(Inventory inventory, String filename) {
        if (this.id != null) {
            inventory.add(this.id, this.num);
        } else {
            inventory.add(this.name, num);
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
