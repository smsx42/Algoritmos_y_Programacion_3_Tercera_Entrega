package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.Controller.Eventos.ItemAplicadoEvent;
import orgFiuba.tpjava.Controller.Eventos.PokemonSeleccionadoEvent;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static orgFiuba.tpjava.Constantes.ESTADO_NORMAL;

public class SeleccionarPokemonController {

    @FXML
    public HashMap<String, ImageView> pokemonMenuViews;

    public List<Pokemon> pokemones;
    private Jugador jugador;
    private JuegoController juegoController;
    private Item itemAplicar;
    @FXML
    private Label afirmador;
    @FXML
    public GridPane gridPanePokemones;

    public void inicializar(Jugador jugador, JuegoController juegoController) {

        juegoController.setSeleccionarPokemonController(this);
        this.juegoController = juegoController;
        this.crearVentanaSeleccionarPokemon(jugador);
    }

    public void actualizarVista(Jugador jugador) {
        try {
            gridPanePokemones.getChildren().clear();
        } catch (Exception ignored) {}

        this.itemAplicar = null;
        this.crearVentanaSeleccionarPokemon(jugador);
    }

    public void actualizarVistaAplicarItem(Jugador jugador, Item itemAplicar) {

        try {
            gridPanePokemones.getChildren().clear();
        } catch (Exception ignored) {}

        this.itemAplicar = itemAplicar;
        this.crearVentanaSeleccionarPokemon(jugador);
    }

    public void crearVentanaSeleccionarPokemon(Jugador jugador) {

        this.jugador = jugador;
        this.pokemonMenuViews = new HashMap<>();
        this.pokemones = new ArrayList<>();
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        this.jugador.getMisPokemones().forEach((k, v) -> pokemones.add(v));

        HBox pokemonView;
        VBox pokemonStats;
        VBox pokemonIconoYNombre;
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 2; col++) {

                pokemonView = new HBox();
                pokemonStats = new VBox();
                pokemonIconoYNombre = new VBox();

                pokemonIconoYNombre.getChildren().add(pokemonResourceFactory.createPokemonMenuView(pokemones.get(index), pokemones.get(index).estaConsciente()));
                pokemonIconoYNombre.getChildren().add(pokemonResourceFactory.createPokemonName(pokemones.get(index)));

                pokemonStats.getChildren().add(pokemonResourceFactory.createPokemonStats(pokemones.get(index)));

                pokemonView.getChildren().add(pokemonIconoYNombre);
                pokemonView.getChildren().add(pokemonStats);

                if(this.itemAplicar == null){
                    if(pokemones.get(index).estaConsciente()){
                        pokemonView.setOnMouseClicked(createImageViewClickHandler(this.juegoController, this.jugador, pokemones.get(index)));
                    }
                }else{
                    pokemonView.setOnMouseClicked(createImageViewClickHandlerItemAplicar(this.juegoController, this.jugador, pokemones.get(index), this.itemAplicar));
                }

                this.gridPanePokemones.add(pokemonView, col, row);
                index++;
            }
        }
    }

    private EventHandler<? super MouseEvent> createImageViewClickHandlerItemAplicar(JuegoController juegoController, Jugador jugador, Pokemon pokemon, Item itemAplicar) {
        return event -> {
            if(pokemon.getCualidades().getVida() == 0 && !Objects.equals(itemAplicar.getNombre(), "Revivir")) {
                PantallaInformacion.mostrarInformacion("El Pokemon no tiene vida, no se puede usar este item.");
            }
            else if((pokemon.getCualidades().getVida() == pokemon.getCualidades().getVidaMaxima() && itemAplicar.getUnaModificacion().getClass() == ModificacionVida.class)){
                PantallaInformacion.mostrarInformacion("El Pokemon tiene toda la vida, no se puede curar.");
            }
            else if(pokemon.getCualidades().estaConsciente() && Objects.equals(itemAplicar.getNombre(), "Revivir")){
                PantallaInformacion.mostrarInformacion("El Pokemon esta consciente, no se puede revivir.");
            }
            else if(itemAplicar.getNombre().equals("Cura Todo") && pokemon.getCualidades().obtenerEstadosActuales().stream().anyMatch(unEstado -> unEstado.getNombre().equals(ESTADO_NORMAL) && pokemon.getCualidades().obtenerEstadosActuales().size() == 1)){
                PantallaInformacion.mostrarInformacion("El Pokemon esta normal, no se puede aplicar un Cura Todo.");
            }

            else{
                jugador.elegirItem(itemAplicar.getNombre()).aplicarItem(pokemon.getCualidades());
                juegoController.handle(new ItemAplicadoEvent(jugador, itemAplicar, pokemon));
            }
        };
    }

    // Create an event handler for ImageView click events
    private EventHandler<MouseEvent> createImageViewClickHandler(JuegoController juegoController, Jugador jugador, Pokemon pokemon) {
        return event -> {
            if(pokemon.getCualidades().getVida() == 0) {
                PantallaInformacion.mostrarInformacion("El Pokemon no tiene vida, no se puede elegir.");
            }else if(jugador.getPokemonActual() == pokemon){
                PantallaInformacion.mostrarInformacion("No se puede seleccionar al Pokemon actual.");
            } else{
                Boolean pokemonAnteriorMurio = false;
                try {
                    pokemonAnteriorMurio = !jugador.getPokemonActual().estaConsciente();
                } catch (NullPointerException ignored) {}
                juegoController.handle(new PokemonSeleccionadoEvent(jugador, pokemon, pokemonAnteriorMurio));
            }
        };
    }

    @FXML
    private void volverMenu(){

        this.afirmador.setText("");
        if(this.jugador.getPokemonActual() == null) {
            PantallaInformacion.mostrarInformacion("No tiene seleccionado a ningun Pokemon Inicial.");
        } else if (!this.jugador.getPokemonActual().estaConsciente()) {
            PantallaInformacion.mostrarInformacion("Tiene que seleccionar un Pokemon para pelear.");
        } else {
            juegoController.volverMenu();
        }
    }
}