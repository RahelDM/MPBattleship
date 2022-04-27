package uo.mp.battleship.player;


import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.util.IO;

public class HumanPlayer {

	private Board myShips;
	private Board myOpponentShips;
	private String name;

	/**
	 * ------ HUMAN PLAYER ------
	 * Crea un nuevo objeto para un jugador humano y guarda el nombre del jugador. 
	 * Este nombre debe siempre ser diferente de null, y de cadena vacía;
	 * en otro caso, lo denominaremos “User”.
	 * @param name
	 */
	public HumanPlayer(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		}
		this.name = "User";
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
	public boolean shootAt(Coordinate position) {
		if (myOpponentShips.shootAt(position)) {
			return true;
		}
		return false;
	}

	/**
	 * ------ GET MY SHIPS -----
	 * Devuelve el tablero que guarda myShips 
	 * (con mis barcos y los disparos del oponente).
	 * 
	 * @return el tablero
	 */
	public Board getMySihps() {
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

	/**
	 * ----- MAKE CHOICE -----
	 * Lee las coordenadas por teclado y devuelve un objeto de tipo Coordinate. 
	 * El paquete útil contiene algunos métodos útiles para entrada/salida.
	 *  Debes suponer que el usuario nunca introducirá valores incorrectos.
	 * 
	 * @return las coordenadas elegidas.
	 */
	public Coordinate makeChoice() {
		return IO.readCoordinates();

     
	}

}
