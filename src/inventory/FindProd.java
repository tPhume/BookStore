package inventory;

// Find product by name or id
public interface FindProd {
    Product find(Integer id);

    Product find(String name);
}
