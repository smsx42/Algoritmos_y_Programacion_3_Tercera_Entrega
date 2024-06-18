package orgFiuba.tpjava.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import orgFiuba.tpjava.Controller.Eventos.*;
import orgFiuba.tpjava.Model.Climas.SistemaDeClima;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.*;

public class JuegoController extends Parent implements EventHandler<Event> {
    @FXML
    private Label welcomeText;
    @FXML
    private Stage stage;
    private Juego juego;
    @FXML
    private MediaPlayer musicPlayer;
    @FXML
    private MediaPlayer soundEffectPlayer;
    private Map<String, Scene> escenas;
    private BatallaController batallaController;
    private SeleccionarPokemonController seleccionarPokemonController;
    private SeleccionarItemController seleccionarItemController;
    private boolean esPrimerTurno;

    public void inicializar(Stage stage, Juego juego) throws IOException {
        this.stage = stage;
        this.stage.setResizable(false);
        this.juego = juego;
        this.juego.setJugadorActual(this.juego.getJugador1());
        this.esPrimerTurno = true;
        this.inicializarEscenas();
        this.reproducirMusica(RUTA_SOUNDTRACK_INICIO);
        this.stage.show();
    }

    private void inicializarEscenas() throws IOException {
        SceneFactory sceneFactory = new SceneFactory();
        this.escenas = sceneFactory.createScenesIniciales(this.juego, this);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("");
        this.crearVentanaSeleccionNombre(1);
    }

    private void elegirJugadorInicial() {

        if (this.esPrimerTurno) {
            if (this.juego.getJugador1().getPokemonActual().getCualidades().getVelocidad() > this.juego.getJugador2().getPokemonActual().getCualidades().getVelocidad()) {
                this.juego.getJugador1().setAtacante(true);
                this.juego.getJugador2().setAtacante(false);
                this.juego.setJugadorActual(this.juego.getJugador1());
            } else {
                this.juego.getJugador1().setAtacante(false);
                this.juego.getJugador2().setAtacante(true);
                this.juego.setJugadorActual(this.juego.getJugador2());
            }
            this.esPrimerTurno = false;
        }
    }

    private void mostrarPantallaFinDeJuego(Jugador jugadorActual) {

        this.reproducirMusica(RUTA_SOUNDTRACK_VICTORIA);
        Alert alert  = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("FIN DEL JUEGO");
        alert.setContentText(jugadorActual.getNombre() + " es el ganador!!!");
        alert.showAndWait();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(RUTA_RESUMEN_PARTIDA), this.juego);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cicloDeTurnos() {
        if (!this.juego.getJugadorActual().perdio() && !this.juego.getJugadorActual().getAdversario().perdio()){

            this.turno(this.juego.getJugadorActual());
        }
        else if(this.juego.getJugadorActual().perdio()){
            mostrarPantallaFinDeJuego(this.juego.getJugadorActual().getAdversario());
            this.stage.close();
        } else {
            mostrarPantallaFinDeJuego(this.juego.getJugadorActual());
            this.stage.close();
        }
    }

    public void turno(Jugador jugador) {

        jugador.aplicarEfectoPasivo();
        SistemaDeClima.aplicarClimaActual(jugador.getPokemonActual());
        if (!jugador.getPokemonActual().estaConsciente()) {
            this.seleccionarPokemonController.actualizarVista(jugador);
            this.stage.setScene(this.escenas.get("sceneSeleccionPokemon"));
        } else if (jugador.perdio()) {
            mostrarPantallaFinDeJuego(jugador.getAdversario());
        } else try {
            this.mostrarVentanaBatalla();
        } catch (NullPointerException e) {
            this.crearVentanaBatalla();
        }
    }

    private void crearVentanaBatalla() {

            this.reproducirMusica(RUTA_SOUNDTRACK_BATALLA);

            SceneFactory sceneFactory = new SceneFactory();
            try {
                this.escenas.put("sceneBatalla", sceneFactory.crearEscenaBatalla(this.juego, this));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mostrarVentanaBatalla();
    }

    private void mostrarVentanaBatalla() {
        this.batallaController.actualizarVista(this.juego);
        this.stage.setScene(this.escenas.get("sceneBatalla"));
        this.stage.setTitle("Batalla Pokemon");
        this.stage.show();
    }

    public void crearVentanaSeleccionNombre(int numero) {

        this.stage.setScene(this.escenas.get("sceneSeleccionNombreJugador" + numero));
        this.stage.setTitle("Escriba el Nombre del Jugador " + numero);
        this.stage.show();
    }

    public void crearVentanaSeleccionarItem(Jugador jugador) {

        try {
            this.seleccionarItemController.actualizarVista(jugador);
            this.stage.setScene(this.escenas.get("sceneAplicarItem"));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        this.stage.setTitle("Aplicar item jugador " + jugador.getNombre());
        this.stage.show();
    }

    public void crearVentanaSeleccionarPokemon(Jugador jugador) {
        try {
            //this.stage.setScene(this.escenas.get("sceneSeleccionPokemonInicialJugador" + numero));
            this.seleccionarPokemonController.actualizarVista(jugador);
            this.stage.setScene(this.escenas.get("sceneSeleccionPokemon"));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        this.stage.setTitle("Seleccion de Pokemon Jugador " + jugador.getNombre());
        this.stage.show();
    }

    private void crearVentanaSeleccionarPokemonItem(Jugador jugador, Item itemAplicar) {

        try{
            this.seleccionarPokemonController.actualizarVistaAplicarItem(jugador, itemAplicar);
            this.stage.setScene(this.escenas.get("sceneSeleccionPokemon"));
        } catch (NullPointerException e) {
        System.out.println("NullPointerException");
    }
        this.stage.setTitle("Seleccion de Pokemon Jugador " + jugador.getNombre());
        this.stage.show();

    }

    public void reproducirMusica(String ruta) {
        try {
            this.musicPlayer.stop();
        } catch (Exception ignored) {}
        this.musicPlayer = new MediaPlayer(new Media(new File(ruta).toURI().toString()));
        this.musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.musicPlayer.setVolume(0.2);
        this.musicPlayer.play();
    }

    public void reproducirSoundEffect(String ruta) {
        try {
            this.soundEffectPlayer.stop();
        } catch (Exception ignored) {}
        this.soundEffectPlayer = new MediaPlayer(new Media(new File(ruta).toURI().toString()));
        this.soundEffectPlayer.setCycleCount(1);
        this.soundEffectPlayer.setVolume(0.2);
        this.soundEffectPlayer.play();
    }

    public void setBatallaController(BatallaController batallaController) {
        this.batallaController = batallaController;
    }

    public void setSeleccionarPokemonController(SeleccionarPokemonController seleccionarPokemonController) {
        this.seleccionarPokemonController = seleccionarPokemonController;
    }

    public void setSeleccionarItemController(SeleccionarItemController seleccionarItemController) {
        this.seleccionarItemController = seleccionarItemController;
    }

    // HANDLE ________________________________________________________________

    @Override
    public void handle(Event event) {
        if (event instanceof JugadorNombradoEvent) {
            this.handle((JugadorNombradoEvent) event);
        } else if (event instanceof PokemonSeleccionadoEvent) {
            this.handle((PokemonSeleccionadoEvent) event);
        }
    }

    public void handle(JugadorNombradoEvent jugadorNombradoEvent) {
        if (this.juego.getJugador2().getNombre().isBlank()) {
            this.crearVentanaSeleccionNombre(2);
        } else {
            this.juego.setJugadorActual(this.juego.getJugador1());
            this.crearVentanaSeleccionarPokemon(this.juego.getJugadorActual());
        }
    }

    public void handle(MenuCambiarPokemonEvent menuCambiarPokemonEvent) {
        this.crearVentanaSeleccionarPokemon(menuCambiarPokemonEvent.getJugador());

    }

    public void handle(PokemonSeleccionadoEvent pokemonSeleccionadoEvent) {

        pokemonSeleccionadoEvent.getJugador().setPokemonActual(pokemonSeleccionadoEvent.getPokemon());
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();
        reproducirSoundEffect(pokemonResourceFactory.createCrySFXPath(pokemonSeleccionadoEvent.getPokemon()));

        if (this.juego.getJugador2().getPokemonActual() == null) {
            this.juego.setJugadorActual(this.juego.getJugador2());
            this.crearVentanaSeleccionarPokemon(juego.getJugador2());
        } else {
            if (this.esPrimerTurno) {
                this.elegirJugadorInicial();
            } else {
                this.batallaController.mostrarMensaje(pokemonSeleccionadoEvent.getJugador().getNombre() + " seleccionó a " + pokemonSeleccionadoEvent.getPokemon().getNombre() + "!");
                if (!pokemonSeleccionadoEvent.pokemonAnteriorMurio()) {
                this.juego.cambiarTurno();}
            }
            this.cicloDeTurnos();
        }
    }

    public void handle(AtaqueSeleccionadoEvent ataqueSeleccionadoEvent) {
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();
        if(ataqueSeleccionadoEvent.sePuedeUsar()){
            try {
                this.reproducirSoundEffect(pokemonResourceFactory.createHabilidadSFXPath(ataqueSeleccionadoEvent.getHabilidad()));
            } catch (Exception ignored) {}
            this.juego.getJugadorActual().atacarJugador(this.juego.getJugadorActual().getAdversario(), ataqueSeleccionadoEvent.getHabilidad().getNombre());
            //this.batallaController.mostrarMensaje("es suerefectivo!");
            this.batallaController.mostrarMensaje(ataqueSeleccionadoEvent.getPokemon().getNombre() + " usó " + ataqueSeleccionadoEvent.getHabilidad().getNombre() + "!");
            this.juego.cambiarTurno();
            this.cicloDeTurnos();
            this.batallaController.actualizarVista(this.juego);
        }else{
            this.batallaController.mostrarMensaje("No quedan PP de "+ataqueSeleccionadoEvent.getNombreHabilidad());
        }
    }

    public void handle(MenuItemEvent menuItemEvent) {
        this.crearVentanaSeleccionarItem(menuItemEvent.getJugador());
    }

    public void handle(RendirseEvent rendirseEvent) {
        rendirseEvent.getJugador().perder();
        this.cicloDeTurnos();
    }

    public void handle(MostrarMensajeEvent mostrarMensajeEvent) {
        this.batallaController.mostrarMensaje(mostrarMensajeEvent.getMensaje());
    }

    public void handle(ItemSeleccionadoEvent itemSeleccionadoEvent) {
        this.crearVentanaSeleccionarPokemonItem(itemSeleccionadoEvent.getJugador(), itemSeleccionadoEvent.getItem());
    }

    public void handle(ItemAplicadoEvent itemAplicadoEvent) {
        this.juego.getJugadorActual().actualizarPokemon(itemAplicadoEvent.getPokemon());
        this.batallaController.mostrarMensaje(itemAplicadoEvent.getJugador().getNombre() + " aplicó " + itemAplicadoEvent.getItem().getNombre() + " a " + itemAplicadoEvent.getPokemon().getNombre() + ".");
        this.juego.cambiarTurno();
        this.cicloDeTurnos();
        this.mostrarVentanaBatalla();
    }

    public void volverMenu(){
        this.mostrarVentanaBatalla();
    }

}