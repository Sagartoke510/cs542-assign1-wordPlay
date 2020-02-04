package wordPlay.sentence;

import wordPlay.stats.StatsCollector;

public class SentenceHandler {
	
	private final StatsCollector stats;
	
	private String partialSentence = null;

	public SentenceHandler() {
		stats = new StatsCollector();
	}

	public void processLine(String lineFromFile) {
		int i = -1;
		String[] words;
		for (String sentence : lineFromFile.split("\\.")) {
			if (partialSentence != null) {
//				partialSentence += sentence;
				sentence = partialSentence + sentence;
				partialSentence = null;
			}
			if (sentence.endsWith("\n")) {
				if (partialSentence.length() > 1) partialSentence = sentence;
				break;
			}
			
			words = sentence.split("\\s+");
			stats.calculateStats(sentence);
			
		}
	}
}
