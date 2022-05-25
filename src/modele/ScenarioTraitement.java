package modele;
import modele.traitement.*;
import modele.donnee.*;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Test du package traitement via un scenario
 * @author Tristan
 * @version 1.0
 */
public class ScenarioTraitement {
    public static void main(String[] args){
        Sommet s1= new Sommet(1,new Lieu(15,38),Date.valueOf("2022-01-02"),EspeceObservee.LOUTRE);
        Sommet s2= new Sommet(2,new Lieu(21,8),Date.valueOf("2022-01-07"),EspeceObservee.LOUTRE);
        Sommet s3= new Sommet(3,new Lieu(5,9),Date.valueOf("2022-01-15"),EspeceObservee.LOUTRE);
        Sommet s4= new Sommet(4,new Lieu(9,3),Date.valueOf("2022-01-16"),EspeceObservee.LOUTRE);
        Sommet s5= new Sommet(5,new Lieu(78,39),Date.valueOf("2022-01-30"),EspeceObservee.LOUTRE);

        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        sommets.add(s1);
        sommets.add(s2);
        sommets.add(s3);
        sommets.add(s4);
        sommets.add(s5);
       
        Graphe g = new Graphe(sommets,15);

        System.out.println("Nombre de sommet :"+g.nbSommets());
        System.out.println("Nombre d'arret :"+g.nbAretes());

    }
}
