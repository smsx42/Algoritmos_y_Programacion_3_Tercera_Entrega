package ModificacionTests;

import orgFiuba.tpjava.Model.Modificaciones.ModificacionDefensa;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionDefensaTest {

    @Test
    public void testModificacionDefensaModificaDefensa() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(true);
        when(cualidades.getDefensa()).thenReturn(10);
        ModificacionDefensa modificacion = new ModificacionDefensa();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades).modificarDefensa(1);
    }

    @Test
    public void testModificacionDefensaNoModificaDefensaSiEstaInconsciente() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.estaConsciente()).thenReturn(false);
        when(cualidades.getDefensa()).thenReturn(10);
        ModificacionDefensa modificacion = new ModificacionDefensa();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades, never()).modificarDefensa(1);
    }
}
