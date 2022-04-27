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
public class NextTest {




	/** ESCENARIOS
	 * 
	 * Caso 1: Comprobar que dos llamadas consecutivas al método next(),
	 * devolverán jugadores alternados.
	 * 
	 */
	
	/**
	 * GIVEN: Dado un tablero formado por casillas Water y Ships.
	 * WHEN: Se invoca al método next();
	 * THEN: Devolverá jugadores alternados.
	 */
	@Test
	public void nextTest() {
		Player user = new HumanPlayer("Human");
		Player computer = new ComputerPlayer("Computer");
		TurnSelector ts = new TurnSelector(user, computer);
		assertEquals(computer, ts.next()); //Comienza jugando el player.
		//Al ejecutar el método next devolverá el computer.
		//Devovlerá el player.
		assertEquals(user, ts.next()); 

	}

}
