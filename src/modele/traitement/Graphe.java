package modele.traitement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Cette classe represente un reseaux de sommet et leur voisin
 * @author Tristan
 * @version 1.2.0
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
                if(som!=null){
                    ArrayList<Sommet> soms = new ArrayList<Sommet>();
                    for (Sommet s : sommets) {
                        if(s!=null && som!=s && som.calculeDist(s)<=dist) soms.add(s);
                    }
                    if(soms.size()!=0) this.sommetVoisins.put(som,soms);
                    else this.sommetVoisins.put(som,null);
                }else System.err.println("Erreur Graphe : constructeur : objet dans l'ArrayList null ");
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
     * renvoie le nombre d'arrete du graphe
     * @return renvoie le nombre d'arret entre les differents sommets du graphe
     * @version 1.0
     */
    public int nbArret(){
        ArrayList<Sommet[]> res = new ArrayList<>();
        
        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            Sommet key = entry.getKey();
            ArrayList<Sommet> value = entry.getValue();

            if(value!=null && !res.isEmpty()){

                for(Sommet v : value){
                    if(v!=null){
                        boolean existant = true;

                        for(Sommet[] r : res){
                            if(res==null && r[0]==key && r[1]!=v || res==null && r[0]==v && r[1]==key) existant=false;
                        }
                        if(existant){
                            Sommet[] soms = {key,v};
                            res.add(soms);
                        }

                    } 
                }
            }
        }
        return res.size();
    }

    /**
     * regarde si un sommet est présent de le graphe
     * @param idSom id du sommet a cherche 
     * @return renvoie Vrai si le sommet est bien de le graphe sinon la methode renvoie Faux
     */
    public boolean estDansGraphe(int idSom){
        boolean ret = false;
        Iterator it = sommetVoisins.entrySet().iterator();
	    while (it.hasNext() && !ret) {
	        Map.Entry<Sommet, ArrayList<Sommet>> entry = (Map.Entry) it.next();
	        if(entry.getKey().getId() == idSom) ret=true; 
	    }
        return ret;
    }

    /**
     * calcul le degre d'un sommet du graphe
     * @param idSom id du sommet dont on doit calculer le degre
     * @return renvoie le degre du sommet designe en parametre
     */
    public int calculeDegre(int idSom){
        int ret=0;
        boolean trouve=false;
        Iterator it = sommetVoisins.entrySet().iterator();
        while (it.hasNext() && !trouve) {
            Map.Entry<Sommet, ArrayList<Sommet>> entry = (Map.Entry) it.next();
            if(entry.getKey().getId() == idSom){
                trouve=true;
                if(sommetVoisins.get(entry.getKey())!=null) ret = sommetVoisins.get(entry.getKey()).size();
            }
        }
        
        return ret;
    }


    /**
     * calcul tout les degres du graphe pour chaque sommet
     * @return renvoie un HasMap contenent la le sommet(cle) et son degre(valeur)
     */
    public HashMap<Sommet,Integer> calculeDegres(){
        HashMap<Sommet,Integer> ret= new HashMap<Sommet,Integer>();
        
        Iterator it = sommetVoisins.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Sommet, ArrayList<Sommet>> entry = (Map.Entry) it.next();
            if(entry.getValue()!=null){
                ret.put(entry.getKey(),Integer.valueOf(entry.getValue().size()));
            }else ret.put(entry.getKey(),Integer.valueOf(0));
        }
        
        return ret;
    }
    
}
