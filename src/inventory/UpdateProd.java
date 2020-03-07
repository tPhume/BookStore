package inventory;

// Update price of a product by name or id
public interface UpdateProd {
    boolean update(int id, int price);

    boolean update(String name, int price);
}
