package memento;

import inventory.Product;

import java.io.Serializable;
import java.util.ArrayList;

public interface Memento extends Serializable {
    ArrayList<Product> getState();
}
