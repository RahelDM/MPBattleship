package uo.mp.battleship.interaction;

import java.util.ArrayList;

import uo.mp.battleship.board.Coordinate;

public class RandomInteractor implements GameInteractor {

	private ArrayList<Coordinate> alreadyFired = new ArrayList<Coordinate>();

	/**
	 * M�todo que genera una coordenada aleaoria.
	 */
	@Override
	public Coordinate getTarget() {
		Coordinate coordinate = Coordinate.random();
		while (alreadyFired.contains(coordinate)) {
			coordinate = Coordinate.random();
		}
		alreadyFired.add(coordinate);

		return coordinate;

	}

}
