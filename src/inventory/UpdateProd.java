package inventory;

// Update price of a product by name or id
public interface UpdateProd {
    void update(int id, int price);

    void update(String name, int price);
}
