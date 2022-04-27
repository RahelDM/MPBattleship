package uo.mp2021.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class FileUtil {
	
	public List<String> readLines(String inFileName)
			throws FileNotFoundException {
		
		List<String> res = new LinkedList<String>();
		try {
			BufferedReader input = createBufferedReader(inFileName);
			try {
				while(input.ready()) {
					res.add(input.readLine());
				}
			} finally {
				input.close();			
			}
				
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
			
		}  catch (IOException err) {
			throw new RuntimeException("Error en la lectura del fichero "
									   + inFileName);
		}
		return res;
		
	}
	
	public void writeLines(String outFileName, List<String> lines) {
		
		try {
			BufferedWriter output = createBufferedWritter(outFileName);
			try {
				for (String line : lines ) {
					output.write(line);
					output.newLine();
				}
			} finally {
				output.close();
			}
		} catch (IOException err) {
			throw new RuntimeException("Error de escritura en "
									   + outFileName);
		}
	}
	
	public abstract BufferedReader createBufferedReader(String inFileName)
				throws FileNotFoundException, IOException;
	public abstract BufferedWriter createBufferedWritter(String outFileName)
				throws FileNotFoundException, IOException;

}