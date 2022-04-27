package uo.mp.battleship.board;

import uo.mp2021.util.checks.ArgumentChecks;

public class BoardBuilder {

	private static int size;
	public final static int MIN_SIZE = 5;
	public final static int MAX_SIZE = 15;
	public final static int DEFAULT_SIZE = 10;

	/**
	 * ------ BOARD BUILDER ------
	 * Constructor que almacena en el atributo size de la clase, el tamaño
	 *  del array que se va a crear con el valor que recibe como parámetro. 
	 *  Devuelve el propio objeto BoardBuilder. 
	 *  Size debe estar en el rango [5,15].
	 *  
	 * @param size
	 * @return
	 */
	public BoardBuilder of(int size) {
		ArgumentChecks.isTrue(size >= MIN_SIZE && size <= MAX_SIZE, "Error: Tamaño fuera de rango");
		setSize(size);
		return this;
	}

	/**
	 * ------ BUILD -----
	 * Devuelve un nuevo array cuadrado de enteros con el contenido fijo.
	 * Debería estar invocado antes el método of para dar un valor 
	 * correcto al atributo size. 
	 * 
	 * @return el tablero de juego.
	 */
	public int[][] build() {
		int[][]board = 
			{ 	{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 2, 2, 0, 2, 2, 0, 2, 2, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 3, 3, 3, 0, 3, 3, 3, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 4, 4, 4, 4, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
		return board;

	}

	/**
	 * ------ GET SIZE ------
	 * Método que devuelve el tamaño del tablero.
	 * @return el tamaño del boardBuilder
	 */
	public static int getSize() {
		return size;
	}

	/**
	 * ------ SET SIZE ------
	 * Método que modifica el tamaño del tablero.
	 * @param modifica el tamaño del boardBuilder
	 */
	private void setSize(int size) {
		BoardBuilder.size = size;
	}
}