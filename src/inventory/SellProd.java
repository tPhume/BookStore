package inventory;

// Decrease stock of a product given id or name
public interface SellProd {
    void sell(Integer id, int num);

    void sell(String name, int num);
}
