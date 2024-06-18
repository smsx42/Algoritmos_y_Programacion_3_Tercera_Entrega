package orgFiuba.tpjava.View.ItemsView;

import orgFiuba.tpjava.Model.Items.Item;

import static orgFiuba.tpjava.Constantes.ANSI_GRISCLARO;
import static orgFiuba.tpjava.Constantes.ANSI_RESET;

public class AtaqueXView extends ItemView{

    public AtaqueXView(Item item) {
        super(item);
    }

    public void mostrar(){

        System.out.println(ANSI_GRISCLARO + item.getNombre() + ANSI_RESET + ": Aumenta 10% el ataque - Cantidad: " + ANSI_GRISCLARO + item.getCantidad() + ANSI_RESET);

    }
}
