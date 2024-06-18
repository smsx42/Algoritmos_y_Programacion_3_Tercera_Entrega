package orgFiuba.tpjava.View.PokemonesView;

import orgFiuba.tpjava.Model.Pokemones.*;


public class HabilidadFactory {

    public HabilidadView createHabilidadView(Habilidad habilidad){
        if(habilidad.getClass() == HabilidadAtaque.class){
            return new HabilidadAtaqueView((HabilidadAtaque) habilidad);
        }
        if(habilidad.getClass() == HabilidadEstadistica.class){
            return new HabilidadEstadisticaView((HabilidadEstadistica) habilidad);
        }
        if (habilidad.getClass() == HabilidadClima.class){
            return new HabilidadClimaView((HabilidadClima) habilidad);
        }
        return new HabilidadEstadoView((HabilidadEstado) habilidad);
    }
}
