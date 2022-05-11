package modele.donnee;

/**
 * cette classe représente un lieu par les coordonnee x et y en Lambert93
 * @author BOURBIGOT Tristan
 * @version 1.0
 */
public class Lieu {

	/**
	 * coordonnee x en Lambert93
	 */ 
	private double xCoord;

	/**
	 * coordonnée y en Lambert93
	 */
	 private double yCoord;

	/**
	 * Initialisation du lieux
	 * @param x coordonee x en Lambert93
	 * @param y coordonee y en Lambert93
	 */
	public Lieu(double x, double y){
		this.xCoord=x;
		this.yCoord=y;
	}
}