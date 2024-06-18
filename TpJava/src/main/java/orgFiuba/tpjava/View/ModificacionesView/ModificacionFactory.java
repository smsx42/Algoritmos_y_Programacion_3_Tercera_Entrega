package orgFiuba.tpjava.View.ModificacionesView;

import orgFiuba.tpjava.Model.Modificaciones.*;

public class ModificacionFactory {

    public ModificacionView createModificacionView(Modificacion modificacion){
        if(modificacion.getClass() == ModificacionEstado.class){
            return new ModificacionEstadoView(modificacion);
        }
        if(modificacion.getClass() == ModificacionEstadoInhabilitado.class){
            return new ModificacionEstadoInhabilitadoView(modificacion);
        }
        if(modificacion.getClass() == ModificacionAtaque.class){
            return new ModificacionAtaqueView(modificacion);
        }
        if(modificacion.getClass() == ModificacionDefensa.class){
            return new ModificacionDefensaView(modificacion);
        }

        return new ModificacionVidaView(modificacion);
    }
}
