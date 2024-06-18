package orgFiuba.tpjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orgFiuba.tpjava.Controller.JuegoController;
import orgFiuba.tpjava.Model.Juego;

import java.io.IOException;

import static orgFiuba.tpjava.Constantes.RUTA_ICONO_LOGO;

public class MainJavaFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Juego juego = new Juego();

        FXMLLoader fxmlLoader = new FXMLLoader(MainJavaFX.class.getResource("inicio-view.fxml"));
        VBox root = fxmlLoader.load();

        stage.getIcons().add(new Image(MainJavaFX.class.getResourceAsStream(RUTA_ICONO_LOGO)));

        JuegoController juegoController = fxmlLoader.getController();

        Scene sceneInicio = new Scene(root, 1024, 768);
        stage.setTitle("Batalla Pokémon");
        stage.setScene(sceneInicio);

        juegoController.inicializar(stage, juego);
    }


    public static void main(String[] args) {
        launch();
    }
}