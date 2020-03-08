package book;

import command.InventoryCommand;
import inventory.Inventory;

public class BookCreateCommand implements InventoryCommand {
    private Book book;

    public BookCreateCommand(Book book) {
        this.book = new Book(book.getId(), book.getName(), book.getPrice(), book.getStock());
    }

    @Override
    public void execute(Inventory inventory) {
        inventory.create(book);
    }
}
