package PokemonesTests;

import orgFiuba.tpjava.Model.Climas.SistemaDeClima;
import orgFiuba.tpjava.Model.Estados.EstadoEnvenenado;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionDefensa;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import orgFiuba.tpjava.Model.Pokemones.*;
import orgFiuba.tpjava.Model.Tipos.Tipo;
import org.junit.jupiter.api.Test;

import static orgFiuba.tpjava.Constantes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PokemonTest {

    @Test
    public void testPokemonSeCreaConNombre() {
        //Arrange
        Pokemon pikachu = new Pokemon("Pikachu", 1, "Electrico", "Pikachu es un pokemon electrico", 100, 10, 10, 10);
        //Act
        //Assert
        assertEquals("Pikachu", pikachu.getNombre());
    }

    @Test
    public void testPokemonAniadeUnaHabilidad() {
        //Arrange
        Pokemon pikachu = new Pokemon("Pikachu", 1, "Electrico", "Pikachu es un pokemon electrico", 100, 10, 10, 10);
        Habilidad ataqueRapido = mock(Habilidad.class);
        //Act
        pikachu.aniadirHabilidad(ataqueRapido);
        //Assert
        assert(pikachu.getMisHabilidades().containsValue(ataqueRapido));
    }


    // TESTS DE INTEGRACION


    @Test
    public void testCharizardAtacaALucarioConLanzallamas() {
        //Arrange
        Pokemon charizard = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
                153, 120, 105, 129);
        Habilidad lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.instanciarUnTipoDe("Fuego"),90,15);
        charizard.aniadirHabilidad(lanzallamas);
        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
                100, 110, 90, 135);
        //Act
        charizard.atacar(lucario, "Lanzallamas");
        //Assert
        assert(lucario.getCualidades().getVida() < 100);
    }

    @Test
    public void testCrobatUsaToxicoContraCharizard() {
        //Arrange
        Pokemon charizard = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
                153, 120, 105, 129);
        Pokemon crobat = new Pokemon("Crobat", 50, "Veneno", "Crobat ataca a su presa desde la oscuridad de la noche, sin que esta se percate de su presencia.",
                173, 130, 80, 100);
        Habilidad toxico = new HabilidadEstado("Toxico",10, new EstadoEnvenenado());
        crobat.aniadirHabilidad(toxico);
        //Act
        crobat.atacar(charizard, "Toxico");
        //Assert
        assert(charizard.getCualidades().obtenerEstadosActuales().stream().anyMatch(unEstado -> unEstado.getNombre().equals(ESTADO_ENVENENADO)));
    }

    @Test
    public void testGolemUsaTormentaDeArenaContraLucario() {
        //Arrange
        SistemaDeClima.iniciarSistemaDeClima();
        Pokemon golem = new Pokemon("Golem", 50, "Roca", "Golem vive en las montañas. Siempre rueda por las laderas para desplazarse.",
                153, 120, 105, 129);
        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
                100, 110, 90, 135);
        Habilidad tormentaDeArena = new HabilidadClima("Tormenta de Arena",CLIMA_TORMENTA_DE_ARENA,5);
        golem.aniadirHabilidad(tormentaDeArena);
        //Act
        golem.atacar(lucario, "Tormenta de Arena");
        //Assert
        assertEquals(SistemaDeClima.getClimaActual().getNombre(), CLIMA_TORMENTA_DE_ARENA);
    }

    @Test
    public void testAlakazamSeCuraUsandoRecuperacion() {
        //Arrange
        Pokemon alakazam = new Pokemon("Alakazam", 50, "Psiquico", "Alakazam tiene un cerebro que se desarrolló mucho antes que el resto de su cuerpo. Si se le daña el cerebro, el Pokémon se debilita.",
                100, 110, 90, 135);
        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
                100, 110, 90, 135);
        Habilidad recuperacion = new HabilidadEstadistica("Recuperacion",5, true, (int)(alakazam.obtenerVidaMaxima()/2), new ModificacionVida());
        alakazam.aniadirHabilidad(recuperacion);
        //Act
        alakazam.getCualidades().recibirDanio(60);
        alakazam.atacar(lucario, "Recuperacion");
        //Assert
        assertEquals(alakazam.getCualidades().getVida(), 90);
    }

    @Test
    public void testLucarioUsaEcoMetalicoParaBajarLaDefensaDeCharizard() {
        //Arrange
        Pokemon charizard = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
                153, 120, 105, 129);
        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
                100, 110, 90, 135);
        Habilidad ecoMetalico = new HabilidadEstadistica("Eco Metalico",5, false, -2, new ModificacionDefensa());
        lucario.aniadirHabilidad(ecoMetalico);
        //Act
        lucario.atacar(charizard, "Eco Metalico");
        //Assert
        assertEquals(charizard.getCualidades().getDefensa(), 84);
    }
}
