package ItemTests;

import orgFiuba.tpjava.Model.Items.MegaPocion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MegaPocionTest {

    @Test
    public void testAplicarItemConVidaMaximaNoCura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        MegaPocion megaPocion = new MegaPocion("Mega Pocion", 10, modificacion,"");
        //Act
        boolean itemAplicado = megaPocion.aplicarItem(cualidades);
        //Assert
        assertFalse(itemAplicado);
        assertEquals(10, megaPocion.getCantidad());
    }

    @Test
    public void testAplicarItemConVida0NoCura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        MegaPocion megaPocion = new MegaPocion("Mega Pocion", 10, modificacion,"");
        //Act
        boolean itemAplicado = megaPocion.aplicarItem(cualidades);
        //Assert
        assertFalse(itemAplicado);
        assertEquals(10, megaPocion.getCantidad());
    }

    @Test
    public void testAplicarItemConVidaNoMaximaNi0Cura() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(50.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = mock(ModificacionVida.class);

        MegaPocion megaPocion = new MegaPocion("Mega Pocion", 10, modificacion,"");
        //Act
        boolean itemAplicado = megaPocion.aplicarItem(cualidades);
        //Assert
        assert(itemAplicado);
        assertEquals(9, megaPocion.getCantidad());
    }
}
