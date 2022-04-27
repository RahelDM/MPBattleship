package uo.mp2021.util.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class Logger {
	private static PrintStream out;
	private String logFileName = "default.log";
	private static PrintStream errorOut = System.err;

	public Logger(String fileName) {
		if (fileName != null && !fileName.isBlank())
			this.logFileName = fileName;
	}

	/**
	 * Sends the string received as message to the log prefixing it with a timestamp
	 * 
	 * @param message
	 */
	public void log(String message) {
		try {
			out = new PrintStream(new FileOutputStream(logFileName, true));
			out.print(new Date() + " ");
			out.println(message);
		} catch (FileNotFoundException e) {
			errorOut.println(e.getMessage());
		} finally {
			out.close();
		}
	}

	/**
	 * Sends the full stack trace of the exception received to the log prefixing it
	 * with a timestamp
	 * 
	 * @param t, the exception to be logged
	 */
	public void log(Throwable t) {
		try {
			out = new PrintStream(new FileOutputStream(logFileName, true));
			out.print(new Date() + " ");
			t.printStackTrace(out);
		} catch (FileNotFoundException e) {
			errorOut.println(e.getMessage());
		} finally {
			out.close();
		}
	}
}
