package uo.mp.battleship.player;

/**
 * Clase Jugador.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

public abstract class Player {

	//------ ATRIBUTOS-----

	private Board myShips;
	protected Board myOpponentShips;
	protected String name;

	public Player() {
		super();
		myShips= new Board(10);
		myOpponentShips= new Board(10);
		
	}

	/**
	 * ------ GET NAME ------
	 * Devuelve el nombre del jugador
	 * 
	 * @return el nombre del jugador.
	 */
	public String getName() {
		return name;
	}

	/**
	 * ------ SET MY SHIPS ------
	 * Asigna el parámetro recibido al tablero myShips que contendrá 
	 * sus barcos y los disparos del enemigo, con el parámetro 
	 * que recibe (de momento supondremos que nunca será null).
	 * 
	 * @param board
	 */
	public void setMyShips(Board board) {
		this.myShips = board;
	
	}

	/**
	 * ------ SET OPPONENT SHIPS ------
	 * Asigna el parámetro recibido al tablero opponentShip que almacena 
	 * los disparos propios y los barcos del oponente 
	 * (por el momento, suponemos que nunca será null).
	 * 
	 * @param board
	 */
	public void setOpponentShips(Board board) {
		this.myOpponentShips = board;
	}

	/**
	 * ------ SHOOT AT ------
	 * Dispara sobre el tablero del oponente. 
	 * Devuelve true si el disparo toca un barco y false en otro caso.
	 * 
	 * @param position
	 * @return true o false dependiendo de sí ha tocado o no un barco.
	 */
	public int shootAt(Coordinate position) {
		return myOpponentShips.shootAt(position);
	}
	

	/**
	 * ------ GET MY SHIPS -----
	 * Devuelve el tablero que guarda myShips 
	 * (con mis barcos y los disparos del oponente).
	 * 
	 * @return el tablero
	 */
	public Board getMyShips() {
		return myShips;
	}

	/**
	 * ------ HAS WON ------
	 * Devuelve true si la flota del oponente ha sido hundida;
	 *  false en otro caso.
	 *  
	 * @return true o false.
	 */
	public boolean hasWon() {
		if (myOpponentShips.isFleetSunk()) {
			return true;
		}
		return false;
	}

	/**
	 * ------ GET OPPONENT SHIPS -----
	 * Devuelve el tablero opponentShips
	 * (con los barcos del oponente y mis disparos).
	 * 
	 * @return el tablero de mi enemigo.
	 */
	public Board getOpponentShips() {
		return myOpponentShips;
	}
	
	
	public abstract Coordinate makeChoice();
		
	

}