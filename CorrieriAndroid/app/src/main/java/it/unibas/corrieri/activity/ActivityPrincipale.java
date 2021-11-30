package it.unibas.corrieri.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    public VistaPrincipale getVistaPrincipale() {
        return (VistaPrincipale) getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

    public void mostraActivityDettaglioCorriere() {
        Intent intent = new Intent(this, ActivityDettaglioCorriere.class);
        this.startActivity(intent);
    }
}
