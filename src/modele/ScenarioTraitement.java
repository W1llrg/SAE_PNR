package modele;
import modele.traitement.*;
import modele.donnee.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

/**
 * Test du package traitement via un scenario
 * @author Tristan, William, Theo
 * @version 1.0
 */
public class ScenarioTraitement {
    public static void main(String[] args){

        String separator = "---------------------------------------------------------------------------";
        
        // creation des sommets
        ArrayList<Sommet> sommets = creationSommets();

        //Creation du HashMap
        HashMap<Sommet,ArrayList<Sommet>> mapGraph = new HashMap<Sommet,ArrayList<Sommet>>(); 
        mapGraph.put(sommets.get(0),sommets);
        
        // creation d'un graphe 
        Graphe g = new Graphe(sommets,15);

        
        // tests Sommet

        System.out.println("\n\ntest constructeur Sommet\n" + separator);
        try {
            
            testSommet();

        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }

        
        // tests Graphe
        
        System.out.println("\n\ntest calculeDist()\n" + separator);
        testCalculeDist(sommets);

        System.out.println("\n\ntest estDansGraphe()\n" + separator);
        testEstDansGraphe(g);

        System.out.println("\n\ntest calculeDegre()\n" + separator);
        testCalculeDegre(g);

        System.out.println("\n\ntest calculeDegres()\n" + separator);
        testCalculeDegres(g);

        System.out.println("\n\ntest sontVoisins()\n" + separator);
        testSontVoisins(g);
        
        System.out.println("\n\ntest nbSommets()\n" + separator);
        testNbSommets(g);

        System.out.println("\n\ntest nbAretes()\n" + separator);
        testNbAretes(g);        

        try {

            System.out.println("\n\ntest matriceAdjacence()\n" + separator);
            testMatriceAdjacence(g);
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            
        }
        
        try {
            
            System.out.println("\n\ntest existeChemin()\n" + separator);
            testExisteChemin(g);
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());

        }
        
        // System.out.println("Nombre de sommet :"+g.nbSommets());
        // System.out.println("Nombre d'arret :"+g.nbAretes());

    }

    /**
     * Creer des instances de la classe Sommet
     * @return un ArrayList de sommets
     */
    public static ArrayList<Sommet> creationSommets() {

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

        return sommets;
    
    }

    /**
     * test le constructeur de la classe Sommet
     */
    public static void testSommet() {

        // creation sommet valide
        Sommet s = new Sommet(1,new Lieu(15,38),Date.valueOf("2022-01-02"),EspeceObservee.LOUTRE);

        System.out.println("\nerreurs :");
        // creation d'un sommet invalide
        Sommet wrongS = new Sommet(2,new Lieu(15,38), null,EspeceObservee.LOUTRE);

    }

    /**
     * test la methode CalculeDist() de la classe Sommet
     * @param s un ArrayList de sommets
     */
    public static void testCalculeDist(ArrayList<Sommet> s) {

        Sommet s1 = s.get(2);
        Sommet s2 = s.get(4);
        
        double distance = s1.calculeDist(s2);
        System.out.println("Distance calculee : " + distance);
        
    }
    
    /**
     * test de la methode estDansGraphe
     */
    public static void testEstDansGraphe(Graphe g) {

        // test true
        Boolean t1 = g.estDansGraphe(2);
        System.out.println("Resultat test (id = 2): " + t1);

        // test false
        Boolean t2 = g.estDansGraphe(6);
        System.out.println("Resultat test (id = 6): " + t2);
        
    }

    /**
     * test de la methode calculeDegre()
     */
    public static void testCalculeDegre(Graphe g) {

        // test true
        int t1 = g.calculeDegre(1);
        System.out.println("Resultat test (id = 1): " + t1);

        // test false
        int t2 = g.calculeDegre(7);
        System.out.println("Resultat test (id = 7): " + t2);
        
    }

    /**
     * test de la methode calculeDegres()
     */
    public static void testCalculeDegres(Graphe g) {

        HashMap<Sommet,Integer> t1 = g.calculeDegres(); 
        //test pas fini, faudrais afficher le hashmap qu'on obtient mais je sais pas faire mdrrr
    }

    /**
     * teste la methode nbSommets()
     */
    public static void testNbSommets(Graphe g) {

        System.out.println("Test avec un graphe rempli : ");
        System.out.println("nombre sommets : " + g.nbSommets());

        System.out.println("Test avec un graphe vide : ");
        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        Graphe gVide = new Graphe(sommets, 16);
        System.out.println("nombre sommets : " + gVide.nbSommets());

    }

    /**
     * teste la methode nbSommets()
     */
    public static void testNbAretes(Graphe g) {

        System.out.println("Test avec un graphe rempli : ");
        System.out.println("nombre aretes : " + g.nbAretes());

        System.out.println("Test avec un graphe vide : ");
        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        Graphe gVide = new Graphe(sommets, 16);
        System.out.println("nombre aretes : " + gVide.nbAretes());

    }


    /**
     * test de la methode sontVoisins()
     */
    public static void testSontVoisins(Graphe g){
        
        //test valide
        boolean t1 = g.sontVoisins(1,2);
        System.out.println("Resultat test (sommet 1 et sommet 2): " + t1);

        //cas limite
        boolean t3 = g.sontVoisins(0,0);
        System.out.println("Resultat test (sommet 0 et sommet 0): " + t3);

        //test faux
        boolean t2 = g.sontVoisins(6,7);
        System.out.println("Resultat test (sommet 6 et sommet 7): " + t2);

    }

    /**
     * test de la methode existeChemin()
     */
    public static void testExisteChemin(Graphe g) {

        //test valide
        boolean t1 = g.existeChemin(1,2);
        System.out.println("Resultat test (sommet 1 et sommet 2): " + t1);

        //cas limite
        boolean t3 = g.existeChemin(0,0);
        System.out.println("Resultat test (sommet 0 et sommet 0): " + t3);

        //test faux
        boolean t2 = g.existeChemin(4,7);
        System.out.println("Resultat test (sommet 4 et sommet 7): " + t2);

    }

    public static void testMatriceAdjacence(Graphe g) {

        g.matriceAdjacence();

    }
}
