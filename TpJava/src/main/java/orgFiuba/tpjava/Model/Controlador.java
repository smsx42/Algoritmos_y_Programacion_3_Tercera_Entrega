package orgFiuba.tpjava.Model;

import orgFiuba.tpjava.Model.Opciones.*;
import orgFiuba.tpjava.View.GeneralView;
import orgFiuba.tpjava.View.JugadorView;

import java.util.HashMap;
import java.util.Map;
import static orgFiuba.tpjava.Constantes.*;

public class Controlador {

    Map<String, Opcion> opciones;

    //Metodos:

    public Controlador(){
        this.inicializarOpciones();
    }


    public void inicializarOpciones(){

        opciones = new HashMap<>();
        opciones.put(OPCION_UNO, new OpcionRendirse());
        opciones.put(OPCION_DOS, new OpcionVerCampoDeBatalla());
        opciones.put(OPCION_TRES, new OpcionIntercambiarPokemon());
        opciones.put(OPCION_CUATRO, new OpcionAplicarItem());
        opciones.put(OPCION_CINCO, new OpcionAtacar());
    }

    private void mensajeNombreJugador() {

        System.out.println("\n");
        System.out.println(ANSI_VERDE + "╔════════════════════╗");
                     System.out.println("║ Eleccion de nombre ║ ");
                     System.out.println("╚════════════════════╝" + ANSI_RESET);
        System.out.println("\n");
    }

    public void validarNombresJugador(Jugador jugador) {

        boolean nombreValido = false;

        while (!nombreValido) {
            mensajeNombreJugador();
            System.out.println(ANSI_VERDEOSCURO + "Ingrese el nombre del jugador: " + ANSI_RESET);
            String nombreJugador = ServicioDeUserInput.input();

            if (nombreJugador.length() < LIMITE_CARACTERES) {
                mensajeNombreJugador();
                jugador.setNombre(nombreJugador);
                nombreValido = true;
                System.out.println(ANSI_VERDE + "BIENVENIDO AL JUEGO " + nombreJugador.toUpperCase() + ANSI_RESET);
            } else {
                mensajeNombreJugador();
                System.out.println("\n");
                System.out.println(ANSI_ROJO + "ERROR: EL NOMBRE TIENE MAS DE 50 CARACTERES. " + ANSI_RESET);
            }
        }
    }

    public void seleccionarPokemon(Jugador jugador, JugadorView jugadorView) {

        boolean pokemonValido = false;
        while (!pokemonValido) {

            jugadorView.mostrarPokemones();
            System.out.println(ANSI_VERDEOSCURO + "Seleccione a un Pokemon: " + ANSI_RESET);
            String nombrePokemon = ServicioDeUserInput.input();
            jugadorView.mostrarCasosDeEleccion(nombrePokemon, jugador.getPokemonActual(), jugador.getMisPokemones());
            pokemonValido = jugador.elegirPokemon(nombrePokemon);

        }
        jugadorView.setPokemonActualView(jugador.getPokemonActual());
    }

    public void opcionesJugadores(Jugador jugador, GeneralView generalView) {

        String decision;

        if(!jugador.verficarEstadoPokemonActual()){

            this.seleccionarPokemon(jugador, generalView.getJugadorView());
        }

        while (jugador.isAtacante()) {
            generalView.mostrarMensajeMenu();
            decision = ServicioDeUserInput.input();
            if(opciones.containsKey(decision)){
                opciones.get(decision).aplicarOpcion(jugador, generalView);
            }else{
                generalView.mostrarMensajeOpcionInvalida();
            }
        }
    }
}
