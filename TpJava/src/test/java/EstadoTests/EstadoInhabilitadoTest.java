package EstadoTests;

import orgFiuba.tpjava.Model.Estados.EstadoInhabilitado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoInhabilitadoTest {

    @Test
    public void testPuedeAtacar() {
        //Arrange
        EstadoInhabilitado estadoInhabilitado = new EstadoInhabilitado();
        //Act
        boolean puedeAtacar = estadoInhabilitado.puedeAtacar();
        //Assert
        assertFalse(puedeAtacar);
    }
}