package it.unibas.corrieri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaNuovoPacco;

public class ActivityNuovoPacco extends AppCompatActivity {

    public static final String TAG = ActivityNuovoPacco.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_pacco);
    }

    public VistaNuovoPacco getVistaNuovoPacco() {
        return (VistaNuovoPacco) getSupportFragmentManager().findFragmentById(R.id.vistaNuovoPacco);
    }

    public void mostraActivitySelzionaUtente() {
        Intent intent = new Intent(this, ActivitySelezionaUtente.class);
        this.startActivity(intent);
    }

    public void mostraFinestraErrori(String errori) {
        Toast.makeText(this, errori,Toast.LENGTH_LONG).show();
    }
}
