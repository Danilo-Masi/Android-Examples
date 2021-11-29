package it.unibas.corrieri.persistenza;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public class ServerMock {

    //IN QUESTA PAGINA NON BISOGNA INSERIRE CODICE DI LOGICA APPLICATIVA
    //IN QUANTO NEL CASO DOVESSIMO TRASFERIRE LA NOSTRA APP SU UN SERVER REALE
    //DOVREMMO ESSERE IN GRADO DI CANCELLARE QUESTA PAGINA SENZA PROBLEMI.

    private List<Corriere> listaCorrieri = new ArrayList<>();
    private List<Utente> listaUtenti = new ArrayList<>();

    public ServerMock() {
        Utente utente1 = new Utente("MR0", "elliot", "Choy", "Main street", 4);
        listaUtenti.add(utente1);
        Utente utente2 = new Utente("RRR", "Luis", "Sal", "Non street", 24);
        listaUtenti.add(utente2);
        //Serve solo per la creazioni di utenti in modo rapido
        for (int i = 10; i < 50; i++) {
            listaUtenti.add(new Utente("U", "zzz test Utente", "Utente" + i, "Via test", i));
        }
        Corriere corriere1 = new Corriere(1, "Walter white", "centro");
        listaCorrieri.add(corriere1);
        Pacco pacco1 = new Pacco(new GregorianCalendar(2020, Calendar.JULY, 1), false, 1.4, utente1, utente2);
        corriere1.aggiungiPacco(pacco1);
        utente1.aggiungiPaccoInviato(pacco1);
        //Serve solo per la creazioni di corrieri in modo rapido
        for (int i = 10; i < 50; i++) {
            listaCorrieri.add(new Corriere(i, "zzz test Corriere" + i, "centro"));
        }
    }

    public List<Corriere> findCorriereByZona(String zona) {
        List<Corriere> listaFiltarata = new ArrayList<>();
        for (Corriere corriere: this.listaCorrieri) {
            if(corriere.getZona().equalsIgnoreCase(zona)) {
                listaFiltarata.add(corriere);
            }
        }
        return listaFiltarata;
    }

    public List<Utente> findAllUtenti() {
        return this.listaUtenti;
    }

    public void salvaPacco(Pacco pacco) {
        //SERVE UNA VOLTA CHE AVREMO IL SERVER REALE
        //IN QUESTO CASO NON LO UTILIZZIAMO
    }


}
