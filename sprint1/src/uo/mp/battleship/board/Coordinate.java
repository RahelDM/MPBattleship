package uo.mp.battleship.board;

import java.util.Random;

import uo.mp2021.util.checks.ArgumentChecks;

public class Coordinate {

	// X es la columna
	// Y es la fila
	private int colum;
	private int row;
	private char label;
	

	/**
	 * ----- COORDINATE ------
	 * Crea un objeto de tipo Coordinate, a partir de los 
	 * parámetros x para la columna, e y para la fila.
	 * 
	 * @param x, columna.
	 * @param y, fila.
	 */
	public Coordinate(int x, int y) {
		ArgumentChecks.isTrue(x >= 0 && y>=0, "Error:Parámetro incorrecto");
		this.colum = x;
		this.row = y;
	}

	/**
	 * ------ COORDINATE -----
	 * Crea un objeto Coordenada a partir de la etiquete que 
	 * representa la columna (x), que es una letra, y la etiqueta que 
	 * representa la fila, que es un número (y).
	 * 
	 * @param x, columna en letra.
	 * @param y, fila en número.
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
	 * Sobreescribe el método toString y devuelve
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
	 * más adecuado para el usario. 
	 * En lugar de Coordenada [x = 1, y = 1] este método devuelve B-2
	 */
	public String toUserString() {
		return getLabel() + "-" + (getRow()+1);
	
	}

	/**
	 * ------ GET LABEL -----
	 *Devuelve el valor de la columan como char.
	 *
	 * @return el valor de la columna como letra.
	 */
	private char getLabel() {
		return  label;

	}

	/**
	 * ------ EQUALS ------
	 * Sobreescribe el método equals.
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
