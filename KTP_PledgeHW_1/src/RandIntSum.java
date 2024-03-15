import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class RandIntSum {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		int in = 0;
	    System.out.println("Enter an integer for list length :: \n");
		do {
		    if (keyboard.hasNextInt()) {
		        in = keyboard.nextInt();
		        validInput = true;
		    } else {
		        System.out.println("\nPlease enter a valid integer :: \n");
		        keyboard.nextLine();
		    }
		} while (!validInput);
		
		int[] randInt = new int[in];
		
		int sum = 0;
		
		Random rand = new Random();
	    
		for(int i = 0; i < in; i++) {
			randInt[i] = rand.nextInt(100) + 1;
			sum += randInt[i];
		}
		
		System.out.println("\n" + Arrays.toString(randInt));
		
		if(sum % 2 == 0) {
			System.out.println("\nList sum = " + sum + ", which is even.");
		} else {
			System.out.println("\nList sum = " + sum + ", which is odd.");
		}
		
		keyboard.close();
	}
}