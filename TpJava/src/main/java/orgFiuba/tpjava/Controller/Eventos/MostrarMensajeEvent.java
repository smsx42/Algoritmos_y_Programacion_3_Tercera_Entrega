package orgFiuba.tpjava.Controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;

public class MostrarMensajeEvent extends Event {

    public static final EventType<MostrarMensajeEvent> MOSTRAR_MENSAJE_EVENT = new EventType<>("Mostrar MensajeE vent");
    private final String mensaje;

    public MostrarMensajeEvent(String mensaje) {
        super(MOSTRAR_MENSAJE_EVENT);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
