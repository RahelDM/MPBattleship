/**
 * 
 */
package uo.mp.battleship.board;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Raquel Suárez
 *
 */
public class GetNotFiredCoordinatesTest {


	private Board board;
	private int size;
	
	@Before
	public void setUp() {
		size = 10;
		board = new Board(size);

	}
	
	/** ESCENARIOS
	 * Caso 1: Tablero sin haber sido usado devuelve todas las casillas.
	 * Caso 2: Tablero al que se le dispará una única vez, devuelve todas
	 * las casillas excepto la disparada.
	 * Caso 3: Tablero al se le dispará a una casillas que ya ha sido disparada,
	 * devuelve todas las casillas excepto la disparada.
	 */
	
	/**
	 * GIVEN: Dado un tablero sin disparos.
	 * WHEN: No se dispara al tablero y se ejecuta el método a probar.
	 * THEN: Devuelve todo el tablero.
	 */
	@Test
	public void getNotFiredCoordinate1() {
		List<Coordinate> list = new ArrayList<Coordinate>();
		for(int i=0; i< board.getSize(); i++) {
			for(int j=0; j<board.getSize();j++) {
				list.add(new Coordinate(i,j));
			}
		}
		assertEquals(list, board.getNotFiredPositions());
		

		
	}
	
	/**
	 * GIVEN: Dado un tablero sin disparos.
	 * WHEN: Se dispara al tablero y se ejecuta el método a probar.
	 * THEN: Devuelve todo el tablero excepto la casilla disparada.
	 */
	@Test
	public void getNotFiredCoordinate2() {
		List<Coordinate> list = new ArrayList<Coordinate>();
		for(int i=0; i< board.getSize(); i++) {
			for(int j=0; j<board.getSize();j++) {
				list.add(new Coordinate(i,j));
			}
	
		}
		list.remove(11);
		board.shootAt(new Coordinate('B',2));
		assertEquals(list, board.getNotFiredPositions());
		
	}
	
	/**
	 * GIVEN: Dado un tablero sin disparos.
	 * WHEN: Se dispara al tablero en un punto ya disparado y se ejecuta el método a probar.
	 * THEN: Devuelve todo el tablero excepto la casilla disparada.
	 */
	@Test
	public void getNotFiredCoordinate3() {
		List<Coordinate> list = new ArrayList<Coordinate>();
		for(int i=0; i< board.getSize(); i++) {
			for(int j=0; j<board.getSize();j++) {
				list.add(new Coordinate(i,j));
			}
	
		}
		list.remove(11); //El barco está en la posición 11 del array.
		
		board.shootAt(new Coordinate('B',2));
		board.shootAt(new Coordinate('B',2));
		assertEquals(list, board.getNotFiredPositions());
		
		
	}

}
