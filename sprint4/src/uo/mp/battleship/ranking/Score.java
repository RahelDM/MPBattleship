package uo.mp.battleship.ranking;

import java.io.Serializable;
import java.util.Date;

import uo.mp.battleship.session.GameLevel;

@SuppressWarnings("serial")
public class Score implements Serializable {
	private String userName;
	private GameLevel level;
	private long time;
	private Date date;

	/**
	 * Constructor. − userName: nombre del usuario que jugó el juego. − level: nivel
	 * de dificultad. − time: duración del juego.
	 * 
	 * @param userName
	 * @param level
	 * @param time
	 */
	public Score(String userName, GameLevel level, long time) {
		setLevel(level);
		setTime(time);
		setUserName(userName);
		date = new Date();
	}

	/**
	 * Segundo contructor de la clase Score.
	 * 
	 * @param name
	 * @param level2
	 * @param time2
	 * @param date2
	 */
	public Score(String name, GameLevel level2, Long time2, Date date2) {
		setLevel(level);
		setTime(time);
		setUserName(userName);
		setDate(date2);
	}

	/**
	 * Devuelve el atributo de la fecha.
	 * 
	 * @param date2
	 */
	private void setDate(Date date2) {
		this.date = date2;
	}

	/**
	 * Devuelve el atributo del nombre del jugador.
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Devuelve el nivel de dificultad del juego, es decir, el atributo level.
	 * 
	 * @return the level
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * Devuelve el atributo del tiempo de jeugo.
	 * 
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Modifica el nombre del jugador.
	 * 
	 * @param userName the userName to set
	 */
	private void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Modifica el nivel de dificultad del juego.
	 * 
	 * @param level the level to set
	 */
	private void setLevel(GameLevel level) {
		this.level = level;
	}

	/**
	 * Modifica la duración de juego.
	 * 
	 * @param time the time to set
	 */
	private void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		if (this.userName.equals("Computer")) {

			return "Score [userName=" + userName + ", level= " + typeOfLevel(level) + ", time= " + time + " seconds"
					+ "]" + " Lost!  " + "Date: " + this.date + "\n";
		} else {
			return "Score [userName=" + userName + ", level= " + typeOfLevel(level) + ", time= " + time + " seconds"
					+ "]" + " Won!  " + "Date: " + this.date + "\n";
		}

	}

	public String toStringNotName() {
		return "Score [level= " + typeOfLevel(level) + ", time= " + time + " seconds" + "]" + "  Date: " + this.date
				+ "\n";
	}

	/**
	 * Método privado que cataloga la dificultad del juego dependiendo de su
	 * GameLevel.
	 * 
	 * @param level
	 * @return la dificultad de juego.
	 */
	private String typeOfLevel(GameLevel level) {
		if (level.getLevel() == 10) {
			return "EASY";
		} else if (level.getLevel() == 15) {
			return "MEDIUM";
		}
		return "HIGH";
	}

	public Date getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/**
	 * Método equals para comparar los nombres de dos jugadores. Si los nombres son
	 * iguales son el mismo jugador y devuelve true.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * Comparador para ordenar scores por el tipo de nivel.
	 * 
	 * Se ordeanará en el siguiente orden:
	 * 
	 * HIGH > MEDIUM > EASY.
	 */
	public int compareTo(Score that) {
		return this.getLevel().compareTo(that.getLevel());

	}

	public String serialize() {
		if (this.userName.equals("Computer")) {

			return "Score [userName=" + userName + ", level= " + typeOfLevel(level) + ", time= " + time + " seconds"
					+ "]" + " Lost!  " + "Date: " + this.date + "\n";
		} else {
			return "Score [userName=" + userName + ", level= " + typeOfLevel(level) + ", time= " + time + " seconds"
					+ "]" + " Won!  " + "Date: " + this.date + "\n";
		}

	}
}
