package modele.donnee;

/**
 * cette classe représente un lieu par les coordonnee x et y en Lambert93
 * @author Tristan
 * @version 1.1
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

	/**
	 * getter de xCoord
	 * @return renvoie la coordonnee de x
	 */
	public double getXCoord(){
		return this.xCoord;
	}

	/**
	 * getter de yCoord
	 * @return renvoie la coordonnee de y
	 */
	public double getYCoord(){
		return this.yCoord;
	}

	/**
	 * setter de xCoord
	 * @param x nouvelle coordonee de xCoord
	 */
	public void setXCoord(double x){
		this.xCoord=x;
	}

	/**
	 * setter de yCoord
	 * @param y nouvelle coordonee de yCoord
	 */
	public void setYCoord(double y){
		this.yCoord=y;
	}

}