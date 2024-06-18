package ItemTests;

import orgFiuba.tpjava.Model.Items.Pocion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PocionTest {

    @Test
    public void testAplicarItemConVidaMaximaNoCura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        Pocion pocion = new Pocion("Pocion", 10, modificacion,"");
        //Act
        boolean itemAplicado = pocion.aplicarItem(cualidades);
        //Assert
        assertFalse(itemAplicado);
        assertEquals(10, pocion.getCantidad());
    }

    @Test
    public void testAplicarItemConVida0NoCura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        Pocion pocion = new Pocion("Pocion", 10, modificacion,"");
        //Act
        boolean itemAplicado = pocion.aplicarItem(cualidades);
        //Assert
        assertFalse(itemAplicado);
        assertEquals(10, pocion.getCantidad());
    }

    @Test
    public void testAplicarItemConVidaNoMaximaNi0Cura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(50.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        Pocion pocion = new Pocion("Pocion", 10, modificacion,"");
        //Act
        boolean itemAplicado = pocion.aplicarItem(cualidades);
        //Assert
        assert(itemAplicado);
        assertEquals(9, pocion.getCantidad());
    }
}
