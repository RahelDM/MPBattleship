/**
 * 
 */
package uo.mp.battleship.game;

import static org.junit.Assert.*;
import org.junit.Test;
import uo.mp.battleship.player.ComputerPlayer;
import uo.mp.battleship.player.HumanPlayer;
import uo.mp.battleship.player.Player;

/**
 * @author Raquel Su�rez
 *
 */
public class RepeatTest {

	/** ESCENARIOS
	 * 
	 * Caso 1: Comprobar que, despu�s de ejecutar repeat(), next() devolver� 
	 * el mismo jugador de nuevo.
	 * 
	 */
	
	/**
	 * GIVEN: Dado un tablero formado por casillas Water y Ships.
	 * WHEN: Se invoca al m�todo repeat()
	 * THEN: Devuelve el mismo jugador.
	 */

	@Test
	public void repeatTest() {
		Player user = new HumanPlayer("Human");
		Player computer = new ComputerPlayer("Computer");
		TurnSelector ts = new TurnSelector(user, computer);
		assertEquals(computer, ts.next()); //Comienza jugando el player.
		//Al ejecutar el m�todo next devolver� el computer.
		ts.repeat(); //Al repetir y despu�s ejecutar el m�todo next devovler� 
		//de nuevo el computer.
		assertEquals(computer, ts.next());

	}

}
