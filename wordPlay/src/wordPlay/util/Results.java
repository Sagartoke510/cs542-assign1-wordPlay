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

	@Override
	public void writeToStdOut(String writeContent) {
		if (writers.get("stdout") == null)
			writers.put("stdout", new BufferedWriter(new OutputStreamWriter(System.out)));
		write(writers.get("stdout"), writeContent);
	}

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
	
	private File getFileHandle(String filename) {
		for (String file : filenames) {
			if (filename.equalsIgnoreCase(file))
				return new File(file);
		}
		return null;
	}
	
	private void write(BufferedWriter out, String content) {
		try {
			out.append(content);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		for (Entry<String, BufferedWriter> entry : writers.entrySet()) {
			entry.getValue().close();
		}
		writers.clear();
	}
	
	

}
