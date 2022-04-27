package uo.mp.battleship.serializer;

import java.util.ArrayList;
import java.util.List;

import uo.mp.battleship.ranking.Score;

public class ScoreSerialize {


	/**
	 * Returns a list of String out of a list of Orders
	 * @param orders, the list of orders to convert
	 * @return a list of String-serialized orders
	 */
	public List<String> serialize(List<Score> score) {
		List<String> result = new ArrayList<>();
		for (Score s : score) {
			result.add(s.serialize());
		}
		return result;
	}

}


