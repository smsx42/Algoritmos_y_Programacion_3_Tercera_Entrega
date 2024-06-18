package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class AtaqueSeleccionadoEvent extends Event {

    public static final EventType<AtaqueSeleccionadoEvent> ATAQUE_SELECCIONADO_EVENT = new EventType<>("Ataque seleccionado Event");
    private final Habilidad habilidad;
    private final Pokemon pokemon;

    public AtaqueSeleccionadoEvent(Habilidad habilidad, Pokemon pokemon) {
        super(ATAQUE_SELECCIONADO_EVENT);
        this.habilidad = habilidad;
        this.pokemon = pokemon;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public boolean sePuedeUsar() {
        return this.habilidad.getCantidadDeUsos()>0;
    }

    public String getNombreHabilidad() {
        return this.habilidad.getNombre();
    }
}
