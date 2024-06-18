package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static orgFiuba.tpjava.Constantes.MODIFICACION_ATAQUE;

@JsonTypeName("ataque")
public class ModificacionAtaque implements Modificacion {


    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarAtaque(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_ATAQUE;
    }

}