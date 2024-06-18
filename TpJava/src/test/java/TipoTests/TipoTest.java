package TipoTests;

import orgFiuba.tpjava.Model.Tipos.*;
import org.junit.jupiter.api.Test;

import static orgFiuba.tpjava.Constantes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoTest {

    // TESTS DE INTEGRACION

    @Test
    public void testCalcularBonusDelMismoTipoConTiposIguales() {
        //Arrange
        Tipo agua = new Agua();
        Tipo agua2 = new Agua();
        //Act
        //Assert
        assertEquals(BONUS_MISMO_TIPO, agua.calcularBonusDelMismoTipo(agua2));
    }

    @Test
    public void testCalcularBonusDelMismoTipoConTiposDistintos() {
        //Arrange
        Tipo agua = new Agua();
        Tipo fuego = new Fuego();
        //Act
        //Assert
        assertEquals(BONUS_NEUTRAL, agua.calcularBonusDelMismoTipo(fuego));
    }

    @Test
    public void testCalcularMultiplicadorDeDanioNeutral() {
        //Arrange
        Tipo agua = new Agua();
        Tipo volador = new Volador();
        //Act
        //Assert
        assertEquals(MULTIPLICADOR_NEUTRAL, agua.calcularMultiplicadorDeDanio(volador));
    }

    @Test
    public void testCalcularMultiplicadorDeDanioDebil() {
        //Arrange
        Tipo fuego = new Fuego();
        Tipo agua = new Agua();
        //Act
        //Assert
        assertEquals(MULTIPLICADOR_DEBIL, fuego.calcularMultiplicadorDeDanio(agua));
    }

    @Test
    public void testCalcularMultiplicadorDeDanioFuerte() {
        //Arrange
        Tipo fuego = new Fuego();
        Tipo planta = new Planta();
        //Act
        //Assert
        assertEquals(MULTIPLICADOR_FUERTE, fuego.calcularMultiplicadorDeDanio(planta));
    }

    @Test
    public void testCalcularMultiplicadorDeDanioNulo() {
        //Arrange
        Tipo tierra = new Tierra();
        Tipo volador = new Volador();
        //Act
        //Assert
        assertEquals(MULTIPLICADOR_NULA, tierra.calcularMultiplicadorDeDanio(volador));
    }
}
