package wordPlay.sentence;

public class SentenceUtils {
	
	public String reverse(String word) {
		
		char[] chars = word.toCharArray();
		int len = chars[chars.length - 1] == '.' ? chars.length - 1 : chars.length;
		char temp;
		for (int i=0; i<len/2; i++) {
			temp = chars[i];
			chars[i] = chars[len - i - 1];
			chars[len - i - 1] = temp;
			
		}
		return new String(chars);
	}

}
