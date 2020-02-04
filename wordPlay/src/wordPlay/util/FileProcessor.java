package wordPlay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import wordPlay.sentence.SentenceHandler;

public class FileProcessor {

	public boolean isValid(String fileName) {
		File file = new File(fileName);
		if(!file.exists()) {
			System.out.println("File Exists");
		}
		return file.exists();
	}

	public boolean createIfNotExists(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception ie) {
				System.out.println("Error cocurred while creating file ["+fileName+"]:\n" + ie.getMessage());
				ie.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public BufferedReader readFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String lineFromFile=br.readLine();
			SentenceHandler sc = new SentenceHandler();
			sc.processLine(lineFromFile);
			return br;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error while reading contents of file ["+filename+"]:\n" + e.getMessage());
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
