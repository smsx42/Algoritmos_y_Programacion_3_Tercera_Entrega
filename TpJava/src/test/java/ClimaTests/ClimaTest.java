package ClimaTests;

import orgFiuba.tpjava.Model.Climas.ClimaLLuvia;
import orgFiuba.tpjava.Model.Climas.ClimaTormentaElectrica;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimaTest {

    // TESTS DE INTEGRACION

    @Test
    public void testAplicarEfectoClimaNoAbrasivoTipoNoFavorecido() {
        //Arrange
        ClimaLLuvia lLuvia = new ClimaLLuvia();
        Cualidades cualidades = new Cualidades(100, 50, 50, 50, 50, "Fuego");
        //Act
        lLuvia.aplicarEfectoClima(cualidades);
        //Assert
        assertEquals(1, cualidades.getTipo().getMultiplicadorClima());
        assertEquals(100, cualidades.getVida());
    }

    @Test
    public void testAplicarEfectoClimaNoAbrasivoTipoFavorecido() {
        //Arrange
        ClimaLLuvia lLuvia = new ClimaLLuvia();
        Cualidades cualidades = new Cualidades(100, 50, 50, 50, 50, "Agua");
        //Act
        lLuvia.aplicarEfectoClima(cualidades);
        //Assert
        assertEquals(1.1, cualidades.getTipo().getMultiplicadorClima());
        assertEquals(100, cualidades.getVida());
    }

    @Test
    public void testAplicarEfectoClimaAbrasivoTipoNoFavorecido() {
        //Arrange
        ClimaTormentaElectrica tormentaElectrica = new ClimaTormentaElectrica();
        Cualidades cualidades = new Cualidades(100, 50, 50, 50, 50, "Fuego");
        //Act
        tormentaElectrica.aplicarEfectoClima(cualidades);
        //Assert
        assertEquals(1, cualidades.getTipo().getMultiplicadorClima());
        assertEquals(97, cualidades.getVida());
    }

    @Test
    public void testAplicarEfectoClimaAbrasivoTipoFavorecido() {
        //Arrange
        ClimaTormentaElectrica tormentaElectrica = new ClimaTormentaElectrica();
        Cualidades cualidades = new Cualidades(100, 50, 50, 50, 50, "Electrico");
        //Act
        tormentaElectrica.aplicarEfectoClima(cualidades);
        //Assert
        assertEquals(1.1, cualidades.getTipo().getMultiplicadorClima());
        assertEquals(100, cualidades.getVida());
    }
}