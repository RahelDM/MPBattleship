package uo.mp.battleship.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uo.mp.battleship.ranking.Score;
import uo.mp.battleship.session.GameLevel;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.exception.LineFormatException;
import uo.mp2021.util.log.SimpleLogger;



public class ScoreParser {

	private int lineNumber = 0;
	private SimpleLogger log;

	public List<Score> parse(List<String> lines) {
		ArgumentChecks.isNotNull(lines);
		List<Score> scoreList = new ArrayList<>();
		for (String line : lines) {
			lineNumber++;
			try {
				Score s = parseLine(line);
				scoreList.add(s);

			} catch (LineFormatException e) {
				log.log(e);
			} catch (ParseException e) {
				log.log(e);
			}
		}
		return scoreList;
	}

	private Score parseLine(String line) throws LineFormatException, ParseException {
		checkIsBlank(line); 
		String[] parts = line.split("\t");
		String name = parts[0];
		GameLevel level = parseLevel(parts[1]);
		Long time = Long.parseLong(parts[2]);
		String date1 = parts[3] + " " + parts[4];
		Date date = new SimpleDateFormat("dd/MM/yy HH:mm:ss").parse(date1);
		return new Score(name, level, time, date);
	}

	private GameLevel parseLevel(String string) throws LineFormatException {
		if (string.equals("S")) {
			return GameLevel.SEA;
		} else if (string.equals("O")) {
			return GameLevel.OCEAN;
		} else if (string.equals("P")) {
			return GameLevel.PLANET;
		} else {
			throw new LineFormatException(lineNumber, "Nivel incorrecto");
		}
	}

	private void checkIsBlank(String line) throws LineFormatException {
		if (line.isBlank()) {
			throw new LineFormatException(lineNumber, "Línea en blanco");
		}
	}

	public int getLineNumber() {
		return lineNumber;
	}

}
