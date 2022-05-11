package modele.donnee;
import java.util.ArrayList;

/**
 * Une interface qui implemente des methodes de controle pour les observations
 * @author William RAGUENEAU
 * @version 1.0
 */
public interface IObs<T> {

	public void ajouteUneObs(T obs);

	public void ajoutePlsObs(ArrayList<T> obs);

	public void videObs();

	public boolean retireObs(int idObs);

	public int nbObs();
}