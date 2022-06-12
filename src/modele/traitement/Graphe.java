package modele.traitement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Cette classe represente un reseaux de sommet et leur voisin
 * @author Tristan
 * @version 1.4.4
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
     * calcule tout les degres du graphe pour chaque sommet
     * @return renvoie un HashMap contenant le sommet(cle) et son degre(valeur)
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
            int[][] s1 = this.matriceAdjacence();
            
            int i=0;
            int tab[] = new int[this.sommetVoisins.size()];
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                tab[i]=entry.getKey().getId();
                i++;
            }
            Arrays.sort(tab);
            
            for (int j=0;j<tab.length;j++) {
                indSom.put(this.getSommet(tab[j]),j);
            }
            
            int[][] s2 = s1;
            int[][] res = s1;
            int nbZero = 0;
            while(nbZero<(res.length*res.length) && !ret){
                nbZero=0;
                for(int j=0;j<s1.length;j++){
                    for(int k=0;k<s1.length;k++){
                        res[j][k+1]=0;
                        for(int u=0;u<s1.length;u++){
                            res[j][k+1]+=s1[j][u+1]*s2[u][k+1];
                        }
                        if(res[j][k+1]==0) nbZero++;
                    }
                }
                if(res[indSom.get(som1)][indSom.get(som2)+1]>=1) ret=true;
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




    /**
     * cree et renvoie la matrice d'adjacence du graphe
     * @return renvoie une matrice d'adjacence du graphe
     */
    public int[][] matriceAdjacence() {
        
        int ret[][] = new int[this.sommetVoisins.size()][this.sommetVoisins.size()+1];

        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        
        int i=0;
        int tab[] = new int[this.sommetVoisins.size()];
        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            tab[i]=entry.getKey().getId();
            i++;
        }
        Arrays.sort(tab);
        
        for (int j=0;j<tab.length;j++) {
            indSom.put(this.getSommet(tab[j]),j);
        }
        i=0;
        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            ret[indSom.get(entry.getKey())][0]=entry.getKey().getId();
            if(entry.getValue()!=null){
                for(Sommet som : entry.getValue()){
                    ret[indSom.get(entry.getKey())][indSom.get(som)+1]+=1;
                }
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
                if(som1!=entry.getKey()) ret = this.existeChemin(som1.getId(),entry.getKey().getId());
            }
        }
        return ret;
    }





    /**
     * cherche tout les composantes connexes du graphe et les renvoies dans un Arraylist de graphe
     * @return renvoie un Arraylist de graphe qui sont toute les composante connexe de celui ci
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
     * chercher et calcul la distance entre deux sommet avec leur id
     * @param idSom1 id du premier sommet
     * @param idSom2 id du deuxieme sommet
     * @return renvoie la distance entre les deux sommets si un chemin existe, sinon si les deux sommets existe il renvoie 0, sinon -1
     */
    public int distAretes(int idSom1,int idSom2){
        int ret=0;
        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        if(sontVoisins(idSom1,idSom2)) ret=1;

        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);
        if(ret==0 && som1!=null && som2!=null && sommetVoisins.get(som1)!=null && sommetVoisins.get(som2)!=null){

            int i=0;
            int tab[] = new int[this.sommetVoisins.size()];
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                tab[i]=entry.getKey().getId();
                i++;
            }
            Arrays.sort(tab);
            
            for (int j=0;j<tab.length;j++) {
                indSom.put(this.getSommet(tab[j]),j);
            }

            int[][] s1 = this.matriceAdjacence();
            int[][] s2 = s1;
            int[][] res = s1;
            int nbZero = 0;
            boolean trouve=false;
            while(nbZero<(res.length*res.length) && ret==0){
                nbZero=0;
                for(int j=0;j<s1.length;j++){
                    for(int k=0;k<s1.length;k++){
                        res[j][k + 1] = 0;
                        for(int u=0;u<s1.length;u++){
                            res[j][k+1]+=s2[j][u+1]*s1[u][k+1];
                        }
                        if(res[j][k+1]==0) nbZero++;
                    }
                }
                if(res[indSom.get(som1)][indSom.get(som2)+1]>=1 && !trouve) ret=res[indSom.get(som1)][indSom.get(som2)+1];
                else if(res[indSom.get(som1)][indSom.get(som2)+1]>0 && res[indSom.get(som1)][indSom.get(som2)+1]< ret) ret=res[indSom.get(som1)][indSom.get(som2)+1];
                s2=res;
            }
        }else if(som1==null || som2==null) ret=-1;

        return ret;
    }





    /**
     * cherche le sommet ayant le plus long chemin par rapport au sommet en parametre 
     * @param idSom id du sommet
     * @return renvoie le nombre d'arrete du sommet le plus distant 
     */
    public int excentricite(int idSom){
        int ret=0;

        Sommet som = this.getSommet(idSom);

        if(this.estConnexe() && som!=null && this.sommetVoisins.get(som)!=null){
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()) {
                if(entry.getKey()!=som){
                    int res = this.distAretes(som.getId(),entry.getKey().getId());
                    if(res>=ret){
                        ret = res;
                    }
                } 
            }      
            
        }else if(som==null) ret=-1;

        return ret;
    }




    /**
     * cherche le diamtre du graphe, soit le nombre d'aretes maximal entre deux sommet dans un graphe
     * @return renvoie le nombre d'arrete entre les deux sommet les plus eloigner si il n'est pas connexe, sinon renvoie -1
     */
    public int diametre(){
        int ret=0;
        if(this.estConnexe()){
            for(Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()){
                int res = this.excentricite(entry.getKey().getId());
                if(res>ret)ret=res;
            }
        }else ret=-1;
        return ret;
    }




    /**
     * cherche le rayon du graphe, soit le nombre d'aretes entre deux sommet minimal dans un graphe
     * @return retourne le minimum des excentricites. Si le rayon est calcule sur un graphe non connexe, retourner -1.
     */
    public int rayon(){
        int ret=0;
        if(this.estConnexe()){
            for(Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()){
                int res = this.excentricite(entry.getKey().getId());
                if(res<ret)ret=res;
            }
        }else ret=-1;
        return ret;
    }






    /**
     * calcule la distance entre deux sommet
     * @param idSom1 id du premier sommet
     * @param idSom2 id du deuxieme sommet
     * @return renvoie la distance des deux sommet si il existe un chemin,sinon si l'un des deux sommet est nul alors renvoie -1, sinon 0
     */
    public double calculeDist(int idSom1, int idSom2){
        double ret=0;
        Sommet som1 = this.getSommet(idSom1);
        Sommet som2 = this.getSommet(idSom2);

        if(sontVoisins(idSom1,idSom2)) ret= som1.calculeDist(som2);

        
        if(ret==0 && som1!=null && som2!=null && sommetVoisins.get(som1)!=null && sommetVoisins.get(som2)!=null){

            HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
            double[][] s1 = new double[sommetVoisins.size()][sommetVoisins.size()];
            int i=0;
            int tab[] = new int[this.sommetVoisins.size()];
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                tab[i]=entry.getKey().getId();
                i++;
            }
            Arrays.sort(tab);
            
            for (int j=0;j<tab.length;j++) {
                indSom.put(this.getSommet(tab[j]),j);
            }
            i=0;
            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
                for(Sommet som : entry.getValue()){
                    s1[i][indSom.get(som)+1]+=som.calculeDist(this.getSommetOfIndex(indSom,i));
                }
                i++;
            }

            double[][] s2 = s1;
            double[][] res = s1;
            int nbZero = 0;
            while(nbZero<(res.length*res.length) && ret!=0){
                nbZero=0;
                for(int j=0;j<s1.length;j++){
                    for(int k=0;k<s1.length;k++){
                        res[j][k+1]=0;
                        for(int u=0;u<s1.length;u++){
                            res[j][k+1]+=s1[j][u+1]*s2[u][k+1];
                        }
                        if(res[j][k+1]==0) nbZero++;
                    }
                }
                if(res[indSom.get(som1)][indSom.get(som2)+1]>=1) ret=res[indSom.get(som1)][indSom.get(som2)+1];
                s2=res;
            }
        }else if(som1==null || som2==null) ret=-1;

        return ret;
    }





    /**
     * cherche la cle(sommet) correspondant a la valeur(index)
     * @param indSom hashmap qui assosie des sommets a un index
     * @param i valeur de la cle a chercher
     * @return renvoie la cle correspondant a la valeur
     */
    public Sommet getSommetOfIndex(HashMap<Sommet,Integer> indSom,int i){
        Sommet ret=null;
        for (Map.Entry<Sommet, Integer> entry : indSom.entrySet()) {
            if(entry.getValue()==Integer.valueOf(i)) ret=entry.getKey();
        }
        return ret;
    }




    /**
     * cherche la distance maximale du chemin entre le sommet en parametre et les autres sommets du graphe
     * @param idSom id du sommet
     * @return revoie la distance maximale du chemin entre le sommet en parametre et les autres sommets du graphe,
     * Si l’excentricite est calculee sur un graphe non connexe, retourner -1.
     */
    public double excentriciteDist(int idSom){
        double ret=0;

        Sommet som = this.getSommet(idSom);
        if(this.estConnexe() && ret!=0 && som!=null && this.sommetVoisins.get(som)!=null){

            for (Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()) {
                if(entry.getKey()!=som && this.calculeDist(som.getId(),entry.getKey().getId())>ret){
                    ret = this.distAretes(som.getId(),entry.getKey().getId());
                } 
            }      
            
        }else if(som==null) ret=-1;

        return ret;
    }




    /**
     * cherche le diamtre du graphe, soit la distance maximal dans un graphe
     * @return renvoie la distance maximum entre les deux sommet les plus eloigner si il ests connexe, sinon renvoie -1
     */
    public double diametreDist(){
        double ret=0;
        if(this.estConnexe()){
            for(Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()){
                double res = this.excentriciteDist(entry.getKey().getId());
                if(res>ret)ret=res;
            }
        }else ret=-1;
        return ret;
    }




    /**
     * cherche le rayon du graphe, soit la distance minimal dans un graphe
     * @return renvoie la distance minimum entre les deux sommet les plus eloigner si il ests connexe, sinon renvoie -1
     */
    public double rayonDist(){
        double ret=0;
        if(this.estConnexe()){
            for(Map.Entry<Sommet, ArrayList<Sommet>> entry : this.sommetVoisins.entrySet()){
                double res = this.excentriciteDist(entry.getKey().getId());
                if(res<ret)ret=res;
            }
        }else ret=-1;
        return ret;
    }




    /**
     * cree une matrice de ponderation, soit une matrice contenant la distance entre les sommet et sur la premier colone leur id ordonne par
     * leur id
     * @return retourn la matrice de ponderation cree
     * 
     * public Graphe clotureTransitive(){
     * return ret;}
     */
    public double[][] matricePonderation(){
        double ret[][] = new double[this.sommetVoisins.size()][this.sommetVoisins.size()+1];

        HashMap<Sommet,Integer> indSom = new HashMap<Sommet,Integer>();
        
        int i=0;
        int tab[] = new int[this.sommetVoisins.size()];
        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            tab[i]=entry.getKey().getId();
        }
        Arrays.sort(tab);
        
        for (int j=0;j<tab.length;j++) {
            indSom.put(this.getSommet(tab[j]),j);
        }


        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : sommetVoisins.entrySet()) {
            ret[indSom.get(entry.getKey())][0]=entry.getKey().getId();
            if(entry.getValue()!=null){
                for(Sommet som : entry.getValue()){
                    ret[indSom.get(entry.getKey())][indSom.get(som)+1]+=som.calculeDist(this.getSommetOfIndex(indSom,i));
                }
            }
            i++;
        }
        return ret;
    }



    /**
     * cree un graphe avec le quelle tout les sommets avec un chemin existant vers un autre devient sont voisin
     * @return renvoie le nouveau graphe cree
     */
    public Graphe clotureTransitive(){
        HashMap<Sommet,ArrayList<Sommet>> soms=this.sommetVoisins;
        for (Map.Entry<Sommet, ArrayList<Sommet>> entry : soms.entrySet()) {
            for(Map.Entry<Sommet, ArrayList<Sommet>> ent : soms.entrySet()){
                if(this.existeChemin(entry.getKey().getId(),ent.getKey().getId()) && !this.sontVoisins(entry.getKey().getId(), ent.getKey().getId())){
                    entry.getValue().add(ent.getKey());
                    ent.getValue().add(entry.getKey());
                }
            }
        }

        return new Graphe(soms);
    }
}
