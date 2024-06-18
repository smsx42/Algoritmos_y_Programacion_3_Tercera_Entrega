package ItemTests;

import orgFiuba.tpjava.Model.Items.AtaqueX;
import orgFiuba.tpjava.Model.Items.ItemsEstadistica;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemsEstadisticaTest {

    @Test
    public void testRealizarUsadoItemsDeEstadisitcasConVidaDistintaDe0() {
        // Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        Modificacion modificacion = mock(Modificacion.class);
        ItemsEstadistica itemsEstadistica = new AtaqueX("Ataque X", 5, modificacion,"");
        // Act
        boolean resultado = itemsEstadistica.realizarUsadoItemsDeEstadisitcas(cualidades);
        // Assert
        assertTrue(resultado);
        assertEquals(4, itemsEstadistica.getCantidad());
    }

    @Test
    public void testRealizarUsadoItemsDeEstadisitcasConVidaIgualA0() {
        // Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        Modificacion modificacion = mock(Modificacion.class);
        ItemsEstadistica itemsEstadistica = new AtaqueX("Ataque X", 5, modificacion,"");
        // Act
        boolean resultado = itemsEstadistica.realizarUsadoItemsDeEstadisitcas(cualidades);
        // Assert
        assertFalse(resultado);
        assertEquals(5, itemsEstadistica.getCantidad());
    }
}
