package it.unibas.corrieri.modello;

import java.util.Calendar;

public class Pacco {

    private Calendar dataSpedizione;
    private boolean urgente;
    private double peso;
    private Utente utenteMittente;
    private Utente utenteDestinatario;

    public Pacco(Calendar dataSpedizione, boolean urgente, double peso, Utente utenteMittente, Utente utenteDestinatario) {
        this.dataSpedizione = dataSpedizione;
        this.urgente = urgente;
        this.peso = peso;
        this.utenteMittente = utenteMittente;
        this.utenteDestinatario = utenteDestinatario;
    }

    public Calendar getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(Calendar dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Utente getUtenteMittente() {
        return utenteMittente;
    }

    public void setUtenteMittente(Utente utenteMittente) {
        this.utenteMittente = utenteMittente;
    }

    public Utente getUtenteDestinatario() {
        return utenteDestinatario;
    }

    public void setUtenteDestinatario(Utente utenteDestinatario) {
        this.utenteDestinatario = utenteDestinatario;
    }
}
