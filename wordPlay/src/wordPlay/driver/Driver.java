package wordPlay.driver;

import wordPlay.util.FileProcessor;

/**
 * @author Sagar Toke
 *
 */
public class Driver {

	public static void main(String[] args) {

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

		FileProcessor fp = new FileProcessor();
		if (!fp.isValid(args[0])) {
			System.out.println("Input file [" + args[0] + "] does not exist, please provide a valid input filename");
			System.exit(0);
		}

		String filename = null;
		if (!fp.createIfNotExists(filename = args[1]) ||
			!fp.createIfNotExists(filename = args[2])) {
			System.out.println("Failed to create output file named [" + filename + "]");
			System.exit(0);
		}

		System.out.println("Hello World! Lets get started with the assignment");

	}

}
