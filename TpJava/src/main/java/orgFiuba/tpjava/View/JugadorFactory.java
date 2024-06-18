package orgFiuba.tpjava.View;

import orgFiuba.tpjava.Model.Jugador;

public class JugadorFactory {

    public JugadorView createJugadorView(Jugador jugador){
        return new JugadorView(jugador);
    }
}
