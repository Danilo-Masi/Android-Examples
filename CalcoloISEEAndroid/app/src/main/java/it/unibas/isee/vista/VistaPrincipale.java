package it.unibas.isee.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import it.unibas.isee.Applicazione;
import it.unibas.isee.R;

public class VistaPrincipale extends Fragment {

    private EditText campoReddito;
    private EditText campoPatrimonio;
    private EditText campoNumeroComponenti;
    private Switch switchMinori;
    private Button bottoneCalcola;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        this.campoReddito = vista.findViewById(R.id.campoReddito);
        this.campoPatrimonio = vista.findViewById(R.id.campoPatrimonio);
        this.campoNumeroComponenti = vista.findViewById(R.id.campoComponenti);
        this.switchMinori = vista.findViewById(R.id.switchMinori);
        this.bottoneCalcola = vista.findViewById(R.id.bottoneCalcola);
        this.bottoneCalcola.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneCalcola());
        return vista;
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

}
