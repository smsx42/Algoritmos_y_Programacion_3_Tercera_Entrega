package orgFiuba.tpjava.Model.Opciones;

import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.View.GeneralView;

public interface Opcion {

    void aplicarOpcion(Jugador jugador, GeneralView generalView);

}
