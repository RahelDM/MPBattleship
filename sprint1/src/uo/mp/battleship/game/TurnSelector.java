package uo.mp.battleship.game;

public class TurnSelector {

	private int turnSelector;
	
	/**
	 * ------ TURN SELECTOR ------
	 * Inicializa el turno de usuario. La primera vez, 
	 * el turno es siempre para el Usuario.
	 */
	public TurnSelector() {
		setTurnSelector(1);
	}
	
	/**
	 * ----- NEXT ------
	 * Devuelve alternado 1 o 0. 
	 * Cada número representa un turno de jugador diferente: 
	 * 1 es para el usuario, 
	 * 0 es para la máquina.
	 * 
	 * @return el turno.
	 */
	public int next() {
		if (getTurnSelector()==1) {
			setTurnSelector(0);
		}else {
			setTurnSelector(1);
		}
		return getTurnSelector();
		
	}

	
	/**
	 * ------ GET TURN SELECTOR -----
	 * Método que devuelve el turnSelector.
	 * @return the turnSelector
	 */
	public int getTurnSelector() {
		return turnSelector;
	}

	/**
	 * ----- SET TURN SELECTOR ------
	 * Método que modifica el turnSelector.
	 * @param turnSelector the turnSelector to set
	 */
	private void setTurnSelector(int turnSelector) {
		this.turnSelector = turnSelector;
	}
}

