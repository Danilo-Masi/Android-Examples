package it.unibas.isee.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.isee.Applicazione;
import it.unibas.isee.R;
import it.unibas.isee.modello.ModuloISEE;

public class AdapterStoriaCalcoli extends BaseAdapter {

    private List<ModuloISEE> storia;

    public AdapterStoriaCalcoli(List<ModuloISEE> storia) {
        this.storia = storia;
    }

    public List<ModuloISEE> getStoria() {
        return storia;
    }

    public void setStoria(List<ModuloISEE> storia) {
        this.storia = storia;
    }

    @Override
    public int getCount() {
        if(storia == null){
            return 0;
        }
        return storia.size();
    }

    @Override
    public Object getItem(int position) {
        return storia.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View recycledView, ViewGroup parent) {
        View riga;
        if(recycledView == null){
            LayoutInflater layoutInflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Applicazione.LAYOUT_INFLATER_SERVICE);
            riga = layoutInflater.inflate(R.layout.riga_storia, parent, false);
        } else {
            riga = recycledView;
        }
        ModuloISEE moduloISEE = storia.get(position);
        TextView campoReddito = riga.findViewById(R.id.campoReddito);
        campoReddito.setText("Reddito: " + moduloISEE.getReddito());
        TextView campoPatrimonio = riga.findViewById(R.id.campoPatrimonio);
        campoPatrimonio.setText("Patrimonio: " + moduloISEE.getPatrimonio());
        TextView campoMinori = riga.findViewById(R.id.campoMinori);
        if(moduloISEE.isPresenzaMinori()){
            campoMinori.setText("Presenza di minori");
        } else {
            campoMinori.setText("Assenza di minori");
        }
        TextView campoIsee = riga.findViewById(R.id.campoISEE);
        campoIsee.setText(moduloISEE.getStringaValoreISEE());
        return riga;
    }

    public void aggiornaContenuto(){
        super.notifyDataSetChanged();
    }
}
