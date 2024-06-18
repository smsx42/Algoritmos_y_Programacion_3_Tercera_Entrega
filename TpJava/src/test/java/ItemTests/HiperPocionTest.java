package ItemTests;

import orgFiuba.tpjava.Model.Items.HiperPocion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HiperPocionTest {

    @Test
    public void testAplicarItemConVidaMaximaNoCura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        HiperPocion hiperPocion = new HiperPocion("HiperPocion", 1, modificacion,"");
        //Act
        boolean itemAplicado = hiperPocion.aplicarItem(cualidades);
        //Assert
        assertFalse(itemAplicado);
        assertEquals(1, hiperPocion.getCantidad());
    }

    @Test
    public void testAplicarItemConVida0NoCura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        HiperPocion hiperPocion = new HiperPocion("HiperPocion", 1, modificacion,"");
        //Act
        boolean itemAplicado = hiperPocion.aplicarItem(cualidades);
        //Assert
        assertFalse(itemAplicado);
        assertEquals(1, hiperPocion.getCantidad());
    }

    @Test
    public void testAplicarItemConVidaNoMaximaNi0Cura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(50.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        HiperPocion hiperPocion = new HiperPocion("HiperPocion", 1, modificacion,"");
        //Act
        boolean itemAplicado = hiperPocion.aplicarItem(cualidades);
        //Assert
        assert(itemAplicado);
        assertEquals(0, hiperPocion.getCantidad());
    }
}
