//import the scanner class so that you can take user input
import java.util.Scanner;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 26, 2022
//This class's soul purpose is to test the BasicTime and the PreciseTime classes.
public class TestAssignment2 {
	public static void main(String[] args) {
		String userI1;
		String userI2;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Basic Time operations:");
		
		//takes first input for the BasicTime
		System.out.print("Enter time 1 for basic manipulation (12hr format: HH:MMXX) : ");
		userI1 = keyboard.nextLine();
		
		//checks to make sure that input matches the 12hr-format for basic time
		while(!(userI1.matches("[0-1][\\d]:[0-5][\\d][aApP][mM]"))) {
			System.out.print("Sorry re-enter time 1 in correct format : ");
			userI1 = keyboard.nextLine();
		}
		
		//takes second BasicTime input
		System.out.print("Enter time 2 for basic manipulation (12hr format: HH:MMXX) : ");
		userI2 = keyboard.nextLine();
		
		//checks to make sure that input matches the 12hr-format for basic time
		while(!(userI2.matches("[0-1][\\d]:[0-5][\\d][aApP][mM]"))) {
			System.out.print("Sorry re-enter time 2 in correct format : ");
			userI2 = keyboard.nextLine();
		}
		
		//creates 3 basictime objects using the 3 constructors
		BasicTime bTime1 = new BasicTime();
		BasicTime bTime2 = new BasicTime("10:48pm");
		BasicTime bTime3 = new BasicTime(2,57,true);
		
		//creates basictime objects using user inputs
		BasicTime uTime1 = new BasicTime(userI1);
		BasicTime uTime2 = new BasicTime(userI2);
		
		System.out.println();
		
		//does basictime operations with user inputs and prints them
		BasicTime.toString(uTime1);
		BasicTime.toString(uTime2);
		BasicTime.toString(uTime1.add(uTime2));
		BasicTime.toString(BasicTime.addTo(uTime1, uTime2));
		BasicTime.toString(uTime1.subtract(uTime2));
		BasicTime.toString(BasicTime.subtractFrom(uTime1, uTime2));
		
		System.out.println();
		
		//does basictime operations with basictime objects explicitly declared and prints them
		BasicTime.toString(bTime1);
		BasicTime.toString(bTime2.add(bTime3));
		BasicTime.toString(BasicTime.addTo(bTime3, bTime2));
		BasicTime.toString(bTime2.subtract(bTime3));
		BasicTime.toString(BasicTime.subtractFrom(bTime3, bTime2));
		
		System.out.println();
		
		System.out.println("Precise Time operations:");
		
		//takes first precisetime input
		System.out.print("Enter time 1 for precise manipulation (12hr format: HH:MM:SSXX) : ");
		userI1 = keyboard.nextLine();
		
		//checks to see if user input matches precise time 12hr-format
		while(!(userI1.matches("[0-1][\\d]:[0-5][\\d]:[0-5][\\d][aApP][mM]"))) {
			System.out.print("Sorry re-enter time 1 in correct format : ");
			userI1 = keyboard.nextLine();
		}
		
		//takes second precisetime input
		System.out.print("Enter time 2 for precise manipulation (12hr format: HH:MM:SSXX) : ");
		userI2 = keyboard.nextLine();
		
		//checks to see if user input matches precise time 12hr-format
		while(!(userI2.matches("[0-1][\\d]:[0-5][\\d]:[0-5][\\d][aApP][mM]"))) {
			System.out.print("Sorry re-enter time 2 in correct format : ");
			userI2 = keyboard.nextLine();
		}
		
		//creates 3 precisetime objects using the 3 constructor
		PreciseTime pTime1 = new PreciseTime();
		PreciseTime pTime2 = new PreciseTime("10:48:52pm");
		PreciseTime pTime3 = new PreciseTime(2,57,29,true);
		
		//creates precise time objects using user inputs
		PreciseTime uTime3 = new PreciseTime(userI1);
		PreciseTime uTime4 = new PreciseTime(userI2);
		
		System.out.println();
		
		//performs precisetime operations with user inputs and prints them
		PreciseTime.toString(uTime3);
		PreciseTime.toString(uTime4);
		PreciseTime.toString(uTime3.add(uTime4));
		PreciseTime.toString(PreciseTime.addTo(uTime3, uTime4));
		PreciseTime.toString(uTime3.subtract(uTime4));
		PreciseTime.toString(PreciseTime.subtractFrom(uTime3, uTime4));
		
		System.out.println();
		
		//performs precisetime operations with 3 explicitly declared objects and prints them
		PreciseTime.toString(pTime1);
		PreciseTime.toString(pTime2.add(pTime3));
		PreciseTime.toString(PreciseTime.addTo(pTime3, pTime2));
		PreciseTime.toString(pTime2.subtract(pTime3));
		PreciseTime.toString(PreciseTime.subtractFrom(pTime3, pTime2));
		
		//closes the scanner object so it doesnt take any more accidental user inputs
		keyboard.close();
	}
}