package ModificacionTests;

import orgFiuba.tpjava.Model.Modificaciones.ModificacionVelocidad;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionVelocidadTest {

    @Test
    public void testModificacionVelocidadModificaVelocidad() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(true);
        when(cualidades.getVelocidad()).thenReturn(10);
        ModificacionVelocidad modificacion = new ModificacionVelocidad();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades).modificarVelocidad(1);
    }

    @Test
    public void testModificacionVelocidadNoModificaVelocidadSiEstaInconsciente() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(false);
        when(cualidades.getVelocidad()).thenReturn(10);
        ModificacionVelocidad modificacion = new ModificacionVelocidad();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades, never()).modificarVelocidad(1);
    }
}
