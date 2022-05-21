package modele;

import modele.donnee.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * une classe qui effectue les tests necessaires sur le package donnee
 * @author William, Eve-Anne, Theo, Tristan, Lucas
 * @version 1.1
 * derniere modif : William
 */
public class ScenarioDonnee {
    /**
    * Constitue le main de la classe
    * @param args tableau de String
    */
    public static void main(String[] args){
        
        String separator = "---------------------------------------------------------------------------";

        // test Observateur
        System.out.println("\n\ntest Observateur\n" + separator);
        try {
            
            testObservateur();

        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }

        // creation d'observateurs
        ArrayList<Observateur> obs = initObservateur();


        // test ObsHippocampe
        System.out.println("\n\ntest ObsHippocampe\n" + separator);
        try {
            
            testObsHippocampe(obs);

            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }                
        
        // test ObsBatracien
        System.out.println("\n\ntest ObsBatracien\n" + separator);
        try {
            
            testObsBatracien(obs);

        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }
        
        // test ObsChouette
        System.out.println("\n\ntest ObsChouette\n" + separator);
        try {
            
            testObsChouette(obs);

        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }

        // test ObsGCI
        System.out.println("\n\ntest ObsGCI\n" + separator);
        try {
            
            testObsGCI(obs);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // test NidGCI
        System.out.println("\n\ntest NidGCI\n" + separator);
        try {
            
            testNidGCI(obs);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // test ObsLoutre
        System.out.println("\n\ntest ObsLoutre\n" + separator);
        try {
            
            testObsLoutre(obs);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    /** 
     * crees des instances d'observateur
     * @return un ArrayList pour tester les autres classes
     * */
    public static ArrayList<Observateur> initObservateur() {

        Observateur obs1 = new Observateur(1, "Jean", "Pierre");
        Observateur obs2 = new Observateur(2, "Anne", "Bourbigot");
        Observateur obs3 = new Observateur(3, "Theo", "Phuoc Thach");

        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        
        observateurs.add(obs1);
        observateurs.add(obs2);
        observateurs.add(obs3);

        return observateurs;

    }

    /**
     * teste la classe Observateur
     */
    public static void testObservateur() {

        // Creation d'un objet Observateur
        Observateur unObs = new Observateur(0, "White", "Walter");

        System.out.println("\nerreurs :");
        // Creation d'un objet Observateur invalide
        Observateur deuxObs = new Observateur(1, null, "Jesse");

    } 

    /** 
     * teste la classe ObsHippocampe
     * @param observateurs un ArrayList contenant des observateurs
     */
    public static void testObsHippocampe(ArrayList<Observateur> observateurs) {

        // Date, heure et lieu
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());
        Lieu lieu = new Lieu(123454.32,234211.2354);
        
        // Creation de l'objet ObsHippocampe
        ObsHippocampe testObsHippocampe = new ObsHippocampe(1, date, heure, lieu, observateurs, 23.3, Peche.CASIER_CREVETTES, EspeceHippocampe.SYNGNATHUS_ACUS, Sexe.MALE);

        System.out.println("\nerreurs :");
        // Creation d'un objet ObsHippocampe invalide
        ObsHippocampe wrongObsHippocampe = new ObsHippocampe(2, date, heure, lieu, observateurs, 23.3, null, EspeceHippocampe.SYNGNATHUS_ACUS, Sexe.MALE);

    }

    /** 
     * teste la classe ObsBatracien
     * @param observateurs un ArrayList contenant des observateurs
     */
    public static void testObsBatracien(ArrayList<Observateur> observateurs) {

        //Date, heure et lieu
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());
        Lieu lieu = new Lieu(123454.32,234211.2354);

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
        ObsBatracien testObsBatracien = new ObsBatracien(1, date, heure, lieu, observateurs, tabBatracien, EspeceBatracien.CALAMITE);
       
        System.out.println("\nerreurs :");
       // Creation d'un object ObsBatracien invalide
        ObsBatracien wrongObsBatracien = new ObsBatracien(1, date, heure, lieu, observateurs, tabBatracien, null);
        
    }

    /** 
     * teste la classe ObsChouette et ses methodes
     * @param observateurs un ArrayList contenant des observateurs 
     * @author Eve-Anne
     */
    public static void testObsChouette(ArrayList<Observateur> observateurs) {

        //Date, heure et lieu
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());
        Lieu lieu = new Lieu(123454.32,234211.2354);

        // System.out.println("Partie Chouettes/ObsChouette..." + "\n");

        ObsChouette obsChouette1 = new ObsChouette(1,date,heure,lieu, observateurs, TypeObservation.SONORE);
        Chouette newChouette = new Chouette("1",Sexe.FEMELLE,EspeceChouette.HULOTTE);
        Chouette falseChouette = new Chouette("2",null,null);
        ObsChouette obsChouette2 = new ObsChouette(2,date,heure,lieu,observateurs,TypeObservation.VISUELLE);
        ObsChouette obsChouette3 = new ObsChouette(3,date,heure,lieu,observateurs,TypeObservation.SONORE_VISUELLE);
            
        //liste d'observations 
        ArrayList<ObsChouette> list = new ArrayList<ObsChouette>();
        list.add(obsChouette2);
        list.add(obsChouette3);

        //tests methodes chouette
        newChouette.ajouteUneObs(obsChouette1);
        newChouette.ajoutePlsObs(list);
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

    /** 
     * teste la classe ObsGCI 
     * @param observateurs un ArrayList contenant des observateurs
     * @author William
     */
    public static void testObsGCI(ArrayList<Observateur> observateurs) {

        //Date, heure et lieu
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());
        Lieu lieu = new Lieu(123454.32,234211.2354);

        // Creation d'un objet ObsGCI
        ObsGCI unObsGCI = new ObsGCI(1, date, heure, lieu, observateurs, ContenuNid.OEUF, 3);

        System.out.println("\nerreurs :");
        // Creation d'objets ObsGCI invalide
        ObsGCI ErrorObsGCI = new ObsGCI(2, date, heure, lieu, observateurs, null, 2);
        ObsGCI ExceptionObsGCI = new ObsGCI(3, date, heure, lieu, observateurs, ContenuNid.NID_SEUL, -1);

    }

    /**
     * teste la classe NidGCI et ses methodes a l'aide d'instances d'ObsGCI
     * @param observateurs un ArrayList contenant des observateurs
     * @author William
     */
    public static void testNidGCI(ArrayList<Observateur> observateurs) {

        //Date, heure et lieu
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());
        Lieu lieu = new Lieu(123454.32,234211.2354);

        // Creation d'objets ObsGCI
        ObsGCI unObsGCI = new ObsGCI(1, date, heure, lieu, observateurs, ContenuNid.OEUF, 3);
        ObsGCI deuxObsGCI = new ObsGCI(2, date, heure, lieu, observateurs, ContenuNid.OEUF, 2);
        ObsGCI troisObsGCI = new ObsGCI(3, date, heure, lieu, observateurs, ContenuNid.OEUF, 1);

        // Creation d'objets NidGCI
        NidGCI testNidGCI = new NidGCI(3, "Cabourg");


        // Tests des methodes heritees de l'interface IObs

        // Creation d'une lsite d'observations
        ArrayList<ObsGCI> liste = new ArrayList<ObsGCI>();
        liste.add(deuxObsGCI);
        liste.add(troisObsGCI);

        // tests ajouts
        testNidGCI.ajouteUneObs(unObsGCI);
        testNidGCI.ajoutePlsObs(liste);

        System.out.println("Liste des observations (3 observations) : ");
        for (ObsGCI obs : testNidGCI.getLesObservations()) {

            System.out.println("- " + obs);

        }
        // test nombre
        System.out.println("Nombre d'observations = " + testNidGCI.nbObs());

        // test suppression
        testNidGCI.retireObs(0);

        System.out.println("\nListe des observations (2 observations, la premiere a disparu) : ");
        for (ObsGCI obs : testNidGCI.getLesObservations()) {

            System.out.println("- " + obs);

        }

        // test vidage
        testNidGCI.videObs();

        System.out.println("\nListe des observations (aucune) : ");
        for (ObsGCI obs : testNidGCI.getLesObservations()) {

            System.out.println("- " + obs);

        }

        System.out.println("\nerreurs :");
        // Creation d'un objet NidGCI invalide
        NidGCI wrongNidGCI = new NidGCI(-1, "Dieppe");
        
    }

    /** 
     * teste la classe ObsLoutre 
     * @param observateurs un ArrayList contenant des observateurs
     * @author William
     */
    public static void testObsLoutre(ArrayList<Observateur> observateurs) {

        //Date, heure et lieu
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());
        Lieu lieu = new Lieu(123454.32,234211.2354);

        // Creation d'un objet ObsGCI
        ObsLoutre testObsLoutre = new ObsLoutre(1, date, heure, lieu, observateurs, IndiceLoutre.POSITIF);

        System.out.println("\nerreurs :");
        // Creation d'un objet ObsGCI invalide
        ObsLoutre wrongObsLoutre = new ObsLoutre(1, date, heure, lieu, observateurs, null);
    }

}


