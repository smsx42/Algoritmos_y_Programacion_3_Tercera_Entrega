package orgFiuba.tpjava.Model.Opciones;

import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.ServicioDeUserInput;
import orgFiuba.tpjava.View.GeneralView;

public class OpcionVerCampoDeBatalla implements Opcion{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeCampoBatalla();
        ServicioDeUserInput.input();
    }
}
