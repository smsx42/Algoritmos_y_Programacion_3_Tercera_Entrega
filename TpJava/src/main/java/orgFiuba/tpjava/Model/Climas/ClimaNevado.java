package orgFiuba.tpjava.Model.Climas;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import static orgFiuba.tpjava.Constantes.CLIMA_NEVADO;

public class ClimaNevado extends Clima{

    public ClimaNevado(){
        this.nombre = CLIMA_NEVADO;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);

    }
}
