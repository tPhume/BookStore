package inventory;

import java.io.Serializable;

public interface Inventory extends CreateProd, AddProd, SellProd, FindProd, UpdateProd, Serializable {
}
