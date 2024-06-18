package orgFiuba.tpjava.Model.Climas;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.CLIMA_TORMENTA_DE_RAYOS;
import static orgFiuba.tpjava.Constantes.PORCENTAJE_DANIO_CLIMA_ABRASIVO;

public class ClimaTormentaElectrica extends Clima{

    public ClimaTormentaElectrica(){
        this.nombre = CLIMA_TORMENTA_DE_RAYOS;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
        if(cualidades.getTipo().verSiEsAbrasivo(this.nombre)){
            cualidades.recibirDanio(cualidades.getVidaMaxima() * PORCENTAJE_DANIO_CLIMA_ABRASIVO);
        }
    }
}
