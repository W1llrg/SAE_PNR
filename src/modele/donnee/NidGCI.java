package modele.donnee;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * une classe qui represente un nid de GCI
 * @author William
 * @version 1.2
 */
public class NidGCI implements IObs<ObsGCI> {

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
		
		if (aId < 0) throw new IllegalArgumentException("Erreur NidGCI : constructeur : id null");
		else this.idNid = aId;
		
		if (aPlage == null) throw new IllegalArgumentException("Erreur NidGCI : constructeur : plage null");
		else this.nomPlage = aPlage;
		
	}

	/** @return le parametre idNid */
	public int getIdNid() {

		return this.idNid;

	}

	/** @return le parametre nbEnvol */
	public int getNbEnvol() {

		return this.nbEnvol;

	}

	/** @return le parametre nomPlage */
	public String getNomPlage() {

		return this.nomPlage;

	}

	/** @return le parametre lesObservations */
	public ArrayList<ObsGCI> getLesObservations() {

		return this.lesObservations;

	}

	/**
	 * setter pour le parametre idNid
	 * @param id le nouvel id
	 */
	public void setIdNid(int id) {

		if (id < 0) System.err.println("Erreur NidGCI : setIdNid() : valeur invalide (<0)");
		else this.idNid = id;

	}

	/**
	 * setter pour le parametre nbEnvol
	 * @param nbEnvol la nouvelle valeur pour le parametre
	 */
	public void setNbEnvol(int nbEnvol) {

		if (nbEnvol < 0) System.err.println("Erreur NidGCI : setIdNid() : valeur invalide (<0)");
		else this.idNid = nbEnvol;
		
	}

	
	/**
	 * setter pour le parametre nomPlage 
	 * @param nom le nouveau nom pour la plage
	 */
	public void setNomPlage(String nom) {

		if (nom == null || nom.equals("")) System.err.println("Erreur NidGCI : setNomPlage() : valeur invalide");
		else this.nomPlage = nom;
		
	}
	
	
	/**
	 * setter pour le parametre lesObservations
	 * @param observations le nouvel ArrayList d'observations pour les GCI
	 */
	public void setLesObservations(ArrayList<ObsGCI> observations) {

		if (observations == null) System.err.println("Erreur NidGCI : setLesObservations() : donnee invalide");
		else this.lesObservations = observations;
		
	}

	/**
	 * Cette methode consulte toutes les observations et recupere pour chacune la date de l'observation.
	 * Si la date recuperee precede la date sauvegardee, elle remplace la date sauvegardee.  
	 * @return la date la plus ancienne des observations pour ce nid
	 */
	public Date dateDebutObs() {

		// date premiere obs
		// comparer dates lesObservations et garder le minimum
		Date oldestDate = this.lesObservations.get(0).getDateObs();	// initialisation, cette valeur n'est pas definitive
		
		for (ObsGCI obs : lesObservations) {
			
			Date tmp = obs.getDateObs();
			if (tmp.compareTo(oldestDate) < 0) {
				
				oldestDate = tmp;

			}

		}

		return oldestDate;
	}

	/**
	 * Cette methode consulte toutes les observations et recupere pour chacune la date de l'observation.
	 * Si la date recuperee succede la date sauvegardee, elle remplace la date sauvegardee.  
	 * @return la date la plus recente des observations pour ce nid
	 */
	public Date dateFinObs() {
		
		// date derniere obs
		// comparer dates lesObservations et garder le maximum
		Date recentDate = this.lesObservations.get(0).getDateObs();	// initialisation, cette valeur n'est pas definitive
		
		for (ObsGCI obs : lesObservations) {
			
			Date tmp = obs.getDateObs();
			if (tmp.compareTo(recentDate) > 0) {
				
				recentDate = tmp;

			}

		}

		return recentDate;
	}

	/**
	* Ajoute une observation GCI
	* @param obs nouvelle observation
	*/
	@Override
	public void ajouteUneObs(ObsGCI obs) {
		
		if (obs == null) System.err.println("Erreur NigGCI : ajouteUneObs() : valeur invalide");
		else this.lesObservations.add(obs);
		
	}

	/**
	* Ajoute plusieurs observations GCI
	* @param obs nouvelles observations
	*/
	@Override
	public void ajoutePlsObs(ArrayList<ObsGCI> obs) {

		if (obs == null) System.err.println("Erreur NigGCI : ajouteUneObs() : valeur invalide");
		else {
			
			for(ObsGCI elem : obs) {

			this.lesObservations.add(elem);

			}

		}
		
	}

	/**
	* Retire toutes les observations GCI
	*/
	@Override
	public void videObs() {
		
		this.lesObservations.clear();
		
	}

	/**
	* Retire une observation GCI
	* @param idObs id de l'observation a retirer
	*/
	@Override
	public boolean retireObs(int idObs) {
		
		boolean rep = false;

		if (idObs < 0) System.out.println("Erreur NidGCI : retireObs() : l'id est negatif");
		else {

			this.lesObservations.remove(idObs);
			rep = true;

		}
		return rep;

	}

	
	/**
	* Renvoie le nombre d'observations de GCI
	* @return nombre 
	*/
	@Override
	public int nbObs() {
		
		return this.lesObservations.size();
		
	}
}