package modele.traitement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Cette classe represente un reseaux de sommets et leurs voisins
 * @author Tristan
 * @version 1.4.4
 */
public class Graphe{

    /**
     * liste des sommets et de ses voisins
     */
    private HashMap<Sommet,ArrayList<Sommet>> sommetVoisins;
    
    /**
     * Constructeur de Graphe, prend les sommets d'une Arraylist un a un et les compare aux autres pour voir si ils sont voisins grace a
     * une distance donnee. Si ils sont voisins alors on l'ajoute dans une ArrayList, puis on met cette ArrayList de sommets voisins avec le 
     * sommet dans l'HashMap. Le sommet est la cle tandis que l'ArrayList de sommets voisins est la valeur
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
     * Construteur de Graphe, utilise un HashMap directement en parametre pour l'attribut
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
     * Cherche et renvoie le sommet du graphe avec le même id
     * @param idSom id du sommet a chercher
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
     * cette methode permet de renvoyer le nombre de sommets
     * @return renvoie le nombre de cle de sommetVoisins
     */
    public int nbSommets(){
        return sommetVoisins.size();
    }

    /**
     * renvoie le nombre d'arretes du graphe
     * @return renvoie le nombre d'arretes entre les differents sommets du graphe
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
     * regarde si un sommet est present de le graphe
     * @param idSom id du sommet a chercher
     * @return renvoie Vrai si le sommet est bien de le graphe sinon la methode renvoie Faux
     */
    public boolean estDansGraphe(int idSom){
        boolean ret = false;
        if(getSommet(idSom)!=null) ret =true;
        return ret;
    }

    /**
     * calcule le degre d'un sommet du graphe
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
     * calcule tous les degres du graphe pour chaque sommet
     * @return renvoie un HasMap contenent la/le sommet(cle) et son degre(valeur)
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
     * cherche si deux sommets sont relies par une arrete
     * @param idSom1 id du premier sommet a chercher 
     * @param idSom2 id du deuxieme sommet a chercher
     * @return renvoie Vrai si les sommets sont relies par une arrete, sinon Faux
     */
    public boolean sontVoisins(int idSom1, int idSom2){
        boolean ret=false;
        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);
        if(som1!=null && som2!=null && sommetVoisins.get(som1).contains(som2)) ret=true;
            
        return ret;
    }
    

    /**
     * chercher si un sommet peut parcourir un chemin d'arretes pour arriver a un autre sommet 
     * @param idSom1 id du premier sommet dont on doit chercher le chemin
     * @param idSom2 id du deuxieme sommet dont on doit chercher le chemin
     * @return renvoie Vrai si il existe un chemin entre les deux sommets, sinon Faux
     */
    public boolean existeChemin(int idSom1, int idSom2){
        boolean ret=false;
        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        if(sontVoisins(idSom1,idSom2)) ret=true;

        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);
        if(!ret && som1!=null && som2!=null && sommetVoisins.get(som1)!=null && sommetVoisins.get(som2)!=null){
            int[][] s1 = this.matriceAdjacence();
            int i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                indSom.put(entry.getKey(),Integer.valueOf(i));
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
     * renvoie la liste des voisins du sommet
     * @param idSom id du sommet 
     * @return renvoie une ArrayList compose de tous les sommets qui sont relies par une arrete avec le sommet dont l'id est passe en parametre
     */
    public ArrayList<Sommet> voisins(int idSom){
        return sommetVoisins.get(this.getSommet(idSom));
    }

    
    /**
     * Ajoute une arrete entre les deux sommets specifiee en parametre
     * @param idSom1 id du premier sommet a relier
     * @param idSom2 id du deuxieme sommet a relier
     * @return renvoie Vrai si l'arrete a bien ete ajoutee, sinon Faux
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
     * Retire une arrete entre les deux sommets specifies dans les parametres
     * @param idSom1 id du premier sommet a retire
     * @param idSom2 id du deuxieme sommet a retire
     * @return renvoie Vrai si l'arrete a bien ete retiree, sinon Faux
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


    /**
     * creer et renvoie la matrice d'adjacence du graphe
     * @return renvoie une matrice d'adjacence du graphe
     */
    public int[][] matriceAdjacence(){
        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        int[][] ret = new int[sommetVoisins.size()][sommetVoisins.size()];
            int i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                indSom.put(entry.getKey(),Integer.valueOf(i));
                i++;
            }
            i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                for(Sommet som : entry.getValue()){
                    ret[i][indSom.get(som)]+=1;
                }
                i++;
            }
        return ret;
    }


    /**
     * cherche si le graphe est connexe
     * @return renvoie Vrai si le graphe est connexe, sinon Faux
     */
    public boolean estConnexe(){
        boolean ret=true;
        if(sommetVoisins.size()>0){
            Iterator it = sommetVoisins.entrySet().iterator();
            Map.Entry<Sommet, ArrayList<Sommet>> entry = (Map.Entry) it.next();
            Sommet som1 = entry.getKey();
            while (it.hasNext() && ret) {
                entry = (Map.Entry) it.next();
                ret = this.existeChemin(som1.getId(),entry.getKey().getId());
            }
        }
        return ret;
    }


    /**
     * cherche tous les composantes connexes du graphe et les renvoies dans une Arraylist de graphe
     * @return renvoie une Arraylist de graphe composee de tout les composants connexes de celui ci
     */
    public ArrayList<Graphe> composanteConnexe(){
        ArrayList<Graphe> ret = new ArrayList<Graphe>();
        if(this.estConnexe()) ret.add(new Graphe(this));
        else{
            HashMap<Sommet,ArrayList<Sommet>> sommets=new HashMap<Sommet,ArrayList<Sommet>>();
            Graphe graphe=new Graphe(this);

            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                sommets.put(entry.getKey(),entry.getValue());
                graphe = new Graphe(sommets);

                if(!graphe.estConnexe()){
                    sommets.remove(entry.getKey());
                    boolean existe=false;

                    for(Graphe e : ret){
                        if(e.estDansGraphe(entry.getKey().getId())) existe=true;
                    }

                    if(!existe){
                        HashMap<Sommet,ArrayList<Sommet>> soms=new HashMap<Sommet,ArrayList<Sommet>>();
                        soms.put(entry.getKey(),entry.getValue());
                        Graphe g=new Graphe(soms);
                        for (Map.Entry<Sommet, ArrayList<Sommet>> ent : sommetVoisins.entrySet()) {
                            if(ent.getKey()!=entry.getKey()){
                                soms.put(ent.getKey(),ent.getValue());
                                g = new Graphe(soms);
                
                                if(!g.estConnexe()) soms.remove(entry.getKey());
                            }
                        }

                        ret.add(g);
                    }

                }
            }
            ret.add(graphe);
        }
        return ret;
    } 

    /**
     * chercher et calculer la distance entre deux sommets avec leur id
     * @param idSom1 id du premier sommet
     * @param idSom2 id du deuxieme sommet
     * @return renvoie la distance entre les deux sommets si un chemin existe, si les deux sommets existent il renvoie 0, sinon -1
     */
    public int distAretes(int idSom1,int idSom2){
        int ret=0;
        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        if(sontVoisins(idSom1,idSom2)) ret=1;

        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);
        if(ret!=0 && som1!=null && som2!=null && sommetVoisins.get(som1)!=null && sommetVoisins.get(som2)!=null){

            int i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                indSom.put(entry.getKey(),Integer.valueOf(i));
                i++;
            }

            int[][] s1 = this.matriceAdjacence();
            int[][] s2 = s1;
            int[][] res = s1;
            int nbZero = 0;
            while(nbZero>=(s1.length*s1[0].length) && ret!=0){
                nbZero=0;
                for(int j=0;j<s1.length;j++){
                    for(int k=0;k<s1.length;k++){
                        for(int u=0;u<s1.length;u++){
                            res[j][k]+=s1[j][u]*s2[u][k];
                        }
                        if(res[j][k]==0) nbZero++;
                    }
                }
                if(res[indSom.get(som1)][indSom.get(som2)]>=1) ret=res[indSom.get(som1)][indSom.get(som2)];
                s2=res;
            }
        }else if(som1==null || som2==null) ret=-1;
        return ret;
    }


    /**
     * cherche le sommet ayant le plus long chemin par rapport au sommet en parametre 
     * @param idSom id du sommet
     * @return renvoie le nombre d'arretes du sommet le plus distant 
     */
    public int excentricite(int idSom){
        int ret=0;

        Sommet som = this.getSommet(idSom);
        if(ret!=0 && som!=null && this.sommetVoisins.get(som)!=null){

            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()) {
                if(entry.getKey()!=som && this.distAretes(som.getId(),entry.getKey().getId())>ret){
                    ret = this.distAretes(som.getId(),entry.getKey().getId());
                } 
            }      
            
        }else if(som==null) ret=-1;

        return ret;
    }

    /**
     * cherche le diametre du graphe, soit la distance maximale dans un graphe
     * @return renvoie le nombre d'arretes entre les deux sommets les plus eloignes si il n'est pas connexe, sinon renvoie -1
     */
    public int diametre(){
        int ret=0;
        if(!this.estConnexe()){
            for(Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()){
                int res = this.excentricite(entry.getKey().getId());
                if(res>ret)ret=res;
            }
        }else ret=-1;
        return ret;
    }

    /**
     * cherche le rayon du graphe, soit la distance minimale dans un graphe
     * @return retourne le minimum des excentricites. Si le rayon est calcule sur un graphe non connexe, retourne -1.
     */
    public int rayon(){
        int ret=0;
        if(!this.estConnexe()){
            for(Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()){
                int res = this.excentricite(entry.getKey().getId());
                if(res<ret)ret=res;
            }
        }else ret=-1;
        return ret;
    }
}
