package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Estados.EstadoNormal;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.MODIFICACION_ESTADO;

public class ModificacionEstado implements  Modificacion{

    public void modificar(Cualidades cualidades, int etapas){

        if (cualidades.estaConsciente()) {
            cualidades.cambiarLosEstadosA(new EstadoNormal());
        }
    }

    public  String obtenerNombreModificacion(){
        return MODIFICACION_ESTADO;
    }
}
