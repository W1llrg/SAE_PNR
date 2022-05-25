package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Cette classe ObsBatracien est une observation de l'espece batracien 
 * sous-type de la classe Observation avec, en plus, un attribut enumereprecisant l’espece precise du batracien et quatre en-tiers indiquant le resultat de l’observation. 
 * @author Theo
 * @version 1.0 
 */
public class ObsBatracien extends Observation {
	private int nombreAdultes;
	private int nombreAmplexus;
	private int nombreTetard;
	private int nombrePonte;
	private EspeceBatracien espece;

	/**
	 * Methode constructeur de la classe ObsBatracien
	 * @param id Date identifiant unique
	 * @param date Time date de la prise de l'observation
	 * @param heure heure de la prise de l'observation 
	 * @param lieu Lieu lieu de la prise de l'observation
	 * @param observateurs ArrayList<Observateur> la personne qui a prise l'observation
	 * @param resObs int[] tableau de int de 4 cases contenant le nombre d adultes (resObs[0]), d amplexus (resObs[1]), de t etards (resObs[2]) et de pontes (resObs[3])
	 * @param lEspece EspeceBatracien espece du batracien.
	 */
	public ObsBatracien(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, int[] resObs, EspeceBatracien lEspece) {
		super(id,date,heure,lieu,observateurs);

		if(resObs == null){
			throw new IllegalArgumentException("ERREUR ObsBatracien : Constructor : resObs null ");
		}else{
			this.nombreAdultes = resObs[0];
			this.nombreAmplexus = resObs[1];
			this.nombreTetard = resObs[2];
			this.nombrePonte = resObs[3];
		}

		if(lEspece == null){
			throw new IllegalArgumentException("ERREUR ObsBatracien : Constructor : lEspece null ");
		}else{
			this.espece = lEspece;
		}
		
	}

	/**
	 * Methode herite de la class observation, return la valeur du type enumere EspeceObservee Batracien
	 * @return EspeceObservee.BATRACIEN la valeur du type enumere
	 */
	public EspeceObservee especeObs() {
		return EspeceObservee.BATRACIEN;
	}

	/**
	 * getter de nombreAdultes 
	 * @return le nombre d adulte de Batracien en int
	 */
	public int getNombreAdultes(){
		return this.nombreAdultes;	
	}

	/**
	 * getter de nombreAmplexus 
	 * @return le nombre d amplexus du Batracien en int
	 */
	public int getNombreAmplexus(){
		return this.nombreAmplexus;	
	}

	/**
	 * getter de nombreTetard 
	 * @return le nombre de tetard du Batracien en int
	 */
	public int getNombreTetard(){
		return this.nombreTetard;	
	}

	/**
	 * getter de nombrePonte 
	 * @return le nombre de ponte du Batracien en int
	 */
	public int getNombrePonte(){
		return this.nombrePonte;	
	}

	/**
	 * getter d espece
	 * @return l'espece du Batracien en EspeceBatracien
	 *  
	 */
	public EspeceBatracien getEspece(){
		return this.espece;	
	}

	/**
	 * Methode setter du nombreAdultes
	 * @param leNombreAdultes int du nombre d'adulte de Batracien 
	 */
	public void setNombreAdultes(int leNombreAdultes){
		if(leNombreAdultes < 0){
			System.out.println("Erreur setNombreAdultes : setter : leNombreAdultes est negative");
		}else{
			this.nombreAdultes = leNombreAdultes;
		}
	}


	/**
	 * Methode setter du nombreAmplexus
	 * @param leNombreAmplexus int du nombre d'amplexus de Batracien 
	 */
	public void setNombreAmplexus(int leNombreAmplexus){
		if(leNombreAmplexus < 0){
			System.out.println("Erreur setNombreAmplexus : setter : leNombreAmplexus est negative");
		}else{
			this.nombreAmplexus = leNombreAmplexus;
		}
	}

	/**
	 * Methode setter du nombreTetard
	 * @param leNombreTetard int du nombre de tetard de Batracien 
	 */
	public void setNombreTetard(int leNombreTetard){
		if(leNombreTetard < 0){
			System.out.println("Erreur setNombreTetard : setter : leNombreTetard est negative");
		}else{
			this.nombreTetard = leNombreTetard;
		}
	}

	/**
	 * Methode setter du nombrePonte
	 * @param leNombrePonte int du nombre de ponte d'un Batracien 
	 */
	public void setNombrePonte(int leNombrePonte){
		if(leNombrePonte < 0){
			System.out.println("Erreur setNombrePonte : setter : leNombrePonte est negative");
		}else{
			this.nombrePonte = leNombrePonte;
		}
	}

	/**
	 * Methode setter d'espece
	 * @param lEspece EspeceBatracien de l'espece d'un Batracien 
	 */
	public void setEspece(EspeceBatracien lEspece){
		if(lEspece == null){
			System.out.println("Erreur setEspece : setter : lEspece null");
		}else{
			this.espece = lEspece;
		}
	}

}