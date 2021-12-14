package it.unibas.corrieri.controllo;

import android.view.View;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.activity.ActivityDettaglioCorriere;

public class ControlloDettaglioCorriere {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            ActivityDettaglioCorriere activityDettaglioCorriere = (ActivityDettaglioCorriere) Applicazione.getInstance().getCurrentActivity();
            activityDettaglioCorriere.mostraActivityNuovoPacco();
        }
    }

}
