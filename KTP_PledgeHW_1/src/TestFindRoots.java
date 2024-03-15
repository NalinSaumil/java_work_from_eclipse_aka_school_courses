import java.util.Arrays;
import java.util.Scanner;

public class TestFindRoots {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the 3 coeffecients [Format: a,b,c] :: \n");
		String input = keyboard.nextLine();
		while(!(input.matches("^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?(,\\s*[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?){2}$"))) {
			System.out.println("\nPlease enter the 3 coeffecients with the correct format [Format: a,b,c] :: \n");
			input = keyboard.nextLine();
		}
		String[] coeff = input.split(",");
		System.out.println();
		find_roots(Double.parseDouble(coeff[0]), Double.parseDouble(coeff[1]), Double.parseDouble(coeff[2]));
		keyboard.close();
	}
	
	public static void find_roots(double a, double b, double c) {
		double[] roots = new double[2];
		String[] complex = new String[2];
		if((Math.pow(b, 2) - 4 * a * c) < 0) {
			complex[0] = String.format("%.2f", (b / (2 * a))) + " + i*" + String.format("%.2f", ((Math.sqrt(4 * a * c - Math.pow(b, 2))) / (2 * a)));
			complex[1] = String.format("%.2f", (b / (2 * a))) + " - i*" + String.format("%.2f", ((Math.sqrt(4 * a * c - Math.pow(b, 2))) / (2 * a)));
			System.out.println(Arrays.toString(complex));
		} else {
			roots[0] = (b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			roots[1] = (b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			System.out.println(Arrays.toString(roots));
		}
	}
}
