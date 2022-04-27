package uo.mp.battleship.board;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private int[][] grid;

	public final static int MIN_SIZE = 5;
	public final static int MAX_SIZE = 15;

	public final static char BATTLESHIP = 'B';
	public final static char CRUISER = 'C';
	public final static char DESTROYER = 'D';
	public final static char SUBMARINE = 'S';
	public final static char HIT = '*';
	public final static char MISSED_SHOT = '.';
	public final static char WATER = ' ';

	/**
	 * En este constructor el tama�o del array 
	 * ser� el que reciba como par�metro, size x size.
	 * @param size, tama�o del tablero.
	 */
	public Board(int size) {
		grid = new BoardBuilder().of(size).build();
	}

	/**
	 * ------- SHOOT AT -----
	 * M�todo que guarda un disparo en esas coordenadas. 
	 * Devuelve true si hay un barco en ellas, false si no lo hay. 
	 * Esto supone cambiar el contenido de la casilla 
	 * por el nuevo estado (un valor negativo):
	 * Si es un barco: -1, -2, -3, -4.
	 * Si es agua: -10.
	 * Si se dispara a la misma posici�n dos veces, la aplicaci�n 
	 * siempre devolver� true y el contenido de la casilla no cambiar�
	 *  del primer al segundo disparo.
	 *  
	 * @param position a la que se le quiere disparar.
	 * @return true o false.
	 */
	public boolean shootAt(Coordinate position) {
	        if (grid[position.getRow()][position.getCol()] >= 0) {
	            if (grid[position.getRow()][position.getCol()] >=1 ) {
	                grid[position.getRow()][position.getCol()] = 
	                -grid[position.getRow()][position.getCol()];
	                return true;

	            } if (grid[position.getRow()][position.getCol()] == 0) {
	                grid[position.getRow()][position.getCol()] = -10;
	                return false;
	            }
	        } else if( grid[position.getRow()][position.getCol()] <0
	                && grid[position.getRow()][position.getCol()]!=-10) {
	            return true;
	        }

	        return false;

	    }

	/**
	 * ------ IS FLEET SUNK -----
	 * Comprueba si todos los barcos de la flota est�n hundidos,
	 *  en cuyo caso devuelve true; en caso contrario devuelve false.
	 *  
	 * @return true o false.
	 */
	public boolean isFleetSunk() {
		int ships = 20;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length-1; j++) {
				if (grid[i][j] < 0 && grid[i][j]!=-10) {
					ships--;
				}
			}
		}
		if (ships == 0) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return grid.length;
	}

	/**
	 * ------- GET NOT FIRED POSITIONS ------
	 * M�todo que devuelve la lista de coordenadas
	 *  del tablero que no han sido disparadas todav�a.

	 * @return la lista con las coordenadas a�n no disparadas.
	 */
	public List<Coordinate> getNotFiredPositions() {
		List<Coordinate> list = new ArrayList<Coordinate>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] >= 0) {
					Coordinate coordinate = new Coordinate(i, j);
					list.add(coordinate);
				}
			}
		}
		return list;
	}

	/**
	 * ------ GET FULL STATUS ------
	 * M�todo que devuelve un array de 2D de caracteres 
	 * representando el estado del tablero.
	 *  Un car�cter en las coordenadas (x, y) representa el estado 
	 *  de esa casilla.
	 *  
	 * @return el array con los caracteres.
	 */
	public char[][] getFullStatus() {
		char[][] character = new char[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 1) {
					character[i][j] = SUBMARINE;
				} else if (grid[i][j] == 2) {
					character[i][j] = DESTROYER;
				} else if (grid[i][j] == 3) {
					character[i][j] = CRUISER;
				} else if (grid[i][j] == 4) {
					character[i][j] = BATTLESHIP;
				} else if (grid[i][j] <= -1 && grid[i][j] >= -4) {
					character[i][j] = HIT;
				} else if (grid[i][j] == 0) {
					character[i][j] = WATER;
				} else if (grid[i][j] == -10) {
					character[i][j] = MISSED_SHOT;

				}
			}
		}
		return character;
	}

	/**
	 * ------ GET MINIMAL STATUS -----
	 * 
	 * M�todo que devuelve un array 2D de caracteres. 
	 * Sin embargo, devuelve el valor actual de aquellas casillas 
	 * en la cuadr�cula que han sido ya disparadas. 
	 * Aquellas que a�n no han sido disparadas, devuelven un car�cter blanco,
	 *  independientemente de que contengan un barco o no. 
	 *  
	 * @return el array con los caracteres.
	 */
	public char[][] getMinimalStatus() {
		char[][] minimalStatus = new char[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] <= -1 && grid[i][j] >= -4) {
					minimalStatus[i][j] = HIT;
				} else if (grid[i][j] == -10) {
					minimalStatus[i][j] = MISSED_SHOT;
				} else {
					minimalStatus[i][j] = WATER;
				}

			}
		}
		return minimalStatus;

	}


	/**
	 * ------ GET COORDINATE ------
	 * M�todo que devuelve la posici�n de la coordenada pasada como 
	 * par�metro.
	 * 
	 * @param coordinate
	 * @return la posici�n de la coordenada.
	 */
	public int getCoordinate(Coordinate coordinate) {
		return grid[coordinate.getRow()][coordinate.getCol()];

	}
	
}
