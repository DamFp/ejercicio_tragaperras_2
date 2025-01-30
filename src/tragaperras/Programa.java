package tragaperras;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        // Arrays de combinaciones ganadoras de frutas
        ArrayList<Fruta> combinacionGanadora1 = new ArrayList<>();
        ArrayList<Fruta> combinacionGanadora2 = new ArrayList<>();

        // Añadiendo combinaciones ganadoras a los arrays de frutas
        combinacionGanadora1.add(Fruta.FRESA);
        combinacionGanadora1.add(Fruta.FRESA);
        combinacionGanadora1.add(Fruta.FRESA);

        combinacionGanadora2.add(Fruta.PLATANO);
        combinacionGanadora2.add(Fruta.PERA);
        combinacionGanadora2.add(Fruta.PLATANO);

        /*
         * Otra forma de agregar elementos a un ArrayList:
         * premios.add(new Premio(new ArrayList<>(Arrays.asList(Fruta.FRESA, Fruta.FRESA, Fruta.FRESA)), 10));
         */

        // Array de Premios
        ArrayList<Premio> premios = new ArrayList<>();

        // Creando los objetos premio
        Premio premio1 = new Premio(combinacionGanadora1, 10);
        Premio premio2 = new Premio(combinacionGanadora2, 15);

        // Agregando premio al arralist premios
        premios.add(premio1);
        premios.add(premio2);

        // Creando objeto maquinaTragaperras
        Maquina maquinaTragaperras = new Maquina(3, 2, 0.0, premios );

        // Comprobaciones por consola
        /*
        *System.out.println(combinacionGanadora1);
        *System.out.println(combinacionGanadora2);
        *System.out.println(premio1.getPremio());
        *System.out.println(premio2.getPremio());
         */




        // Incrementar crédito
        maquinaTragaperras.incrementarCredito(10.0);

        // Mostrar estado actual de la máquina tragaperras
        System.out.println("El estado inicial de la máquina: ");
        System.out.println(maquinaTragaperras);

        // Jugar hasta no tener saldo
        int jugada = 1;
        ArrayList<Fruta> resultado;

        while ((resultado = maquinaTragaperras.jugar()) != null) {
            System.out.println("\n### Jugada " + jugada + " ###");
            System.out.println("Resultado de la tirada: \n" + resultado);

            boolean premiado = false;
            for (Premio premio: premios) {
                if (resultado.equals(premio.getListaFrutas())){
                    premiado = true;
                    System.out.println("¡Has ganado " + premio.getPremio() + " créditos!");
                }
            }

            if (!premiado){
                System.out.println("Combinación no premiada");
            }

            System.out.println("Crédito restante " + maquinaTragaperras.getCredito());
            jugada ++;
        }

        System.out.println("\nLo siento no puedes seguir tirando, tu crédito es: " + maquinaTragaperras.getCredito());


    }
}
