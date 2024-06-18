package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonSeleccionadoEvent extends Event {

    public static final EventType<PokemonSeleccionadoEvent> POKEMON_SELECCIONADO_EVENT = new EventType<>("Pokemon seleccionado Event");
    private final Pokemon pokemon;
    private final Jugador jugador;
    private final boolean pokemonAnteriorMurio;

    public PokemonSeleccionadoEvent(Jugador jugador, Pokemon pokemon){
       super(POKEMON_SELECCIONADO_EVENT);
       this.jugador = jugador;
       this.pokemon = pokemon;
       this.pokemonAnteriorMurio = false;
   }

   public PokemonSeleccionadoEvent(Jugador jugador, Pokemon pokemon, boolean pokemonAnteriorMurio) {
       super(POKEMON_SELECCIONADO_EVENT);
       this.jugador = jugador;
       this.pokemon = pokemon;
       this.pokemonAnteriorMurio = pokemonAnteriorMurio;
   }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean pokemonAnteriorMurio() {
        return pokemonAnteriorMurio;
    }
}
