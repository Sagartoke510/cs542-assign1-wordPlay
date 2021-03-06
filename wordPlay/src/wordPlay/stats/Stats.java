package wordPlay.stats;

import java.util.HashMap;
import java.util.Map.Entry;

public class Stats {
//	public ArrayList<String> longest = new ArrayList<String>();
	String longest = "";

	private static boolean ROUND_UP = false;

	private int charCount = 0;
	private int sentenceCount = 0;

	private HashMap<String, Integer> wordCount = new HashMap<>();

	/**Increment Sentence counter
	 * @param 
	 * @return 
	 */
	public void incrementSentence() {
		sentenceCount++;
	}
	
	/**Increment Sentence counter
	 * @param sentence for the line
	 * @return
	 */
	public void incrementCharacter(String sentence) {
		charCount += sentence.length();
	}

	/**Increment Word counter
	 * @param sentence for the line
	 * @return
	 */
	public void incrementWord(String word) {
		word = word.toLowerCase().trim();
		int count = wordCount.containsKey(word) ? wordCount.get(word) : 0;
		wordCount.put(word, count + 1);
	}

	/**processing longest word
	 * @param words from the lines
	 * @return
	 */
	public void processLongest(String word) {
//		if (longest.isEmpty() || longest.get(0).length() < word.length()) {
//			longest.clear();
//			longest.add(word);
//		} else if (longest.get(0).length() == word.length()) {
//			longest.add(word);
//		}
		word = word.replaceAll("[^a-zA-Z0-9]", "");
		if (longest.length() < word.length()) {
			longest = word;
		}
	}

	/**word increment and longest word processes
	 * @param words from the lines
	 * @return
	 */
	public void process(String word) {
		incrementWord(word);
		processLongest(word);
	}

	/********** Stats Getters ***********/

	/**get the average word count per sentence
	 * @param 
	 * @return{@code double} with average word count per sentence
	 */
	public double getAvgWordCount() {
		int sum = 0;
		for (Entry<String, Integer> word : wordCount.entrySet()) {
			sum += word.getValue();
		}
		return (sum * 1.0) / this.sentenceCount;
	}

	/**method for average character per sentence
	 * @param 
	 * @return{@code double} with average character count per sentence 
	 */
	public double getAvgCharCount() {
		return (this.charCount * 1.0) / this.sentenceCount;
	}

	/**method for most frequent word 
	 * @param 
	 * @return{@code String} with most frequent word from the file 
	 */
	public String getMaxFreqWord() {
		int maxFreq = 0;
		String retWord = null;
		for (Entry<String, Integer> word : wordCount.entrySet()) {
			if (word.getValue() > maxFreq) {
				maxFreq = word.getValue();
				retWord = word.getKey();
			}
		}
		return retWord;
	}

	/**method for getting longest word
	 * @param 
	 * @return{@code String} with most longest from the file 
	 */
	public String getLongestWord() {
		return this.longest;
	}

	/**method for returning precised values
	 * @param d word or char from file 
	 * @param precision precision value
	 * @return{@code String} with precision of upto 2 decimals
	 */
	private String precision(double d, int precision) {
		String ret;
		if (ROUND_UP)
			ret = String.format("%.0"+precision+"f", d);
		else {
			ret = String.format("%.0"+(precision+1)+"f", d);
			ret = ret.substring(0, ret.length() - 1);
		}
		return ret;
	}

	@Override
	public String toString() {
		return "AVG_NUMBER_WORDS_PER_SENTENCE = " + precision(this.getAvgWordCount(), 2) + "\n"
				+ "AVG_NUM_CHARS_PER_SENTENCE = " + precision(this.getAvgCharCount(), 2) + "\n"
				+ "MAX_FREQ_WORD = " + this.getMaxFreqWord() + "\n" + "LONGEST_WORD = " + this.getLongestWord();
	}

}
