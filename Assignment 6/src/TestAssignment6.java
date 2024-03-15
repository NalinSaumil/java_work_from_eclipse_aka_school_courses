//import the scanner class so that you can take user input
import java.util.Scanner;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Nov 10, 2022
//This class asks for an infix input and uses the other classes to give an answer to the expression.
public class TestAssignment6 {
	public static void main(String[] args) {
		//Scanner object to get user input
		Scanner keyboard = new Scanner(System.in);
		
		//ask for user expression
		System.out.print("Enter mathematical expression that you want to evaluate (no spaces and PEMDAS operators only): ");
		String exp = keyboard.nextLine();
		
		//one way to check if the user input is valid is if all open parentheses have a close parentheses
		int countOpen = 0;
		int countClose = 0;
		
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) == '(') {
				countOpen++;
			}
			if(exp.charAt(i) == ')') {
				countClose++;
			}
		}
		
		//So while the open parentheses doesn't equal close parentheses keep asking for input and keep checking for equality of
		//the 2 parentheses
		while(!(countOpen == countClose)) {
			System.out.print("The mathematical expression entered was wrong or unfinished. Re-enter the expression: ");
			exp = keyboard.nextLine();
			
			countOpen = 0;
			countClose = 0;
			
			for(int i = 0; i < exp.length(); i++) {
				if(exp.charAt(i) == '(') {
					countOpen++;
				}
				if(exp.charAt(i) == ')') {
					countClose++;
				}
			}
		}
		
		//once parentheses match, take input and get a postfix stack and make it a object array
		Object[] temp = InfixToPostfix.convert(exp).toArray();
		
		//create a string array out of the object array so that it can be put into 
		//the calculate method of the evaluatepostfixvalue class
		String[] postfix = new String[temp.length];
		for(int i = 0; i < temp.length; i++) {
			postfix[i] = String.valueOf(temp[i]);
		}
		
		//create a postfix expression to output for the user
		String postfixFormat = "";
		for(int j = 0; j < postfix.length; j++) {
			if(j < postfix.length - 1) {
				postfixFormat += postfix[j] + " ";
			} else {
				postfixFormat += postfix[j];
			}
		}
		
		System.out.println();
		
		//print all outputs
		System.out.println("The mathematical expression you entered was (infix format): " + InfixToPostfix.addSpaces(exp) + "\n");
		System.out.println("This mathematical expression in Postfix format is: " + postfixFormat + "\n");
		System.out.println("The mathematical expression evalutes to: " + String.format("%.2f", EvaluatePostfixValue.calculate(postfix)));
		
		//close scanner object
		keyboard.close();
	}
}
