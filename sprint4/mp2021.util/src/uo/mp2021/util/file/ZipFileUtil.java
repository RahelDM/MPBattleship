package uo.mp2021.util.file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil extends FileUtil{

	@Override
	public BufferedReader createBufferedReader(String inFileName)
			throws FileNotFoundException, IOException {
		return new BufferedReader(
				  new InputStreamReader(
				  new GZIPInputStream(
				  new FileInputStream(inFileName))));
		
	}

	@Override
	public BufferedWriter createBufferedWritter(String outFileName)
			throws FileNotFoundException, IOException {
		return new BufferedWriter(
				   new OutputStreamWriter(
				   new GZIPOutputStream(
				   new FileOutputStream(outFileName))));
		
	}

}