package orgFiuba.tpjava.View.PokemonesView;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadEstadistica;

import static orgFiuba.tpjava.Constantes.*;

public class HabilidadEstadisticaView extends HabilidadView{

    private HabilidadEstadistica habilidadEstadistica;

    public HabilidadEstadisticaView(HabilidadEstadistica habilidadEstadistica) {

        super(habilidadEstadistica);
        this.habilidadEstadistica = habilidadEstadistica;
    }

    public void mostrar(){
        System.out.println("Nombre: " + ANSI_GRISCLARO + this.habilidadEstadistica.getNombre() + ANSI_RESET);
        System.out.println("Modifica: " + ANSI_GRISCLARO + this.habilidadEstadistica.obtenerNombreModificacion() + ANSI_RESET);
        System.out.println("Cuantas Etapas: " + ANSI_GRISCLARO +this.habilidadEstadistica.getEtapas() + ANSI_RESET);
        System.out.println("Cantidad de usos: "  + ANSI_GRISCLARO + this.habilidadEstadistica.getCantidadDeUsos() + ANSI_RESET);
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){

        if(!this.habilidadEstadistica.isModificacionPropia()){
            System.out.println(ANSI_GRISCLARO + "Se redujo la " + this.habilidadEstadistica.obtenerNombreModificacion() + " rival en " +
                    this.habilidadEstadistica.getEtapas() * PORCENTAJE * 100 + "%" + ANSI_RESET);
        } else {
            //this.unaModificacion.modificar(cualidadesPokemonEnemigo,this.etapas);
            System.out.println(ANSI_GRISCLARO + "Se aumento la " + this.habilidadEstadistica.obtenerNombreModificacion() + " propia en " +
                    this.habilidadEstadistica.getEtapas() * PORCENTAJE * 100 + "%" + ANSI_RESET);

        }

    }
}
