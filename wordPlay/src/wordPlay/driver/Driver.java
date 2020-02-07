package wordPlay.driver;

import java.io.IOException;

import wordPlay.sentence.SentenceHandler;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;

/**
 * @author Sagar Toke
 *
 */
public class Driver {

	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}"))
				|| (args[2].equals("${arg2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		
		FileProcessor.Validators.fileValidator(args[0]).run();
		FileProcessor.Validators.fileContentValidator(args[0]);

		String filename = null;
		if (!FileProcessor.createIfNotExists(filename = args[1]) ||
			!FileProcessor.createIfNotExists(filename = args[2])) {
			System.out.println("Failed to create output file named [" + filename + "]");
			System.exit(0);
		}
		

		System.out.println("Hello World! Lets get started with the assignment");
		
		try (
				FileProcessor fp = new FileProcessor(args[0]);
				Results res = new Results(args[1], args[2]);
			) {
			SentenceHandler sh = new SentenceHandler();
			String line;
			while (fp.next()) {
				line = sh.processLine(fp.getLine());
				res.writeToFile(args[1], line);
				res.writeToStdOut(line);
			}
			res.writeToFile(args[2], sh.getStats());
		} catch (IOException iox) {
			iox.printStackTrace();
		}
		


	}

}
