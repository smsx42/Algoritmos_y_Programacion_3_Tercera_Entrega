package EstadoTests;

import orgFiuba.tpjava.Model.Estados.EstadoNormal;
import org.junit.jupiter.api.Test;

class EstadoNormalTest {

    @Test
    public void testPuedeAtacar() {
        //Arrange
        EstadoNormal estadoNormal = new EstadoNormal();
        //Act
        boolean puedeAtacar = estadoNormal.puedeAtacar();
        //Assert
        assert(puedeAtacar);
    }
}