package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
* Observation des hippocampes
* @author Lucas
* @version 1.0
*/
public class ObsHippocampe extends Observation {

	private double taille;
	private boolean estGestant;
	private Peche typePeche;
	private EspeceHippocampe espece;
	private Sexe sexe;

	/**
	* ObsHippocampe cree un objet ObsHippocampe
	* @param id l'identifiant de l'espece
	* @param date la date de l'observation
	* @param heure l'heure de l'observation
	* @param lieu le lieu de l'observation
	* @param observateurs la liste des observateurs participants a cette observation
	* @param laTaille la taille de l'espece observee
	* @param leTypePeche le type de peche utilise
	* @param lEspece l'espece observee
	* @param leSexe le sexe de l'animal observe
	*/
	public ObsHippocampe(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, double laTaille, Peche leTypePeche, EspeceHippocampe lEspece, Sexe leSexe) {
		super(id,date,heure,lieu,observateurs);

		if(laTaille < 0){
			throw new IllegalArgumentException("Erreur ObsHippocampe : constructeur : laTaille null ou negative");
		}else{
			this.taille = laTaille;
		if(leTypePeche == null) {
			throw new IllegalArgumentException("Erreur ObsHippocampe : constructeur : leTypePeche null");
		}else{
			this.typePeche = leTypePeche;
		if(lEspece == null) {
			throw new IllegalArgumentException("Erreur ObsHippocampe : constructeur : lEspece null");
		}else{
			this.espece = lEspece;
		}
		if(leSexe == null){
			throw new IllegalArgumentException("Erreur ObsHippocampe : constructeur : leSexe null");
		}else{
			this.sexe = leSexe;
		}
		this.estGestant = false;
	}

	public EspeceObservee especeObs() {
		throw new UnsupportedOperationException();
	}

	/**
	* Getter de la taille de l'espece
	*/
	public double getTaille(){
		return this.taille;
	}

	/**
	* Getter du type de peche utilise
	*/
	public Peche getTypePeche(){
		return this.typePeche;
	}

	/**
	* Getter de l'espece observee
	*/
	public EspeceHippocampe getEspece(){
		return this.espece;
	}

	/**
	* Getter du sexe de l'espece observee
	*/
	public Sexe getSexe(){
		return this.sexe;
	}

	/**
	* Setter de la taille de l'espece observee
	* @param nouvelleTaille remplacera l'ancienne taille
	*/
	public void setTaille(double nouvelleTaille){
		if(nouvelleTaille < 0){
			System.out.println("Erreur setTaille : setter : nouvelleTaille negative");
		}else{
			this.taille = nouvelleTaille;
		}
	}

	/**
	* Setter du type de peche utilise
	* @param nouveauType remplacera l'ancien type de peche
	*/
	public void setTypePeche(Peche nouveauType){
		if(nouveauType == null){
			System.out.println("Erreur setTypePeche : setter : nouveauType null");
		}else{
			this.typePeche = nouveauType;
		}
	}

	/**
	* Setter du type d'espece observee
	* @param nouvelleEspece remplacera l'ancienne espece observee
	*/
	public void setEspece(EspeceHippocampe nouvelleEspece){
		if(nouvelleEspece == null){
			System.out.println("Erreur setEspece : setter : nouvelleEspece null");
		}else{
			this.espece = nouvelleEspece;
		}
	}

	/**
	* Setter du sexe de l'espece observee
	* @param nouveauSexe remplacera l'ancien sexe de l'espece
	*/
	public void setSexe(Sexe nouveauSexe){
		if(nouveauSexe == null){
			System.out.println("Erreur setSexe : setter : nouveauSexe null");
		}else{
			this.sexe = nouveauSexe;
		}
	}

	/**
	* Setter de la gestation de l'espece
	* @param estGestantObs modifiera la valeur du boolean
	*/
	public void setEstGestant(boolean estGestantObs){
		if(estGestantObs == true && this.getSexe() == Sexe.FEMELLE){
			System.out.println("Erreur setEstGestant : setter : estGestant vrai mais n'est pas un male");
		}else if(estGestantObs == true && this.getSexe() == Sexe.INCONNU){
			this.estGestant = true;
			this.setSexe(Sexe.MALE);
		}else{
			this.estGestant = estGestantObs;
		}
	}
}
