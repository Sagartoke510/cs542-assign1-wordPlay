package wordPlay.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import wordPlay.validation.Validator;
import wordPlay.validation.ValidatorUtil;

public class FileProcessor implements Closeable {

	public static class Validators {

		public static Validator fileValidator(String fileName) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (!FileProcessor.isValid(fileName))
						throw new ValidatorUtil.ValidationException("File", fileName, "File does not exist");
				}
			};
		}	
		public static Validator fileContentValidator(String fileName1) {
			return new Validator() {
				@Override
				public void run() throws Exception{
					File f = new File(fileName1);
				
					if(f.length()==0) {
						throw new ValidatorUtil.ValidationException("file is empty");
					}
					
				}
			};
		}
		}

	
	
	private BufferedReader br = null;
	private String next = null;
	File file = null;
	
	public FileProcessor(String fileName) {
		file = new File(fileName);
	}

	/**method for checking file exists or not
	 * @param fileName name of the input file
	 * @return{@code Boolean} with true or false values
	 */
	public static boolean isValid(String fileName) {
		File file = new File(fileName);
//		if (!file.exists()) {
//			System.out.println("File Exists");
//		}
		return file.exists();
		
	}

	/**method for average character per sentence
	 * @param fileName name of the file
	 * @return{@code Boolean} creates file if not exists
	 */
	public static boolean createIfNotExists(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception ie) {
				System.out.println("Error cocurred while creating file [" + fileName + "]:\n" + ie.getMessage());
				ie.printStackTrace();
				return false;
			}
		}
		return true;
	}

	/**method for reading a file
	 * @param 
	 * @return{@code String} with most frequent word from the file 
	 */
	private void openReader() {
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while reading contents of file [" + file.getName() + "]:\n" + e.getMessage());
		}
	}
	
	/**method for reading line
	 * @param 
	 * @return{@code String} with line
	 */
	public String getLine() {
		return next;
	}
	
	/**method checking whether line is read or not 
	 *   
	 */
	public boolean next() {
		if (br == null) openReader();
		
		try {
			return ((next = br.readLine()) != null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**method for closing all open resources and null
	 *
	 */
	@Override
	public void close() throws IOException {
		if (br != null) {
			br.close();
			br = null;
		}
	}
	
	
	

}
