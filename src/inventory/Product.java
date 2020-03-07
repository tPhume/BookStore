package inventory;

public interface Product {
    // for id attribute
    int getId();

    void setId(int id);

    // for name attribute
    String getName();

    void setName(String name);

    // for price attribute
    double getPrice();

    void setPrice(double price);

    // for stock attribute
    int getStock();

    void setStock(int stock);
}
