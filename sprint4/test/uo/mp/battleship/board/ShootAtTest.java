/**
 * 
 */
package uo.mp.battleship.board;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;

/**
 * @author Raquel Suárez
 *
 */
public class ShootAtTest {
	private static final int SUBMARINE = 1;
	private static final int DESTROYER = 2;
	private static final int CRUISER = 3;
	private static final int BATTLESHIP = 4;
	private static int SIZE_FOR_TEST=10;
	private static Board board= new Board(SIZE_FOR_TEST);


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Square[][] boardForTest = new Square[SIZE_FOR_TEST][SIZE_FOR_TEST];
		
		Ship s1 = new Ship(SUBMARINE);
		Ship s2 = new Ship(SUBMARINE);
		Ship s3 = new Ship(SUBMARINE);
		Ship s4 = new Ship(SUBMARINE);

		Ship d1 = new Ship(DESTROYER);
		Ship d2 = new Ship(DESTROYER);
		Ship d3 = new Ship(DESTROYER);

		Ship c1 = new Ship(CRUISER);
		Ship c2 = new Ship(CRUISER);

		Ship b = new Ship(BATTLESHIP);

		boardForTest[0][0] = new Square().setContent(s1);
		boardForTest[0][1] = new Square().setContent(new Water());
		boardForTest[0][2] = new Square().setContent(s2);
		boardForTest[0][3] = new Square().setContent(new Water());
		boardForTest[0][4] = new Square().setContent(s3);
		boardForTest[0][5] = new Square().setContent(new Water());
		boardForTest[0][6] = new Square().setContent(s4);
		boardForTest[0][7] = new Square().setContent(new Water());

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[1][i] = new Square().setContent(new Water());
		}
	
		boardForTest[2][0] = new Square().setContent(d1);
		boardForTest[2][1] = new Square().setContent(d1);
		boardForTest[2][2] = new Square().setContent(new Water());
		boardForTest[2][3] = new Square().setContent(d2);
		boardForTest[2][4] = new Square().setContent(d2);
		boardForTest[2][5] = new Square().setContent(new Water());
		boardForTest[2][6] = new Square().setContent(d3);
		boardForTest[2][7] = new Square().setContent(d3);

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[3][i] = new Square().setContent(new Water());
		}

		boardForTest[4][0] = new Square().setContent(c1);
		boardForTest[4][1] = new Square().setContent(c1);
		boardForTest[4][2] = new Square().setContent(c1);
		boardForTest[4][3] = new Square().setContent(new Water());
		boardForTest[4][4] = new Square().setContent(c2);
		boardForTest[4][5] = new Square().setContent(c2);
		boardForTest[4][6] = new Square().setContent(c2);
		boardForTest[4][7] = new Square().setContent(new Water());

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[5][i] = new Square().setContent(new Water());
		}

		boardForTest[6][0] = new Square().setContent(new Water());
		boardForTest[6][1] = new Square().setContent(new Water());
		boardForTest[6][2] = new Square().setContent(new Water());
		boardForTest[6][3] = new Square().setContent(new Water());
		boardForTest[6][4] = new Square().setContent(b);
		boardForTest[6][5] = new Square().setContent(b);
		boardForTest[6][6] = new Square().setContent(b);
		boardForTest[6][7] = new Square().setContent(b);

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[7][i] = new Square().setContent(new Water());
		}
		
		board.setSquares(boardForTest);
	}


	/**
	 * ESCENARIOS 
	 * Caso 1: Disparo a agua, devolerá 0 de daño.
	 * Caso 2: Disparo a un submarino (size 1), devolverá 2 (lo hunde).
	 * Caso 3: Disparo a una posición de destructor, devuelve 1 de daño.
	 * Caso 4: Disparo al destructor en su última posición. Devuelve 2.
	 * 
	 */
	
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla con agua.
	 * THEN: Devuelve 0
	 */
	@Test
	public void shootAtWaterTest() {
		Coordinate coordinate = new Coordinate (0,1); //Casilla 
		assertEquals(0,board.shootAt(coordinate));

	}
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla.
	 * THEN: Devuelve 2 y hundo el barco.
	 */
	@Test
	public void shootAtSubmarineTest() {
		Coordinate coordinate = new Coordinate (0,0); //Barco de tipo submarino.
		assertEquals(2,board.shootAt(coordinate));


	}
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla.
	 * THEN: Devuelve 1 pues toco un barco pero no lo hundio.
	 */
	@Test
	public void shootAtDestructorTest() {
		Coordinate coordinate = new Coordinate (0,2); //Barco destructor (size 2)
		assertEquals(1,board.shootAt(coordinate));

	}
	
	/**
	 * GIVEN: Dado un tablero.
	 * WHEN: Se dispara a una casilla.
	 * THEN: Devuelve 2 pues hundo un destructor.
	 */
	@Test
	public void shootAtTest4() {
		assertEquals(1,board.shootAt( new Coordinate (3,2)));
		assertEquals(2,board.shootAt( new Coordinate (4,2)));

	}
	

}
