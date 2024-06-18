package ModificacionTests;

import orgFiuba.tpjava.Model.Estados.EstadoParalizado;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionEstado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static orgFiuba.tpjava.Constantes.*;
import static org.junit.jupiter.api.Assertions.*;

class ModificacionEstadoTest {

    // TESTS DE INTEGRACION

    @Test
    public void testModificarConVidaMayorA0() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        cualidades.agregarEstado(new EstadoParalizado());
        ModificacionEstado modificacionEstado = new ModificacionEstado();
        //Act
        modificacionEstado.modificar(cualidades, (int) cualidades.getVidaMaxima());
        //Assert
        assert(cualidades.obtenerEstadosActuales().stream().allMatch(unEstado -> unEstado.getNombre().equals(ESTADO_NORMAL)));
    }

    @Test
    public void testModificarConVidaIgualA0() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        cualidades.agregarEstado(new EstadoParalizado());
        cualidades.recibirDanio(100);
        assertEquals(0, cualidades.getVida());

        ModificacionEstado modificacionEstado = new ModificacionEstado();
        //Act
        modificacionEstado.modificar(cualidades, (int) cualidades.getVidaMaxima());
        //Assert
        assert(cualidades.obtenerEstadosActuales().stream().allMatch(unEstado -> unEstado.getNombre().equals(ESTADO_INHABILITADO)));
    }
}