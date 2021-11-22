package it.unibas.isee.controllo;

import android.util.Log;
import android.view.View;

import it.unibas.isee.Applicazione;
import it.unibas.isee.activity.ActivityPrincipale;
import it.unibas.isee.modello.ModuloISEE;
import it.unibas.isee.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneCalcola = new AzioneCalcola();

    public View.OnClickListener getAzioneCalcola(){
        return this.azioneCalcola;
    }

    private class AzioneCalcola implements View.OnClickListener {

        private String TAG = this.getClass().getSimpleName();

        @Override
        public void onClick(View v) {
            Log.d(TAG, "Eseguo azione calcola...");
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            String campoReddito = vistaPrincipale.getCampoReddito();
            String campoPatrimonio = vistaPrincipale.getCampoPatrimonio();
            String campoNumeroComponenti = vistaPrincipale.getCampoNumeroComponenti();
            boolean presenzaMinori = vistaPrincipale.getSwithMinori();
            boolean errori = convalida(campoReddito, campoPatrimonio, campoNumeroComponenti, presenzaMinori, vistaPrincipale);
            if(errori){
                return;
            }
            double reddito = Double.parseDouble(campoReddito);
            double patrimonio = Double.parseDouble(campoPatrimonio);
            int numeroComponenti = Integer.parseInt(campoNumeroComponenti);
            ModuloISEE moduloISEE = new ModuloISEE(reddito, patrimonio, numeroComponenti, presenzaMinori);
            String messaggio = "Il valore dell'ISEE e' " + moduloISEE.getStringaValoreISEE();
            Log.d(TAG, messaggio);
            activityPrincipale.mostraMessaggio(messaggio);
        }

        private boolean convalida(String campoReddito, String campoPatrimonio, String campoNumeroComponenti, boolean presenzaMinori, VistaPrincipale vistaPrincipale){
            boolean errori = false;
            if(campoReddito.trim().isEmpty()){
                errori = true;
                vistaPrincipale.setErroreReddito("Il campo reddito e' obbligatorio");
            } else {
                try{
                    double reddito = Double.parseDouble(campoReddito);
                    //Nota: le seguenti convalide sono inutili impostando correttamente l'inputType del EditText
                    if(reddito < 0){
                        errori = true;
                        vistaPrincipale.setErroreReddito("Il reddito dev'essere maggiore di zero");
                    }
                }catch(NumberFormatException ex){
                    errori = true;
                    vistaPrincipale.setErroreReddito("Il campo reddito dev'essere un numero");
                }
            }
            if(campoPatrimonio.trim().isEmpty()){
                errori = true;
                vistaPrincipale.setErrorePatrimonio("Il campo patrimonio e' obbligatorio");
            }
            if(campoNumeroComponenti.trim().isEmpty()){
                errori = true;
                vistaPrincipale.setErroreNumeroComponenti("Il campo numero componenti e' obbligatorio");
            } else {
                int numeroComponenti = Integer.parseInt(campoNumeroComponenti);
                if(numeroComponenti < 3 && presenzaMinori){
                    errori = true;
                    vistaPrincipale.setErroreNumeroComponenti("In caso di presenza di minori i componenti devono essere almeno tre");
                }
            }
            return errori;
        }
    }

}
