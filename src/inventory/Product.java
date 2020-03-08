package inventory;

public interface Product {
    // for id attribute
    int getId();

    // for name attribute
    String getName();

    // for price attribute
    double getPrice();

    void setPrice(double price);

    // for stock attribute
    int getStock();

    void setStock(int stock);
}
