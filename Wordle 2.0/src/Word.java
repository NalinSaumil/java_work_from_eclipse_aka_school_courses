import java.util.ArrayList;

public class Word {
	private String word;
	private ArrayList<Character> letters;
	
	public Word() {
		word = "";
		letters = new ArrayList<Character>();
		char[] temp = word.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			letters.add(temp[i]);
		}
	}
	
	public Word(String input) {
		word = input;
		letters = new ArrayList<Character>();
		char[] temp = word.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			letters.add(temp[i]);
		}
	}
	
	public String getWord() {
		return word;
	}
	
	public String printMatch(String match) {
		char[] array1 = match.toCharArray();
		char[] result = {'#','#','#','#','#'};
		ArrayList<Character> temp = new ArrayList<Character>();
		char[] temp1 = word.toCharArray();
		for(int i = 0; i < temp1.length; i++) {
			temp.add(temp1[i]);
		}
		String res = "";
		for(int l = 0; l < temp.size(); l++) {
			if(array1[l] == temp.get(l)) {
				result[l] = array1[l];
				temp.set(l, '0');
				array1[l] = '1';
			}
	    }
		for(int i = 0; i < array1.length; i++) {
			char letter = array1[i];
			for(int j = 0; j < temp.size(); j++) {
				if(letter == temp.get(j)) {
					result[i] = '*';
					temp.set(j, '0');
					break;
				}
			}
		}
		for(int k = 0; k < result.length; k++) {
			res = res + result[k] + " ";
		}
		return res;
	}
}