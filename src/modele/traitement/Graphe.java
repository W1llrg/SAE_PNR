package modele.traitement;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe represente un reseaux de sommet et leur voisin
 * @author Tristan
 * @version 1.0.1
 */
public class Graphe{

    /**
     * liste sommet et de ces voisins
     */
    private HashMap<Sommet,ArrayList<Sommet>> sommetVoisins;
    
    /**
     * Constructeur de Graphe, prend les sommets d'un Arraylist un a un et les compares aux autre pour voir si il sont voisin grace a
     * une distance donnee. Si il sont voisin alors on l'ajoute dans un ArrayList, puis on met cette ArrayList de sommet voisin avec le 
     * sommet dans l'HashMap. Le sommet est la cle tandis que l'ArrayList de sommet voisin et la valeur
     * @param sommets arraylist de sommet a compare
     * @param dist distance de comparaison, cette distance doit etre superieur au sommet voisin
     */
    public Graphe (ArrayList<Sommet> sommets,double dist){
        if(sommets!=null){
            sommetVoisins = new HashMap<Sommet,ArrayList<Sommet>>();
            for (Sommet som : sommets) {
                ArrayList<Sommet> soms = new ArrayList<Sommet>();
                for (Sommet s : sommets) {
                    if(som!=s && som.calculeDist(s)<=dist) soms.add(s);
                }
                if(soms.size()!=0) this.sommetVoisins.put(som,soms);
                else this.sommetVoisins.put(som,null);
            }
        }else throw new IllegalArgumentException("Erreur Graphe : constructeur : parametre invalide");
    }
    

    /**
     * Construteur de Graphe, utilise un HashMap directement en parametre pour l'atribut
     * @param somVoisins
     */
    public Graphe (HashMap<Sommet, ArrayList<Sommet>> somVoisins){
        if(somVoisins!=null) this.sommetVoisins=somVoisins;
        else throw new IllegalArgumentException("Erreur Graphe : constructeur : parametre invalide");
    }

    /**
     * constructeur de Graphe par copie
     * @param g Graphe a copier
     */
    public Graphe(Graphe g){
        if(g!=null) this.sommetVoisins= g.sommetVoisins;
        else throw new IllegalArgumentException();
    }

    /**
     * cette methode permet de renvoie le nombre de sommet 
     * @return renvoie la nombre de cle de sommetVoisins
     */
    public int nbSommets(){
        return sommetVoisins.size();
    }

    /**
     * renvoie le nom d'arrete du graphe
     * @author Tristan
     * @return 
     */
    public int nbArret(){

        return 0;
    }
}
