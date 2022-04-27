package uo.mp.battleship.session;

public enum GameLevel {
	
	PLANET(20), OCEAN(15), SEA(10);

	private int level;

	/**
	 * Constructor de la clase GameLevel.
	 * @param i
	 */
	GameLevel(final int i) {
		this.level = i;
	}

	/**
	 * Método que devuelve un entero indicando el tamaño del tablero de juego.
	 * 
	 * @return the level en int.
	 */
	public int getLevel() {
		return level;
	}
	
	
	
	

	


}

