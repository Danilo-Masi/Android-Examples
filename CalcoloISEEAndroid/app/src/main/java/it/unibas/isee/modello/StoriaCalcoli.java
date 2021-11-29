package it.unibas.isee.modello;

import java.util.ArrayList;
import java.util.List;

public class StoriaCalcoli {

    private List<ModuloISEE> storia = new ArrayList<ModuloISEE>();

    public void aggiungiCalcolo(ModuloISEE moduloISEE){
        this.storia.add(moduloISEE);
    }

    public List<ModuloISEE> getStoria() {
        return storia;
    }
}
