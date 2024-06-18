package orgFiuba.tpjava.View.ModificacionesView;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_ROJO;

public class ModificacionEstadoInhabilitadoView extends ModificacionView{

    public ModificacionEstadoInhabilitadoView(Modificacion unaModifcacion){
        super(unaModifcacion);
    }

    public void mostrar(Cualidades unaCualidad){

        if(unaCualidad.estaConsciente()){
            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon no se puede revivir ya que no esta Inhabilitado" + ANSI_RESET);
        }
    }
}
