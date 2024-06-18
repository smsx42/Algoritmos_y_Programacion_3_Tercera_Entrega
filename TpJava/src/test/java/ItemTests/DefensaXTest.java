package ItemTests;

import org.junit.jupiter.api.Nested;
import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Items.DefensaX;
import orgFiuba.tpjava.Model.Items.Revivir;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionDefensa;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionEstado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static orgFiuba.tpjava.Constantes.ESTADO_INHABILITADO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefensaXTest {

    @Test
    public void testAplicarItem() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(10.0);
        ModificacionDefensa modificacion = mock(ModificacionDefensa.class);
        DefensaX defensaX = new DefensaX("Defensa X", 5, modificacion,"");
        //Act
        boolean realizo = defensaX.aplicarItem(cualidades);
        //Assert
        assert realizo;
    }

    @Nested
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
            Revivir revivir = new Revivir("Revive", 1, modificacion,"");

            //Act
            boolean realizo = revivir.aplicarItem(cualidades);

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
            Revivir revivir = new Revivir("Revive", 1, modificacion,"");

            //Act
            boolean realizo = revivir.aplicarItem(cualidades);

            //Assert
            assertFalse(realizo);
        }
    }
}
