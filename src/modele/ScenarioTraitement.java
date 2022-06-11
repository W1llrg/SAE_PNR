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
        
        // creation du HashMap
        HashMap<Sommet,ArrayList<Sommet>> mapGraph = creationHashMap(sommets);

        // creation d'un graphe 
        Graphe g = new Graphe(mapGraph);

        
        // tests Sommet

        System.out.println("\n\ntest constructeur Sommet\n" + separator);
        try {
            
            testSommet();

        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }

        System.out.println("\n\ntest calculeDist()\n" + separator);
        testCalculeDist(sommets);
        


        // tests Graphe
        
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
    
        System.out.println("\n\ntest matriceAdjacence()\n" + separator);
        testMatriceAdjacence(g);

        System.out.println("\n\ntest existeChemin()\n" + separator);
        testExisteChemin(g);
                    
        System.out.println("\n\ntest voisins()\n" + separator);
        testVoisins(g);

        System.out.println("\n\ntest ajouteArete()\n" + separator);
        testAjouteArete(g);

        System.out.println("\n\ntest retireArete()\n" + separator);
        testRetireArete(g);

        System.out.println("\n\ntest estConnexe()\n" + separator);
        testEstConnexe(g);

        System.out.println("\n\ntest composanteConnexe()\n" + separator);

        System.out.println("\n\ntest distAretes()\n" + separator);

        System.out.println("\n\ntest excentricite()\n" + separator);

        System.out.println("\n\ntest diametre()\n" + separator);
        testDiametre(g);

        System.out.println("\n\ntest rayon()\n" + separator);

        System.out.println("\n\ntest gCalculeDist()\n" + separator);

        System.out.println("\n\ntest getSommetOfIndex()\n" + separator);

        System.out.println("\n\ntest excentriciteDist()\n" + separator);

        System.out.println("\n\ntest diametreDist()\n" + separator);

        System.out.println("\n\ntest rayonDist()\n" + separator);

        System.out.println("\n\ntest matricePonderation()\n" + separator);

        System.out.println("\n\ntest clotureTransitive()\n" + separator);
        
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
        Sommet s6= new Sommet(6,new Lieu(23,45),Date.valueOf("2022-01-17"),EspeceObservee.LOUTRE);

        // sommets additionnels pour des tests au niveau de existeChemin()
        Sommet s7= new Sommet(7,new Lieu(13,25),Date.valueOf("2022-02-17"),EspeceObservee.LOUTRE);
        Sommet s8= new Sommet(8,new Lieu(56,56),Date.valueOf("2021-02-17"),EspeceObservee.LOUTRE);
        
        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        sommets.add(s1);
        sommets.add(s2);
        sommets.add(s3);
        sommets.add(s4);
        sommets.add(s5);
        sommets.add(s6);
        sommets.add(s7);
        sommets.add(s8);

        return sommets;
    
    }


    /**
     * crees une HashMap contenant chaque sommet avec leurs voisins respectifs
     * @param sommets un ArrayList de sommets
     * @return une HashMap de sommets et de voisins
     */
    public static HashMap<Sommet,ArrayList<Sommet>> creationHashMap(ArrayList<Sommet> sommets) {

        // creation des voisins pour chaque sommet
        ArrayList<Sommet> voisins1 = new ArrayList<Sommet>();
        voisins1.add(sommets.get(1));
        voisins1.add(sommets.get(3));

        ArrayList<Sommet> voisins2 = new ArrayList<Sommet>();
        voisins2.add(sommets.get(0));
        voisins2.add(sommets.get(3));

        ArrayList<Sommet> voisins3 = new ArrayList<Sommet>();
        voisins3.add(sommets.get(3));

        ArrayList<Sommet> voisins4 = new ArrayList<Sommet>();
        voisins4.add(sommets.get(0));
        voisins4.add(sommets.get(1));
        voisins4.add(sommets.get(2));
        voisins4.add(sommets.get(5));

        ArrayList<Sommet> voisins6 = new ArrayList<Sommet>();
        voisins6.add(sommets.get(3));


        // sommets additionnels pour des tests au niveau de existeChemin()
        ArrayList<Sommet> voisins7 = new ArrayList<Sommet>();
        voisins7.add(sommets.get(7));

        ArrayList<Sommet> voisins8 = new ArrayList<Sommet>();
        voisins8.add(sommets.get(6));

        //Creation du HashMap
        HashMap<Sommet,ArrayList<Sommet>> mapGraph = new HashMap<Sommet,ArrayList<Sommet>>(); 
        mapGraph.put(sommets.get(0), voisins1);
        mapGraph.put(sommets.get(1), voisins2);
        mapGraph.put(sommets.get(2), voisins3);
        mapGraph.put(sommets.get(3), voisins4);
        mapGraph.put(sommets.get(4), null);
        mapGraph.put(sommets.get(5), voisins6);
        mapGraph.put(sommets.get(6), voisins7);
        mapGraph.put(sommets.get(7), voisins8);

        return mapGraph;

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
        System.out.println("Est-il dans le graphe ? (id = 2): " + t1);

        // test false
        Boolean t2 = g.estDansGraphe(99);
        System.out.println("Est-il dans le graphe ? (id = 99): " + t2);
        
    }

    /**
     * test de la methode calculeDegre()
     */
    public static void testCalculeDegre(Graphe g) {

        // test true
        int t1 = g.calculeDegre(1);
        System.out.println("Resultat test (id = 1): " + t1);

        // test false
        int t2 = g.calculeDegre(99);
        System.out.println("Resultat test (id = 99): " + t2);
        
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
        boolean t2 = g.sontVoisins(6,99);
        System.out.println("Resultat test (sommet 6 et sommet 99): " + t2);

    }

    /**
     * test de la methode existeChemin()
     */
    public static void testExisteChemin(Graphe g) {

        //test valide
        boolean t1 = g.existeChemin(1,2);
        System.out.println("Resultat test (sommet 1 et sommet 2): " + t1);

        boolean t4 = g.existeChemin(6,2);
        System.out.println("Resultat test (sommet 6 et sommet 2): " + t4);

        boolean t5 = g.existeChemin(7,2);
        System.out.println("Resultat test (sommet 7 et sommet 2): " + t5);

        //cas limite
        boolean t3 = g.existeChemin(0,0);
        System.out.println("Resultat test (sommet 0 et sommet 0): " + t3);

        //test faux
        boolean t2 = g.existeChemin(4,99);
        System.out.println("Resultat test (sommet 4 et sommet 99): " + t2);

    }

    /**
     * teste la methode matriceAdjacence() de la classe Graphe
     * @param g un Graphe
     */
    public static void testMatriceAdjacence(Graphe g) {

        int[][] matrice = g.matriceAdjacence();
        System.out.println("Matrice d'adjacence : \n");

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * teste la methode voisins() de la classe Graphe
     * @param g un Graphe
     */
    public static void testVoisins(Graphe g) {

        System.out.println("\nVoisins du sommet 1 (2 et 4) : ");
        ArrayList<Sommet> v1 = g.voisins(1);
        
        if (v1 != null) {
            for (Sommet sommet : v1) {
                    
                    int s = sommet.getId();
                    System.out.print(s + " ");

            }
        } else System.out.println("none");


        System.out.println("\nVoisins du sommet 4 (1 2 3 et 6) : ");
        ArrayList<Sommet> v2 = g.voisins(4);

        if (v2 != null) {
            for (Sommet sommet : v2) {
                    
                    int s = sommet.getId();
                    System.out.print(s + " ");
                
            }
        } else System.out.println("none");


        System.out.println("\nVoisins du sommet 5 (aucun) : ");
        ArrayList<Sommet> v3 = g.voisins(5);

        if (v3 != null) {
            for (Sommet sommet : v3) {
                    
                    int s = sommet.getId();
                    System.out.print(s + " ");

            }
        } else System.out.println("none");

    }

    /**
     * teste la methode ajouteArete() de la classe Graphe
     * @param g un Graphe
     */
    public static void testAjouteArete(Graphe g) {

        System.out.println("chemin entre le sommet 4 et 5 (aucun) : ");
        System.out.println("Existe chemin ? :" + g.existeChemin(4, 5) + "\n");

        // creation d'un chemin
        g.ajouteArete(4, 5);

        System.out.println("chemin entre le sommet 4 et 5 (doit etre a true) : ");
        System.out.println("Existe chemin ? :" + g.existeChemin(4, 5) + "\n");

    }

    /**
     * teste la methode retireArete() de la classe Graphe
     * @param g un Graphe
     */
    public static void testRetireArete(Graphe g) {

        System.out.println("chemin entre le sommet 4 et 5 (doit etre a true) : ");
        System.out.println("Existe chemin ? :" + g.existeChemin(4, 5) + "\n");

        // creation d'un chemin
        g.retireArete(4, 5);

        System.out.println("chemin entre le sommet 4 et 5 (aucun) : ");

        System.out.println("Existe chemin ? :" + g.existeChemin(4, 5) + "\n");

    }

    /**
     * teste la methode estConnexe() de la classe Graphe
     * @param g un Graphe
     */
    public static void testEstConnexe(Graphe g) {

        // test avec le graphe donne en parametre
        System.out.println("Le graphe est-il connexe ? (graphe rempli) : " + g.estConnexe());

        // test avec un graphe vide
        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        Graphe gVide = new Graphe(sommets, 16);
        System.out.println("Le graphe est-il connexe ? (graphe vide) : " + gVide.estConnexe());
        
    }

    /**
     * teste la methode composanteConnexe() de la classe Graphe
     * @param g un Graphe
     */
    public static void testComposanteConnexe(Graphe g) {

        // test avec le graphe donne en parametre
        ArrayList<Graphe> v1 = g.composanteConnexe();

        if (v1 != null) {
            for (Graphe graph : v1) {
                int i = 0;
                Sommet gra = graph.getSommet(i);
                System.out.print(gra + " ");
                i++;

            } 

        } else System.out.println("none");
        
    }

    /**
     * teste la methode distAretes() de la classe Graphe
     * @param g un Graphe
     */
    public static void testDistAretes(Graphe g) {



    }

    /**
     * teste la methode excentricite() de la classe Graphe
     * @param g un Graphe
     */
    public static void testExcentricite(Graphe g) {
    
    
        
    }

    /**
     * teste la methode diametre() de la classe Graphe
     * @param g un Graphe
     */
    public static void testDiametre(Graphe g) {
        //test du diametre du graph en parametre
        int test = g.diametre();

        System.out.println("Le diametre du graphe est de" + test);        
    }

    /**
     * teste la methode rayon() de la classe Graphe
     * @param g un Graphe
     */
    public static void testRayon(Graphe g) {
    
    
        
    }

    //#region methodes supplementaires

    public static void testGCalculeDist(Graphe g) {



    }

    public static void testGetSommetOfIndex(Graphe g) {



    }

    public static void testExcentriciteDist(Graphe g) {



    }

    public static void testDiametreDist(Graphe g) {



    }

    public static void testRayonDist(Graphe g) {



    }

    public static void testMatricePonderation(Graphe g) {



    }

    public static void testClotureTransitive(Graphe g) {



    }
    //#endregion methodes supplementaires

}
