package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Classe observation CGI
 * @author William RAGUENEAU
 * @version 1.1
 */
public class ObsGCI extends Observation {

	/** nombre d'oeufs */
	private int nombre;

	/** instance de la classe NidGCI */
	public NidGCI unnamed_NidGCI;

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

		if (leNombre < 0) throw new IllegalArgumentException("ERREUR - leNombre: valeur invalide (<0)");
		else this.nombre = leNombre;

		if (nature == null) throw new IllegalArgumentException("Erreur ObsGCI : constructeur : nature: parametre null");
		else this.natureObs = nature;

	}

	public EspeceObservee EspeceObs() {
		throw new UnsupportedOperationException();
	}
}