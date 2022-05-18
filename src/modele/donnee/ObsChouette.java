package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * une classe qui represente une observation de chouette : ObsChouette
 * @author Eve-Anne OFFREDI
 * @version 1.0
 */
public class ObsChouette extends Observation {
	/**Type de l'observation */
	private TypeObservation typeObs;

	/**
	* ObsChouette cree un objet ObsChouette
	* @param id l'identifiant de l'espece
	* @param date la date de l'observation
	* @param heure l'heure de l'observation
	* @param lieu le lieu de l'observation
	* @param observateurs la liste des observateurs participants a cette observation
	* @param type le type d'espece observe
	*/
	public ObsChouette(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, TypeObservation type) {
		super(id,date,heure,lieu,observateurs);
		if(type==null) System.out.println("Erreur ObsChouette : Constructeur : parametre type null");
		else this.typeObs = type;
	}

	/**
	* Retourne l'espece observee
	* @return chouette
	*/
	public EspeceObservee especeObs() {
		return EspeceObservee.CHOUETTE;
	}

	/**
	* Retourne le type d'observatione
	* @return espece
	*/
	public TypeObservation getTypeObs(){
		return this.typeObs;
	}

	/**
	* Change le type d'observation
	* @param t le nouveau type d'observation
	*/
	public void setTypeObs(TypeObservation t){
		if(t == null) System.out.println("Erreur ObsChouette : setTypeObs : paramètre null");
		else typeObs = t;
	}
}