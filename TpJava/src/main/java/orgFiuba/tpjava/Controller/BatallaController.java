package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Controller.Eventos.AtaqueSeleccionadoEvent;
import orgFiuba.tpjava.Controller.Eventos.MenuCambiarPokemonEvent;
import orgFiuba.tpjava.Controller.Eventos.MenuItemEvent;
import orgFiuba.tpjava.Controller.Eventos.RendirseEvent;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.FileNotFoundException;
import java.util.*;

public class BatallaController {

    @FXML
    VBox pantalla;
    @FXML
    ImageView climaOverlay;
    @FXML
    StackPane stackPaneFondo;
    @FXML
    HBox pokemones;
    @FXML
    VBox pokemonJ1Box;
    @FXML
    VBox pokemonJ1Stats;
    @FXML
    ProgressBar pokemonJ1HP;
    @FXML
    Text pokemonJ1StatsText;
    @FXML
    HBox pokemonJ1ViewBox;
    @FXML
    ImageView pokemonJ1View;
    @FXML
    VBox pokemonJ2Box;
    @FXML
    HBox pokemonJ2ViewBox;
    @FXML
    ImageView pokemonJ2View;
    @FXML
    VBox pokemonJ2Stats;
    @FXML
    ProgressBar pokemonJ2HP;
    @FXML
    Text pokemonJ2StatsText;
    @FXML
    HBox dialogoYMenuBox;
    @FXML
    VBox dialogoBox;
    @FXML
    Text dialogo;
    @FXML
    VBox ataquesBox;
    @FXML
    GridPane menuGrid;
    @FXML
    Button atacarButton;
    @FXML
    Button pokemonButton;
    @FXML
    Button itemButton;
    @FXML
    Button rendirseButton;
    @FXML
    HBox pokeballs1;
    @FXML
    HBox pokeballs2;
    private JuegoController juegoController;
    private List<String> mensajes;
    //private Set<String> mensajes;


    public void inicializar(Juego juego, JuegoController juegoController){

        this.juegoController = juegoController;
        this.juegoController.setBatallaController(this);
        this.mensajes = new ArrayList<>();
        this.mensajes.add("Comienza la batalla!");
        //this.mensajes = new HashSet<>();
        this.crearVentanaBatalla(juego);
    }

    public void crearVentanaBatalla(Juego juego) {

        this.mostrarMensaje("Es el turno de " + juego.getJugadorActual().getNombre() + "!");
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        String clima = juego.getClimaActual().getNombre();
        this.mostrarMensaje("El clima es " + clima);

        this.climaOverlay.setImage(pokemonResourceFactory.createClimaOverlay(clima));
        // Bind the dimensions of the ImageView to the dimensions of the StackPane
        this.climaOverlay.fitWidthProperty().bind(this.stackPaneFondo.widthProperty());
        this.climaOverlay.fitHeightProperty().bind(this.stackPaneFondo.heightProperty());

        this.dibujarPokeballs(juego.getJugadorActual(),pokeballs1,pokemonResourceFactory);
        this.dibujarPokeballs(juego.getJugadorActual().getAdversario(),pokeballs2,pokemonResourceFactory);

        pokemonResourceFactory.dibujarHPBar(juego.getJugadorActual().getPokemonActual(), this.pokemonJ1HP);
        pokemonResourceFactory.dibujarHPBar(juego.getJugadorActual().getAdversario().getPokemonActual(), this.pokemonJ2HP);

        this.pokemonJ2StatsText.setText(pokemonResourceFactory.createBatallaStats(juego.getJugadorActual().getAdversario().getPokemonActual()));
        this.pokemonJ1StatsText.setText(pokemonResourceFactory.createBatallaStats(juego.getJugadorActual().getPokemonActual()));

        this.pokemonJ1View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugadorActual().getPokemonActual(), "Espalda").getImage());
        this.pokemonJ1View.setFitHeight(this.pokemonJ1View.getImage().getHeight()*3);
        this.pokemonJ1View.setFitWidth(this.pokemonJ1View.getImage().getWidth()*3);
        this.pokemonJ2View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugadorActual().getAdversario().getPokemonActual(), "Frente").getImage());
        this.pokemonJ2View.setFitHeight(this.pokemonJ2View.getImage().getHeight()*3);
        this.pokemonJ2View.setFitWidth(this.pokemonJ2View.getImage().getWidth()*3);

        this.atacarButton.setOnAction(event -> {
            this.ataquesBox.getChildren().clear();
            crearMenuAtaques(juego.getJugadorActual().getPokemonActual());
        });

        this.itemButton.setOnAction(event -> {
            this.ataquesBox.getChildren().clear();
            crearMenuItem(juego.getJugadorActual());
        });

        this.pokemonButton.setOnAction(event -> {
            this.ataquesBox.getChildren().clear();
            this.juegoController.handle(new MenuCambiarPokemonEvent(juego.getJugadorActual()));
        });

        this.rendirseButton.setOnAction(event -> {
            if (showConfirmationDialog()) {
                this.juegoController.handle(new RendirseEvent(juego.getJugadorActual()));
            }
        });
    }

    private void crearMenuItem(Jugador jugadorActual) {
        this.ataquesBox.getChildren().clear();
        juegoController.handle(new MenuItemEvent(jugadorActual));
    }

    public void crearMenuAtaques(Pokemon pokemon) {
        GridPane ataques = new GridPane();

        List<Habilidad> habilidades = new ArrayList<>(pokemon.getMisHabilidades().values());
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Habilidad habilidad = habilidades.get(index);
                Pane ataque = pokemonResourceFactory.generarBotonHabilidad(habilidad);
                ataque.setOnMouseClicked(event -> this.juegoController.handle(new AtaqueSeleccionadoEvent(habilidad, pokemon)));
                ataques.add(ataque, j, i);
                index++;
            }
        }
        this.ataquesBox.getChildren().add(ataques);
    }

    public void actualizarVista(Juego juego) {
        this.pokeballs1.getChildren().clear();
        this.pokeballs2.getChildren().clear();
        this.ataquesBox.getChildren().clear();
        this.crearVentanaBatalla(juego);
    }

    public void mostrarMensaje(String mensaje) {
        StringBuilder concatenado = new StringBuilder();

        if (this.mensajes.size() <= 2) {
            this.mensajes.add(mensaje);
        } else if (!Objects.equals(mensaje, mensajes.get(mensajes.size() - 1)) && !Objects.equals(mensaje, mensajes.get(mensajes.size() - 2))) {
            this.mensajes.add(mensaje);

            if (this.mensajes.size() > 4)
                this.mensajes.remove(0);
        }
        for (String mensajeActual : this.mensajes) {
                concatenado.append(mensajeActual).append("\n\n");
        }
        this.dialogo.setText(concatenado.toString());
    }



    public void dibujarPokeballs(Jugador unJugador, HBox pokeballs, PokemonResourceFactory resourceFactory){
        Map<String,Pokemon> pokemons;
        pokemons = unJugador.getMisPokemones();
        pokemons.forEach((x,v) -> pokeballs.getChildren().add(resourceFactory.getPokeball(v)));
    }

    private boolean showConfirmationDialog() {
        // Create confirmation dialog
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Confirmation");
        dialog.setHeaderText("Querés rendirte?");

        // Add buttons to the dialog
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

        // Show the dialog and wait for user input
        Optional<ButtonType> result = dialog.showAndWait();

        // Return true if the user clicked "Yes", false otherwise
        return result.isPresent() && result.get() == ButtonType.YES;
    }
}
