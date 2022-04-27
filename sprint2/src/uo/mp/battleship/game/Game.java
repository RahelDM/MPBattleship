package uo.mp.battleship.game;

/**
 * Clase Game. Juego Battleship.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.ConsoleInteraction;
import uo.mp.battleship.player.ComputerPlayer;
import uo.mp.battleship.player.HumanPlayer;
import uo.mp.battleship.player.Player;
import uo.mp.util.IO;

public class Game {

	//------ ATRIBUTOS-----
	public Player leftPlayer;
	public Player rightPlayer;
	public int size;
	private Board myShip;
	private Board opponentShip;
	private boolean gameMode;
	private TurnSelector turn;

	//------ CONSTANTES-----
	public final static int DEFAULT_SIZE = 10;

	/**
	 * ------ GAME -----
	 *  Constructor que recibe un objeto de tipo HumanPlayer como 
	 *  primer parámetro y un ComputerPlayer, como segundo. 
	 *  Otros atributos del juego como el tamaño de los tableros 
	 *  y el modo de juego toman valores por defecto. 
	 *  Esto es, tableros para jugar de 10x10. 
	 *  Modo de juego Normal.
	 *  Se crean los tableros con los barcos de ambos jugadores y se les asigna
	 *  la referencia a los jugadores.
	 *  Cada jugador guarda el tablero con sus barcos 
	 *  y el tablero del oponente (y viceversa).
	 *  
	 * @param leftPlayer
	 * @param rightPlayer
	 */
	public Game(HumanPlayer leftPlayer, ComputerPlayer rightPlayer) {
		this.leftPlayer = leftPlayer;
		this.rightPlayer = rightPlayer;
		size = DEFAULT_SIZE;
		myShip = new Board(size);
		opponentShip = new Board(size);
		setGameMode(true);
		leftPlayer.setMyShips(myShip);
		leftPlayer.setOpponentShips(opponentShip);
		rightPlayer.setMyShips(opponentShip);
		rightPlayer.setOpponentShips(myShip);
		turn= new TurnSelector(leftPlayer, rightPlayer);
	}

	/**
	 * ----- GAME -----
	 *  Los primeros dos parámetros son los mismos que en el constructor anterior. 
	 *  El tercero se refiere al tamaño de los tableros
	 *  para jugar en lugar del valor por defecto. 
	 *  Debe estar dentro del rango [5, 15].
	 *  Cualquier otro valor será ignorado, y en su lugar será 
	 *  usado el tamaño por defecto. 
	 *  El modo de juego se coloca al modo por defecto.

	 * @param leftPlayer
	 * @param rightPlayer
	 * @param size
	 */
	public Game(HumanPlayer leftPlayer, ComputerPlayer rightPlayer, int size) {
		this.leftPlayer = leftPlayer;
		this.rightPlayer = rightPlayer;
		this.size = size;
		myShip = new Board(size);
		opponentShip = new Board(size);
		leftPlayer.setMyShips(myShip);
		leftPlayer.setOpponentShips(opponentShip);
		rightPlayer.setMyShips(opponentShip);
		rightPlayer.setOpponentShips(myShip);
		turn= new TurnSelector(leftPlayer, rightPlayer);

	}

	/**
	 * ----- IS GAME MODE -----
	 * Devuelve el modo de juego. 
	 *   
	 * @return el modo de juego.
	 */
	public boolean isGameMode() {
		return gameMode;
	}
	
	/**
	 * ----- SET GAME MODE -----
	 * Asigna el modo de juego. 
	 * Si el argumento es false, se coloca a modo normal
	 * (la flota de la máquina estará oculta). 
	 * Si es true, el modo de juego será depuración que 
	 * permitirá en su momento mostrar las coordenadas
	 * de la flota del oponente. 
	 * 
	 *  @param el nuevo modo de juego.
	 */
	public void setGameMode(boolean gameMode) {
		this.gameMode = gameMode;
	}

	/**
	 * ------ PLAY ------
	 * Es el único responsable de la interacción con el usuario, 
	 * así como la gestión del bucle principal.
	 *  En este bucle, los jugadores alternan 
	 *  turnos de disparo mientras no haya ganador. 
	 */
	public void play() {
			boolean game = true;
			ConsoleInteraction.showGameStatus(myShip, opponentShip, gameMode);
			Coordinate coordinate;
			while (game) {
				if (turn.getTurnSelector()==1) {
					IO.display("¡Ahora es el turno del jugador: " +
				leftPlayer.getName() + "!");
					coordinate = leftPlayer.makeChoice();
					coordinateString(coordinate);
					playerShoot(opponentShip.shootAt(coordinate));
					ConsoleInteraction.showGameStatus(myShip, opponentShip, gameMode);
					turn.next();
				} else {
					IO.display("¡Ahora es el turno del jugador: " 
				+ rightPlayer.getName() + "!");
					coordinate = rightPlayer.makeChoice();
					coordinateString(coordinate);
					playerShoot(myShip.shootAt(coordinate));
					ConsoleInteraction.showGameStatus(myShip, opponentShip, gameMode);
					turn.next();
				}
				game = ifWon(game);
			}
	}
	
		
	/**
	 * ------ IF WON -----
	 * Método que, dependiendo de quién gane el juego, imprimirá por
	 * pantalla la oración correcta. Indicando quién de los dos jugadores 
	 * es el ganador.
	 * 
	 * @param game
	 * @return el valor de game, indicando que acabará el juego.
	 */
	private boolean ifWon(boolean game) {
		if (rightPlayer.hasWon()) {
			IO.display("¡Se acabó el juego! \n" + "El ganador es: " 
		+ rightPlayer.getName().toUpperCase());
			game = false;
		} else if (opponentShip.isFleetSunk()) {
			IO.display("¡Se acabó el juego! \n" + "El ganador es: " 
		+ leftPlayer.getName().toUpperCase());
			game = false;
		}
		return game;
	}


	/**
	 * ------ COORDINATE STRING ------
	 * Método que imprimé por pantalla la posición, tanto en leta como en 
	 * números (respecto al array) de la coordenada pasada como 
	 * parámetro.
	 * 
	 * @param coordinate
	 */
	private void coordinateString(Coordinate coordinate) {
		IO.display("Disparo a: " + 
		coordinate.toUserString().toUpperCase() 
		+ " Posición: " + coordinate.toString());
	}

	/**
	 * ------ PLAYER SHOOT ------
	 * Método que imprime por pantalla el resultado del disparo.
	 * 
	 * @param isWater, true será tocado, false agua.
	 */
	private void playerShoot(int isWater) {
		if (isWater==1) {
			IO.display("¡TOCADO!");
			turn.repeat();
		} else if(isWater==2){
			IO.display("¡HUNDIDO!");
			turn.repeat();
		} else if(isWater==0) {
		IO.display("¡AGUA!");
	}

}
}
