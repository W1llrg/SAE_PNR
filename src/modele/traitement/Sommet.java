package modele.traitement;

import modele.donnee.*;
import java.sql.Date;

/**
 * @author Tristan
 * @version 1.0
 */
public class Sommet {

    private int id;

    private int coordLieu;

    private Date date;

    private EspeceObservee espece;  


    /**
     * 
     */
     public Sommet(int id,Lieu coord,Date date,EspeceObservee espece){
         if(coord != null && date != null && espece != null){
             this.id =id;
             this.date = date;
             this.espece = espece;
         }else throw new IllegalArgumentException("Erreur Sommet : constructeur : parametre invalide");
     }

    public Sommet(Observation obs){
        if(obs!=null){

        }
    } 

    /**
     *
     */
    public double calculeDist(Sommet som){
        return 0;
    }
}