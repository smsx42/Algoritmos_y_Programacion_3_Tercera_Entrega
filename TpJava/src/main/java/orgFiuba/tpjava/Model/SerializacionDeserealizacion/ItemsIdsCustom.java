package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import orgFiuba.tpjava.Model.Items.Item;


public class ItemsIdsCustom {
    private int id;
    private Item unItem;

    public ItemsIdsCustom(int id, Item unItem) {
        this.id = id;
        this.unItem = unItem;
    }

    public int getId() {return this.id ;}

    public Item getUnItem() {return this.unItem;}

}
