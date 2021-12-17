package it.unibas.corrieri.controllo;

import android.view.View;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityNuovoPacco;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.OperatorePacchi;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;
import it.unibas.corrieri.vista.VistaNuovoPacco;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneSelezionaMittente = new AzioneSelezionaUtente(Costanti.AZIONE_SELEZIONA_MITTENTE);
    private View.OnClickListener azioneSelezionaDestinatario = new AzioneSelezionaUtente(Costanti.AZIONE_SELEZIONA_DESTINATARIO);
    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();
    private CalendarView.OnDateChangeListener azioneSelezionaData = new AzioneSelezionaData();


    public CalendarView.OnDateChangeListener getAzioneSelezionaData() {
        return azioneSelezionaData;
    }

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    public View.OnClickListener getAzioneSelezionaMittente() {
        return azioneSelezionaMittente;
    }

    public View.OnClickListener getAzioneSelezionaDestinatario() {
        return azioneSelezionaDestinatario;
    }

    private class AzioneSelezionaData implements CalendarView.OnDateChangeListener {

        @Override
        public void onSelectedDayChange(CalendarView calendarView, int anno, int mese, int giorno) {
            Calendar calendar = new GregorianCalendar(anno,mese, giorno);
            Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA, calendar);
        }
    }


    private class AzioneNuovoPacco implements View.OnClickListener {

        private OperatorePacchi operatorePacchi = new OperatorePacchi();

        @Override
        public void onClick(View view) {
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            VistaNuovoPacco vistaNuovoPacco = activityNuovoPacco.getVistaNuovoPacco();
            Corriere corriere = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
            Utente mittente = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.MITTENTE_SELEZIONATO);
            Utente destinatario = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.DESTINATARIO_SELEZIONATO);
            boolean isUrgente = vistaNuovoPacco.isUrgente();
            String stringPeso = vistaNuovoPacco.getPeso();
            Calendar dataSelezionata = (Calendar) Applicazione.getInstance().getModello().getBean(Costanti.DATA_SELEZIONATA);
            String errori = convalida(mittente,destinatario,stringPeso,dataSelezionata,isUrgente);
            if(!errori.isEmpty()) {
                activityNuovoPacco.mostraFinestraErrori(errori);
                return;
            }
            double peso = Double.parseDouble(stringPeso);
            Pacco nuovoPacco = new Pacco(dataSelezionata,isUrgente,peso,mittente,destinatario);
            Pacco reso = operatorePacchi.cercaReso(nuovoPacco);
            if(reso != null && reso.getPeso() != nuovoPacco.getPeso()) {
                activityNuovoPacco.mostraFinestraErrori("Il pacco e un reso ");
                return;
            }
            corriere.aggiungiPacco(nuovoPacco);
            mittente.aggiungiPaccoInviato(nuovoPacco);
            Applicazione.getInstance().getServerMock().salvaPacco(nuovoPacco);
            activityNuovoPacco.finish();
        }

        private String convalida(Utente mittente, Utente destinatario, String stringPeso, Calendar dataSelezionata, boolean isUrgente) {
            StringBuilder errori = new StringBuilder();
            if(mittente == null) {
                errori.append("Mittente obbligatorio \n");
            }
            if(destinatario == null) {
                errori.append("Destinatario obbligatorio \n");
            }
            if(mittente != null && destinatario != null && mittente.getCodice().equalsIgnoreCase(destinatario.getCodice())) {
                errori.append("Il mittente ed il destinatario non possono coincidere \n");
            }
            if(stringPeso.isEmpty()) {
                errori.append("Inserire un peso valido");
            }
            if(dataSelezionata == null) {
                errori.append("Inserire una data valida");
            }else if(isUrgente && !operatorePacchi.verificaDataSepdizione(dataSelezionata.getTime())){
                errori.append("La data inserita non e valida");
            }
            return errori.toString();
        }

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
