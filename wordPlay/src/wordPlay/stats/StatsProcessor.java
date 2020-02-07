package wordPlay.stats;

public class StatsProcessor {
	
	private final Stats matrix;
	
	public StatsProcessor() {
		matrix = new Stats();
	}
	
	/**method for calculating all the statistics
	 * @param sentence sentence from the file
	 * @return
	 */
	public void calculateStats(String sentence) {
		matrix.incrementCharacter(sentence);
		for (String word : sentence.split("\\s+")) {
			matrix.process(word);
		}
	}
	
	/**method for calling sentence counter
	 *
	 */
	public void incrementSentenceCount() {
		matrix.incrementSentence();
	}
	
	/**method for getting all statistics values
	 * @param 
	 * @return{@code String} with all the calculations
	 */
	public String getAll() {
		return matrix.toString();
	}
	
}
