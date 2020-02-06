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

	public String processLine(String lineFromFile) {
//		int i = -1;
		String[] words;
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
				else partialSentence += sentence + "\n";
				break;
			}
			
			stats.calculateStats(sentence + ".");
			for (String word : words = sentence.split("^\\s\\r\\n")) {
				sb.append( sentUtils.reverse(word) ).append(" ");
			}
			if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1).append(".");
		}
		String returnVal = sb.toString();
		sb.setLength(0);
		return returnVal;
	}
	
	public String getStats() {
		return stats.getAll();
	}
	
}
