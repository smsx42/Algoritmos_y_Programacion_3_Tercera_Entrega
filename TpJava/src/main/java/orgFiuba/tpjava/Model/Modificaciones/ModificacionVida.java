package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static orgFiuba.tpjava.Constantes.MODIFICACION_VIDA;
@JsonTypeName("vida")
public class ModificacionVida implements Modificacion{

    @Override
    public void modificar(Cualidades cualidades, int etapas) {

        if(cualidades.getVida() != cualidades.getVidaMaxima() && cualidades.estaConsciente()){
            cualidades.aumentarVida(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_VIDA;
    }

}
