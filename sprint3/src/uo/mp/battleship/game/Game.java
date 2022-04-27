package uo.mp.battleship.game;

/**
 * Clase Game. Juego Battleship.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.StateChecks;

public class Game {

	// ------ ATRIBUTOS-----
	public Player leftPlayer;
	public Player rightPlayer;
	public int size;
	private Board myShip;
	private Board opponentShip;
	private boolean gameMode;
	private TurnSelector turn;
	private GamePresenter presenter;

	// ------ CONSTANTES-----
	public final static int DEFAULT_SIZE = 10;

	/**
	 * ------ GAME ----- Constructor que recibe un objeto de tipo HumanPlayer como
	 * primer parámetro y un ComputerPlayer, como segundo. Otros atributos del juego
	 * como el tamaño de los tableros y el modo de juego toman valores por defecto.
	 * Esto es, tableros para jugar de 10x10. Modo de juego Normal. Se crean los
	 * tableros con los barcos de ambos jugadores y se les asigna la referencia a
	 * los jugadores. Cada jugador guarda el tablero con sus barcos y el tablero del
	 * oponente (y viceversa).
	 * 
	 * @param leftPlayer
	 * @param rightPlayer
	 */
	public Game(Player leftPlayer, Player rightPlayer) {
		ArgumentChecks.isTrue(leftPlayer != null && rightPlayer != null, "Error: Parámetros incorrectos");
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
		turn = new TurnSelector(leftPlayer, rightPlayer);

	}

	/**
	 * ----- GAME ----- Los primeros dos parámetros son los mismos que en el
	 * constructor anterior. El tercero se refiere al tamaño de los tableros para
	 * jugar en lugar del valor por defecto. Debe estar dentro del rango [5, 15].
	 * Cualquier otro valor será ignorado, y en su lugar será usado el tamaño por
	 * defecto. El modo de juego se coloca al modo por defecto.
	 * 
	 * @param leftPlayer
	 * @param rightPlayer
	 * @param size
	 */
	public Game(Player leftPlayer, Player rightPlayer, int size) {
		ArgumentChecks.isTrue(leftPlayer != null && rightPlayer != null && size >= 5 && size <= 15,
				"Error: parámetros incorrectos");
		setGameMode(true);
		this.leftPlayer = leftPlayer;
		this.rightPlayer = rightPlayer;
		this.size = size;
		myShip = new Board(size);
		opponentShip = new Board(size);
		leftPlayer.setMyShips(myShip);
		leftPlayer.setOpponentShips(opponentShip);
		rightPlayer.setMyShips(opponentShip);
		rightPlayer.setOpponentShips(myShip);
		turn = new TurnSelector(leftPlayer, rightPlayer);

	}

	/**
	 * ----- SET GAME MODE ----- Asigna el modo de juego. Si el argumento es false,
	 * se coloca a modo normal (la flota de la máquina estará oculta). Si es true,
	 * el modo de juego será depuración que permitirá en su momento mostrar las
	 * coordenadas de la flota del oponente.
	 * 
	 * @param el nuevo modo de juego.
	 */
	public void setGameMode(boolean gameMode) {
		this.gameMode = gameMode;
	}

	/**
	 * ------ PLAY ------ Es el único responsable de la interacción con el usuario,
	 * así como la gestión del bucle principal. En este bucle, los jugadores
	 * alternan turnos de disparo mientras no haya ganador.
	 */
	public void play() {
		boolean game = true;
		presenter.showGameStatus(myShip, opponentShip, gameMode);
		Coordinate coordinate;
		while (game) {
			if (turn.getTurnSelector() == 1) {
				coordinate = leftPlayer.getInteractor().getTarget();
				presenter.showShootingAt(coordinate);
				int shoot = opponentShip.shootAt(coordinate);
				presenter.showHitOrMiss(shoot);
				typeShoot(shoot);
				presenter.showGameStatus(myShip, opponentShip, gameMode);
				presenter.showTurn(turn.next());
			} else {
				coordinate = rightPlayer.getInteractor().getTarget();
				presenter.showShootingAt(coordinate);
				int shoot = myShip.shootAt(coordinate);
				typeShoot(shoot);
				presenter.showHitOrMiss(shoot);
				presenter.showGameStatus(myShip, opponentShip, gameMode);
				presenter.showTurn(turn.next());
			}
			game = ifWon(game);
		}
	}

	/**
	 * @param shoot
	 */
	private void typeShoot(int shoot) {
		if (shoot != 0) {
			turn.repeat();
		}
	}

	/**
	 * Método que se deverá ejecutar antes que cualquier otro método. Implica la
	 * comunicación con la persona que está jugando. El no hacerlo producirá un
	 * IllegalStateException.
	 * 
	 * @param arg
	 * @return
	 */
	public void setPresenter(GamePresenter arg) {
		StateChecks.isTrue(arg!=null, "Error: Parámetro incorrecto");
		this.presenter = arg;

	}

	/**
	 * ------ IF WON ----- Método que, dependiendo de quién gane el juego, imprimirá
	 * por pantalla la oración correcta. Indicando quién de los dos jugadores es el
	 * ganador.
	 * 
	 * @param game
	 * @return el valor de game, indicando que acabará el juego.
	 */
	private boolean ifWon(boolean game) {
		if (rightPlayer.hasWon()) {
			presenter.showWinner(rightPlayer);
			presenter.showGameOver();
			game = false;
		} else if (opponentShip.isFleetSunk()) {
			presenter.showWinner(leftPlayer);
			presenter.showGameOver();
			game = false;
		}
		return game;
	}
}
