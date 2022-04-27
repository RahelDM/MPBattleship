package uo.mp2021.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A utility class to read/write text lines from/to a text file
 */
public class TxtUtil extends FileUtil{

	@Override
	public BufferedReader createBufferedReader(String inFileName)
			throws FileNotFoundException {
		return new BufferedReader(new FileReader(inFileName));
		
	}

	@Override
	public BufferedWriter createBufferedWritter(String outFileName)
			throws IOException {
		return new BufferedWriter(new FileWriter(outFileName));
		
	}

}
