package uo.mp.battleship.interaction;

/**
 * Clase ConsoleIteraction. Consola de interacción del juego.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.Board;
import uo.mp.util.IO;

public class ConsoleInteraction {

	//------ CONSTANTES-----
	private static boolean GAME_NORMAL = true;

	/**
	 * ------ SHOW GAME STATUS ------
	 * Muestra los dos tableros y su formato, depende del modo de juego: 
	 * Normal o Depuración.
	 * 
	 * @param left, tablero de la izquierda.
	 * @param right, tablero de la derecha.
	 * @param debugMode, el modo de juego.
	 */
	public static void showGameStatus(Board left, Board right, boolean debugMode) {
		showHeader(left);
		showBodyShips(left, right, debugMode);
	}

	/**
	 * ------ SHOW HEADER ------
	 * Método para imprimir la cabecera de los tableros.
	 * 
	 * @param user.
	 */
	private static void showHeader(Board user) {
		String header = String.format("           MY SHIPS   \t\t\t    "
				+ "                   OPPONENTS'S SHIPS    \n    ");
		char label = 'A';
		for (int i = 1; i <= 2; i++) {
			for (int j = 0; j < user.getSize(); j++) {
				header+= String.format("%c  ", label);
				label++;
			}
			label = 'A';
			header += String.format("\t\t\t    "); // Separación de tableros.

		}
		header += String.format("\n");
		IO.display(header);

	}

	/**
	 * ------ SHOW BODY SHIPS ------
	 * Método para imprimir el cuerpo del juego, es decir, los correspondientes
	 * tablero de juego.
	 * 
	 * @param user, tablero del usuario.
	 * @param opponent, tablero del oponente.
	 * @param gameMode, modo de juego.
	 */
	private static void showBodyShips(Board user, Board opponent, boolean gameMode) {
		char[][] myShips = user.getFullStatus();
		char[][] opponentShips;
		if (gameMode == GAME_NORMAL) {
			opponentShips = opponent.getMinimalStatus();
		} else {
			opponentShips = opponent.getFullStatus();
		}
		String body = "";
		for (int row = 0; row < myShips.length; row++) {
			body = printRow(body, row, myShips[row]);
			body+=" |";
			body += String.format("\t\t\t");
			body = printRow(body, row, opponentShips[row]);
			body+=" |"+ "\n";
		}
		body += String.format("\n");
		IO.display(body);
	}


	/**
	 * ------ PRINT ROW -----
	 * Método que imprime fila por fila.
	 * @param body
	 * @param row
	 * @param cs
	 * @return el cuerpo con las filas impresas.
	 */
	public static String printRow(String body, int row, char[] cs) {
		body += String.format("%2d", row+1);
		for(int j=0; j< cs.length;j++) {
			body += String.format(" |"+cs[j]);
		}
		return body;

	}
}