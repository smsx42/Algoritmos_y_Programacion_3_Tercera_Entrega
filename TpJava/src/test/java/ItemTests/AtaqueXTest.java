package ItemTests;

import orgFiuba.tpjava.Model.Items.AtaqueX;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionAtaque;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtaqueXTest {

    @Test
    public void testAplicarItem() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(10.0);
        ModificacionAtaque modificacion = mock(ModificacionAtaque.class);
        AtaqueX ataqueX = new AtaqueX("Ataque X", 5, modificacion,"");
        //Act
        boolean realizo = ataqueX.aplicarItem(cualidades);
        //Assert
        assert realizo;
    }
}
