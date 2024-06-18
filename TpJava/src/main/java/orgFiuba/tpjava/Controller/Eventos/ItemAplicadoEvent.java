package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Controller.Eventos.CambioDeTurnoEvent;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class ItemAplicadoEvent extends Event {
    private final Jugador jugador;
    private final Item item;

    private final Pokemon pokemon;
    public static final EventType<CambioDeTurnoEvent> ITEM_APLICADO_EVENT = new EventType<>("Item Aplicado Event");

    public ItemAplicadoEvent(Jugador jugador, Item item, Pokemon pokemon) {
        super(ITEM_APLICADO_EVENT);
        this.item = item;
        this.jugador = jugador;
        this.pokemon = pokemon;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Item getItem() {
        return item;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}

