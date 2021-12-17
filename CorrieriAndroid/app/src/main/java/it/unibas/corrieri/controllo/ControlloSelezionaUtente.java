package it.unibas.corrieri.controllo;

import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.modello.Utente;

public class ControlloSelezionaUtente {

    private AdapterView.OnItemClickListener selezionaUtente = new AzioneSelezionaUtente();

    class AzioneSelezionaUtente implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            List<Utente> listaUtenti = (List<Utente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_UTENTI);
            Utente utente = listaUtenti.get(i);
            String tipoSelezione = (String) Applicazione.getInstance().getModello().getBean(Costanti.TIPO_SLEZIONE);
            if(tipoSelezione.equalsIgnoreCase(Costanti.AZIONE_SELEZIONA_MITTENTE)) {
                    Applicazione.getInstance().getModello().putBean(Costanti.MITTENTE_SELEZIONATO, utente);
            }else {
                    Applicazione.getInstance().getModello().putBean(Costanti.DESTINATARIO_SELEZIONATO, utente);
            }
            Applicazione.getInstance().getCurrentActivity().finish();
        }
    }

    public AdapterView.OnItemClickListener getSelezionaUtente() {
        return selezionaUtente;
    }
}
