package PokemonesTests.HabilidadTests;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadEstadistica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class HabilidadEstadisticaTest {

    @Test
    public void testUsarHabilidadConCantidadDeUsos10() {
        //Arrange
        Cualidades cualidadesPokemonPropio = mock(Cualidades.class);
        Cualidades cualidadesPokemonEnemigo = mock(Cualidades.class);
        Modificacion modificacion = mock(Modificacion.class);

        HabilidadEstadistica habilidad = new HabilidadEstadistica("Habilidad", 10, true, 1, modificacion);
        //Act
        habilidad.usarHabilidad(cualidadesPokemonEnemigo, cualidadesPokemonPropio);
        //Assert
        assertEquals(9, habilidad.getCantidadDeUsos());
    }

}
