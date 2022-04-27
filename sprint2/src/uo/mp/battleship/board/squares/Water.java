package uo.mp.battleship.board.squares;

/**
 * Clase Water. Agua para el tablero.
 * 
 * @author Raquel Su�rez
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
	 * M�todo que modifica la etiqueta de la casilla water por una distinta.
	 * @param label
	 */
	private void setLabel(char label) {
		this.label=label;
	}


	/**
	 * ------ SHOOT AT ------
	 * El barco es golpeado por un disparo del oponente y devuelve 
	 * el da�o causado, como ha sido descrito en la clase Square. 
	 * 
	 * @return el da�o causado.
	 */
	public int shootAt() {
		toFiredChar();
		return 0;
		
	}
	
	/**
	 * ------ HAS IMPACT -----
	 * M�todo que devuelve true si ha sido tocado el barco, o 
	 * false si no.
	 * Como no es un barco, si no agua, siempre devovler� false.
	 * 
	 * @return true o false.
	 */
	public boolean hasImpact() {
		return false;
	}
	
	/**
	 * ------ TO CHAR -----
	 * M�todo que devuelve el car�cter asociado con una celda de tipo agua.
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
	 * M�todo que devuelve el car�cter asociado con una celda Water.
	 * Como es una casilla con agua DISPARADA entonces siempre
	 * devolver� '.', es decir, un disparo perdido.
	 * 
	 * @return devuelve un disparo perdido.
	 */
	public char toFiredChar() {
		setLabel(MISSED_SHOT);
		return label;
		
	
      }



}
