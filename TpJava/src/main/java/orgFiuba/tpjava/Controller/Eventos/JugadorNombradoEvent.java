package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;

public class JugadorNombradoEvent extends Event {

    public static final EventType<JugadorNombradoEvent> JUGADOR_NOMBRADO_EVENT = new EventType<>("Jugador Nombrado Event");

    public JugadorNombradoEvent() {
        super(JUGADOR_NOMBRADO_EVENT);
    }
}
