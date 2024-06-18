package PokemonesTests.HabilidadTests;

import orgFiuba.tpjava.Model.Estados.EstadoParalizado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadEstado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HabilidadEstadoTest {

    @Test
    public void testUsarHabilidad() {
        //Arrange
        Cualidades cualidadesPokemonPropio = mock(Cualidades.class);
        Cualidades cualidadesPokemonEnemigo = mock(Cualidades.class);
        EstadoParalizado estado = mock(EstadoParalizado.class);
        HabilidadEstado habilidad = new HabilidadEstado("Habilidad", 10, estado);
        //Act
        habilidad.usarHabilidad(cualidadesPokemonEnemigo, cualidadesPokemonPropio);
        //Assert
        assertEquals(9, habilidad.getCantidadDeUsos());
        verify(cualidadesPokemonEnemigo).agregarEstado(estado);
    }
}