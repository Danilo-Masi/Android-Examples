package it.unibas.isee.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import it.unibas.isee.Applicazione;
import it.unibas.isee.Costanti;
import it.unibas.isee.R;
import it.unibas.isee.modello.ModuloISEE;
import it.unibas.isee.modello.StoriaCalcoli;

public class VistaPrincipale extends Fragment {

    private EditText campoReddito;
    private EditText campoPatrimonio;
    private EditText campoNumeroComponenti;
    private Switch switchMinori;
    private Button bottoneCalcola;
    private ListView listaStoriaCalcoli;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        this.campoReddito = vista.findViewById(R.id.campoReddito);
        this.campoPatrimonio = vista.findViewById(R.id.campoPatrimonio);
        this.campoNumeroComponenti = vista.findViewById(R.id.campoComponenti);
        this.switchMinori = vista.findViewById(R.id.switchMinori);
        this.bottoneCalcola = vista.findViewById(R.id.bottoneCalcola);
        this.bottoneCalcola.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneCalcola());
        this.listaStoriaCalcoli = vista.findViewById(R.id.listaStoriaCalcoli);
        //StoriaCalcoli storiaCalcoli = (StoriaCalcoli) Applicazione.getInstance().getModello().getBean(Costanti.STORIA_CALCOLI);
        StoriaCalcoli storiaCalcoli = (StoriaCalcoli) Applicazione.getInstance().getModelloPersistente().getPersistentBean(Costanti.STORIA_CALCOLI, StoriaCalcoli.class);
        AdapterStoriaCalcoli adapterStoriaCalcoli = new AdapterStoriaCalcoli(storiaCalcoli.getStoria());
        listaStoriaCalcoli.setAdapter(adapterStoriaCalcoli);
        listaStoriaCalcoli.setOnItemClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneSelezioneStoria());
        return vista;
    }

    public void aggiornaDati(){
        AdapterStoriaCalcoli adapterStoriaCalcoli = (AdapterStoriaCalcoli) listaStoriaCalcoli.getAdapter();
        adapterStoriaCalcoli.aggiornaContenuto();
    }

    public String getCampoReddito(){
        return this.campoReddito.getText().toString();
    }

    public String getCampoPatrimonio(){
        return this.campoPatrimonio.getText().toString();
    }

    public String getCampoNumeroComponenti(){
        return this.campoNumeroComponenti.getText().toString();
    }

    public boolean getSwithMinori(){
        return this.switchMinori.isChecked();
    }

    public void setErroreReddito(String messaggio){
        this.campoReddito.setError(messaggio);
    }

    public void setErrorePatrimonio(String messaggio){
        this.campoPatrimonio.setError(messaggio);
    }

    public void setErroreNumeroComponenti(String messaggio){
        this.campoNumeroComponenti.setError(messaggio);
    }

    public void inizializzaCampi(ModuloISEE moduloISEE) {
        this.campoReddito.setText(moduloISEE.getReddito() + "");
        this.campoPatrimonio.setText(moduloISEE.getPatrimonio() + "");
        this.campoNumeroComponenti.setText(moduloISEE.getNumeroComponenti() + "");
        this.switchMinori.setChecked(moduloISEE.isPresenzaMinori());
    }

    public void ripulisciCampi() {
        this.campoReddito.setText("");
        this.campoPatrimonio.setText("");
        this.campoNumeroComponenti.setText("");
        this.switchMinori.setChecked(false);
    }
}
