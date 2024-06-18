package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Controller.Eventos.ItemSeleccionadoEvent;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleccionarItemController {

// --Commented out by Inspection START (05/12/2023 19:29):
//    @FXML
//    public HashMap<String, ImageView> itemsViews;
// --Commented out by Inspection STOP (05/12/2023 19:29)

    @FXML
    public VBox vboxMenuItems;

    public List<Item> items;
    private JuegoController juegoController;
    @FXML
    public GridPane gridPaneItems;
    @FXML
    public Text descripcionItem;
    @FXML
    public Label afirmador;


    public void inicializar(Jugador jugador, JuegoController juegoController) {
        juegoController.setSeleccionarItemController(this);
        this.juegoController = juegoController;
        this.crearVentanaMenuItem(jugador);

    }

    public void crearVentanaMenuItem(Jugador jugador){

        //this.itemsViews = new HashMap<>();
        this.items = new ArrayList<>();
        ItemsResourceFactory itemsResourceFactory = new ItemsResourceFactory();

        jugador.getItems().forEach((k, v) -> items.add(v));

        HBox itemsView;
        HBox itemIconoYNombre;
        int index = 0;

        for (int row = 0; row < 8; row++) {

            Item item = items.get(index);
            itemsView = new HBox();
            itemIconoYNombre = new HBox();

            itemIconoYNombre.getChildren().add(itemsResourceFactory.createItemMenuView(item));
            itemIconoYNombre.getChildren().add(itemsResourceFactory.createItemData(item));
            itemIconoYNombre.getChildren().add(itemsResourceFactory.createModificacionesView(item.getUnaModificacion()));
            itemIconoYNombre.setTranslateX(40);
            itemIconoYNombre.setTranslateY(20);

            itemsView.getChildren().add(itemIconoYNombre);

            itemsView.setOnMouseClicked(createImageViewClickHandler(this.juegoController, jugador, item));

            itemsView.setOnMouseEntered(event -> descripcionItem.setText(item.getDescripcion()));
            itemsView.setOnMouseExited(event -> descripcionItem.setText(""));
            gridPaneItems.add(itemsView, 0, row);
            index++;
        }
    }

    private EventHandler<MouseEvent> createImageViewClickHandler(JuegoController juegoController, Jugador jugador, Item item) {
        return event -> {
            if(item.getCantidad() == 0){
                PantallaInformacion.mostrarInformacion("Se quedo sin este tipo de items.");
            }else{
                juegoController.handle(new ItemSeleccionadoEvent(jugador, item));
            }
        };
    }

    public void actualizarVista(Jugador jugador) {
        try {
            gridPaneItems.getChildren().clear();
        } catch (Exception ignored) {}
        this.crearVentanaMenuItem(jugador);
    }

    @FXML
    public void volverMenu(){
        this.afirmador.setText("");
        juegoController.volverMenu();
    }
}



