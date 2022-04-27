package uo.mp.battleship.ranking;

import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

public class GameRanking {

	private List<Score> ranking = new ArrayList<Score>();
	private String fileName;
	

	public GameRanking(String rankingFile) {
		ArgumentChecks.isNotEmpty(rankingFile);
		ArgumentChecks.isNotNull(rankingFile);
		setFileName(rankingFile);
	}

	/**
	 * Nombre del fichero.
	 * Modifica el nombre.
	 * 
	 * @param rankingFile
	 */
	private void setFileName(String rankingFile) {
		this.fileName=rankingFile;
	}
	

	/**
	 * Devuelve el nombre del fichero.
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Añade el parámetro al final de la lista de puntuaciones.
	 * 
	 * @param score
	 */
	public void append(Score score) {
		ranking.add(score);
	}

	/**
	 * Devuelve una copia de la lista de puntuaciones.
	 * 
	 * @return
	 */
	public List<Score> getRanking() {
		return new ArrayList<>(ranking);
	}
	

	/**
	 * Devuelve una lista que contiene solo aquellas puntuaciones cuyo nombre de
	 * usuario coincide con el parámetro
	 * 
	 * @param userName
	 * @return
	 */
	public List<Score> getRankingFor(String userName) {
		List<Score> newRanking = new ArrayList<Score>();
		for(Score rank: ranking) {
			if(rank.getUserName().equals(userName)) {
				newRanking.add(rank);
			}
		}
		return newRanking;
	}
}
