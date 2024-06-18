package orgFiuba.tpjava.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import orgFiuba.tpjava.Controller.Eventos.JugadorNombradoEvent;
import orgFiuba.tpjava.Model.Jugador;

public class SeleccionarNombreJugadoresController {

    public TextField nombreJugador;
    private JuegoController juegoController;

    private Jugador jugador;

    public void inicializador(Jugador jugador, JuegoController juegoController){
        this.jugador = jugador;
        this.juegoController = juegoController;
    }

    public void siguienteVentana(ActionEvent event) {

        String nombre = this.nombreJugador.getText();
        //System.out.println(nombre);
        if(nombre.isEmpty()){
            PantallaInformacion.mostrarInformacion("No hay caracteres ingresados.");
        }
        else if(nombre.length() > 50){
            PantallaInformacion.mostrarInformacion("Hay mas de 50 caracteres en el nombre.");
        }
        else{
            this.jugador.setNombre(nombre);
            this.juegoController.handle(new JugadorNombradoEvent());
        }
    }
}
