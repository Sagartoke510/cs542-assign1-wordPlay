package wordPlay.sentence;


import wordPlay.stats.StatsProcessor;

public class SentenceHandler {
	
	private final StatsProcessor stats;
	private String partialSentence = null;
	private StringBuilder sb;
	SentenceUtils sentUtils;

	public SentenceHandler() {
		stats = new StatsProcessor();
		sb = new StringBuilder();
		sentUtils = new SentenceUtils();
	}

	/** Calculates stats and returns string with reversed words
	 * @param lineFromFile Line read from a file
	 * @return {@code String} with reversed words
	 */
	public String processLine(String lineFromFile) {
//		int i = -1;
		String[] words;
		stats.calculateStats(lineFromFile);
		lineFromFile += "\n";
		String lineWithoutDots = lineFromFile.replaceAll("\\.", "");
		int sentenceCount = lineFromFile.length() - lineWithoutDots.length();
		for (String sentence : lineFromFile.split("\\.")) {
			if (partialSentence != null) {
//				partialSentence += sentence;
				sentence = partialSentence + sentence;
				partialSentence = null;
			}
			if (sentenceCount-- <= 0) {
				if (partialSentence == null) partialSentence = sentence;
				else partialSentence += sentence;
				break;
			}
			
//			stats.calculateStats(sentence + ".");
			stats.incrementSentenceCount();
			for (String word : words = sentence.split("[^\\S\\r\\n]")) {
				sb.append( sentUtils.reverse(word) ).append(" ");
			}
			if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1).append(".");
		}
//		if (lineFromFile.endsWith("\n"))
		String returnVal = sb.toString();
		sb.setLength(0);
		return returnVal;
	}
	
	/** get all the calculations
	 * 
	 */
	public String getStats() {
		return stats.getAll();
	}
	
}
