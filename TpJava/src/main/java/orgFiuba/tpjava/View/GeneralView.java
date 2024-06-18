package orgFiuba.tpjava.View;

import orgFiuba.tpjava.Model.Climas.Clima;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.View.ClimasView.SistemaDeClimaView;
import orgFiuba.tpjava.View.ModificacionesView.ModificacionFactory;
import orgFiuba.tpjava.View.ModificacionesView.ModificacionView;

import static orgFiuba.tpjava.Constantes.*;

public class GeneralView {

    private JugadorView jugadorView;

    private JugadorFactory jugadorFactory;

    private ModificacionFactory modificacionFactory;
    private ModificacionView modificacionView;

    private SistemaDeClimaView sistemaDeClimaView;

    public GeneralView(Jugador jugador, Clima climaActual){
        this.jugadorFactory = new JugadorFactory();
        this.modificacionFactory = new ModificacionFactory();
        this.jugadorView = jugadorFactory.createJugadorView(jugador);
        this.sistemaDeClimaView = new SistemaDeClimaView(climaActual);

    }

    public JugadorView getJugadorView() {
        return jugadorView;
    }

    public JugadorView getJugadorAdversarioView(){
        return jugadorView.getJugadorAdversarioView();
    }

    public void setJugadorView(Jugador jugador) {
        this.jugadorView = this.jugadorFactory.createJugadorView(jugador);
    }

    public void modificarClimaActualView(Clima climaActual){
        this.sistemaDeClimaView.setClimaActualView(climaActual);
    }

    //Mensajes genericos.

    public void mostrarMensajeBienvenida() {

        System.out.println(ANSI_VERDE + "╔═══════════════════════╗");
        System.out.println("║ BIENVENIDO A POKEMON  ║");
        System.out.println("╚═══════════════════════╝\n" + ANSI_RESET   );
    }
    public void mensajeVolverAlMenu(){
        System.out.println(ANSI_VERDEOSCURO + "Oprima una tecla para volver al menu: " + ANSI_RESET);
    }

    public void felicitar(Jugador jugador) {
        System.out.println(ANSI_VERDE + "¡¡Felicidades a " + jugador.getNombre() + "!! Ganaste el juego" + ANSI_RESET);
    }

    public void mostrarMensajeOpcionInvalida() {

        System.out.println(ANSI_ROJO + "\nERROR: NO ES UNA OPCION VALIDAD.\n" + ANSI_RESET);

    }

    public void mostrarEfectoPasivo(){
        this.jugadorView.getPokemonActualView().mostrarEfectoPasivo();
    }

    public void mostrarMensajeMenu() {

        System.out.println(ANSI_VERDE);
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║           MENU            ║");
        System.out.println("║═══════════════════════════║");
        System.out.println("║                           ║");
        System.out.println("║ 1 => Rendirse             ║");
        System.out.println("║                           ║");
        System.out.println("║ 2 => Ver campo de batalla ║ ");
        System.out.println("║                           ║");
        System.out.println("║ 3 => Intercambiar Pokemon ║");
        System.out.println("║                           ║");
        System.out.println("║ 4 => Aplicar item         ║");
        System.out.println("║                           ║");
        System.out.println("║ 5 => Atacar               ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println(ANSI_RESET);

        System.out.println(ANSI_GRISCLARO);
        System.out.println("TURNO: " + this.jugadorView.getNombre());
        System.out.println("POKEMON: " + this.jugadorView.getNombrePokemonActual());
        this.sistemaDeClimaView.mostrarEfectosClima(jugadorView.getPokemonActualView());
        System.out.println("\nSELECCIONE UNA OPCION: ");
        System.out.println(ANSI_RESET);
    }


    //Mensajes de aplicar item.
    public void mostrarMensajeOpcionAplicarItem(){

        System.out.println(ANSI_VERDE + "\n╔══════════════╗");
        System.out.println("║ Aplicar Item ║");
        System.out.println("╚══════════════╝\n" + ANSI_RESET);

        jugadorView.mostratItems();
        System.out.println(ANSI_VERDEOSCURO + "Seleccione el item a aplicar: " + ANSI_RESET);


    }

    public void mostrarCasoModicicacion(Modificacion unaModificacion, Pokemon pokemon) {
        this.modificacionView = this.modificacionFactory.createModificacionView(unaModificacion);
        modificacionView.mostrar(pokemon.getCualidades());

    }

    public void mostrarMensajeAplicoItem(Jugador jugador, String nombreItem) {

        System.out.println(ANSI_VERDE + "\n╔═════════════════════════════╗");
        System.out.println("║ Se acaba de aplicar un item ║");
        System.out.println("╚═════════════════════════════╝\n" + ANSI_RESET);
        System.out.println("El jugador " + jugador.getNombre() + " acaba de usar " + nombreItem + ".");
        System.out.println(ANSI_VERDE + "ES EL TURNO DE " + this.jugadorView.getNombreJugadorAdversarioView().toUpperCase() + "\n" + ANSI_RESET);

        this.mensajeVolverAlMenu();
    }

    //Mensajes de atacar Pokemon.
    public void mostrarMensajeAtacarPokemon() {

        System.out.println(ANSI_VERDE + "\n╔════════════════╗");
                       System.out.println("║ Atacar Pokemon ║");
                       System.out.println("╚════════════════╝\n" + ANSI_RESET);

        this.jugadorView.mostratHabilidadesPokemonActual();
        System.out.println(ANSI_VERDEOSCURO + "Elige una habilidad: " + ANSI_RESET);
    }

    public void mostrarCasoAtques(Pokemon pokemon, Jugador jugadorAversario, String nombreHabilidad) {
        Habilidad habilidadAux = pokemon.getMisHabilidades().get(nombreHabilidad);
        this.jugadorView.getPokemonActualView().mostrarCasoSePuedeAtacar(pokemon, jugadorAversario.getPokemonActual(), habilidadAux);

    }

    //Mensajes de intercambiar Pokemon.
    public void mostrarMensajeIntercambiarPokemon() {

        System.out.println(ANSI_VERDE + "\n╔══════════════════════╗");
                       System.out.println("║ Intercambiar Pokemon ║");
                       System.out.println("╚══════════════════════╝\n" + ANSI_RESET);

        this.jugadorView.mostrarPokemones();
        System.out.println(ANSI_VERDEOSCURO + "Ingrese el nombre del pokemon que desea intercambiar: " + ANSI_RESET);
    }

    public void mostrarMensajeNoSeRealizoIntercambio(){
        System.out.println(ANSI_ROJO + "No se realizo el intercambio. \n" + ANSI_RESET);
        this.mensajeVolverAlMenu();
    }

    public void mostrarMensajeIntercambioAlAdversario(){

        System.out.println(ANSI_VERDE + "╔══════════════════════════════════════╗");
        System.out.println("║ El Adversario Intercambio el Pokemon ║ ");
        System.out.println("╚══════════════════════════════════════╝\n");
        System.out.println(ANSI_VERDE + "ES EL TURNO DE " + this.jugadorView.getNombreJugadorAdversarioView().toUpperCase() + "\n" + ANSI_RESET);
        this.mensajeVolverAlMenu();
    }

    //Mensajes de ver el campo de batalla.
    public void mostrarMensajeCampoBatalla() {

        System.out.println(ANSI_VERDEOSCURO + "\n╔══════════════════╗");
                             System.out.println("║ Campo de Batalla ║");
                             System.out.println("╚══════════════════╝\n" + ANSI_RESET);
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        this.jugadorView.mostrarPokemonActual();
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        this.jugadorView.getJugadorAdversarioView().mostrarPokemonActual();
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        System.out.println("\n");
        this.mensajeVolverAlMenu();
    }

    //Mensjes de rendirse,
    public void mostrarMensajeRendirse(){

              System.out.println(ANSI_VERDE + "╔═════════════════╗");
                           System.out.println("║ Usted se rindio ║ ");
                           System.out.println("╚═════════════════╝" + ANSI_RESET);
    }


}
