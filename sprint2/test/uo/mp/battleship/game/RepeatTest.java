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
 * @author Raquel Suárez
 *
 */
public class RepeatTest {

	/** ESCENARIOS
	 * 
	 * Caso 1: Comprobar que, después de ejecutar repeat(), next() devolverá 
	 * el mismo jugador de nuevo.
	 * 
	 */
	
	/**
	 * GIVEN: Dado un tablero formado por casillas Water y Ships.
	 * WHEN: Se invoca al método repeat()
	 * THEN: Devuelve el mismo jugador.
	 */

	@Test
	public void repeatTest() {
		Player user = new HumanPlayer("Human");
		Player computer = new ComputerPlayer("Computer");
		TurnSelector ts = new TurnSelector(user, computer);
		assertEquals(computer, ts.next()); //Comienza jugando el player.
		//Al ejecutar el método next devolverá el computer.
		ts.repeat(); //Al repetir y después ejecutar el método next devovlerá 
		//de nuevo el computer.
		assertEquals(computer, ts.next());

	}

}
