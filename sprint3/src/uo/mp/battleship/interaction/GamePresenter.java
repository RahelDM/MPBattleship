package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.player.Player;

public interface GamePresenter {

	/**
	 * M�odo que visualiza el estado del juego incluyendo tableros, 
	 * la flota original y la flota restante. 
	 * Tanto left, como right son referencias a los tableros que ser�n visualizados.
	 * El tercer par�metro es true cuando se juega en modo depuraci�n 
	 * y false en otro caso.
	 * @param left
	 * @param right
	 * @param gameMode, true en juego modo depuraci�n y false en normal.
	 */
	void showGameStatus (Board left, Board right, boolean gameMode);
	
	/**
	 * M�todo que informa al jugador de si el juego
	 * ha finalizado imprimiendo el mensaje: GAME OVER!!!
	 */
	void showGameOver ();
	
	/**
	 * M�todo que muestra el nombre del jugador que haya
	 * ganado la partida, imprimiendo un mensaje como:
	 * �The winner is <nombre del jugador>. Congratulations!!!�
	 * @param theWinner
	 */
	void showWinner (Player theWinner);

	/**
	 * M�todo que indica al usuario el resultado del disparo, con mensajes como: 
	 * �Hit! Repeat�, �Hit  and Sunk! Repeat� o �Miss! Change turn�
	 * @param impact
	 */
	void showHitOrMiss (int impact);

	/**
	 * M�todo que muestra el nombre del jugador al que le toca disparar: 
	 * �Now, the turn is for player  <NOMBRE DEL JUGADOR>�. 
	 */
	void showTurn (Player player);

	/**
	 * M�todo que muestra un mensaje para identificar la casilla objetivo:
	 *  � Shooting at <coordenada en el formato del usuario (con letra-numero)>� 
	 * @param coordinate
	 */
	void showShootingAt (Coordinate coordinate);

	
}
