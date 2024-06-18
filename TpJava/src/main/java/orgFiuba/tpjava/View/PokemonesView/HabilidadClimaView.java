package orgFiuba.tpjava.View.PokemonesView;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadClima;

import static orgFiuba.tpjava.Constantes.ANSI_GRISCLARO;
import static orgFiuba.tpjava.Constantes.ANSI_RESET;

public class HabilidadClimaView extends HabilidadView{

    HabilidadClima habilidadClima;

    public HabilidadClimaView(HabilidadClima habilidadClima) {
        super(habilidadClima);
        this.habilidadClima = habilidadClima;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + ANSI_GRISCLARO + this.habilidadClima.getNombre() + ANSI_RESET);
        System.out.println("Clima: " +  ANSI_GRISCLARO + this.habilidadClima.getClimaNombre() + ANSI_RESET);
        System.out.println("Cantidad de usos: " + ANSI_GRISCLARO + this.habilidadClima.getCantidadDeUsos() + ANSI_RESET);
        System.out.println("\n");
    }

    @Override
    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo) {
        System.out.println( ANSI_GRISCLARO + "El clima actual es: " + this.habilidadClima.getClimaNombre() + ANSI_RESET);
    }
}
