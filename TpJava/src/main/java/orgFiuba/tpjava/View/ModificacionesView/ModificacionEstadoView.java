package orgFiuba.tpjava.View.ModificacionesView;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_ROJO;

public class ModificacionEstadoView extends ModificacionView{

    public ModificacionEstadoView(Modificacion unaModificacion){
        super(unaModificacion);
    }

    public void mostrar(Cualidades unaCualidad){

        if(!unaCualidad.estaConsciente()) {
            System.out.println(" ");
            System.out.println(ANSI_ROJO + "No se puede aplicar este item a un Pokemon Inhabilitado o Normal." + ANSI_RESET);
        }
    }

}
