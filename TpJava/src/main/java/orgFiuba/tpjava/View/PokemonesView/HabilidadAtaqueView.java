package orgFiuba.tpjava.View.PokemonesView;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadAtaque;

import static orgFiuba.tpjava.Constantes.ANSI_GRISCLARO;
import static orgFiuba.tpjava.Constantes.ANSI_RESET;

public class HabilidadAtaqueView extends HabilidadView{

    HabilidadAtaque habilidadAtaque;

    public HabilidadAtaqueView(HabilidadAtaque habilidadAtaque){
        super(habilidadAtaque);
        this.habilidadAtaque = habilidadAtaque;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + ANSI_GRISCLARO + this.habilidadAtaque.getNombre() + ANSI_RESET);
        System.out.println("Tipo: " + this.habilidadAtaque.getTipo().getNombreConColor());
        System.out.println("Poder: " + ANSI_GRISCLARO +  this.habilidadAtaque.getPoder() + ANSI_RESET);
        System.out.println("Cantidad de usos: " +  ANSI_GRISCLARO +  this.habilidadAtaque.getCantidadDeUsos() + ANSI_RESET);
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){
        double danio = this.habilidadAtaque.getDanioRealizado();
        System.out.println(ANSI_GRISCLARO + "El daño infligido de la habiilidad: "+this.habilidadAtaque.getNombre() +" es = " + danio + ANSI_RESET);

    }
}
