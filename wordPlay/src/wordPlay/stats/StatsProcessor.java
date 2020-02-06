package wordPlay.stats;

public class StatsProcessor {
	
	private final Stats matrix;
	
	public StatsProcessor() {
		matrix = new Stats();
	}
	
	public void calculateStats(String sentence) {
		matrix.incrementSentence();
		matrix.incrementCharacter(sentence);
		for (String word : sentence.split("\\s+")) {
			matrix.process(word);
		}
	}
	
	public String getAll() {
		return matrix.toString();
	}
	
}
