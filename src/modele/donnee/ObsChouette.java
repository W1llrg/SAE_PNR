package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ObsChouette extends Observation {
	private TypeObservation typeObs;

	public ObsChouette(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, TypeObservation type) {
		super(id,date,heure,lieu,observateurs);
		if(type==null) System.out.println("Erreur ObsChouette : Constructeur : parametre type null");
		else this.typeObs = type;
	}
	public EspeceObservee especeObs() {
		return EspeceObservee.CHOUETTE;
	}
}