package modele.donnee;

import java.sql.Date;
import java.sql.Time;
//import donnee.Observateur;
import java.util.ArrayList;

/**
 * class abstrait qui représente une observation et qui associe les observateurs, le lieu , la date et l'heure de celle-ci  
 * @author BOURBIGOT Tristan
 * @version 1.1
 */
public abstract class Observation {
	protected int idObs;
	protected Date dateObs;
	protected Time heureObs;
	protected Lieu lieuObs;
	protected ArrayList<Observateur> lesObservateurs = new ArrayList<Observateur>();

	/**
	 * Constructeur observation, initialise tout les parametre d'une observation 
	 * @param id identifiant de l'observation
	 * @param date date de l'observation 
	 * @param heure heure de l'observation
	 * @param lieu lieu de l'observation
	 * @param observateur tableau contenant tout les observateur qui on fait l'observation
	 */
	public Observation(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs) {
		boolean pasDObservateur = false;
		if(observateurs!=null){
			for(Observateur o: observateurs){
				if(o==null) pasDObservateur= true;
			}
		}else pasDObservateur =true;
		
		if(date!=null && heure!=null && lieu!=null && !pasDObservateur) {
			this.idObs=id;
			this.dateObs=date;
			this.heureObs=heure;
			this.lieuObs=lieu;
			this.lesObservateurs=observateurs;
		}else throw new IllegalArgumentException("Erreur Observation : constructeur : parametre invalide");
	}

	public void ajouteObservateur(Observateur aO) {
		if(aO!=null) this.lesObservateurs.add(aO);
		else System.err.println("Erreur observation : ajouteObservateur : observateur null");
	}

	public void retireObservateur(int aIdObservateur) {
		if(aIdObservateur>=0 && aIdObservateur>this.lesObservateurs.size() ) this.lesObservateurs.remove(aIdObservateur);
		else System.err.println("Erreur Observation : retireObservateur : observateur non trouve");
	}

	public abstract EspeceObservee especeObs();
}