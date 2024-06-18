package ModificacionTests;

import orgFiuba.tpjava.Model.Modificaciones.ModificacionEstadoInhabilitado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModificacionEstadoInhabilitadoTest {


    // TESTS DE INTEGRACION

    @Test
    public void testModificarConVidaMayorA0() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        ModificacionEstadoInhabilitado modificacionEstadoInhabilitado = new ModificacionEstadoInhabilitado();
        //Act
        modificacionEstadoInhabilitado.modificar(cualidades, (int) cualidades.getVidaMaxima());
        //Assert
        assertEquals(100, cualidades.getVida());
    }

    @Test
    public void testModificarConVidaIgualA0() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        cualidades.recibirDanio(100);
        assertEquals(0, cualidades.getVida());

        ModificacionEstadoInhabilitado modificacionEstadoInhabilitado = new ModificacionEstadoInhabilitado();
        //Act
        modificacionEstadoInhabilitado.modificar(cualidades, (int) cualidades.getVidaMaxima());
        //Assert
        assertEquals(100, cualidades.getVida());
    }
}