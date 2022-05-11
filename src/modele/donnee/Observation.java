package modele.donnee;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;
import donnee.Observateur;
import java.util.ArrayList;

/**
 * 
 * @author BOURBIGOT Tristan
 * @version 1.0
 */
public abstract class Observation {
	protected int idObs;
	protected Date dateObs;
	protected Time heureObs;
	protected Lieu lieuObs;
	protected Vector<Observateur> lesObservateurs = new Vector<Observateur>();

	/**
	 * 
	 * @param id identifiant de l'observation
	 * @param date date de l'observation 
	 * @param heure 
	 */
	public Observation(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs) {
	}

	public void ajouteObservateur(Observateur aO) {
	}

	public void retireObservateur(int aIdObservateur) {
	}

	public abstract EspeceObservee especeObs();
}