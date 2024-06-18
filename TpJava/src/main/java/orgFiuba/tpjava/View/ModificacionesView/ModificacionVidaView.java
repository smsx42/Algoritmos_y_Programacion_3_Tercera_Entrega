package orgFiuba.tpjava.View.ModificacionesView;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_ROJO;

public class ModificacionVidaView extends ModificacionView {

    public ModificacionVidaView(Modificacion unaModificacion) {
        super(unaModificacion);
    }

    public void mostrar(Cualidades unaCualidad) {
        if (unaCualidad.getVida() == 0) {

            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon esta Inhabilitado, no se puede curar." + ANSI_RESET);
        } else if (unaCualidad.getVida() == unaCualidad.getVidaMaxima()) {

            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon tiene toda la vida, no se puede curar." + ANSI_RESET);
        }

    }
}