package modele.donnee;

/**
 * Cette class représente un observateur identifier par un id unique
 * et son nom et prénom
 * @author BOURBIGOT Tristan
 * @version 1.0
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
	 * Constructeur de l'observateur, le nom et prénom ne peuvet etre null ou vide
	 * et l'identifiant est unique pour chaque observateur
	 * @param unique à chaque observateurid identifiant uniqst ue représentant l'observateur
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