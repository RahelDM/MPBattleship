package uo.mp.battleship.player;

/**
 * Clase ComputerPlayer.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.Coordinate;

public class ComputerPlayer extends Player {

	/**
	 * ------ COMPURTER PLAYER ------
	 * Crea un nuevo objeto para un jugador humano y guarda el nombre del jugador. 
	 * Este nombre debe siempre ser diferente de null, y de cadena vacía;
	 * en otro caso, lo denominaremos “computer”.
	 * @param name
	 */
	public ComputerPlayer(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		}
		this.name = "Computer";
	}

	/**
	 * ----- MAKE CHOICE -----
	 * Genera aleatoriamente coordenadas que no hayan sido disparadas anteriormente.
	 * 
	 * @return las coordenadas elegidas.
	 */
	public Coordinate makeChoice() {
		int i=0;
		Coordinate coordinate = Coordinate.random();
		int size=myOpponentShips.getNotFiredPositions().size();
		while(i<size && myOpponentShips.getNotFiredPositions().get(i)!=coordinate) {
			i++;
		}
	
		return coordinate;
	}
}
