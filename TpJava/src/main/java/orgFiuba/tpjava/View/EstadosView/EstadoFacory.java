package orgFiuba.tpjava.View.EstadosView;

import orgFiuba.tpjava.Model.Estados.*;

public class EstadoFacory {

    public EstadoView createEstadoView(Estado estado){
        if(estado.getClass() == EstadoDormido.class){
            return new EstadoDormidoView((EstadoDormido) estado);
        }
        if(estado.getClass() == EstadoParalizado.class){
            return new EstadoParalizadoView((EstadoParalizado) estado);
        }
        if(estado.getClass() == EstadoEnvenenado.class){
            return new EstadoEnvenenadoView((EstadoEnvenenado) estado);
        }
        if(estado.getClass() == EstadoNormal.class){
            return new EstadoNormalView((EstadoNormal) estado);
        }
        if(estado.getClass() == EstadoInhabilitado.class){
            return new EstadoInhabilitadoView((EstadoInhabilitado) estado);
        }
        return new EstadoConfusoView((EstadoConfuso) estado);
    }
}
