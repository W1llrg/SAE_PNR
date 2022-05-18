package modele.donnee;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * une classe qui represente un nid de GCI
 * @author William RAGUENEAU
 * @version 1.1
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

	public void setIdNid(int id) {

		if (id < 0) System.err.println("Erreur NidGCI : setIdNid() : valeur invalide (<0)");
		else this.idNid = id;

	}

	public void setNbEnvol(int nbEnvol) {

		if (nbEnvol < 0) System.err.println("Erreur NidGCI : setIdNid() : valeur invalide (<0)");
		else this.idNid = nbEnvol;
		
	}

	
	public void setNomPlage(String nom) {

		if (nom == null || nom.equals("")) System.err.println("Erreur NidGCI : setNomPlage() : valeur invalide");
		else this.nomPlage = nom;
		
	}
	
	public void setLesObservations(ArrayList<ObsGCI> observations) {

		if (observations == null) System.err.println("Erreur NidGCI : setLesObservations() : donnee invalide");
		else this.lesObservations = observations;
		
	}

	/**
	 * CETTE METHODE MARCHE PAS SANS LES GETTERS D'Observation
	 * @return
	 */
	public Date dateDebutObs() {

		/*
		// date premiere obs
		// comparer dates lesObservations et garder le minimum
		Date oldestDate = this.lesObservations.get(0).getDate();
		
		for (ObsGCI obs : lesObservations) {
			
			Date tmp = obs.getDate();
			if (tmp.compareTo(oldestDate) > 0) {
				
			}
		}
		*/
		throw new UnsupportedOperationException();
	}

	public Date dateFinObs() {
		// date derniere obs
		// comparer dates lesObservations et garder le maximum
		throw new UnsupportedOperationException();
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