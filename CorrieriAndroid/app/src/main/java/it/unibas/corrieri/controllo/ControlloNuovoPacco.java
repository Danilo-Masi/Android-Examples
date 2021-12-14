package it.unibas.corrieri.controllo;

import android.view.View;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityNuovoPacco;
import it.unibas.corrieri.modello.Utente;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneSelezionaMittente = new AzioneSelezionaUtente(Costanti.AZIONE_SELEZIONA_MITTENTE);
    private View.OnClickListener azioneSelezionaDestinatario = new AzioneSelezionaUtente(Costanti.AZIONE_SELEZIONA_DESTINATARIO);

    public View.OnClickListener getAzioneSelezionaMittente() {
        return azioneSelezionaMittente;
    }

    public View.OnClickListener getAzioneSelezionaDestinatario() {
        return azioneSelezionaDestinatario;
    }

    private class AzioneSelezionaUtente implements View.OnClickListener {

        private String tipoSelezione;

        public AzioneSelezionaUtente(String tipoSelezione) {
            this.tipoSelezione = tipoSelezione;
        }

        @Override
        public void onClick(View view) {
            List<Utente> listaUtenti = Applicazione.getInstance().getServerMock().findAllUtenti();
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_UTENTI, listaUtenti);
            Applicazione.getInstance().getModello().putBean(Costanti.TIPO_SLEZIONE, tipoSelezione);
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            activityNuovoPacco.mostraActivitySelzionaUtente();
        }
    }
}
