package ModificacionTests;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionVidaTest {

    @Test
    public void testModificarConVidaMaximaNoModifica() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(true);
        when(cualidades.getVida()).thenReturn(100.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = new ModificacionVida();
        //Act
        modificacion.modificar(cualidades, 10);
        //Assert
        verify(cualidades, never()).aumentarVida(anyInt());
    }

    @Test
    public void testModificarConVida0NoModifica() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(false);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = new ModificacionVida();
        //Act
        modificacion.modificar(cualidades, 10);
        //Assert
        verify(cualidades, never()).aumentarVida(anyInt());
    }

    @Test
    public void testModificarConVidaNoMaximaNi0Modifica() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(true);
        when(cualidades.getVida()).thenReturn(50.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = new ModificacionVida();
        //Act
        modificacion.modificar(cualidades, 10);
        //Assert
        verify(cualidades, times(1)).aumentarVida(10);
    }
}
