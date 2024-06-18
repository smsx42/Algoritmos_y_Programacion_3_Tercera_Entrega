package PokemonesTests.HabilidadTests;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import orgFiuba.tpjava.Model.Pokemones.HabilidadAtaque;
import orgFiuba.tpjava.Model.Tipos.Tipo;
import orgFiuba.tpjava.Model.ServicioDeRandoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HabilidadAtaqueTest {

    @Test
    public void testUsarHabilidadReduceLaCantidadDeUsos() {
        //Arrange
        Tipo tipoPokemonPropio = mock(Tipo.class);
        Tipo tipoPokemonEnemigo = mock(Tipo.class);
        Tipo tipoHabilidad = mock(Tipo.class);
        when(tipoPokemonPropio.calcularBonusDelMismoTipo(tipoHabilidad)).thenReturn(1.0);
        when(tipoPokemonEnemigo.calcularMultiplicadorDeDanio(tipoPokemonPropio)).thenReturn(1.0);

        Cualidades cualidadesPokemonPropio = mock(Cualidades.class);
        when(cualidadesPokemonPropio.getAtaque()).thenReturn(10);
        when(cualidadesPokemonPropio.getTipo()).thenReturn(tipoPokemonPropio);
        when(cualidadesPokemonPropio.getNivel()).thenReturn(1.0);

        Cualidades cualidadesPokemonEnemigo = mock(Cualidades.class);
        when(cualidadesPokemonEnemigo.getDefensa()).thenReturn(10);
        when(cualidadesPokemonEnemigo.getTipo()).thenReturn(tipoPokemonEnemigo);

        HabilidadAtaque habilidad = new HabilidadAtaque("Ataque", tipoPokemonPropio, 10, 10);

        //Act
        habilidad.usarHabilidad(cualidadesPokemonEnemigo, cualidadesPokemonPropio);
        //Assert
        assertEquals(9, habilidad.getCantidadDeUsos());
    }

    @Test
    public void testUsarHabilidadAtaqueHaceDanioSinCritico() {
        //Arrange
        try (MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {

            when(ServicioDeRandoms.obtenerRandomParaHabilidadAtaqueCalculoCritico()).thenReturn(50);
            when(ServicioDeRandoms.obtenerRandomParaHabilidadAtaqueCalculoAtaqueSegunTipo()).thenReturn(0.5);

            Tipo tipoPokemonPropio = mock(Tipo.class);
            Tipo tipoPokemonEnemigo = mock(Tipo.class);
            Tipo tipoHabilidad = mock(Tipo.class);
            when(tipoPokemonPropio.calcularBonusDelMismoTipo(tipoHabilidad)).thenReturn(1.0);
            when(tipoHabilidad.calcularMultiplicadorDeDanio(tipoPokemonEnemigo)).thenReturn(1.0);

            Cualidades cualidadesPokemonPropio = mock(Cualidades.class);
            when(cualidadesPokemonPropio.getAtaque()).thenReturn(10);
            when(cualidadesPokemonPropio.getTipo()).thenReturn(tipoPokemonPropio);
            when(cualidadesPokemonPropio.getNivel()).thenReturn(50.0);

            Cualidades cualidadesPokemonEnemigo = mock(Cualidades.class);
            when(cualidadesPokemonEnemigo.getDefensa()).thenReturn(10);
            when(cualidadesPokemonEnemigo.getTipo()).thenReturn(tipoPokemonEnemigo);

            HabilidadAtaque habilidad = new HabilidadAtaque("Ataque", tipoHabilidad, 10, 10);

            //Act
            habilidad.usarHabilidad(cualidadesPokemonEnemigo, cualidadesPokemonPropio);

            //Assert
            assertEquals(2, habilidad.getDanioRealizado()); //TODO hacer la cuenta para verificar que da 2
        }
    }
}
