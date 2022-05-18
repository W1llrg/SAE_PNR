package modele.traitement;

import modele.donnee.*;
import java.sql.Date;
import java.lang.Math;

/**
 * Cette classe represent une observation sous forme de sommet
 * @author Tristan
 * @version 1.3
 */
public class Sommet {

    /**
     * l'id du sommet
     */
    private int id;

    /**
     * coordonne du sommet
     */
    private Lieu coordLieu;

    /**
     * date du sommet
     */
    private Date date;

    /**
     * espece du sommet
     */
    private EspeceObservee espece;  


    /**
     * constructeur de Sommet, prend tout les attributs en parametre
     * @param id l'id du sommet
     * @param coord les coordonnees du sommet
     * @param date la date du  sommet
     * @param espece l'espece du sommet
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
     * Cette methode calcul la distance entre un sommet en parametre et celui courant
     * @param som le deuxième sommet pour calculer la distance
     * @return renvoie la distance calculer entre deux sommet
     */
    public double calculeDist(Sommet som){
        double x1=som.getCoordLieu().getXCoord();
        double y1=som.getCoordLieu().getYCoord();
        double x2=this.coordLieu.getXCoord();
        double y2=this.coordLieu.getYCoord();
        return Math.sqrt(Math.sqrt(y2 - y1) + Math.sqrt(x2 - x1));
    }

    /**
     * getter de id
     * @return renvoie l'id du sommet
     */
    public int getId(){
        return this.id;
    }

    /**
     * getter de coordLieu
     * @return renvoie les coordonnees du lieu du sommet
     */
    public Lieu getCoordLieu(){
        return this.coordLieu;
    }

    /**
     * getter de date
     * @return renvoie la date du sommet
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * getter de espece
     * @return renvoie l'espece du sommet
     */
    public EspeceObservee getEspece(){
        return this.espece;
    }

    /**
     * setter de id
     * @param idSom nouvelle id du sommet
     */
    public void setId(int idSom){
        this.id=idSom;
    }

    /**
     * setter de coordLieu
     * @param coord nouveau lieu du sommet
     */
    public void setCoordLieu(Lieu coord){
        if(coord!=null) this.coordLieu=coord;
        else System.err.println("Erreur Sommet : setCoordLieu : parametre invalide");
    }

    /**
     * setter de date
     * @param date nouvelle date du sommet
     */
    public void setDate(Date date){
        if(date!=null) this.date=date;
        else System.err.println("Erreur Sommet : setDate : parametre invalide");
    }

    /**
     * setter de espece
     * @param espece nouvelle espece du sommet
     */
    public void setEspece(EspeceObservee espece){
        if(espece!=null) this.espece=espece;
        else System.err.println("Erreur Sommet : setEspece : parametre invalide");
    }
}