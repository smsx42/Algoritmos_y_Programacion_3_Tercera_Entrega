package orgFiuba.tpjava.View.ItemsView;

import orgFiuba.tpjava.Model.Items.Item;

public abstract class ItemView {

    protected Item item;

    public ItemView(Item item) {
        this.item = item;
    }

    public abstract void mostrar();
}
