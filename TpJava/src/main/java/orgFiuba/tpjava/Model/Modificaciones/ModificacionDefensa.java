package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static orgFiuba.tpjava.Constantes.MODIFICACION_DEFENSA;
@JsonTypeName("defensa")
public class ModificacionDefensa implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarDefensa(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_DEFENSA;
    }
}
