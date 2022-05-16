package modele.donnee;

import java.util.Vector;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Chouette implements IObs<ObsChouette>{
	private String idChouette;
	private ArrayList<ObsChouette> lesObservations;
	private Sexe sexe;
	private EspeceChouette espece;

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
			this.espece = EspeceChouette.lEspece;
			this.lesObservations =  new ArrayList<ObsChouette>();
		}

	}

	@Override
	public int nbObs() {
		int rep = 
		return rep;
	}
}

