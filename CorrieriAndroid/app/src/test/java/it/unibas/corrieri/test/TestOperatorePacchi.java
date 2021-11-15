package it.unibas.corrieri.test;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;

import it.unibas.corrieri.modello.OperatorePacchi;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public class TestOperatorePacchi extends TestCase {
    private OperatorePacchi operatore = new OperatorePacchi();

    public void testNoReso1() {
        Utente utente1 = new Utente("1", "Test", "User1", "",1);
        Utente utente2 = new Utente("2", "Test", "User2", "",2);
        Pacco paccoDaVerificare = new Pacco((new GregorianCalendar(2020, Calendar.JANUARY,1)),false,1.0,utente1,utente2);
        utente1.aggiungiPaccoInviato(paccoDaVerificare);
        assertNull(operatore.cercaReso(paccoDaVerificare));
    }

    //Aggiungere altri test simili al testReso1 con altre asserzioni
}
