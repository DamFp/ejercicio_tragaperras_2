package tragaperras;

import java.util.ArrayList;
import java.util.List;

public class Premio {

    private List<Fruta> listaFrutas;
    private int premio;

    public Premio(List<Fruta> listaFrutas, int premio) {
        this.listaFrutas = new ArrayList<>(listaFrutas);
        this.premio = premio;
    }

    // Getters y Setters
    public List<Fruta> getListaFrutas() {
        return new ArrayList<>(listaFrutas);
    }

    public int getPremio() {
        return premio;
    }

    public void setListaFrutas(List<Fruta> listaFrutas) {
        this.listaFrutas = new ArrayList<>(listaFrutas);
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Combinacion ganadora " + getListaFrutas() +
                " Premio: " + getPremio() + " Euros";
    }
}
