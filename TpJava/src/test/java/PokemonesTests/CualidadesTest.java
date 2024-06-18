package PokemonesTests;

import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CualidadesTest {

    @Test
    public void testCualidadesSeCreaConAtributosCorrectos() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        //Assert
        assertEquals(100, cualidades.getVida());
        assertEquals(1, cualidades.getNivel());
        assertEquals(10, cualidades.getVelocidad());
        assertEquals(10, cualidades.getDefensa());
        assertEquals(10, cualidades.getAtaque());
    }

    @Test
    public void testReduccionVidaMenorQueTotal() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.recibirDanio(10);
        //Assert
        assertEquals(90, cualidades.getVida());
    }

    @Test
    public void testReduccionVidaMayorQueTotal() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.recibirDanio(110);
        //Assert
        assertEquals(0, cualidades.getVida());
    }

    @Test
    public void testReducirVidaYAumentarVidaMenosQueLoReducido() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.recibirDanio(20);
        cualidades.aumentarVida(10);
        //Assert
        assertEquals(90, cualidades.getVida());
    }

    @Test
    public void testReducirVidaYAumentarVidaMasQueLoReducido() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.recibirDanio(10);
        cualidades.aumentarVida(20);
        //Assert
        assertEquals(100, cualidades.getVida());
    }

    @Test
    public void testPokemonVivoEstaConsciente() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        //Assert
        assertTrue(cualidades.estaConsciente());
    }

    @Test
    public void testPokemonMuertoNoEstaConsciente() {
        //Arrange
        Cualidades cualidades = new Cualidades(0, 1, 10, 10, 10, "Electrico");
        //Act
        //Assert
        assertFalse(cualidades.estaConsciente());
    }

    @Test
    public void testAumentarVelocidad() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.modificarVelocidad(1);
        //Assert
        assertEquals(11, cualidades.getVelocidad());
    }

    @Test
    public void testReducirVelocidad() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.modificarVelocidad(-1);
        //Assert
        assertEquals(9, cualidades.getVelocidad());
    }

    @Test
    public void testAumentarAtaque() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.modificarAtaque(1);
        //Assert
        assertEquals(11, cualidades.getAtaque());
    }

    @Test
    public void testReducirAtaque() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.modificarAtaque(-1);
        //Assert
        assertEquals(9, cualidades.getAtaque());
    }

    @Test
    public void testAumentarDefensa() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.modificarDefensa(1);
        //Assert
        assertEquals(11, cualidades.getDefensa());
    }

    @Test
    public void testReducirDefensa() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        //Act
        cualidades.modificarDefensa(-1);
        //Assert
        assertEquals(9, cualidades.getDefensa());
    }

    @Test
    public void testAgregarEstado() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        Estado estadoParalizado = mock(Estado.class);
        //Act
        cualidades.agregarEstado(estadoParalizado);
        //Assert
        assert(cualidades.obtenerEstadosActuales().contains(estadoParalizado));
    }

    @Test
    public void testAtacarConEstadosActuales() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        Estado estadoNormal = mock(Estado.class);
        when(estadoNormal.puedeAtacar()).thenReturn(true);
        Estado estadoDormido = mock(Estado.class);
        when(estadoDormido.puedeAtacar()).thenReturn(false);
        //Act
        //Assert
        assertTrue(cualidades.atacarConEstadosActuales());
        cualidades.agregarEstado(estadoDormido);
        assertFalse(cualidades.atacarConEstadosActuales());
    }
}
