package modele.donnee;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * une classe qui represente un nid de GCI
 * @author William RAGUENEAU
 * @version 1.0
 */
public class NidGCI {

	/** id du nid */
	private int idNid;

	/** nombre d'envols reussi pour ce nid */
	private int nbEnvol;

	/** nom de la plage ou le nid est localise */
	private String nomPlage;

	/** observations pour ce nid */
	private ArrayList<ObsGCI> lesObservations = new ArrayList<ObsGCI>();

	/**
	 * constructeur : initialise les parametres de classe
	 * @param aId identifiant du nid
	 * @param aPlage plage ou est situe le nid
	 */
	public NidGCI(int aId, String aPlage) {
		throw new UnsupportedOperationException();
	}

	public Date dateDebutObs() {
		throw new UnsupportedOperationException();
	}

	public Date dateFinObs() {
		throw new UnsupportedOperationException();
	}
}