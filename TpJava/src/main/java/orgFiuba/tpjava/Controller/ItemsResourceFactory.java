package orgFiuba.tpjava.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;

public class ItemsResourceFactory {


    public ImageView createItemMenuView(Item item) {

        String extension = ".png";
        String path = "Imagenes/Items/"   + item.getNombre() + extension;
        Image itemImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView itemImageView = new ImageView();
        itemImageView.setImage(itemImage);
        itemImageView.setFitHeight(50);
        itemImageView.setFitWidth(50);
        itemImageView.setTranslateY(-9);
        return itemImageView;
    }

    public ImageView createModificacionesView(Modificacion modificacion) {

        String extension = ".png";
        String path = "Imagenes/Iconos/Estadisticas/"   + modificacion.obtenerNombreModificacion().toLowerCase() + extension;
        //System.out.println(path);
        Image modificacionImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView modificacionImageView = new ImageView();
        modificacionImageView.setImage(modificacionImage);
        modificacionImageView.setFitHeight(30);
        modificacionImageView.setFitWidth(30);
        return modificacionImageView;
    }

    public Text createItemData(Item item) {
        Text itemData = new Text(item.getNombre() +" | " + " X " + item.getCantidad() + " | " + "Modificacion: " + item.getUnaModificacion().obtenerNombreModificacion() + " ");
        itemData.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        itemData.setFill(Color.BLACK);
        return itemData;
    }
}