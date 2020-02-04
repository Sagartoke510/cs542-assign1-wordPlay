package wordPlay.stats;

public class StatsCollector {
	
	private final Stats matrix;
	
	public StatsCollector() {
		matrix = new Stats();
	}
	
	public void calculateStats(String sentence) {
		matrix.incrementSentence();
		matrix.incrementCharacter(sentence);
		for (String word : sentence.split("\\s+")) {
			matrix.process(word);
		}
	}
	
}
