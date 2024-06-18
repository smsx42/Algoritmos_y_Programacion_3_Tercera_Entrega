package orgFiuba.tpjava.Model.Opciones;

import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.View.GeneralView;

public class OpcionRendirse implements Opcion{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView) {

        generalView.mostrarMensajeRendirse();

        jugador.setAtacante(false);
        jugador.perder();
    }
}
