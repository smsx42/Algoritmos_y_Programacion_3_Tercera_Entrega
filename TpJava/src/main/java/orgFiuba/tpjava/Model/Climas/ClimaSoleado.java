package orgFiuba.tpjava.Model.Climas;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.CLIMA_SOLEADO;

public class ClimaSoleado extends Clima{

    public ClimaSoleado(){
        this.nombre = CLIMA_SOLEADO;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades){

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}

