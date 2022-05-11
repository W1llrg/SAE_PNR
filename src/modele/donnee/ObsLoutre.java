package modele.donnee;
import java.sql.Date;
import java.sql.Time;

public class ObsLoutre extends Observation {
	private IndiceLoutre indice;

	public ObsLoutre(int aId, Date aDate, Time aHeure, Lieu aLieu, ArrayList<Observateur> aObservateurs, IndiceLoutre aLIndice) {
		throw new UnsupportedOperationException();
	}

	public EspeceObservee especeObs() {
		throw new UnsupportedOperationException();
	}
}