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
public class IsFleetSunkTest {


	private Board board;
	private int size;
	
	@Before
	public void setUp() {
		size = 10;
		board = new Board(size);
	}
	
	/** ESCENARIOS
	 * Caso 1: Varios barcos a flote:
	 *         Caso 1.1 : Falla un disparo devuelve false.
	 *         Caso 1.2 : Acierta disparo pero no hunde barco, devuelve false.
	 *         Caso 1.3 : Acierta disparo, hunde barco, aún quedan otros a flote,
	 *         devuelve false.
	 * Caso 2: Solo hay un barco a flote, dispara y se hunde, devuelve true.
	 */     
	
	/**
	 * GIVEN: Dado un tablero con varios barcos a flote.
	 * WHEN:  Se falla el disparo
	 * THEN:  Devuelve false
	 */
	@Test
	public void isFleetSunkTest1_1() {
		Coordinate coordinate = new Coordinate('A',2); //No hay barco
		assertEquals(0,board.shootAt(coordinate));
		assertFalse(board.isFleetSunk());
		
	}
		
	/**
	 * GIVEN: Dado un tablero con varios barcos a flote.
	 * WHEN:  Se acierta el disparo pero NO se hunde barco.
	 * THEN:  Devuelve false
	 */
	@Test
	public void isFleetSunkTest1_2() {
		Coordinate coordinate = new Coordinate('F',2); //Hay parte de un barco
		assertEquals(1,board.shootAt(coordinate)); //No lo hunde
		assertFalse(board.isFleetSunk()); // Sigue habiendo más barcos.
		
	}	
	
	/**
	 * GIVEN: Dado un tablero con varios barcos a flote.
	 * WHEN:  Se acierta el disparo pero SÍ se hunde barco.
	 * THEN:  Devuelve false
	 */
	@Test
	public void isFleetSunkTest1_3() {
		Coordinate coordinate = new Coordinate('D',2); //Hay parte de un barco
		assertEquals(2,board.shootAt(coordinate)); //Lo hunde.
		assertFalse(board.isFleetSunk()); // Sigue habiendo más barcos.
		
	}
	
	/**
	 * GIVEN: Dado un tablero con varios barcos a flote.
	 * WHEN:  Se acierta el disparo pero SÍ se hunde barco.
	 * THEN:  Devuelve false
	 */
	@Test
	public void isFleetSunkTest2() {
		assertEquals(2,board.shootAt(new Coordinate('B',2))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('D',2))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('E',5))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('E',7))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('B',6))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('B',7))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('B',9))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('D',9))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('C',9))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('G',5))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('H',5))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('H',7))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('I',7))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('G',9))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('H',9))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('I',9))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('F',2))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('G',2))); //Hunde el barco
		assertEquals(1,board.shootAt(new Coordinate('H',2))); //Hunde el barco
		assertEquals(2,board.shootAt(new Coordinate('I',2))); //Hunde el barco
		assertTrue(board.isFleetSunk()); 
		
	}
}
