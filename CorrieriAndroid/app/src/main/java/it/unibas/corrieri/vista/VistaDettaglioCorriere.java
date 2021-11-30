package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class VistaDettaglioCorriere extends Fragment {

    private ListView listaPacchi;
    private TextView campoCorriere;
    private Button bottoneNuovoPacco;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_dettaglio_corriere, container, false);
        this.listaPacchi = vista.findViewById(R.id.listaPacchi);
        this.campoCorriere = vista.findViewById(R.id.campoCorriere);
        this.bottoneNuovoPacco = vista.findViewById(R.id.bottoneNuovoPacco);
        aggiornaDati();
        return vista;
    }

    private void aggiornaDati() {
        Corriere corriere = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
        AdapterListaPacchi adapterListaPacchi = new AdapterListaPacchi(corriere.getPacchi());
        listaPacchi.setAdapter(adapterListaPacchi);
        campoCorriere.setText(corriere.getNome());
    }

}
