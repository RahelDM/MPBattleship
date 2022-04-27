package uo.mp.battleship.board;

import java.util.List;

/**
 * Clase BoardBuilder. Constructor del tablero.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;
import uo.mp2021.util.checks.ArgumentChecks;

public class BoardBuilder {

	//------ ATRIBUTOS-----
	private static int size;
	private List<Ship> fleet;
	//------ CONSTANTES-----

	public final static int MIN_SIZE = 5;
	public final static int MAX_SIZE = 15;
	public final static int DEFAULT_SIZE = 10;

	/**
	 * ------ BOARD BUILDER ------
	 * Constructor que almacena en el atributo size de la clase, el tamaño
	 *  del array que se va a crear con el valor que recibe como parámetro. 
	 *  Devuelve el propio objeto BoardBuilder. 
	 *  Size debe estar en el rango [5,15].
	 *  
	 * @param size
	 * @return
	 */
	public BoardBuilder of(int size) {
		ArgumentChecks.isTrue(size >= MIN_SIZE && size <= MAX_SIZE, 
				"Error: Tamaño fuera de rango");
		setSize(size);
		return this;
	}
	
    public BoardBuilder forFleet(List<Ship> fleet) {
		this.fleet=fleet;
		return this;
		
	}
	

	/**
	 * ------ BUILD -----
	 * Devuelve un nuevo array cuadrado de objetos con el contenido fijo.
	 * Debería estar invocado antes el método of para dar un valor 
	 * correcto al atributo size. 
	 * 
	 * @return el tablero de juego.
	 */
	public Square[][] build(){
		Square[][] board = new Square[getSize()][getSize()];
		waterBoard(board); // Añado todas las casillas con agua.
		shipsBoard(board); // Coloco barcos en casillas fijas.
		return board;
	}

	/**
	 * ----- SHIPS BOARD ------
	 * Método para colocar todos los barcos en el tablero en posiciones fijas.
	 * 
	 * @param board, el tablero donde se colocarán los barcos.
	 */
	public void shipsBoard(Square[][] board) {
		//Submarionos:
		board[1][1]= new Square().setContent(fleet.get(9));
		board[1][3]= new Square().setContent(fleet.get(8));
		board[4][4]= new Square().setContent(fleet.get(7));
		board[6][4]= new Square().setContent(fleet.get(6));
		//Destructores:
		board[4][6]= new Square().setContent(fleet.get(5));
		board[4][7]= new Square().setContent(fleet.get(5));
		board[6][7]= new Square().setContent(fleet.get(4));
		board[6][8]= new Square().setContent(fleet.get(4));
		board[5][1]= new Square().setContent(fleet.get(3));
		board[6][1]= new Square().setContent(fleet.get(3));
		//Cruceros:
		board[8][1]= new Square().setContent(fleet.get(2));
		board[8][2]= new Square().setContent(fleet.get(2));
		board[8][3]= new Square().setContent(fleet.get(2));
		board[8][6]= new Square().setContent(fleet.get(1));
		board[8][7]= new Square().setContent(fleet.get(1));
		board[8][8]= new Square().setContent(fleet.get(1));
        //Barco de batalla:
		board[1][5]= new Square().setContent(fleet.get(0));
		board[1][6]= new Square().setContent(fleet.get(0));
		board[1][7]= new Square().setContent(fleet.get(0));
		board[1][8]= new Square().setContent(fleet.get(0));
	}
	

	/**
	 * ------ WATER BOARD ------
	 * Método que llena de agua todo el tablero.
	 * 
	 * @param board
	 */
	private void waterBoard(Square[][] board) {
		for(int i=0; i < board.length; i++ ) {
			for(int j=0; j < board[i].length; j++ ) {
				board[i][j]= new Square().setContent(new Water());
			}
		}
	}
	
	
	/**
	 * ------ GET SIZE ------
	 * Método que devuelve el tamaño del tablero.
	 * @return el tamaño del boardBuilder
	 */
	public static int getSize() {
		return size;
	}

	/**
	 * ------ SET SIZE ------
	 * Método que modifica el tamaño del tablero.
	 * @param modifica el tamaño del boardBuilder
	 */
	private void setSize(int size) {
		BoardBuilder.size = size;
	}
	
}