package EstadoTests;

import orgFiuba.tpjava.Model.Estados.EstadoParalizado;
import orgFiuba.tpjava.Model.ServicioDeRandoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class EstadoParalizadoTest {

    @Test
    public void testPuedeAtacarConBuenaSuerte() {
        try(MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(100.0);

            EstadoParalizado estadoParalizado = new EstadoParalizado();
            //Act
            boolean puedeAtacar = estadoParalizado.puedeAtacar();
            //Assert
            assert(puedeAtacar);
        }
    }

    @Test
    public void testPuedeAtacarConMalaSuerte() {
        try(MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(0.0);

            EstadoParalizado estadoParalizado = new EstadoParalizado();
            //Act
            boolean puedeAtacar = estadoParalizado.puedeAtacar();
            //Assert
            assertFalse(puedeAtacar);
        }
    }
}