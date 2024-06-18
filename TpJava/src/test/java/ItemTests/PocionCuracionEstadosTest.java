package ItemTests;

import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Items.PocionCuracionEstados;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionEstado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static orgFiuba.tpjava.Constantes.ESTADO_INHABILITADO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PocionCuracionEstadosTest {

    @Test
    public void testAplicarItemCuandoEstaInhabilitado() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        Set<Estado> estadosActuales = new HashSet<>();
        Estado unEstado = mock(Estado.class);
        when(unEstado.getNombre()).thenReturn(ESTADO_INHABILITADO);
        estadosActuales.add(unEstado);
        when(cualidades.obtenerEstadosActuales()).thenReturn(estadosActuales);
        ModificacionEstado modificacion = mock(ModificacionEstado.class);
        PocionCuracionEstados curaTodo = new PocionCuracionEstados("Cura Todo", 1, modificacion,"");

        //Act
        boolean realizo = curaTodo.aplicarItem(cualidades);

        //Assert
        assertFalse(realizo);
    }

    @Test
    public void testAplicarItemCuandoNoEstaInhabilitado() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        Set<Estado> estadosActuales = new HashSet<>();
        Estado unEstado = mock(Estado.class);
        when(unEstado.getNombre()).thenReturn("Otro");
        estadosActuales.add(unEstado);
        when(cualidades.obtenerEstadosActuales()).thenReturn(estadosActuales);
        ModificacionEstado modificacion = mock(ModificacionEstado.class);
        PocionCuracionEstados curaTodo = new PocionCuracionEstados("Cura Todo", 1, modificacion,"");

        //Act
        boolean realizo = curaTodo.aplicarItem(cualidades);

        //Assert
        assertTrue(realizo);
    }
}