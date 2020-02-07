package wordPlay.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Results implements FileDisplayInterface, StdoutDisplayInterface, Closeable {

	private final String[] filenames;
	
	private HashMap<String, BufferedWriter> writers = new HashMap<String, BufferedWriter>();

	private Results() {
		filenames = null;
	}

	public Results(String... filenames) {
		this.filenames = filenames;
	}

	/**method for writing to the console
	 * @param writeContent reversed string to the console
	 * 
	 */
	@Override
	public void writeToStdOut(String writeContent) {
		if (writers.get("stdout") == null)
			writers.put("stdout", new BufferedWriter(new OutputStreamWriter(System.out)));
		write(writers.get("stdout"), writeContent);
	}

	/**method for writing to file
	 * @param destination name of the file to be written
	 * @param writeContent reversed string to the file
	 * @return{@code String} with most frequent word from the file 
	 */
	@Override
	public void writeToFile(String destination, String writeContent) {
		if (writers.get(destination) == null)
			try {
				writers.put(destination, new BufferedWriter(new FileWriter(getFileHandle(destination))));
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		write(writers.get(destination), writeContent);
	}
	
	/**method for handling files
	 * @param fileName name of the file
	 * @return{@code File} with correct file
	 */
	private File getFileHandle(String filename) {
		for (String file : filenames) {
			if (filename.equalsIgnoreCase(file))
				return new File(file);
		}
		return null;
	}
	
	
	/**method for writing into the file
	 * @param out object 
	 * @content contents of the file
	 * 
	 */
	private void write(BufferedWriter out, String content) {
		try {
			out.append(content);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**method forclosing all the write buffers
	  */

	@Override
	public void close() throws IOException {
		for (Entry<String, BufferedWriter> entry : writers.entrySet()) {
			entry.getValue().close();
		}
		writers.clear();
	}
	
	

}
