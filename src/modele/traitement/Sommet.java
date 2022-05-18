package modele.traitement;

import modele.donnee.*;
import java.sql.Date;

/**
 * @author Tristan
 * @version 1.0
 */
public class Sommet {

    private int id;

    private Lieu coordLieu;

    private Date date;

    private EspeceObservee espece;  


    /**
     * constructeur de Sommet, prend tout les attributs en parametre
     * @param id l'id de l'observation
     * @param coord coordonnee de l'
     * @param date
     * @param espece
     */
     public Sommet(int id,Lieu coord,Date date,EspeceObservee espece){
         if(coord != null && date != null && espece != null){
             this.id =id;
             this.date = date;
             this.espece = espece;
             this.coordLieu=coord;
         }else throw new IllegalArgumentException("Erreur Sommet : constructeur : parametre invalide");
     }

    /**
     * constructeur de sommet, recupere tous les attributs vias les getter de observation
     * @param obs l'observation dont on recupere tous les attributs
     */
    public Sommet(Observation obs){
        if(obs!=null){
            this.id=obs.getIdObs();
            this.coordLieu =obs.getLieuObs();
            this.date=obs.getDateObs();
            this.espece=obs.EspeceObservee();
        }
    } 

    /**
     *
     */
    public double calculeDist(Sommet som){
        return 0;
    }
}
