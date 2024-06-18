package orgFiuba.tpjava.View.PokemonesView;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadEstado;

import static orgFiuba.tpjava.Constantes.*;

public class   HabilidadEstadoView extends HabilidadView{

    private final HabilidadEstado habilidadEstado;

    public HabilidadEstadoView(HabilidadEstado habilidadEstado){
        super(habilidadEstado);
        this.habilidadEstado = habilidadEstado;
    }

    public void mostrar(){
        System.out.println("Nombre: " + ANSI_GRISCLARO + habilidadEstado.getNombre() + ANSI_RESET);
        System.out.println("Estado: " + habilidadEstado.getEstado().getNombreConColor());
        System.out.println("Cantidad de usos: " + ANSI_GRISCLARO +habilidadEstado.getCantidadDeUsos() + ANSI_RESET);
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){

        System.out.println(ANSI_GRISCLARO + "La habilidad " + this.habilidadEstado.getNombre() + " aplica el estado " +  habilidadEstado.getEstado().getNombreConColor() + ANSI_RESET);

    }
}
