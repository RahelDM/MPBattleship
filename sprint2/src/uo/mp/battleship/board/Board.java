package uo.mp.battleship.board;

import java.util.ArrayList;

/**
 * Clase Board. Tablero de juego.
 * 
 * @author Raquel Suárez
 *
 */

import java.util.List;

import uo.mp.battleship.board.squares.Ship;
import uo.mp2021.util.checks.ArgumentChecks;

public class Board {

	//------ ATRIBUTOS-----
	
	private Square[][] grid;
	List<Ship> fleet;

	//------ CONSTANTES-----
	public final static int MIN_SIZE = 5;
	public final static int MAX_SIZE = 15;
	public final static char BATTLESHIP = 'B';
	public final static char CRUISER = 'C';
	public final static char DESTROYER = 'D';
	public final static char SUBMARINE = 'S';
	public final static char HIT = '*';
	public final static char MISSED_SHOT = '.';
	public final static char WATER = ' ';
	public final static char SUNKED = '#';

	/**
	 * En este constructor el tamaño del array será el que reciba como parámetro,
	 * size x size.
	 * 
	 * @param size, tamaño del tablero.
	 */
	public Board(int size) {
		ArgumentChecks.isTrue(size >= MIN_SIZE && size <= MAX_SIZE,
				"Error: Tamaño fuera de rango");
		List<Ship> fleet = createFleet();
		grid = new BoardBuilder().of(size).forFleet(fleet).build();
	}

	/**
	 * Método que crea una flota de barcos.
	 * 
	 * @return la misma flota de barcos.
	 */
	private List<Ship> createFleet() {
		List<Ship> createFleet = new ArrayList<Ship>();
		// Añado 1 barco de batalla.
		createFleet.add(new Ship(Ship.BATTLESHIP_SIZE));
		// Añado 2 cruceros.
		createFleet.add(new Ship(Ship.CRUISER_SIZE));
		createFleet.add(new Ship(Ship.CRUISER_SIZE));
		// Añado 3 destructores.
		createFleet.add(new Ship(Ship.DESTROYER_SIZE));
		createFleet.add(new Ship(Ship.DESTROYER_SIZE));
		createFleet.add(new Ship(Ship.DESTROYER_SIZE));
		// Añado 4 submarinos.
		createFleet.add(new Ship(Ship.SUBMARINE_SIZE));
		createFleet.add(new Ship(Ship.SUBMARINE_SIZE));
		createFleet.add(new Ship(Ship.SUBMARINE_SIZE));
		createFleet.add(new Ship(Ship.SUBMARINE_SIZE));
		return createFleet;
	}

	/**
	 * ------- SHOOT AT ----- Método que guarda un disparo en esas coordenadas.
	 * Devuelve el daño sufrido en esa casilla.
	 * 
	 * 
	 * @param position a la que se le quiere disparar.
	 * @return el daño causado.
	 */
	public int shootAt(Coordinate position) {
		return grid[position.getRow()][position.getCol()].shootAt();

	}

	/**
	 * ------ IS FLEET SUNK ----- Comprueba si todos los barcos de la flota están
	 * hundidos, en cuyo caso devuelve true; en caso contrario devuelve false.
	 * 
	 * @return true o false.
	 */
	public boolean isFleetSunk() { // Mal
		int ships = 20;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length - 1; j++) {
				if (grid[i][j].toChar() == SUNKED) {
					ships--;
				}
			}
		}
		if (ships == 0) {
			return true;
		}
		return false;
	}

	/**
	 * ------- GET NOT FIRED POSITIONS ------ Método que devuelve la lista de
	 * coordenadas del tablero que no han sido disparadas todavía.
	 * 
	 * @return la lista con las coordenadas aún no disparadas.
	 */
	public List<Coordinate> getNotFiredPositions() {
		List<Coordinate> list = new ArrayList<Coordinate>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j].toChar() != MISSED_SHOT 
						&& grid[i][j].toChar() != HIT 
						&& grid[i][j].toChar() != SUNKED) {
					Coordinate coordinate = new Coordinate(i, j);
					list.add(coordinate);
				}
			}
		}
		return list;
	}

	/**
	 * ------ GET FULL STATUS ------ Método que devuelve un array de 2D de
	 * caracteres representando el estado del tablero. Un carácter en las
	 * coordenadas (x, y) representa el estado de esa casilla.
	 * 
	 * @return el array con los caracteres.
	 */
	public char[][] getFullStatus() {
		char[][] character = new char[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				character[i][j] = grid[i][j].toChar();
			}
		}
		return character;
	}

	/**
	 * ------ GET MINIMAL STATUS -----
	 * 
	 * Método que devuelve un array 2D de caracteres. 
	 * Sin embargo, devuelve el valor actual de aquellas casillas 
	 * en la cuadrícula que han sido ya disparadas.
	 * Aquellas que aún no han sido disparadas, devuelven un carácter blanco,
	 * independientemente de que contengan un barco o no.
	 * 
	 * @return el array con los caracteres.
	 */
	public char[][] getMinimalStatus() {
		char[][] minimalStatus = new char[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!grid[i][j].isShot()) {
					minimalStatus[i][j] = WATER;
				} else {
					minimalStatus[i][j] = grid[i][j].toChar();
				}

			}
		}
		return minimalStatus;

	}

	/**
	 * ------ GET COORDINATE ------ 
	 * Método que devuelve la posición de la coordenada
	 * pasada como parámetro.
	 * 
	 * @param coordinate
	 * @return la posición de la coordenada.
	 */
	public Square getSquare(Coordinate coordinate) {
		return grid[coordinate.getRow()][coordinate.getCol()];

	}

	/**
	 * ----- GET SIZE ----- Devuelve la longitud del tablero.
	 * 
	 * @return la longitud del tablero.
	 */
	public int getSize() {
		return grid.length;
	}


	/**
	 * ----- SET SQUARES FOR TEST -----
	 *  Asigna el array de Squares recibido como parámetro al grid de la clase.
	 *  Únicamente para utilizarlo en los tests.
	 * @param boardForTest
	 */
	protected void setSquares(Square[][] boardForTest) {
		this.grid = boardForTest;
	}

}
