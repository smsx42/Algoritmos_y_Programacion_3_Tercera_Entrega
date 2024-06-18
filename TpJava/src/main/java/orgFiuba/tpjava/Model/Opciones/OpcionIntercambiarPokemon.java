package orgFiuba.tpjava.Model.Opciones;

import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.ServicioDeUserInput;
import orgFiuba.tpjava.View.GeneralView;
import orgFiuba.tpjava.View.JugadorView;

import java.util.Objects;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_VERDEOSCURO;


public class OpcionIntercambiarPokemon implements Opcion{

    private boolean validarPokemon(Jugador jugador, JugadorView jugadorView){

        String nombrePokemon = ServicioDeUserInput.input();
        jugadorView.mostrarCasosDeEleccion(nombrePokemon, jugador.getPokemonActual(), jugador.getMisPokemones());
        return jugador.elegirPokemon(nombrePokemon);
    }

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeIntercambiarPokemon();
        Pokemon pokemonAuxliar = jugador.getPokemonActual();
        if(validarPokemon(jugador, generalView.getJugadorView())){
            System.out.println(ANSI_VERDEOSCURO + "Desea Realizar el cambio? Si - No:" + ANSI_RESET);

            String decision = ServicioDeUserInput.input();

            if (Objects.equals(decision.toLowerCase(), "si")) {
                generalView.mostrarMensajeIntercambioAlAdversario();
                jugador.setAtacante(false);

            } else {
                jugador.setPokemonActual(pokemonAuxliar);
                generalView.mostrarMensajeNoSeRealizoIntercambio();

            }
            //decision = ServicioDeUserInput.input();
        }
    }
}