package orgFiuba.tpjava.Model;

import java.util.Random;

public class ServicioDeRandoms {

        static public int obtenerRandomParaHabilidadAtaqueCalculoCritico() {
            Random unRandom = new Random();
            return unRandom.nextInt(100);
        }

        static public double obtenerRandomParaHabilidadAtaqueCalculoAtaqueSegunTipo() {
            Random unRandom = new Random();
            return ((double)unRandom.nextInt(38)+217 ) / 255.0;
        }

        static public double obtenerRandomParaEstadoPuedeAtacar() {
            Random unRandom = new Random();
            return Math.round(unRandom.nextDouble() * 100)/ 100.0;
        }

        static public int obtenerRandomParaSistemaDeClimas(int tamanio) {
            Random unRandom = new Random();
            return unRandom.nextInt(tamanio);
        }
}
