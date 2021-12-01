package it.unibas.corrieri.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Pacco;

public class AdapterListaPacchi extends BaseAdapter {

    private List<Pacco> listaPacchi;

    public AdapterListaPacchi(List<Pacco> listaPacchi) {
        this.listaPacchi = listaPacchi;
    }

    @Override
    public int getCount() {
        if(listaPacchi == null) {
            return 0;
        }
        return listaPacchi.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPacchi.get(position);
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
            riga = layoutInflater.inflate(R.layout.riga_pacco, parent, false);
        }
        Pacco pacco = this.listaPacchi.get(position);
        TextView campoData = riga.findViewById(R.id.campoData);
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        campoData.setText("Data: " + df.format(pacco.getDataSpedizione().getTime()));
        TextView campoPeso = riga.findViewById(R.id.campoPeso);
        campoPeso.setText("Peso " + pacco.getPeso() + " kg");
        TextView campoUrgente = riga.findViewById(R.id.campoUrgente);
        if(pacco.isUrgente()) {
            campoUrgente.setText(" Urgente ");
        }else {
            campoUrgente.setText(" Non urgente ");
        }
        TextView campoMittente = riga.findViewById(R.id.campoMittente);
        campoMittente.setText("Mittente: " + pacco.getUtenteMittente().toString());
        TextView campoDestinatario = riga.findViewById(R.id.campoDestinatario);
        campoDestinatario.setText("Destinatario: " + pacco.getUtenteDestinatario().toString());
        return riga;
    }
}
