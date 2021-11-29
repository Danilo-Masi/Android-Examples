package it.unibas.corrieri.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class AdapterCorrieri extends BaseAdapter {

    private List<Corriere> listaCorrieri;

    public AdapterCorrieri(List<Corriere> listaCorrieri) {
        this.listaCorrieri = listaCorrieri;
    }

    @Override
    public int getCount() {
        if(listaCorrieri == null) {
            return 0;
        }
        return listaCorrieri.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCorrieri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        Corriere corriere = this.listaCorrieri.get(position);
        TextView campoNumero = riga.findViewById(R.id.campoNumero);
        campoNumero.setText(corriere.getNumero() + "");
        TextView campNome = riga.findViewById(R.id.campoNome);
        campNome.setText(corriere.getNome());
        TextView campoZona = riga.findViewById(R.id.campoZonaC);
        campoZona.setText(corriere.getZona());
        return riga;
    }
}
