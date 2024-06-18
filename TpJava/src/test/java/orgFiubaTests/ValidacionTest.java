package orgFiubaTests;

import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.Validacion;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

public class ValidacionTest {

    @Test
    public void testEstaContenidoHabilidadValida() {
        //Arrange
        Map<String, Habilidad> habilidades = new HashMap<>();
        Habilidad impactrueno = mock(Habilidad.class);
        habilidades.put("Impactrueno", impactrueno);
        Validacion validacion = new Validacion();
        //Act
        //Assert
        assert (validacion.estaContenidoHabilidad("Impactrueno", habilidades));
    }

    @Test
    public void testEstaContenidoHabilidadInvalida() {
        //Arrange
        Map<String, Habilidad> habilidades = new HashMap<>();
        Habilidad impactrueno = mock(Habilidad.class);
        habilidades.put("Impactrueno", impactrueno);
        Validacion validacion = new Validacion();
        //Act
        //Assert
        assertFalse (validacion.estaContenidoHabilidad("Lanzallamas", habilidades));
    }

    @Test
    public void testEstaContenidoPokemonValido() {
        //Arrange
        Map<String, Pokemon> pokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        pokemones.put("Pikachu", pikachu);
        Validacion validacion = new Validacion();
        //Act
        //Assert
        assert (validacion.estaContenidoPokemon("Pikachu", pokemones));
    }

    @Test
    public void testEstaContenidoPokemonInvalido() {
        //Arrange
        Map<String, Pokemon> pokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        pokemones.put("Pikachu", pikachu);
        Validacion validacion = new Validacion();
        //Act
        //Assert
        assertFalse (validacion.estaContenidoPokemon("Charmander", pokemones));
    }

    @Test
    public void testEstaContenidoItemValido() {
        //Arrange
        Map<String, Item> items = new HashMap<>();
        Item pocion = mock(Item.class);
        items.put("Pocion", pocion);
        Validacion validacion = new Validacion();
        //Act
        //Assert
        assert (validacion.estaContenidoItem("Pocion", items));
    }

    @Test
    public void testEstaContenidoItemInvalido() {
        //Arrange
        Map<String, Item> items = new HashMap<>();
        Item pocion = mock(Item.class);
        items.put("Pocion", pocion);
        Validacion validacion = new Validacion();
        //Act
        //Assert
        assertFalse (validacion.estaContenidoItem("Pokebola", items));
    }
}
