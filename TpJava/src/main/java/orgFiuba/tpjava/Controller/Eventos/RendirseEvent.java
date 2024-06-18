package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;

public class RendirseEvent extends Event {

    public static final EventType<RendirseEvent> RENDIRSE_EVENT = new EventType<>("Rendirse Event");
    private final Jugador jugador;

    public RendirseEvent(Jugador jugador) {
        super(RENDIRSE_EVENT);
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
