package inventory;

import java.io.Serializable;

public interface Product extends Serializable {
    // for id attribute
    Integer getId();

    // for name attribute
    String getName();

    // for price attribute
    double getPrice();

    void setPrice(double price);

    // for stock attribute
    int getStock();

    void setStock(int stock);
}
