package orgFiuba.tpjava.Model.Estados;

import orgFiuba.tpjava.Model.ServicioDeRandoms;

import static orgFiuba.tpjava.Constantes.*;

public class EstadoParalizado extends Estado{

    private int numeroRandom;
    public EstadoParalizado() {
        this.nombre = ESTADO_PARALIZADO;
        this.color = ANSI_FONDO_AMARILLO + ANSI_NEGRO;
    }

    public int getNumeroRandom() {
        return numeroRandom;
    }

    @Override
    public boolean puedeAtacar() {
        this.numeroRandom = (int) (ServicioDeRandoms.obtenerRandomParaEstadoPuedeAtacar() +1);
        return this.numeroRandom > 50;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado() {
    }
}
