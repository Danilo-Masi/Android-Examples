package it.unibas.corrieri.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Utente;

public class AdapterListaUtenti extends BaseAdapter {

    private List<Utente> listaUtenti;

    public AdapterListaUtenti(List<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    @Override
    public int getCount() {
        if(listaUtenti == null) {
            return 0;
        }
        return listaUtenti.size();
    }

    @Override
    public Object getItem(int i) {
        return listaUtenti.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View converterView, ViewGroup parent) {
        View riga;
        if(converterView != null) {
            riga = converterView;
        }else  {
            LayoutInflater layoutInflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            riga = layoutInflater.inflate(R.layout.riga_corriere, parent, false);
        }
        Utente utente = this.listaUtenti.get(position);
        return riga;
    }
}
