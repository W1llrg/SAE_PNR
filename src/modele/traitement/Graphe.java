package modele.traitement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Cette classe represente un reseaux de sommet et leur voisin
 * @author Tristan
 * @version 1.4.1
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
     * cherche et renvoie le sommet du graphe avec le même id
     * @param idSom id du sommet a cherche 
     * @return renvoie null si le sommet n'est pas dans le graphe sinon il renvoie le sommet
     */
    public Sommet getSommet(int idSom){
        Sommet ret = null;
        boolean trouve =false;
        Iterator it = sommetVoisins.entrySet().iterator();
	    while (it.hasNext() && !trouve) {
	        Map.Entry<Sommet, ArrayList<Sommet>> entry = (Map.Entry) it.next();
	        if(entry.getKey().getId() == idSom) {
                trouve=true; 
                ret = entry.getKey();
            }
	    }
        return ret;
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
     * @version 1.2
     */
    public int nbAretes(){
        int res = 0;
        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            ArrayList<Sommet> value = entry.getValue();
            if(value!=null) res+= value.size();
        }
        return res/2;
    }

    /**
     * regarde si un sommet est présent de le graphe
     * @param idSom id du sommet a cherche 
     * @return renvoie Vrai si le sommet est bien de le graphe sinon la methode renvoie Faux
     */
    public boolean estDansGraphe(int idSom){
        boolean ret = false;
        if(getSommet(idSom)!=null) ret =true;
        return ret;
    }

    /**
     * calcul le degre d'un sommet du graphe
     * @param idSom id du sommet dont on doit calculer le degre
     * @return renvoie le degre du sommet designe en parametre
     */
    public int calculeDegre(int idSom){
        int ret=0;
        Sommet som = this.getSommet(idSom);
        if(som!=null) ret = sommetVoisins.get(som).size();
        return ret;
    }


    /**
     * calcul tout les degres du graphe pour chaque sommet
     * @return renvoie un HasMap contenent la le sommet(cle) et son degre(valeur)
     */
    public HashMap<Sommet,Integer> calculeDegres(){
        HashMap<Sommet,Integer> ret= new HashMap<Sommet,Integer>();

        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            if(entry.getValue()!=null){
                ret.put(entry.getKey(),Integer.valueOf(entry.getValue().size()));
            }else ret.put(entry.getKey(),Integer.valueOf(0));
        }

        return ret;
    }

    
    /**
     * cherche si deux sommet sont reliers par une arete
     * @param idSom1 id du premier sommet a chercher 
     * @param idSom2 id du deuxieme sommet a cherceher
     * @return renvoie Vrai si les sommets sont relier par une arete, sinon Faux
     */
    public boolean sontVoisins(int idSom1, int idSom2){
        boolean ret=false;
        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);
        if(som1!=null && som2!=null && sommetVoisins.get(som1).contains(som2)) ret=true;
            
        return ret;
    }
    

    /**
     * chercher si un sommet peut parcourire un chemin d'aretes pour arrive a un autre sommet 
     * @param idSom1 id du premier sommet a chercher le chemin
     * @param idSom2 id du deuxieme sommet a chercher le chemin
     * @return renvoie Vrai si il existe un chemin entre les deux sommets, sinon Faux
     */
    public boolean existeChemin(int idSom1, int idSom2){
        boolean ret=false;
        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        if(sontVoisins(idSom1,idSom2)) ret=true;

        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);
        if(!ret && som1!=null && som2!=null && sommetVoisins.get(som1)!=null && sommetVoisins.get(som2)!=null){
            int[][] s1 = new int[sommetVoisins.size()][sommetVoisins.size()];
            int i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                indSom.put(entry.getKey(),Integer.valueOf(i));
                i++;
            }
            i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                for(Sommet som : entry.getValue()){
                    s1[i][indSom.get(som)]=1;
                }
                i++;
            }

            int[][] s2 = s1;
            int[][] res = s1;
            int nbZero = 0;
            while(nbZero>=(s1.length*s1[0].length) && !ret){
                nbZero=0;
                for(int j=0;j<s1.length;j++){
                    for(int k=0;k<s1.length;k++){
                        for(int u=0;u<s1.length;u++){
                            res[j][k]+=s1[j][u]*s2[u][k];
                        }
                        if(res[j][k]==0) nbZero++;
                    }
                }
                if(res[indSom.get(som1)][indSom.get(som2)]>=1) ret=true;
                s2=res;
            }
        }


        return ret;
    }

    /**
     * revoie la list des voisins du sommet
     * @param idSom id du sommet 
     * @return renvoie un ArrayList compose de tout les sommets qui sont relier par une arete avec le sommet dont l'id est passe en parametre
     */
    public ArrayList<Sommet> voisins(int idSom){
        return sommetVoisins.get(this.getSommet(idSom));
    }

    
    /**
     * Ajoute une aretes entre les deux sommet specifier dans les parametre
     * @param idSom1 id du premier sommet a relier
     * @param idSom2 id du deuxieme sommet a relier
     * @return revoie Vrai si l'arete a bien ete ajoute, sinon Faux
     */
    public boolean ajouteArete(int idSom1, int idSom2){
        boolean ret=false;
        if(!this.sontVoisins(idSom1, idSom2)){
            Sommet som1 = this.getSommet(idSom1);
            Sommet som2 = this.getSommet(idSom2);
            ArrayList<Sommet> s1= sommetVoisins.get(som1);
            ArrayList<Sommet> s2= sommetVoisins.get(som1);
            if(s1==null) s1 = new ArrayList<Sommet>();
            if(s2==null) s2 = new ArrayList<Sommet>();
            s1.add(som2);
            s2.add(som1);
            sommetVoisins.replace(som1,s1);
            sommetVoisins.replace(som2,s2);
            ret=true;
        }
        return ret;
    }


    /**
     * Retire une aretes entre les deux sommet specifier dans les parametre
     * @param idSom1 id du premier sommet a retire
     * @param idSom2 id du deuxieme sommet a retire
     * @return revoie Vrai si l'arete a bien ete retire, sinon Faux
     */
    public boolean retireArete(int idSom1, int idSom2){
        boolean ret=false;
        if(this.sontVoisins(idSom1, idSom2)){
            Sommet som1 = this.getSommet(idSom1);
            Sommet som2 = this.getSommet(idSom2);
            ArrayList<Sommet> s1= sommetVoisins.get(som1);
            ArrayList<Sommet> s2= sommetVoisins.get(som1);
            s1.remove(som2);
            s2.remove(som1);
            sommetVoisins.replace(som1,s1);
            sommetVoisins.replace(som2,s2);
            ret=true;
        }
        return ret;
    }

}
