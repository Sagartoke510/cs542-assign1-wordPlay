package wordPlay.stats;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Stats {
//	public ArrayList<String> longest = new ArrayList<String>();
	String longest = "";
	
	private int charCount = 0;
	private int sentenceCount = 0;
	
	private HashMap<String, Integer> wordCount = new HashMap();
	
	public void incrementSentence() {
		sentenceCount++;
	}
	
	public void incrementCharacter(String sentence) {
		charCount += sentence.length();
	}
	
	public void incrementWord(String word) {
		int count = wordCount.containsKey(word) ? wordCount.get(word) : 0;
		wordCount.put(word, count+1);
	}
	
	public void processLongest(String word) {
//		if (longest.isEmpty() || longest.get(0).length() < word.length()) {
//			longest.clear();
//			longest.add(word);
//		} else if (longest.get(0).length() == word.length()) {
//			longest.add(word);
//		}
		if (longest.length() < word.length()) {
			longest = word;
		}
	}
	
	public void process(String word) {
		incrementWord(word);
		processLongest(word);
	}
	
	
	/********** Stats Getters ***********/
	
	public int getAvgWordCount() {
		int sum = 0;
		for (Entry<String, Integer> word : wordCount.entrySet()) {
			sum += word.getValue();
		}
		return sum / this.sentenceCount;
	}
	public int getAvgCharCount() {
		return this.charCount / this.sentenceCount;
	}
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
	public String getLongestWord() {
		return this.longest;
	}

	@Override
	public String toString() {
		return "AVG_NUMBER_WORDS_PER_SENTENCE = " + String.format("%.2f", this.getAvgWordCount()) + "\n" + 
				"AVG_NUM_CHARS_PER_SENTENCE = " + String.format("%.2f", this.getAvgCharCount()) + "\n" + 
				"MAX_FREQ_WORD = " + this.getMaxFreqWord() + "\n" + 
				"LONGEST_WORD = " + this.getLongestWord();
	}
	
	
	
}
