import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WordArray {
	private ArrayList<String> words;
	
	public WordArray() {
		words = new ArrayList<String>();
	}
	
	public WordArray(ArrayList<String> input) {
		words = input;
	}
	
	public void randomizeArray() {
		Collections.shuffle(this.words);
	}
	
	public ArrayList<String> getArray() {
		return words;
	}
	
	public String getRandomWord() {
		this.randomizeArray();
		Random rand = new Random();
		return this.getArray().get(rand.nextInt(this.getArray().size()));
	}
}