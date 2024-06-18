package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static orgFiuba.tpjava.Constantes.MODIFICACION_VELOCIDAD;
@JsonTypeName("velocidad")
public class ModificacionVelocidad implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarVelocidad(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_VELOCIDAD;
    }
}
