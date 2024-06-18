package EstadoTests;

import orgFiuba.tpjava.Model.Estados.EstadoConfuso;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.ServicioDeRandoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class EstadoConfusoTest {

    @Test
    public void testPuedeAtacarConTurnosMayorQueDuracionMaxima() {
        //Arrange
        try (MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(100.0);
            Cualidades cualidades = mock(Cualidades.class);

            EstadoConfuso estadoConfuso = new EstadoConfuso();
            estadoConfuso.setCualidades(cualidades);
        //Act
            boolean puedeAtacar = estadoConfuso.puedeAtacar();
        //Assert
            assert (puedeAtacar);
            verify(cualidades, never()).recibirDanio(anyDouble());
        }
    }

    @Test
    public void testPuedeAtacarConMalaSuerte() {
        //Arrange
        try (MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(0.0);
            Cualidades cualidades = mock(Cualidades.class);
            when(cualidades.getVidaMaxima()).thenReturn(100.0);

            EstadoConfuso estadoConfuso = new EstadoConfuso();
            estadoConfuso.setCualidades(cualidades);
        //Act
            boolean puedeAtacar = estadoConfuso.puedeAtacar();
        //Assert
            assertFalse(puedeAtacar);
            verify(cualidades, atLeastOnce()).recibirDanio(anyDouble());
        }
    }
    @Test
    public void testPuedeAtacarConBuenaSuerte() {
        //Arrange
        try (MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(100.0);
            Cualidades cualidades = mock(Cualidades.class);

            EstadoConfuso estadoConfuso = new EstadoConfuso();
            estadoConfuso.setCualidades(cualidades);
        //Act
            boolean puedeAtacar = estadoConfuso.puedeAtacar();
        //Assert
            assert(puedeAtacar);
            verify(cualidades, never()).recibirDanio(anyDouble());
        }
    }
}
