package it.unibas.isee.modello;

import java.text.NumberFormat;

public class ModuloISEE {

    private double reddito;
    private double patrimonio;
    private int numeroComponenti;
    private boolean presenzaMinori;

    public ModuloISEE(double reddito, double patrimonio, int numeroComponenti, boolean presenzaMinori) {
        this.reddito = reddito;
        this.patrimonio = patrimonio;
        this.numeroComponenti = numeroComponenti;
        this.presenzaMinori = presenzaMinori;
    }

    public double getReddito() {
        return reddito;
    }

    public void setReddito(double reddito) {
        this.reddito = reddito;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getNumeroComponenti() {
        return numeroComponenti;
    }

    public void setNumeroComponenti(int numeroComponenti) {
        this.numeroComponenti = numeroComponenti;
    }

    public boolean isPresenzaMinori() {
        return presenzaMinori;
    }

    public void setPresenzaMinori(boolean presenzaMinori) {
        this.presenzaMinori = presenzaMinori;
    }

    public double getValoreISEE(){
        return (this.reddito + this.patrimonio * 0.2) / getParametroScalaEquivalenza();
    }

    public String getStringaValoreISEE(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        return numberFormat.format(getValoreISEE());
    }

    private double getParametroScalaEquivalenza(){
        double parametroScalaEquivalenza;
        if(this.numeroComponenti == 1){
            parametroScalaEquivalenza = 1.0;
        } else if(this.numeroComponenti == 2){
            parametroScalaEquivalenza = 1.5;
        } else if(this.numeroComponenti == 3){
            parametroScalaEquivalenza = 2.0;
        } else {
            parametroScalaEquivalenza = 2.5;
        }
        if(this.presenzaMinori){
            parametroScalaEquivalenza += 0.5;
        }
        return parametroScalaEquivalenza;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModuloISEE{");
        sb.append("reddito=").append(reddito);
        sb.append(", patrimonio=").append(patrimonio);
        sb.append(", numeroComponenti=").append(numeroComponenti);
        sb.append(", presenzaMinori=").append(presenzaMinori);
        sb.append('}');
        return sb.toString();
    }
}
