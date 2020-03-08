package book;

import command.InventoryCommand;
import inventory.Inventory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BookCreateCommand implements InventoryCommand {
    private Book book;

    public BookCreateCommand(Book book) {
        this.book = new Book(book.getId(), book.getName(), book.getPrice(), book.getStock());
    }

    @Override
    public void execute(Inventory inventory, String filename) {
        inventory.create(book);

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
