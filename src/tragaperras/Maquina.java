package tragaperras;

import java.util.ArrayList;
import java.util.Random;

public class Maquina {
    private int casillas;
    private double precioJugada = 0.0;
    private double credito;
    private ArrayList<Premio> premiosDisponibles;

    // Constructor
    public Maquina(int casillas, double precioJugada, double credito, ArrayList<Premio> premiosDisponibles) {
        if (casillas <= 0) throw new IllegalArgumentException("El número de casillas debe ser positivo");
        if (precioJugada <= 0) throw new IllegalArgumentException("El precio por jugada debe ser positivo");
        if (credito < 0) throw new IllegalArgumentException("El crédito inicial no puede ser negativo");
        this.casillas = casillas;
        this.precioJugada = precioJugada;
        this.credito = credito;
        this.premiosDisponibles = new ArrayList<>(premiosDisponibles);
    }


    // Getters y Setters
    public int getCasillas() {
        return casillas;
    }

    public void setCasillas(int casillas) {
        this.casillas = casillas;
    }

    public double getPrecioJugada() {
        return precioJugada;
    }

    public void setPrecioJugada(double precioJugada) {
        this.precioJugada = precioJugada;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public ArrayList<Premio> getPremiosDisponibles() {
        return premiosDisponibles;
    }

    public void setPremiosDisponibles(ArrayList<Premio> premiosDisponibles) {
        this.premiosDisponibles = new ArrayList<>(premiosDisponibles);
    }

    // Otros metodos:

    // Incrementar credito
    public void incrementarCredito(double credito) {
        if (credito > 0) {
            this.credito += credito;
        }else{
            System.out.println("No se puede ingresar saldo negativo");
        }
    }

    // Generar combinaciones de frutas
    private final Random random = new Random();
    public ArrayList<Fruta> generarCombinacion() {
        ArrayList<Fruta> combinacionJugada = new ArrayList<>();
        Fruta[] todasLasFrutas = Fruta.values();
        for (int i = 0; i < this.casillas; i++) {
            combinacionJugada.add(todasLasFrutas[random.nextInt(todasLasFrutas.length)]);
        }
        return combinacionJugada;
    }


    // Jugar a la tragaperras
    public ArrayList<Fruta> jugar(){
        if (this.credito < precioJugada) {
            return null;
        }
            this.credito -= precioJugada;
            ArrayList<Fruta> combinacion = this.generarCombinacion();

            for (Premio premio: premiosDisponibles) {
                if (premio.getListaFrutas().equals(combinacion)) {
                    this.credito += premio.getPremio();
                }

            }

        return combinacion;
    }

    @Override
    public String toString() {
        return "La maquina comienza con: \n" +
                getCasillas() + " casillas\n" +
                getCredito() + " euros de saldo\n" +
                getPrecioJugada() + " euros por jugada\n" +
                "Premios disponibles:\n" + getPremiosDisponibles();
    }
}
