package modele;

import modele.donnee.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * une classe qui effectue les tests necessaires sur le package donnee
 * @author William, Eve-Anne, Theo, Tristan, Lucas
 * @version 1.0
 * derniere modif : William
 */
public class ScenarioDonnee{
    /**
    * Constitue le main de la classe
    * @param args tableau de String
    */
    public static void main(String[] args){
        
        //Observateurs
        testObservateur();

        //Test ObsHippocampe        
        testObsHippocampe();

        //Test ObsBatracien
        testObsBatracien();

        //Test ObsLoutre 

        //Test ObsChouette

    }

    /** teste la classe Observateur */
    public static void testObservateur() {

        Observateur obs1 = new Observateur(1, "Jean", "Pierre");
        Observateur obs2 = new Observateur(2, "Anne", "Bourbigot");
        Observateur obs3 = new Observateur(3, "Theo", "CasseBurne");
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        observateurs.add(obs1);
        observateurs.add(obs2);
        observateurs.add(obs3);

    }

    /** teste la classe ObsHippocampe */
    public static void testObsHippocampe() {

        Date date = Date.valueOf("2022-18-02");
        // Time heure = new Time(11,2,12);
        Lieu lieu = new Lieu(123454.32,234211.2354);
        
        //Creation de l'objet ObsHippocampe
        ObsHippocampe newObsHippocampe = new ObsHippocampe(1, date, heure, lieu, observateurs, 23.3, Peche.CASIER_CREVETTES, EspeceHippocampe.SYNGNATHUS_ACUS, Sexe.MALE);

    }

    /** teste la classe ObsBatracien */
    public static void testObsBatracien() {

        //Creation du tableau regroupant le nombre d'individu pour chaque espece
        int nombreAdultes = 4;
        int nombreAmplexus = 6;
        int nombreTetard = 1900;
        int nombrePonte = 19;
        int[] tabBatracien = new int[4];
        tabBatracien[0] = nombreAdultes;
        tabBatracien[1] = nombreAmplexus;   
        tabBatracien[2] = nombreTetard; 
        tabBatracien[3] = nombrePonte;

        //Creation de l'objet ObsBatracien
        ObsBatracien testBatracien = new ObsBatracien(1, date, heure, lieu, observateurs, tabBatracien, EspeceBatracien.CALAMITE);
        
    }

    /** teste la classe ObsChouette et ses methodes */
    public static void testObsChouette() {

        System.out.println("Partie Chouettes/ObsChouette..." + "\n");
        ObsChouette obsChouette1 = new ObsChouette(1,date,heure,lieu, observateurs, TypeObservation.SONORE);
        Chouette newChouette = new Chouette(1,Sexe.FEMELLE,EspeceChouette.HULOTTE);
        Chouette falseChouette = new Chouette(2,null,null);
        ObsChouette obsChouette2 = new ObsChouette(2,date,heure,lieu,observateurs,TypeObservation.VISUELLE);
        ObsChouette obsChouette3 = new ObsChouette(3,date,heure,lieu,observateurs,TypeObservation.SONORE_VISUELLE);
            //liste d'observations 
        ArrayList<ObsChouette> list = new ArrayList<ObsChouette>();
        list.add(obsChouette2);
        list.add(obsChouette3);

            //tests methodes chouette
        newChouette.ajouteUneObs(obsChouette1);
        newChouette.ajoutePlsObs(list);;
        System.out.println("Observations de chouettes (doit y en avoir 3) : ");
        int n = 1;
        for(ObsChouette elem : newChouette.getLesObservations()){
            System.out.println("Observation " + n + " : " + elem);
            n++;
        }

        newChouette.retireObs(0);
        System.out.println("Observations de chouettes (La premiere doit avoir disparu) : ");
        n = 1;
        for(ObsChouette elem : newChouette.getLesObservations()){
            System.out.println("Observation " + n + " : " + elem);
            n++;
        }

        System.out.println("Nombre d'observations : " + newChouette.nbObs());

        newChouette.videObs();
        System.out.println("Observations de chouettes (aucune) : ");
        n = 1;
        for(ObsChouette elem : newChouette.getLesObservations()){
            System.out.println("Observation " + n + " : " + elem);
            n++;
        }

    }

}


