package orgFiuba.tpjava.Controller;

import javafx.scene.control.Alert;

public class PantallaInformacion {

    public static void mostrarInformacion(String descripcion){
        Alert alert  = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText(descripcion);
        alert.showAndWait();

    }
}
