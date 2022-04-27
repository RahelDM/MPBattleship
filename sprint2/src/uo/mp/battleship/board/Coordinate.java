package uo.mp.battleship.board;

import java.util.Random;

/**
 * Clase Coordinate. Coordenadas para el tablero.
 * 
 * @author Raquel Su�rez
 *
 */

import uo.mp2021.util.checks.ArgumentChecks;

public class Coordinate {
	
	//------ ATRIBUTOS-----
	private int colum; 	// X es la columna
	private int row; 	// Y es la fila
	private char label;
	

	/**
	 * ----- COORDINATE ------
	 * Crea un objeto de tipo Coordinate, a partir de los 
	 * par�metros x para la columna, e y para la fila.
	 * 
	 * @param x, columna.
	 * @param y, fila.
	 */
	public Coordinate(int x, int y) {
		ArgumentChecks.isTrue(x >= 0 && y>=0, "Error:Par�metro incorrecto");
		this.colum = x;
		this.row = y;
	}

	/**
	 * ------ COORDINATE -----
	 * Crea un objeto Coordenada a partir de la etiquete que 
	 * representa la columna (x), que es una letra, y la etiqueta que 
	 * representa la fila, que es un n�mero (y).
	 * 
	 * @param x, columna en letra.
	 * @param y, fila en n�mero.
	 */
	public Coordinate(char x, int y) {
		label = x;
		row = y - 1;
		colum = x - 'A';
	}

	/**
	 * ------ GET COL -----
	 * Devuelve el valor de la columna.
	 * 
	 * @return, el valor de la columna.
	 */
	public int getCol() {
		return colum;
	}

	/**
	 * ------ GET ROW -----
	 *Devuelve el valor de la fila.
	 *
	 * @return el valor de la fila.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * ------ TO STRING ------
	 * Sobreescribe el m�todo toString y devuelve
	 *  el valor de las coordenadas con el formato:
	 * Coordenada [ x = 0, y = 1 ] (por ejemplo)
	 */
	@Override
	public String toString() {
		return "Coordenada [x=" + getCol() + ", y=" + getRow() + "]";
	}

	/**
	 * ------ TO USER STRING ------
	 * Devuelve el valor de las coordenadas en un formato 
	 * m�s adecuado para el usario. 
	 * En lugar de Coordenada [x = 1, y = 1] este m�todo devuelve B-2
	 */
	public String toUserString() {
		return ((char)(getCol()+'A')) + "-" + (getRow()+1);
	
	}

	/**
	 * ------ EQUALS ------
	 * Sobreescribe el m�todo equals.
	 *  Devuelve true si todos los campos de ambos objetos son iguales. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (colum != other.colum)
			return false;
		if (label != other.label)
			return false;
		if (row != other.row)
			return false;
		return true;
		
	}
	
	
	/**
	 * ----- COORDINATE GO ------
	 * Devuelve un objeto Coordinate, adyacente a la coordenada que invoca el 
	 * m�todo, en la direcci�n recibidda como par�metro, donde:
	 * 
	 * 0 es Norte.
	 * 1 es Este.
	 * 2 es Sur.
	 * 3 es Oeste.
	 * 
	 * @return un objeto coordinate v�lido por la forma
	 * en la que se hayan colocado los barcos.
	 */
	public Coordinate go(int direction) {
		ArgumentChecks.isTrue(direction>=0 && direction<4, 
				"Error: Direcci�n no encontrada");
		extracted(direction);
		if(direction==0) { //Norte
			return new Coordinate(getCol(),getRow()-1);
		}else if(direction==1) { //Este
			return new Coordinate(getCol()+1, getRow());
		}else if(direction==2) { //Sur
			return new Coordinate(getCol(),getRow()+1);
		}
		return new Coordinate(getCol()-1,getRow()); //Oeste
	}

	/**
	 * M�todo que comprueba todas y cada una de las filas y columnas, 
	 * as� como sus casillas laterales, en las que no se puede objetenes casillas
	 * adyacentes.
	 * Lanzar� excepciones indicando que es imposible encontrar dicha direcci�n.
	 * 
	 * @param direction
	 */
	private void extracted(int direction) {
		if(getCol()==0 && getRow()==0) {
			ArgumentChecks.isTrue(direction!=0 && direction!=3, 
					"Error: Direcci�n no encontrada");
		}
		if(getRow()==0) {
			ArgumentChecks.isTrue(direction!=0, 
					"Error: Direcci�n no encontrada");
		}
		if(getCol()==9 && getRow()==0) {
			ArgumentChecks.isTrue(direction!=0 && direction!=1, 
					"Error: Direcci�n no encontrada");
		}
		
		if(getCol()==0 && getRow()==9) {
			ArgumentChecks.isTrue(direction!=2 && direction!=3, 
					"Error: Direcci�n no encontrada");
		}
		if(getRow()==9) {
			ArgumentChecks.isTrue(direction!=2, 
					"Error: Direcci�n no encontrada");
		}
		if(getCol()==9 && getRow()==9) {
			ArgumentChecks.isTrue(direction!=1 && direction!=2, 
					"Error: Direcci�n no encontrada");
		}
	}
	
	/**
	 * ------ COORDINATE RANDOM -----
	 * Devuelve coordenadas aleatorias.
	 * 
	 * @return una coordenada aleatoria.
	 */
	public static Coordinate random() {
		Random random = new Random();
		return new Coordinate(random.nextInt(BoardBuilder.getSize()),
				random.nextInt(BoardBuilder.getSize()));
	}

}
