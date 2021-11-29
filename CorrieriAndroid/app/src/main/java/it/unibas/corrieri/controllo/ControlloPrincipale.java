package it.unibas.corrieri.controllo;

import android.util.Log;
import android.view.View;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityPrincipale;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneRicerca = new AzioneRicerca();

    public View.OnClickListener getAzioneRicerca() {
        return azioneRicerca;
    }

    private class AzioneRicerca implements View.OnClickListener {

        private String TAG = AzioneRicerca.class.getSimpleName();

        @Override
        public void onClick(View view) {
            Log.d(TAG, "Eseguo azione ricerca");
            //Chiamiamo il metodo getCampoZona per leggere l'input dell'utente
            //Prendiamo l'Activity corrente
             ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            String zona = vistaPrincipale.getCampoZona();
            //Cerchiamo i corrieri per zona
            List<Corriere> corrieriZona = Applicazione.getInstance().getServerMock().findCorriereByZona(zona);
            Log.d(TAG, "Caricati " + corrieriZona.size() + " corrieri");
            //Immetiamo i corrieri caricati nel modello
            Applicazione.getInstance().getModello().putBean(Costanti.CORRIERI, corrieriZona);
            //Visualizzaimo i dati nell'interfaccia
            vistaPrincipale.aggiornaDati();
        }
    }
}
