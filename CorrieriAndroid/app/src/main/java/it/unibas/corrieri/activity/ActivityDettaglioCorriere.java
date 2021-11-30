package it.unibas.corrieri.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaDettaglioCorriere;

public class ActivityDettaglioCorriere extends AppCompatActivity {

    public static final String TAG = ActivityDettaglioCorriere.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_corriere);
    }

    public VistaDettaglioCorriere getVistaDettaglioCorriere() {
        return (VistaDettaglioCorriere) getSupportFragmentManager().findFragmentById(R.id.vistaDettaglioCorriere);
    }

}
