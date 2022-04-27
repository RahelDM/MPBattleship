package uo.mp.battleship.session;

import java.util.List;

import uo.mp.battleship.ranking.Score;
import uo.mp2021.util.exception.BattleshipException;

public interface SessionInteractor {

	/**
	 * Le pide al usuario un nivel de dificultad y devuelve la respuesta con un
	 * objeto GameLevel.
	 * 
	 * @return
	 * @throws BattleshipException 
	 */
	GameLevel askGameLevel() throws BattleshipException;

	/**
	 * Solicita al usuario un nombre y devuelve una cadena con la respuesta, que no
	 * puede ser nula ni vacía.
	 * 
	 * @return
	 * @throws BattleshipException 
	 */
	String askUserName();

	/**
	 * Le pide al usuario que elija una opción del menú. Devuelve un número entero
	 * que representa la opción elegida. Un valor mayor que cero representará
	 * algunas de las acciones disponibles. Un valor cero siempre representará la
	 * opción de salida.
	 * 
	 * @return
	 * @throws BattleshipException 
	 */
	int askNextOption();

	/**
	 * Le pide al usuario que elija sí o no.
	 * 
	 * @return
	 * @throws BattleshipException 
	 */
	boolean askDebugMode() throws BattleshipException;

	/**
	 * Al final de un juego, le pregunta al usuario si quiere guardar su puntuación.
	 * Devuelve verdadero si la respuesta es afirmativa y falsa en caso contrario.
	 * 
	 * @return
	 * @throws BattleshipException 
	 */
	boolean doYouWantToRegisterYourScore() throws BattleshipException;

	/**
	 * Recibe una lista de objetos Score que representan todas las puntuaciones
	 * registradas en el sistema y muestra toda la información sobre todas ellas
	 * (formato tabular, una línea para cada puntuación).
	 * 
	 * @param ranking
	 */
	void showRanking(List<Score> ranking);

	/**
	 * Recibe una lista de objetos Score que representan todas las puntuaciones
	 * registradas en el sistema y muestra toda la información sobre todas ellas
	 * (formato tabular, una línea para cada puntuación) excepto el nombre de
	 * usuario (se entiende que es el usuario almacenado en la sesión).
	 * 
	 * @param ranking
	 */
	void showPersonalRanking(List<Score> ranking);

	/**
	 * Muestra el mensaje de error, recibido como parámetro. Este tipo de errores no
	 * detienen la ejecución (errores recuperables).
	 * 
	 * @param message
	 */
	void showErrorMessage(String message);

	/**
	 * Muestra mensajes de error graves al usuario. Este método debe invocarse para
	 * informar al usuario del error irrecuperable y que el programa va a detener su
	 * ejecución.
	 * 
	 * @param message
	 */
	void showFatalErrorMessage(String message);

}
