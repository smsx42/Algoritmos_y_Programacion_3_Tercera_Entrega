package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;

public class MenuCambiarPokemonEvent extends Event {

    public static final EventType<MenuCambiarPokemonEvent> CAMBIAR_POKEMON_EVENT = new EventType<>("Cambiar Pokemon Event");
    private final Jugador jugador;

    public MenuCambiarPokemonEvent(Jugador jugador) {
        super(CAMBIAR_POKEMON_EVENT);
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
