package inventory;

// Increase stock of a product given id or name
public interface AddProd {
    void add(Integer id, int num);

    void add(String name, int num);
}
