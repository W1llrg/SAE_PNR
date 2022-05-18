package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ObsLoutre extends Observation {
	private IndiceLoutre indice;

	/**
	 * Methode constructeur de la classe ObsBatracien
	 * @param id Date identifiant unique
	 * @param date Time date de la prise de l'observation
	 * @param heure heure de la prise de l'observation 
	 * @param lieu Lieu lieu de la prise de l'observation
	 * @param observateurs ArrayList<Observateur> la personne qui a prise l'observation
	 * @param lIndice IndiceLoutre indice de la loutre
	 */
	public ObsLoutre(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, IndiceLoutre lIndice) {
		super(id,date,heure,lieu,observateurs);

		if(lIndice == null){
			throw new IllegalArgumentException("ERREUR ObsLoutre : Constructor : lIndice null ");
		}else{
			this.indice = lIndice;
		}
	}

	/**
	 * Methode herite de la class observation, return la valeur du type enumere EspeceObservee Loutre
	 * @return EspeceObservee.LOUTRE la valeur du type enumere
	 */
	public EspeceObservee especeObs() {
		return EspeceObservee.LOUTRE;
	}

	/**
	 * getter d'indice 
	 * @return indice l'indice de la loutre en IndiceLoutre
	 */
	public IndiceLoutre getIndice(){
		return this.indice;	
	}

	/**
	 * Methode setter d'indice 
	 * @param lIndice l'indice de la loutre en IndiceLoutre
	 */
	public IndiceLoutre setIndice(IndiceLoutre lIndice){
		if(lIndice == null){
			System.out.println("Erreur setIndice : setter : lIndice est null");
		}else{
			this.indice = lIndice;
		}
	}
}