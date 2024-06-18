package ModificacionTests;

import orgFiuba.tpjava.Model.Modificaciones.ModificacionAtaque;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionAtaqueTest {

    @Test
    public void testModificacionAtaqueModificaAtaque() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(true);
        when(cualidades.getAtaque()).thenReturn(10);
        ModificacionAtaque modificacion = new ModificacionAtaque();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades).modificarAtaque(1);
    }

    @Test
    public void testModificacionAtaqueNoModificaAtaqueSiEstaInconsciente() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(false);
        when(cualidades.getAtaque()).thenReturn(10);
        ModificacionAtaque modificacion = new ModificacionAtaque();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades, never()).modificarAtaque(1);
    }
}
