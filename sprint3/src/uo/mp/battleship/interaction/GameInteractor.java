package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Coordinate;

public interface GameInteractor {
	
	/**
	 * M�todo que genera una coordenada a la que se va a disparar y la devuelve. 
	 * @return la coordenada generada.
	 */
	Coordinate getTarget();

}
