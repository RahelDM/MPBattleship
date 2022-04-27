package uo.mp.battleship.session;

import java.util.List;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.ranking.Score;
import uo.mp.battleship.serializer.ScoreSerialize;
import uo.mp2021.util.exception.BattleshipException;
import uo.mp2021.util.file.TxtUtil;
import uo.mp2021.util.log.SimpleLogger;

public class GameSession {
	private SessionInteractor sessionInteractor;
	private GameInteractor gameInteractor;
	private GamePresenter gamePresenter;
	private SimpleLogger simpleLogger;
	private GameRanking gameRanking;

	private static final int EXIT = 0;

	/**
	 * Asigna al atributo sessionInteractor el parámetro interactor.
	 */
	public void setSessionInteractor(SessionInteractor consoleSessionInteractor) {
		this.sessionInteractor = consoleSessionInteractor;

	}

	/**
	 * Asigna al atributo gameInteractor el parámetro interactor.
	 */
	public void setGameInteractor(GameInteractor consolePlayerInteractor) {
		this.gameInteractor = consolePlayerInteractor;
	}

	/**
	 * Asigna al atributo gamePresenter el parámetro presenter.
	 */
	public void setGamePresenter(GamePresenter consoleGamePresenter) {
		this.gamePresenter = consoleGamePresenter;
	}

	/**
	 * Asigna al atributo simpleLogger en GameSession el parámetro logger.
	 */
	public void setLogger(SimpleLogger consoleSimpleLogger) {
		this.simpleLogger = consoleSimpleLogger;
	}

	/**
	 * Asigna al atributo gameRanking en GameSession el parámetro ranking.
	 */
	public void setGameRanking(GameRanking gameRanking) {
		this.gameRanking = gameRanking;
	}

	/**
	 * Ejecuta las acciones descritas anteriormente.
	 * @throws BattleshipException 
	 */
	public void run() {
		int option = EXIT;
		do {
			try {
				String name = sessionInteractor.askUserName();
			option = sessionInteractor.askNextOption();
				processOption(option, name);
			} catch (RuntimeException e) {
				simpleLogger.log(e);
				sessionInteractor.showFatalErrorMessage("Error irecuperable. \n"
						+ "Por favor, contacte con el administrador \n"
						+ "Vuelva a intentar ejecutar la aplicación!");
				return;
			}catch(Exception e) {
				sessionInteractor.showErrorMessage("\n Error normal: " 
			+ e.getMessage());
			}
		} while (option != EXIT);
	}

	private void processOption(int option, String nameOfPlayer) throws BattleshipException {
		switch (option) {
		case EXIT:
			return;
		case 1:
			loadGame(nameOfPlayer);
			break;
		case 2:
			showResults();
			break;
		case 3:
			showMyPersonalResults(nameOfPlayer);
			break;
		}
	}

	@SuppressWarnings("unused")
	private void loadGame(String name) throws BattleshipException {
		// Seleccionar nivel de dificultad:
		GameLevel gameLevel = sessionInteractor.askGameLevel();
		int level = gameLevel.getLevel();
		boolean debugMode = sessionInteractor.askDebugMode();

		// Creación de jugadores:
		Player player1 = new Player(name);
		Player player2 = new Player("Computer");
		//Comprobación de parámetros:
		if(player1 == null || player2 == null) {
			throw new RuntimeException("Jugador Nulo");
		}
		player1.setInteractor(gameInteractor);
		player2.setInteractor(gameInteractor);
		
        //Creación del juego:
		Game game = new Game(player1, player2, level, debugMode);
		//Comprobación del juego:
		if(game == null) {
			throw new NullPointerException();
		}
		game.setPresenter(gamePresenter);
		game.play();
		//Si x jugador a ganado:
		if (player1.hasWon()) {
			doYouLikeSaveYourRanking(player1, gameLevel, game.getTime());
		} else if (player2.hasWon()) {
			doYouLikeSaveYourRanking(player2, gameLevel, game.getTime());
		}

	}

	private void doYouLikeSaveYourRanking(Player player, GameLevel level, long time) throws BattleshipException {
		if (sessionInteractor.doYouWantToRegisterYourScore()) {
			Score score = new Score(player.getName(), level, time);
			gameRanking.append(score);
			saveScoreToFile(gameRanking.getFileName());
		}
	}

	private void showResults() {
		List<Score> score = gameRanking.getRanking();
		sessionInteractor.showRanking(score);

	}

	private void showMyPersonalResults(String name) {
		List<Score> score = gameRanking.getRankingFor(name);
		sessionInteractor.showPersonalRanking(score);

	}
	
	/**
	 * Save all orders to a file with the given format
	 * 
	 * @param fileName
	 * @throws NewsStandException in case - the file name is invalid
	 */
	private void saveScoreToFile(String name) {
		ScoreSerialize serializer = new ScoreSerialize();
		List<String> lines = serializer.serialize(gameRanking.getRanking());
		new TxtUtil().writeLines(name, lines);
	}

}
