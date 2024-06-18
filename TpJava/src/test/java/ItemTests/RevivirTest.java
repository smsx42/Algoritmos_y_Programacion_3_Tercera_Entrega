package ItemTests;

import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Items.Revivir;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionEstado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static orgFiuba.tpjava.Constantes.ESTADO_INHABILITADO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RevivirTest {

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
        Revivir revive = new Revivir("Cura Todo", 1, modificacion,"");

        //Act
        boolean realizo = revive.aplicarItem(cualidades);

        //Assert
        assert(realizo);
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
        Revivir revive = new Revivir("Cura Todo", 1, modificacion,"");

        //Act
        boolean realizo = revive.aplicarItem(cualidades);

        //Assert
        assertFalse(realizo);
    }
}