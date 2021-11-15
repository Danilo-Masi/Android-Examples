package it.unibas.corrieri.modello;


import java.util.ArrayList;
import java.util.List;

public class Corriere implements Comparable<Corriere>{

    private int numero;
    private String nome;
    private String zona;
    private List<Pacco> pacchi = new ArrayList<Pacco>();

    public Corriere(int numero, String nome, String zona) {
        this.numero = numero;
        this.nome = nome;
        this.zona = zona;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<Pacco> getPacchi() {
        return pacchi;
    }

    public void setPacchi(List<Pacco> pacchi) {
        this.pacchi = pacchi;
    }

    public void aggiungiPacco(Pacco pacco) {
        this.pacchi.add(pacco);
    }


    @Override
    public int compareTo(Corriere corriere) {
        return nome.compareTo(corriere.nome);
    }
}
