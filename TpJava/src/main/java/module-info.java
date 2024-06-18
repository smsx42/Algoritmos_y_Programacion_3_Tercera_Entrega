module orgFiuba.tpjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires javafx.media;

    opens orgFiuba.tpjava to javafx.fxml;
    exports orgFiuba.tpjava;
    exports orgFiuba.tpjava.Controller;
    opens orgFiuba.tpjava.Controller to javafx.fxml;
    exports orgFiuba.tpjava.Controller.Eventos;
    opens orgFiuba.tpjava.Controller.Eventos to javafx.fxml;
    exports orgFiuba.tpjava.Model.Pokemones;
    exports orgFiuba.tpjava.Model;
    exports orgFiuba.tpjava.Model.Items;
    exports orgFiuba.tpjava.Model.SerializacionDeserealizacion;
}