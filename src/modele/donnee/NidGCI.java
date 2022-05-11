package modele.donnee;

import java.util.Vector;
import donnee.ObsGCI;
import java.sql.Date;
import java.sql.Time;

public class NidGCI {
	private int idNid;
	private int nbEnvol;
	private String nomPlage;
	private Vector<ObsGCI> lesObservations = new Vector<ObsGCI>();

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