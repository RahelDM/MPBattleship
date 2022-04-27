package uo.mp.battleship.board.squares;

/**
 * Clase Water. Agua para el tablero.
 * 
 * @author Raquel Suárez
 *
 */


public class Water implements Target {

	//------ ATRIBUTOS-----

	private char label;
	
	//------ CONSTANTES-----
	public final static char MISSED_SHOT = '.';
	public final static char WATER = ' ';
	



	public Water() {
		super();
		setLabel(label);

	}
	
	/**
	 * ------ SET LABEL ------
	 * Método que modifica la etiqueta de la casilla water por una distinta.
	 * @param label
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
		toFiredChar();
		return 0;
		
	}
	
	/**
	 * ------ HAS IMPACT -----
	 * Método que devuelve true si ha sido tocado el barco, o 
	 * false si no.
	 * Como no es un barco, si no agua, siempre devovlerá false.
	 * 
	 * @return true o false.
	 */
	public boolean hasImpact() {
		return false;
	}
	
	/**
	 * ------ TO CHAR -----
	 * Método que devuelve el carácter asociado con una celda de tipo agua.
	 *  Por ejemplo:
	 *  Barco de Batalla (una B)
	 *  Crucero (una C)
	 *  Destructor (una D)
	 *  Submarino (una S)
	 *  Water (" ")
	 *  
	 * @return devuelve un el caracter asociado al barco.
	 */
	public char toChar() {
		setLabel(WATER);
		return label;

}
	/**
	 * ------ TO FIRED CHAR -----
	 * Método que devuelve el carácter asociado con una celda Water.
	 * Como es una casilla con agua DISPARADA entonces siempre
	 * devolverá '.', es decir, un disparo perdido.
	 * 
	 * @return devuelve un disparo perdido.
	 */
	public char toFiredChar() {
		setLabel(MISSED_SHOT);
		return label;
		
	
      }



}
