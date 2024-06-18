package orgFiuba.tpjava.View.ItemsView;

import orgFiuba.tpjava.Model.Items.Item;

import static orgFiuba.tpjava.Constantes.ANSI_GRISCLARO;
import static orgFiuba.tpjava.Constantes.ANSI_RESET;

public class MegaPocionView extends ItemView{

    public MegaPocionView(Item item){
        super(item);

    }

    public void mostrar(){
        System.out.println(ANSI_GRISCLARO + this.item.getNombre() + ANSI_RESET + ": Restaura 50 de vida - Cantidad: " + ANSI_GRISCLARO + this.item.getCantidad() + ANSI_RESET);
    }
}
