package wordPlay.sentence;

public class SentenceUtils {
	
	public String reverse(String word) {
		
		char[] chars = word.toCharArray();
//		int len = chars[chars.length - 1] == '.' ? chars.length - 1 : chars.length;
		int len = chars.length;
		char temp;
		int offset = 0;
		for (int i=0; i<(len+offset)/2; i++) {
			temp = chars[i];
			if (temp == '\n' || temp == '\r') {
				offset++;
				continue;
			}
			chars[i] = chars[len - i - 1 + offset];
			chars[len - i - 1 + offset] = temp;
			
		}
		return new String(chars);
	}

}
