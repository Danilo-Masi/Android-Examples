package it.unibas.isee.activity;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.isee.R;
import it.unibas.isee.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    public VistaPrincipale getVistaPrincipale(){
        return (VistaPrincipale) getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

    public void mostraMessaggio(String messaggio){
        //Toast.makeText(this, messaggio, Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage(messaggio);
        builder.create().show();
    }

}
