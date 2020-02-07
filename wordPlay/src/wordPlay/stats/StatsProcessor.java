package wordPlay.stats;

public class StatsProcessor {
	
	private final Stats matrix;
	
	public StatsProcessor() {
		matrix = new Stats();
	}
	
	public void calculateStats(String sentence) {
		matrix.incrementCharacter(sentence);
		for (String word : sentence.split("\\s+")) {
			matrix.process(word);
		}
	}
	
	public void incrementSentenceCount() {
		matrix.incrementSentence();
	}
	
	public String getAll() {
		return matrix.toString();
	}
	
}
