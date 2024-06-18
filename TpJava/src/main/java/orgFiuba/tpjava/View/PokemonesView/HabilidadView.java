package orgFiuba.tpjava.View.PokemonesView;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;

public abstract class HabilidadView {

    Habilidad habilidad;

    public HabilidadView(Habilidad habilidad){
        this.habilidad = habilidad;

    }

    public abstract void mostrar();


    public abstract void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo);
}
