//import the scanner class so that you can take user input
import java.util.Scanner;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Oct 29, 2022
//This class tests the functions of the complex class by asking users to input real and imaginary parts of 2 complex numbers
//and using those 2 complex numbers to give different outputs.
public class TestAssignment5 {
	public static void main(String[] args) {
		//Scanner object for user input
        Scanner keyboard = new Scanner(System.in);
        
        //string variables to store user inputs
        String first = "";
        String second = "";
        
        //asking for and storing user input for first complex number
        System.out.print("Enter the real and imaginary part of the first complex number [format: R.R I.I]: ");
        first = keyboard.nextLine();
        
        //checking if user input is in the correct format and re-asking for input until the format is correct
        while(!(first.matches("-?[0-9]+.-?[0-9]+ -?[0-9]+.-?[0-9]+"))) {
        	System.out.print("Wrong Format! Re-enter the real and imaginary parts of your first complex number [format: R.R I.I]: ");
            first = keyboard.nextLine();
        }
        
        //asking for and storing user input for second complex number
        System.out.print("Enter the real and imaginary part of the second complex number [format: R.R I.I]: ");
        second = keyboard.nextLine();
        
        //checking if user input is in the correct format and re-asking for input until the format is correct
        while(!(second.matches("-?[0-9]+.-?[0-9]+ -?[0-9]+.-?[0-9]+"))) {
        	System.out.print("Wrong Format! Re-enter the real and imaginary parts of your second complex number [format: R.R I.I]: ");
            second = keyboard.nextLine();
        }
        
        //uses user input and turns them into an array of double so that 
        //we can make complex objects from the values of the double array
        String allNumbers = first + " " + second;
        
        String[] numbers = allNumbers.split(" ");
        
        double[] temp = new double[numbers.length];
        
        for(int i = 0; i < temp.length; i++) {
        	temp[i] = Double.parseDouble(numbers[i]);
        }
        
        //Declaring complex objects using the double array created from user input
        Complex number1 = new Complex(temp[0], temp[1]);
        Complex number2 = new Complex(temp[2], temp[3]);
        
        //performing the functions of the complex class and printing it out
        System.out.println(number1.toString() + " + " + number2.toString() + " = " + Complex.add(number1, number2).toString());
        System.out.println(number1.toString() + " - " + number2.toString() + " = " + Complex.subtract(number1, number2).toString());
        System.out.println(number1.toString() + " * " + number2.toString() + " = " + Complex.multiply(number1, number2).toString());
        System.out.println(number1.toString() + " / " + number2.toString() + " = " + Complex.divide(number1, number2).toString());
        System.out.println("|" + number1.toString() + "| = " + Complex.abs(number1));
        System.out.println("|" + number2.toString() + "| = " + Complex.abs(number2)); 
        
        //closing the user input scanner object
        keyboard.close();
	}
}