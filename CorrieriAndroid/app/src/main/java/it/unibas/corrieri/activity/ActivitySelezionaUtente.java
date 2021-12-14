package it.unibas.corrieri.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaSelezionaUtente;

public class ActivitySelezionaUtente extends AppCompatActivity {

    public static final String TAG = ActivitySelezionaUtente.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleziona_utente);

    }

    public VistaSelezionaUtente getVistaSelezionaUtente() {
        return (VistaSelezionaUtente) getSupportFragmentManager().findFragmentById(R.id.vistaSelezionaUtente);
    }
}
