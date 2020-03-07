package inventory;

// Increase stock of a product given id or name
public interface AddProd {
    boolean add(int id, int num);

    boolean add(String name, int num);
}
