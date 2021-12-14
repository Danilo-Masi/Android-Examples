package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import it.unibas.corrieri.R;

public class VistaSelezionaUtente extends Fragment {

    private ListView listaUtenti;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_seleziona_utente, container,false);
        this.listaUtenti = vista.findViewById(R.id.listaUtenti);
        return vista;
    }
}
