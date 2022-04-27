package uo.mp.battleship.board.squares;


/**
 * Clase Ship. Barcos para el tablero.
 * 
 * @author Raquel Suárez
 *
 */

public class Ship implements Target {
	
	//------ ATRIBUTOS-----

	private int size;
	private char label;
	private boolean damage;
	
	//------ CONSTANTES-----

	public final static char BATTLESHIP = 'B';
	public final static char CRUISER = 'C';
	public final static char DESTROYER = 'D';
	public final static char SUBMARINE = 'S';
	public final static char HIT = '*';
	public final static char MISSED_SHOT = '.';
	public final static char WATER = ' ';
	public final static char SUNKED = '#';
	public final static int BATTLESHIP_SIZE = 4;
	public final static int CRUISER_SIZE = 3;
	public final static int DESTROYER_SIZE = 2;
	public final static int SUBMARINE_SIZE = 1;
	public final static int NOT_DAMAGE = 0;
	public final static int SEVERE_DAMAGE = 1;
	public final static int MASIVE_DAMAGE = 2;

	public Ship(int shipSize) {
		super();
		setDamage(false);
		this.size=shipSize;
		labelSize(shipSize);
	}

	/**
	 * ------ LABEL SIZE ------
	 * Método que, dependiendo de la longitud pasada como parámetro,
	 * establecerá una etiqueta u otra para el barco.
	 * 
	 * @param shipSize, tamaño del barco.
	 */
	private void labelSize(int shipSize) {
		if(shipSize==BATTLESHIP_SIZE) {
			setLabel(BATTLESHIP);
		}else if(shipSize==CRUISER_SIZE) {
			setLabel(CRUISER);
		}else if(shipSize==DESTROYER_SIZE) {
			setLabel(DESTROYER);
		}else if(shipSize==SUBMARINE_SIZE) {
			setLabel(SUBMARINE);
		}
	}
	
	/**
	 * ----- SET LABEL -----
	 * Método que cambia la etiqueta del barco.
	 * 
	 * @param label, nueva etiqueta.
	 */
	private void setLabel(char label) {
		this.label=label;
	}
	

	/**
	 * ------ SHOOT AT ------
	 * El barco es golpeado por un disparo del oponente y devuelve 
	 * el daño causado, como ha sido descrito en la clase Square. 
	 * 
	 * @return el daño causado.
	 */
	public int shootAt() {
		setDamage(true);
		size--;
		if(size<=0) {	
			return MASIVE_DAMAGE;
		}
		return SEVERE_DAMAGE;
	}

	
	/**
	 * ------ HAS IMPACT -----
	 * Método que devuelve true si ha sido tocado el barco, o 
	 * false si no.
	 *
	 * @return true o false.
	 */
	public boolean hasImpact() {
		if(toChar()==HIT ||toChar()==SUNKED){
			return true;
		}
		return false;
	}
	
	/**
	 * ------ TO CHAR -----
	 * Método que devuelve el carácter asociado con una celda de tipo barco
	 *  Por ejemplo:
	 *  Barco de Batalla (una B)
	 *  Crucero (una C)
	 *  Destructor (una D)
	 *  Submarino (una S)
	 *  
	 * @return devuelve un el caracter asociado al barco.
	 */
	public char toChar() {
		return label;
	}
	
	/**
	 * ------ TO FIRED CHAR -----
	 * Método que devuelve el carácter asociado con una celda.
	 * Como es una casilla con barco podrá retornan diferentes carácteres.
	 * 
	 * @return devuelve tocado o hundido.
	 */
	public char toFiredChar() {
		if(isSunk()) {
			return SUNKED;
		}else {
			return HIT;		
			}
	}

	/**
	 * ------ SIZE ------
	 * Devuelve el tamaño de este barco; es decir el número 
	 * casillas que ocupa.
	 * 
	 * @return longitud del barco.
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * ------ IS SUNK -----
	 * Devuelve true si todas las posiciones del barco han sido tocadas 
	 * (golpeadas), es decir, si el barco está hundido; false en caso contrario.
	 * 
	 * @return true o false.
	 */
	public boolean isSunk() {
		if(size<=0) {
			return true;
		}
		return false;
	}

	/**
	 * @return the damage
	 */
	public boolean isDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	private void setDamage(boolean damage) {
		this.damage = damage;
	}

}
