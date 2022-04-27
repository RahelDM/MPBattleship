/**
 * 
 */
package uo.mp.battleship.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Raquel Suárez
 *
 */
public class ShootAtTest {

	private Board board;
	private int size;

	@Before
	public void setUp() {
		size = 10;
		board = new Board(size);
	}

	/**
	 * ESCENARIOS 
	 * Caso 1: Después de disparar a una casilla no disparada previamente
	 * y sin barco, devuelve false y la casilla queda marcada como -10. 
	 * Caso 2: Después de disparar a una casilla ya disparada y sin barco, el método
	 * devuelve false y la casilla queda marcada como -10. 
	 * Caso 3: Después de disparar a una casilla no disparada que contiene barco,
	 *  el método devolverá true y la casilla cambiará (valor negativo). 
	 *  Caso 4: Después de dispara a una casilla disparada originalemente
	 *  con barco, el contenido permanecerá igual y el método devolverá true.
	 * 
	 */
	
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla no disparada y sin barco.
	 * THEN: Devuelve false.
	 */
	@Test
	public void shootAtTest1() {
		Coordinate coordinate = new Coordinate('A', 2);
		assertFalse(board.shootAt(coordinate));
		assertEquals(-10, board.getCoordinate(coordinate));

	}
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla ya disparada y sin barco.
	 * THEN: Devuelve false.
	 */
	@Test
	public void shootAtTest2() {
		Coordinate coordinate = new Coordinate('A', 2);
		board.shootAt(coordinate);
		assertFalse(board.shootAt(coordinate));
		assertEquals(-10, board.getCoordinate(coordinate));

	}
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla aún no disparada y con barco.
	 * THEN: Devuelve true.
	 */
	@Test
	public void shootAtTest3() {
		Coordinate coordinate = new Coordinate('A', 1);
		assertTrue(board.shootAt(coordinate));
		assertEquals(-1, board.getCoordinate(coordinate));

	}
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla ya disparada y con barco.
	 * THEN: Devuelve true.
	 */
	@Test
	public void shootAtTest4() {
		Coordinate coordinate = new Coordinate('E', 10);
		board.shootAt(coordinate);
		assertFalse(board.shootAt(coordinate));
		assertEquals(-10, board.getCoordinate(coordinate));

	}
	

}
