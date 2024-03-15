import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class TestWordle {
	public static void main(String[] args) {
		WordArray wordList = new WordArray(readFile("C:\\Users\\saumi\\Desktop\\myFiles\\education\\Programming\\Eclipse WorkSpace\\Wordle 2.0\\src\\words.txt"));
		char response;
		Scanner input = new Scanner(System.in);
		do {
			Word target = new Word(wordList.getRandomWord());
			int count = 6;
			String answer = "";
			System.out.println("\nWelcome to Wordle!"
					+ "\n\nYou have 6 guesses to see if you can find out which 5-letter word the computer has."
					+ "\n\nFor every guess, you are going to know if the letters you guessed are:"
					+ "\n-wrong (#)\n-right and in the wrong place (*)\n-right and in the right place (letter)\n\n");
			do {
				count--;
				System.out.print("Guess # " + (6 - count) + ": ");
				answer = input.next();
				while(answer.length() != 5 || !(answer.matches("[a-z][a-z][a-z][a-z][a-z]"))) {
					System.out.print("\nPlease enter a 5-letter word: ");
					answer = input.next();
				}
				System.out.println("\n" + target.printMatch(answer) + "\n");
			} while((count > 0) && !(answer.equals(target.getWord())));
			if(!(answer.equals(target.getWord()))) {
				System.out.println("Sorry! You couldn't guess the word. The word was: " + target.getWord());
			} else {
				System.out.println("Good Job! You successfully guessed: " + target.getWord());
			}
		
			System.out.print("\nDo you want to play again? [Y/N]: ");
			response = input.next().charAt(0);
			while(response != 'y' && response != 'Y' && response != 'n' && response != 'N') {
				System.out.print("\nPlease respond with \"Y\" or \"N\": ");
				response = input.next().charAt(0);
			}
		} while(response == 'y' || response == 'Y');
		if(response == 'n' || response == 'N') {
			System.out.println("\nThank you for playing!");
		}
		input.close();
	}
	
	public static ArrayList<String> readFile(String filePath) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			File inputFile = new File(filePath);
			Scanner reader = new Scanner(inputFile);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				String[] words = data.split(" ");
				for(int i = 0; i < words.length; i++) {
					result.add(words[i]);
				}
			}
			reader.close();
		} catch(FileNotFoundException ex) {
			System.out.println("An error has occured.");
			ex.printStackTrace();
		}
		return result;
	}
}