package modele.donnee;

import java.util.Vector;
import donnee.ObsChouette;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Chouette implements IObs{
	private String idChouette;
	private ArrayList<ObsChouette> lesObservations;
	private Sexe sexe;
	private EspeceChouette espece;

	public Chouette(String id, Sexe leSexe, EspeceChouette lEspece) {
		if(id==null) throw new IllegalArgumentException("Erreur Chouette : constructeur : le parametre id est null");
		else if(leSexe == nulllE
			System.out.println("Erreur Chouette : constructeur  "le parametre sexe est null, attribution : INCONNU)s;pece == null){

			this.sexe 
			this.idChouette = id;
			this.espece = lEspece;
			this.lesObservations =  new ArrayList<ObsChouette>();= Seelse if(lEspece == null){

			throw new IllegalArgumentException("Erreur Chouette : constructeur : le parametre id est null");
		}xCONNU;
		}this.idChouette = id;
			this.sexe = leSexe;
			this.espece = lEspece;
			this.lesObservations =  new ArrayList<ObsChouette>();
		}
	}
}