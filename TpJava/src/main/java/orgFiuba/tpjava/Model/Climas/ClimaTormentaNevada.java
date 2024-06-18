package orgFiuba.tpjava.Model.Climas;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.CLIMA_TORMENTA_DE_NIEVE;
import static orgFiuba.tpjava.Constantes.PORCENTAJE_DANIO_CLIMA_ABRASIVO;

public class ClimaTormentaNevada extends Clima{

    public ClimaTormentaNevada(){
        this.nombre = CLIMA_TORMENTA_DE_NIEVE;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
        if(cualidades.getTipo().verSiEsAbrasivo(this.nombre)){
            cualidades.recibirDanio(cualidades.getVidaMaxima() * PORCENTAJE_DANIO_CLIMA_ABRASIVO);
        }
    }
}