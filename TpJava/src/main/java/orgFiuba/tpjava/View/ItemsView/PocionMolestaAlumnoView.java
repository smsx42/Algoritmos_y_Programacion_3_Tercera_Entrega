package orgFiuba.tpjava.View.ItemsView;
import orgFiuba.tpjava.Model.Items.Item;

import static orgFiuba.tpjava.Constantes.ANSI_GRISCLARO;
import static orgFiuba.tpjava.Constantes.ANSI_RESET;

public class PocionMolestaAlumnoView extends ItemView{

    public PocionMolestaAlumnoView(Item item){
        super(item);
    }

    @Override
    public void mostrar() {
        System.out.println(ANSI_GRISCLARO + this.item.getNombre() + ANSI_RESET  + ": Restaura un tercio de la vida del Pokemon - Cantidad: " + ANSI_GRISCLARO + this.item.getCantidad() + ANSI_RESET);
    }
}
