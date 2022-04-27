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
public class CoordinateGoTest {
	
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

	/** ESCENARIOS
	 * 
	 * Caso 1: Comprueba un Coordinate para la columna A, dirección Oeste.
	 * Caso 2: Comprueba un Coordinate para la fila 0, dirección Norte.
	 * Caso 3: Comprueba todas las direcciones con un Coordinate en fila y 
	 * columna diferente a 0.
	 * 
	 */
	
	/**
	 * GIVEN: Dado un tablero formado por casillas Water y Ships.
	 * WHEN: Se invoca al método go.
	 * THEN: Devuelve la coordenada buscada en la dirección pasada como
	 * parámetro.
	 */
	@Test
	public void coordinateGoTestColumWest() {
		try {
			Coordinate coordinate = new Coordinate(0,0);
			coordinate.go(3); //Dirección Oeste
			fail("Debería haber fallado");
		} catch (IllegalArgumentException ex) {
			assertEquals("Error: Dirección no encontrada", ex.getMessage());
		}
	}
	
	
	
	/**
	 * GIVEN: Dado un tablero formado por casillas Water y Ships.
	 * WHEN: Se invoca al método go.
	 * THEN: Devuelve la coordenada buscada en la dirección pasada como
	 * parámetro.
	 */
	@Test
	public void coordinateGoTestRow0North() {
		try {
			Coordinate coordinate = new Coordinate(5,0);
			coordinate.go(0); //Dirección Oeste
			fail("Debería haber fallado");
		} catch (IllegalArgumentException ex) {
			assertEquals("Error: Dirección no encontrada", ex.getMessage());
		}
	}
	
	
	/**
	 * GIVEN: Dado un tablero formado por casillas Water y Ships.
	 * WHEN: Se invoca al método go.
	 * THEN: Devuelve la coordenada buscada en la dirección pasada como
	 * parámetro.
	 */
	@Test
	public void coordinateGoTestAllDirections() {
		Coordinate coordinate = new Coordinate(4,2);
		//Comprobamos norte.
		Coordinate coordinateNorth = new Coordinate(4,1);
	    assertEquals(coordinateNorth, coordinate.go(0));	
	    //Comprobamos sur.
		Coordinate coordinateSouth = new Coordinate(4,3);
	    assertEquals(coordinateSouth, coordinate.go(2));
	    //Comprobamos este.
	    Coordinate coordinateEast = new Coordinate(5,2);
	    assertEquals(coordinateEast, coordinate.go(1));
	    //Comprobamos oeste.
	    Coordinate coordinateWest = new Coordinate(3,2);
	    assertEquals(coordinateWest, coordinate.go(3));
	    }

}
