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

	/**
	 * cette methode permet d'ajoute un nouveau observateur sur l'observation
	 * @param aO nouveau observateur a ajoute
	 */
	public void ajouteObservateur(Observateur aO) {
		if(aO!=null) this.lesObservateurs.add(aO);
		else System.err.println("Erreur observation : ajouteObservateur : observateur null");
	}

	/**
	 * cette methode permet de retire un observateur de l'observation
	 * @param aIdObservateur observateur a retire
	 */
	public void retireObservateur(int aIdObservateur) {
		if(aIdObservateur>=0 && aIdObservateur>this.lesObservateurs.size() ) this.lesObservateurs.remove(aIdObservateur);
		else System.err.println("Erreur Observation : retireObservateur : observateur non trouve");
	}

	/**
	 * getter de idObs
	 * @return renvoie l'id de l'observation
	 */
	public int getIdObs(){
		return this.idObs;
	}

	/**
	 * getter de dateObs
	 * @return renvoie la date de l'observattion
	 */
	public Date getDateObs(){
		return this.dateObs;
	}

	/**
	 * getter de heureObs
	 * @return renvoie l'heure de l'observation
	 */
	public Time getHeureObs(){
		return this.heureObs;
	}

	/**
	 * getter de lieuObs
	 * @return renvoie  le lieu de l'observation 
	 */
	public Lieu getLieuObs(){
		return this.lieuObs;
	}

	/**
	 * getter de lesObservateurs
	 * @return renvoie un Arraylist des observateurs de l'observation
	 */
	public ArrayList<Observateur> getLesObservateurs(){
		return this.lesObservateurs;
	}

	/**
	 * setter de idObs
	 * @param id nouvelle id de l'observation
	 */
	public void setIdObs(int id){
		this.idObs =id;
	}

	/**
	 * setter de dateObs
	 * @param date nouvelle date de l'observation
	 */
	public void setDateObs(Date date){
		if(date!=null) this.dateObs=date;
		else System.err.println("Erreur Observation : getDateObs : parametre invalide");
	}

	/**
	 * setter de heureObs 
	 * @param heure nouvelle heure de l'observation
	 */
	public void setHeureObs(Time heure){
		if(heure!=null) this.heureObs=heure;
		else System.err.println("Erreur Observation : getDateObs : parametre invalide");
	}

	/**
	 * setter de lieuObs
	 * @param lieu nouveau lieu de l'observation
	 */
	public void setLieuObs(Lieu lieu){
		if(lieu!=null) this.lieuObs=lieu;
		else System.err.println("Erreur Observation : getDateObs : parametre invalide");
	}

	/**
	 * setter de lesObservateurs
	 * @param observateurs les nouveaux observateur de l'observation
	 */
	public void setLesObservateurs(ArrayList<Observateur> observateurs){
		boolean pasDObservateur = false;
		if(observateurs!=null){
			for(Observateur o: observateurs){
				if(o==null) pasDObservateur= true;
			}
		}else pasDObservateur =true;
		if(!pasDObservateur) this.lesObservateurs=observateurs;
	}

	/**
	 * cette mehode renvoie le nom de l'espece
	 * @return renvoie le nom de l'espece observee
	 */
	public abstract EspeceObservee especeObs();
}