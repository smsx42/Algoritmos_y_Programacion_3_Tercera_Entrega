package ItemTests;

import orgFiuba.tpjava.Model.Items.Revivir;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionEstadoInhabilitado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsEstadoTest {

    @Test
    public void testEsUnItemDeSoloCampoDeBatalla() {
        //Arrange
        ModificacionEstadoInhabilitado modificacion = new ModificacionEstadoInhabilitado();
        Revivir revivir = new Revivir("Revivir", 1, modificacion,"");
        //Act
        //Assert
        assertTrue(revivir.esUnItemDeSoloCampoDeBatalla());
    }
}