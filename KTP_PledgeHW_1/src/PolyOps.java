import java.util.Arrays;
import java.util.Scanner;

public class PolyOps {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the coeffecients [Format: a,b,c,...] :: \n");
		String input = keyboard.nextLine();
		while(!(input.matches("^-?\\d+(?:\\.\\d+)?(?:,\\s*-?\\d+(?:\\.\\d+)?)*$"))) {
			System.out.println("\nPlease enter the coeffecients with the correct format [Format: a,b,c,...] :: \n");
			input = keyboard.nextLine();
		}
		String[] init = input.split(",");
		
		double[] coeff = new double[init.length];
		
		for(int i = 0; i < init.length; i++) {
			coeff[i] = Double.parseDouble(init[i]);
		}
		
		boolean validInput = false;
		double in = 0;
	    System.out.println("\nEnter a real number to plug-in :: \n");
		do {
		    if (keyboard.hasNextDouble()) {
		        in = keyboard.nextDouble();
		        validInput = true;
		    } else {
		        System.out.println("\nPlease enter a valid real number :: \n");
		        keyboard.nextLine();
		    }
		} while (!validInput);
		
		System.out.println();
		evaluatePolynomial(coeff, in);
		System.out.println();
		findDerivative(coeff);
		
		keyboard.close();
	}
	
	public static void evaluatePolynomial(double[] coeff, double in) {
		double result = 0;
		int n = coeff.length;
		for(int i = 0; i < n; i++) {
			result += coeff[i] * Math.pow(in, n - (i + 1));
		}
		System.out.println(String.format("%.2f", result));
	}
	
	public static void findDerivative(double[] coeff) {
		int n = coeff.length;
		String[] derivCoeff = new String[n-1];
		for(int i = 0; i < (n - 1); i++) {
			derivCoeff[i] = String.format("%.2f", (coeff[i] * (n - (i + 1))));
		}
		System.out.print(Arrays.toString(derivCoeff));
	}
}



