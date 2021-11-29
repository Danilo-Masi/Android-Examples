package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class VistaPrincipale extends Fragment {

    private EditText campoZona;
    private Button bottoneRicerca;
    private ListView listaCorrieri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Istruzione che carica il file xml associato
        //vista fa riferminento alla ScrollView del xml
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        //Prediamo i componenti della vista tramite il comando findViewById
        this.campoZona = vista.findViewById(R.id.campoZona);
        this.bottoneRicerca = vista.findViewById(R.id.bottoneRicerca);
        this.listaCorrieri = vista.findViewById(R.id.listaCorrieri);
        //Aggiungiamo l'azione al bottone
        this.bottoneRicerca.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneRicerca());
        return vista;
    }

    //Funzione per vedere cosa c'è scritto nel campoZona
    public String getCampoZona() {
        return this.campoZona.getText().toString();
    }

    //Metodo per aggiornare i dati nella lista
    public void aggiornaDati() {
        List<Corriere> corrieri = (List<Corriere>) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERI);
        //Creaimao un Adapter ovvero una ModelloTabella
        AdapterCorrieri adapterCorrieri = new AdapterCorrieri(corrieri);
        this.listaCorrieri.setAdapter(adapterCorrieri);
    }
}
