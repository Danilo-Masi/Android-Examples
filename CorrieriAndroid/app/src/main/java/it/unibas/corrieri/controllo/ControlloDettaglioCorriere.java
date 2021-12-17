package it.unibas.corrieri.controllo;

import android.view.View;

import java.util.GregorianCalendar;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityDettaglioCorriere;

public class ControlloDettaglioCorriere {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Applicazione.getInstance().getModello().putBean(Costanti.MITTENTE_SELEZIONATO, null);
            Applicazione.getInstance().getModello().putBean(Costanti.DESTINATARIO_SELEZIONATO, null);
            Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA, new GregorianCalendar());
            ActivityDettaglioCorriere activityDettaglioCorriere = (ActivityDettaglioCorriere) Applicazione.getInstance().getCurrentActivity();
            activityDettaglioCorriere.mostraActivityNuovoPacco();
        }
    }

}
