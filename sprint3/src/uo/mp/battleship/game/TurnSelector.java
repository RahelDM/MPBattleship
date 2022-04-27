package uo.mp.battleship.game;

/**
 * Clase TurnSelector. Selector de turnos para los jugadores.
 * 
 * @author Raquel Suárez
 *
 */

import uo.mp.battleship.player.Player;

public class TurnSelector {

	//------ ATRIBUTOS-----
	private int turnSelector;
	private Player user;
	private Player computer;
	

	/**
	 * ------ TURN SELECTOR ------ 
	 * Inicializa el turno de usuario.
	 *  La primera vez, el turno es siempre para el Usuario.
	 */
	public TurnSelector(Player user, Player computer) {
		setTurnSelector(1);
		this.user = user;
		this.computer = computer;
	}

	/**
	 * ----- NEXT ------
	 * Devuelve el siguiente jugador que posee el turno.
	 * En circunstancias normales será el oponente. 
	 * Sin embargo, si el jugador ha disparado sobre un barco, el turno 
	 * sigue siendo para el mismo jugador.
	 * En este caso se habrá llamado al método repeat.
	 * 
	 * @return el turno.
	 */
	public Player next() {
		if (getTurnSelector()==1) {
			setTurnSelector(0);
			return computer;
		}else {
			setTurnSelector(1);
			return user;
		}
	}

	/**
	 * Se establece que el turno debe ser repetido.
	 */
	public void repeat() {
		if(getTurnSelector()==1) {
			setTurnSelector(0);
		}else{
			setTurnSelector(1);
		}
	}

	/**
	 * ------ GET TURN SELECTOR ----- 
	 * Método que devuelve el turnSelector.
	 * 
	 * @return the turnSelector
	 */
	public int getTurnSelector() {
		return turnSelector;
	}

	/**
	 * ----- SET TURN SELECTOR ------
	 *  Método que modifica el turnSelector.
	 * 
	 * @param the turnSelector to set
	 */
	public void setTurnSelector(int number) {
		this.turnSelector = number;
	}
	
}
