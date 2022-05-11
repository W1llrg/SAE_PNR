package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Cette classe ObsBatracien est une observation de l'espece batracien 
 * sous-type de la classe Observation avec, en plus, un attribut enumereprecisant l’espece precise du batracien et quatre en-tiers indiquant le resultat de l’observation. 
 * @author Theo
 * @version 1.0 
 */
public class ObsBatracien extends Observation {
	private int nombreAdultes;
	private int nombreAmplexus;
	private int nombreTetard;
	private int nombrePonte;
	private EspeceBatracien espece;

	/**
	 * Methode constructeur de la classe ObsBatracien
	 * @param id Date identifiant unique
	 * @param date Time date de la prise de l'observation
	 * @param heure heure de la prise de l'observation 
	 * @param lieu Lieu lieu de la prise de l'observation
	 * @param observateurs ArrayList<Observateur> la personne qui a prise l'observation
	 * @param resObs int[] tableau de int, la pr
	 * @param lEspece
	 */
	public ObsBatracien(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, int[] resObs, EspeceBatracien lEspece) {
		super(id,date,heure,lieu,observateurs);

		if(resObs == null){
			throw new IllegalArgumentException("ERREUR ObsBatracien : Constructor : resObs null ");
		}else{
			this.nombreAdultes = resObs[0];
			this.nombreAmplexus = resObs[1];
			this.nombreTetard = resObs[2];
			this.nombrePonte = resObs[3];
		}

		if(lEspece == null){
			throw new IllegalArgumentException("ERREUR ObsBatracien : Constructor : lEspece null ");
		}else{
			this.espece = lEspece;
		}
		
	}

	public EspeceObservee especeObs() {
		throw new UnsupportedOperationException();
	}
}