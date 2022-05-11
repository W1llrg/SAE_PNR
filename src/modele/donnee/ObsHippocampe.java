package modele.donnee;
import java.sql.Date;
import java.sql.Time;

/** 
* Observation des hippocampes
* @author Lucas
* @version Lucas
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
		if(id == null) throw new IllegalArgumentException("Erreur ObsHippocampe : constructeur : id null");


		throw new UnsupportedOperationException();
	}

	public EspeceObservee especeObs() {
		throw new UnsupportedOperationException();
	}
}