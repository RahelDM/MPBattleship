/**
 * 
 */
package uo.mp.battleship.board;

import uo.mp.battleship.board.squares.Target;

/**
 * Clase Square. Casilla del tablero.
 * 
 * @author Raquel Su�rez
 *
 */

public class Square {
	
	public final static char HIT = '*';
	public final static char MISSED_SHOT = '.';
	public final static char SUNKED = '#';
	
	private Target target;
	private boolean isShoot=false;

	
	/**
	 * ----- SHOOT AT ------
	 * Marca esta casilla como disparada y propaga el disparo al barco 
	 * o al agua cuya referencia se almacena en la casilla. 
	 * Devuelve un entero, dependiendo del da�o causado por el disparo:
	 *  0: no se ha producido da�o alguno; no hay barco ocupando 
	 *  esa casilla en el tablero del oponente, sino agua.
	 *  1: Da�o severo. Esta casilla tiene una referencia a un barco 
	 *  que no tiene todas sus casillas disparadas todav�a.
	 *  2: Da�o masivo. La casilla tiene una referencia a un barco, 
	 *  y �sta fue la �ltima casilla del barco que a�n 
	 *  no hab�a sido disparada (el barco queda hundido).
	 *  
	 * @return el nivel de da�o causado.
	 */
	public int shootAt() {
		isShoot=true;
		return target.shootAt();
	}
		
	/**
	 * ------ IS SHOT ------
	 * Si esta casilla ha sido disparada, devuelve true, 
	 * en otro caso devuelve false. 
	 * 
	 * @return true o false.
	 */
	public boolean isShot() {
		return isShoot;

	}
	
	/**
	 * ------ HAS IMPACT ------
	 * Devuelve true cuando el objeto contenido en la casilla es un barco 
	 * y ya ha sido disparado (o incluso hundido) y false en otro caso. 
	 * La clase Square delega la implementaci�n en el objeto 
	 * contenido en la casilla.
	 * 
	 * @return true o false
	 */
	public boolean hasImpact() {
		return target.hasImpact();
	}
	
	 
	 /**
	 * ------ TO CHAR -----
	 * Devuelve el car�cter correspondiente al contenido delegando esta
	 *  operaci�n en el objeto contenido en la casilla y dependiendo 
	 *  de si la casilla est� o no disparada para que se muestre 
	 *  el car�cter correspondiente.
	 *  
	 * @return el car�cter
	 * 
	 */
	 public char toChar() {
		if(isShot()) {
			return getContent().toFiredChar();
		}
		return getContent().toChar();
	}

	/**
	  * ------ SET CONTENT -----
	  * Este m�todo guarda en el atributo content de la casilla, el objeto 
	  * recibido como par�metro.
	  *  Podr�a ser un objeto Ship o Water.
	  *   
	  * @param target, de tipo Water o Ship
	  */
	 public Square setContent(Target target) {
		this.target=target;
		return this;
	 }
	 
	 /**
	  * ------ GET CONTENT -----
	  * Este m�todo guarda en el atributo content de la casilla, el objeto 
	  * recibido como par�metro.
	  *  Podr�a ser un objeto Ship o Water.
	  *   
	  * @param target, de tipo Water o Ship
	  */
	 public Target getContent() {
		return target;
	 }
	 
	 /**
	  * ------ SET CONTENT ------
	  * Devuelve true si el contenido de esta casilla est� asignado 
	  * a un objeto Ship o Water, y false en otro caso.
	  *   
	  * @return true o false.
	  */
	 public boolean hasContent() {
		if(target.toChar()!=SUNKED && target.toChar()!=MISSED_SHOT 
				&& target.toChar()!=HIT) return false;
		return true;
	 }
	

}
