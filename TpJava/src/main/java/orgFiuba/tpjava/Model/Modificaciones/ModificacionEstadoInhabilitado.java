package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Estados.EstadoNormal;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.MODIFICACION_INHABILITADO;

public class ModificacionEstadoInhabilitado implements Modificacion{

    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if(!unaCualidad.estaConsciente()){
            unaCualidad.cambiarLosEstadosA(new EstadoNormal());
            //unaCualidad.aumentarVida(etapas);
        }
        if (unaCualidad.getVida() == 0) {
            unaCualidad.aumentarVida(etapas);
        }
    }

    @Override
    public String obtenerNombreModificacion() {
        return MODIFICACION_INHABILITADO;
    }
}
