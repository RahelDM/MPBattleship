package uo.mp.battleship.player;

/**
 * Clase HumanPlayer.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.Coordinate;
import uo.mp.util.IO;

public class HumanPlayer extends Player {


	/**
	 * ------ HUMAN PLAYER ------
	 * Crea un nuevo objeto para un jugador humano y guarda el nombre del jugador. 
	 * Este nombre debe siempre ser diferente de null, y de cadena vacía;
	 * en otro caso, lo denominaremos “User”.
	 * @param name
	 */
	public HumanPlayer(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		}
		this.name = "User";
	}

	
	/**
	 * ----- MAKE CHOICE -----
	 * Lee las coordenadas por teclado y devuelve un objeto de tipo Coordinate. 
	 * El paquete útil contiene algunos métodos útiles para entrada/salida.
	 *  Debes suponer que el usuario nunca introducirá valores incorrectos.
	 * 
	 * @return las coordenadas elegidas.
	 */
	public Coordinate makeChoice() {
		int i=0;
		Coordinate coordinate = IO.readCoordinates();
		int size=myOpponentShips.getNotFiredPositions().size();
		while(i<size && myOpponentShips.getNotFiredPositions().get(i)!=coordinate) {
			i++;
		}
		return coordinate;
}
}
