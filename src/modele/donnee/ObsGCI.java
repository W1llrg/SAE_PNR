package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Classe des observations des CGI
 * @author William
 * @version 1.2.3
 */
public class ObsGCI extends Observation {

	/** nombre d'oeufs */
	private int nombre;

	/** enum ContenuNid */
	private ContenuNid natureObs;

	/**
	 * constructeur ; initialise les parametres de classe
	 * @param id identifiant de l'observation
	 * @param date date de l'observation
	 * @param heure heure de l'observation
	 * @param lieu lieu de l'observation
	 * @param observateurs un ArrayList contenant le/les nom(s) des observateurs
	 * @param nature contenu du nid
	 * @param leNombre nombre d'oeufs dans le nid
	 */
	public ObsGCI(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, ContenuNid nature, int leNombre) {

		super(id, date, heure, lieu, observateurs);

		if (leNombre < 0) throw new IllegalArgumentException("Erreur ObsGCI : constructeur : leNombre : valeur invalide (<0)");
		else this.nombre = leNombre;

		if (nature == null) System.err.println("Erreur ObsGCI : constructeur : nature : parametre null");
		else this.natureObs = nature;

	}

	/**
	 * getter pour le parametre nombre
	 * @return le parametre nombre
	 */
	public int getNombre() {

		return this.nombre;

	}

	/**
	 * getter pour le parametre natureObs
	 * @return le parametre natureObs
	 */
	public ContenuNid getNatureObs() {

		return this.natureObs;
		
	}
	
	/**
	 * setter pour le parametre nombre
	 * @param nombre le nouveau nombre pour le parametre
	 */
	public void setNombre(int nombre) {
		
		if (nombre < 0) System.err.println("Erreur ObsGCI : setNombre() : valeur invalide (<0)");
		else this.nombre = nombre;
		
	}
	
	/**
	 * setter pour le parametre natureObs
	 * @param natureObs la nouvelle valeur pour le parametre
	 */
	public void setNatureObs(ContenuNid natureObs) {
		
		if (natureObs == null) System.err.println("Erreur ObsGCI : getNatureObs() : natureObs est null");
		else this.natureObs = natureObs;
		
	}

	/** methode qui precise l'espece observee dans cette classe */
	public EspeceObservee especeObs() {
		
		return EspeceObservee.GCI;

	}

}