package inventory;

// Find product by name or id
public interface FindProd {
    Product find(int id);

    Product find(String name);
}
