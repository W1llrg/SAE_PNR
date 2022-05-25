package modele.donnee;

import java.util.Vector;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

/**
 * une classe qui represente une chouette liee a son observation
 * @author Eve-Anne OFFREDI
 * @version 1.0
 */

public class Chouette implements IObs<ObsChouette>{
	/**id de la chouette */
	private String idChouette;
	/**liste des observations */
	private ArrayList<ObsChouette> lesObservations;
	/** son sexe */
	private Sexe sexe;
	/**son espece */
	private EspeceChouette espece;

	/**
	* Chouette cree un objet Chouette
	* @param id l'identifiant de l'espece
	* @param leSexe le sexe de l'animal observe
	* @param lEspece l'espece observee
	*/
	public Chouette(String id, Sexe leSexe, EspeceChouette lEspece) {
		if(id==null) throw new IllegalArgumentException("Erreur Chouette : constructeur : le parametre id est null");
		else if(leSexe == null){
			System.out.println("Erreur Chouette : constructeur  : le parametre sexe est null, attribution : INCONNU");
			this.idChouette = id;
			this.sexe = Sexe.INCONNU;
			this.lesObservations =  new ArrayList<ObsChouette>();

			if(lEspece != null) this.espece = lEspece;
			else System.out.println("Erreur Chouette : constructeur  : le parametre espece est null");

		}else if(lEspece == null){
			System.out.println("Erreur Chouette : constructeur  : le parametre espece est null");
		}else{
			this.idChouette = id;
			this.sexe = leSexe;
			this.espece = lEspece;
			this.lesObservations =  new ArrayList<ObsChouette>();
		}

	}

	/**
	* Retourne l'id de la chouette
	* @return idChouette
	*/
	public String getIdChouette(){
		return idChouette;
	}

	/**
	* Retourne la liste des observations des chouettes
	* @return lesObservations
	*/
	public ArrayList<ObsChouette> getLesObservations(){
		return lesObservations;
	}

	/**
	* Retourne le sexe de la chouette
	* @return sexe
	*/
	public Sexe getSexe(){
		return sexe;
	}

	/**
	* Retourne l'espce de la chouette
	* @return espece
	*/
	public EspeceChouette getEspece(){
		return espece;
	}

	/**
	* Change l'id de la chouette
	* @param id nouvel id 
	*/
	public void setIdChouette(String id){
		if(id == null) System.out.println("Chouette : setIdChouette : paramètre null");
		else idChouette = id;
	}

	/**
	* Change la liste des observations de la chouette
	* @param obs nouvelle ArrayList 
	*/
	public void setLesObservations(ArrayList<ObsChouette> obs){
		if(obs == null) System.out.println("Chouette : setLesObservations : paramètre null");
		else lesObservations = obs;
	}

	/**
	* Change le sexe de la chouette
	* @param sexe nouveau sexe
	*/
	public void setSexe(Sexe sexe){
		if(sexe == null) System.out.println("Chouette : setSexe : paramètre null");
		else this.sexe = sexe;
	}

	/**
	* Change l'espece de la chouette
	* @param id nouvelle espece 
	*/
	public void setEspece(EspeceChouette espece){
		if(espece == null) System.out.println("Chouette : setEspece : paramètre null");
		else this.espece = espece;
	}
	
	/**
	* Ajoute une observation chouette
	* @param obs nouvelle observation
	*/
	@Override
	public void ajouteUneObs(ObsChouette obs){
		this.lesObservations.add(obs);
	}

	/**
	* Ajoute plusieurs observations chouette
	* @param obs nouvelles observations
	*/
	@Override
	public void ajoutePlsObs(ArrayList<ObsChouette> obs){
		for(ObsChouette elem : obs){
			this.lesObservations.add(elem);
		}
	}

	/**
	* Retire toutes les observations chouette
	*/
	@Override
	public void videObs(){
		this.lesObservations.clear();
	}

	/**
	* Retire une observation chouette
	* @param idObs id de l'observation a retirer
	*/
	@Override
	public boolean retireObs(int idObs){
		boolean rep = false;
		if(idObs < 0){
			System.out.println("Erreur Chouette : retireObs : l'id est négatif");
		}else if(idObs >= nbObs()){
			System.out.println("Erreur Chouette : retireObs : il n'y a pas autant d'especes");
		}else{
			this.lesObservations.remove(idObs);
			rep = true;
		}
		return rep;
	}

	/**
	* Renvoie le nombre d'observations de chouettes
	* @return nombre 
	*/
	@Override
	public int nbObs() {
		return this.lesObservations.size();
	}
}

