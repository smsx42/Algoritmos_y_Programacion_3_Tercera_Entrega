package orgFiuba.tpjava.Model.Climas;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.CLIMA_HURACAN;
import static orgFiuba.tpjava.Constantes.PORCENTAJE_DANIO_CLIMA_ABRASIVO;

public class ClimaTormentaHuracan extends Clima{

    public ClimaTormentaHuracan(){
        this.nombre = CLIMA_HURACAN;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
        if(cualidades.getTipo().verSiEsAbrasivo(this.nombre)){
            cualidades.recibirDanio(cualidades.getVidaMaxima() * PORCENTAJE_DANIO_CLIMA_ABRASIVO);
        }
    }
}
