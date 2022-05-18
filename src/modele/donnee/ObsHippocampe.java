package modele.donnee;
import java.sql.Date;
import java.sql.Time;

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
	* ObsHippocampe créer un objet ObsHippocampe
	* @param id l'identifiant de l'espèce
	* @param date la date de l'observation
	* @param heure l'heure de l'observation
	* @param lieu le lieu de l'observation
	* @param observateurs la liste des observateurs participants à cette observation
	* @param laTaille la taille de l'espèce observée
	* @param leTypePeche le type de pèche utilisé
	* @param lEspece l'espèce observé
	* @param leSexe le sexe de l'animal observé
	*/
	public ObsHippocampe(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, double laTaille, Peche leTypePeche, EspeceHippocampe lEspece, Sexe leSexe) {
		super(id,date,heure,lieu,observateurs);

		if(laTaille == null || laTaille < 0){
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
	}

	public EspeceObservee especeObs() {
		throw new UnsupportedOperationException();
	}

	/** 
	* Getter de la taille de l'espece
	*/
	public void getTaille(){
		return this.taille;	
	}

	/** 
	* Getter du type de peche utilise 
	*/
	public void getTypePeche(){
		return this.typePeche;	
	}

	/** 
	* Getter de l'espece observee
	*/
	public void getEspece(){
		return this.espece;	
	}

	/** 
	* Getter du sexe de l'espece observee
	*/
	public void getSexe(){
		return this.sexe;	
	}

	/** 
	* Setter de la taille de l'espece observee
	* @param nouvelleTaille remplacera l'ancienne taille
	*/
	public double setTaille(double nouvelleTaille){
		if(nouvelleTaille == null || nouvelleTaille < 0){
			throw new IllegalArgumentException("Erreur setLaTaille : setter : nouvelleTaille null ou negative");
		}else{
			this.taille = nouvelleTaille;
		}
	}

	/** 
	* Setter du type de peche utilise
	* @param nouveauType remplacera l'ancien type de peche
	*/
	public Peche setTypePeche(Peche nouveauType){
		if(nouveauType == null){
			throw new IllegalArgumentException("Erreur setLeTypePeche : setter : nouveauType null");
		}else{
			this.typePeche = nouveauType;
		}
	}

	/** 
	* Setter du type d'espece observee
	* @param nouvelleEspece remplacera l'ancienne espece observee
	*/
	public double setEspece(EspeceHippocampe nouvelleEspece){
		if(nouvelleEspece == null){
			throw new IllegalArgumentException("Erreur setLEspece : setter : nouvelleEspece null");
		}else{
			this.espece = nouvelleEspece;
		}
	}

	/** 
	* Setter du sexe de l'espece observee
	* @param nouveauSexe remplacera l'ancien sexe de l'espece
	*/
	public Sexe setSexe(Sexe nouveauSexe){
		if(nouveauSexe == null){
			throw new IllegalArgumentException("Erreur setLeSexe : setter : nouveauSexe null");
		}else{
			this.sexe = nouveauSexe;
		}
	}
}