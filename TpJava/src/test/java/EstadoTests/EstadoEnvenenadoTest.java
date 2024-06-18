package EstadoTests;

import orgFiuba.tpjava.Model.Estados.EstadoEnvenenado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EstadoEnvenenadoTest {

    @Test
    void puedeAtacar() {
        //Arrange
        EstadoEnvenenado estadoEnvenenado = new EstadoEnvenenado();
        //Act
        //Assert
        assert estadoEnvenenado.puedeAtacar();
    }

    @Test
    void aplicarEfectoPasivoDeEstado() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        EstadoEnvenenado estadoEnvenenado = new EstadoEnvenenado();
        estadoEnvenenado.setCualidades(cualidades);
        //Act
        estadoEnvenenado.aplicarEfectoPasivoDeEstado();
        //Assert
        verify(cualidades, times(1)).recibirDanio(5.0d);
    }
}