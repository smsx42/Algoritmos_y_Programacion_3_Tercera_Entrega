package orgFiuba.tpjava.View;

import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.View.ItemsView.ItemView;
import orgFiuba.tpjava.View.ItemsView.ItemViewFactory;
import orgFiuba.tpjava.View.PokemonesView.PokemonFactory;
import orgFiuba.tpjava.View.PokemonesView.PokemonView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static orgFiuba.tpjava.Constantes.*;

public class JugadorView {

    private String nombre;

    private Map<String, ItemView> itemsView;

    private Map<String, PokemonView> misPokemonesView;

    private PokemonView pokemonActualView;

    private ItemViewFactory itemFactory;

    private PokemonFactory pokemonFactory;

    private JugadorFactory jugadorFactory;
    private JugadorView jugadorAdversarioView;

    public JugadorView(Jugador jugador){
        this.pokemonFactory = new PokemonFactory();
        this.jugadorFactory = new JugadorFactory();
        this.nombre = jugador.getNombre();
        this.itemsView = new HashMap<String, ItemView>();
        itemFactory = new ItemViewFactory();
        jugador.getItems().forEach((k, v) -> itemsView.put(k, itemFactory.createItemView(v)));
        this.misPokemonesView = new HashMap<String, PokemonView>();
        pokemonFactory = new PokemonFactory();
        jugador.getMisPokemones().forEach((k, v) -> misPokemonesView.put(k, pokemonFactory.createPokemonView(v)));
    }

    public void setPokemonActualView(Pokemon pokemon) {
        this.pokemonActualView = this.pokemonFactory.createPokemonView(pokemon);
    }

    public void setJugadorAdversarioView(Jugador jugadorAversario){
        this.jugadorAdversarioView = this.jugadorFactory.createJugadorView(jugadorAversario);
    }

    public String getNombre() {
        return nombre;
    }

    public JugadorView getJugadorAdversarioView() {
        return jugadorAdversarioView;
    }

    public String getNombreJugadorAdversarioView() {
        return jugadorAdversarioView.getNombre();
    }

    public PokemonView getPokemonActualView() {
        return pokemonActualView;
    }

    public void mostrarPokemones() {

        System.out.println(ANSI_GRISCLARO + "POKEMONES DE " + this.nombre.toUpperCase() + "." + ANSI_RESET);
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        System.out.println("\n");
        misPokemonesView.forEach((k, v) -> v.mostrar());
        System.out.println(ANSI_VERDE + "---------------------------------------------------------------------------------------------------" + ANSI_RESET);
    }
    public void mostrarPokemonActual(){
        System.out.println(ANSI_GRISCLARO + " POKEMON ACTUAL DE  " + this.nombre.toUpperCase() + ANSI_RESET);
        pokemonActualView.mostrar();
    }

    public void mostratItems(){

        System.out.println(ANSI_VERDE + "-----------------------------------------------------------------" + ANSI_RESET);
        System.out.println("Items de " + this.nombre);
        itemsView.forEach((k, v) -> v.mostrar());
        System.out.println(ANSI_VERDE + "-----------------------------------------------------------------" + ANSI_RESET);


    }

    public void mostratHabilidadesPokemonActual() {
        System.out.println(ANSI_VERDE+ "Las habilidades de " + pokemonActualView.getNombre() + " actuales son: " + ANSI_RESET);
        pokemonActualView.mostrarHabilidades();
    }


    public void mostrarSeSeleccionoUnPokemon(String nombrePokemon){
        System.out.println(ANSI_VERDE + "Seleccionaste el pokemon -> " + nombrePokemon + "\n" + ANSI_RESET);
    }

    public void mostrarCasosDeEleccion(String nombrePokemon, Pokemon pokemonActual, Map<String, Pokemon> misPokemones){

        if (misPokemones.get(nombrePokemon) == null) {
            System.out.println(ANSI_ROJO + "ERROR: NO SE ENCONTRO EL POKEMON EN LA MOCHILA.\n" + ANSI_RESET);
            return;
        }
        else if (misPokemones.get(nombrePokemon).getCualidades(). getVida() == 0) {
            System.out.println(ANSI_ROJO +"ERROR: EL POKEMON NO TIENE VIDA \n" + ANSI_RESET);
            return;
        }
        else if(pokemonActual != null){
            if(Objects.equals(nombrePokemon, pokemonActual.getNombre())) {
                System.out.println(ANSI_ROJO +"ERROR: ESTAS ELIGIENDO A TU POKEMON ACTUAL\n " + ANSI_RESET);
                return;
            }
        }
        this.mostrarSeSeleccionoUnPokemon(nombrePokemon);

    }

    public String getNombrePokemonActual() {
        return this.pokemonActualView.getNombre();
    }

    public boolean mostrarCasosDeApliacionItem(Item item){
        if (item.getCantidad() == 0) {
            System.out.println(ANSI_ROJO + "No tiene este tipo de items" + "\n" + ANSI_RESET);
            return false;
        }
        else{
            System.out.print(ANSI_VERDE + "Acaba de seleccionar el siguiente Item: " + item.getNombre() + "\n" + ANSI_RESET);
        }

        return true;
    }
}