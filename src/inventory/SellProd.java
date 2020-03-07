package inventory;

// Decrease stock of a product given id or name
public interface SellProd {
    boolean sell(int id, int num);

    boolean sell(String name, int num);
}
