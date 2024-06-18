package orgFiuba.tpjava.View.ModificacionesView;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_ROJO;

public class ModificacionDefensaView extends ModificacionView{

    public ModificacionDefensaView(Modificacion unaModificacion){
        super(unaModificacion);

    }

    public void mostrar(Cualidades unaCualidad){
        if (unaCualidad.getVida() == 0) {

            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon esta Inhabilitado, no se puede aplicar el item." + ANSI_RESET);
        }

    }
}
