package modele.donnee;

/**
 * Cette classe represente un observateur identifie par un identifiant unique et son nom et prenom.
 * @author BOURBIGOT Tristan
 * @version 1.01
 * derniere modif : correction javadoc
 */
public class Observateur {

	/**
	 * id de l'observateur
	 */
	private int idObservateur;

	/**
	 * nom de l'observateur
	 */
	private String nom;

	/**
	 * prenom de l'observateur
	 */
	private String prenom;

	/**
	 * Constructeur de l'observateur, le nom et prenom ne peuvent etre null ou vide
	 * et l'identifiant est unique pour chaque observateur.
	 * @param id identifiant unique representant l'observateur
	 * @param leNom nom de l'observateur
	 * @param lePrenom prenom de l'observateur
	 */
	public Observateur(int id, String leNom, String lePrenom) {
		if(leNom!=null && !leNom.equals("") && lePrenom!=null && !lePrenom.equals("")){
			this.idObservateur=id;
			this.nom=leNom;
			this.prenom=lePrenom;
		}else throw new IllegalArgumentException("Erreur Observateur : constructeur : argument invalide");
	}
}