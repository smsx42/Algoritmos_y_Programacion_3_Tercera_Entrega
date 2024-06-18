package PokemonesTests.HabilidadTests;

import orgFiuba.tpjava.Model.Climas.SistemaDeClima;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadClima;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static orgFiuba.tpjava.Constantes.CLIMA_TORMENTA_DE_ARENA;
import static org.mockito.Mockito.*;

class HabilidadClimaTest {

    @Test
    public void testUsarHabilidad() {
        //Arrange
        try (MockedStatic<SistemaDeClima> mockedStatic = mockStatic(SistemaDeClima.class)) {
            Cualidades cualidades = mock(Cualidades.class);
            Cualidades cualidades2 = mock(Cualidades.class);

            HabilidadClima habilidad = new HabilidadClima(CLIMA_TORMENTA_DE_ARENA, CLIMA_TORMENTA_DE_ARENA, 10);

        //Act
            habilidad.usarHabilidad(cualidades, cualidades2);

        //Assert
            mockedStatic.verify(() -> SistemaDeClima.setClimaActual(CLIMA_TORMENTA_DE_ARENA));
        }

    }
}