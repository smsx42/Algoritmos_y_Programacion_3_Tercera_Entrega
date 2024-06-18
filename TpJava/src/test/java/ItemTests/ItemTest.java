package ItemTests;

import orgFiuba.tpjava.Model.Items.AtaqueX;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionAtaque;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {

    @Test
    public void testRealizarCasosDeAplicacionConCantidadMayorQue0() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        ModificacionAtaque modificacion = mock(ModificacionAtaque.class);
        AtaqueX ataqueX = new AtaqueX("Ataque X", 5, modificacion,"");
        //Act
        boolean realizado = ataqueX.realizarCasosDeApliacion(cualidades);
        //Assert
        assert realizado;
    }

    @Test
    public void testRealizarCasosDeAplicacionConCantidad0() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        ModificacionAtaque modificacion = mock(ModificacionAtaque.class);
        AtaqueX ataqueX = new AtaqueX("Ataque X", 0, modificacion,"");
        //Act
        boolean realizado = ataqueX.realizarCasosDeApliacion(cualidades);
        //Assert
        assertFalse(realizado);
    }
}
