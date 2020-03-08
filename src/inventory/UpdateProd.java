package inventory;

// Update price of a product by name or id
public interface UpdateProd {
    void update(Integer id, int price);

    void update(String name, int price);
}
