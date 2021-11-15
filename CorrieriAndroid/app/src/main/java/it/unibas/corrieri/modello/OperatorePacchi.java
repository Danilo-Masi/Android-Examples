package it.unibas.corrieri.modello;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OperatorePacchi {

    // Proprietà di tipo String che prende il nome della classe
    // Serve per il log
    private static final String TAG = OperatorePacchi.class.getSimpleName();

    public  Pacco cercaReso(Pacco pacco) {
        //Presenta la data attuale
        Calendar dataLimite = new GregorianCalendar();
        //Modifichiamo la data di oggi con la data del pacco passato come paramentro
        dataLimite.setTime(pacco.getDataSpedizione().getTime());
        //Decrementiamo la data limite a 15 giorni prima
        dataLimite.add(Calendar.DAY_OF_MONTH,-15);
        //Messagio di log
        //La d sta come debug
        Log.d(TAG, "Data limite per il reso" + dataLimite);
        //Vediamo se l'utente destinatario ha ricevuto almeno un pacco in questa data limite
        Utente destinatario = pacco.getUtenteDestinatario();
        for(Pacco paccoInviato : destinatario.getPacchiInviati()) {
            if(paccoInviato.getUtenteDestinatario().getCodice().equalsIgnoreCase(pacco.getUtenteMittente().getCodice())
                    && paccoInviato.getDataSpedizione().getTime().after(dataLimite.getTime())) {
                return paccoInviato;
            }
        }
        return null;
    }

    public  boolean verificaDataSepdizione(Date data) {
        //Presenta la data attuale
        Calendar dataLimite = new GregorianCalendar();
        //Incrementiamo la data di oggi a domani
        dataLimite.add(Calendar.DAY_OF_MONTH, 1);
        //Verifichiamo che la data presa come paramentro viene dopo la data limite
        if(data.after(dataLimite.getTime())) {
            return false;
        }
        return true;
    }


}
