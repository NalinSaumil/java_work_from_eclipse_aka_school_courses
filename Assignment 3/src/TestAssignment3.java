//import the scanner class so that you can take user input
import java.util.Scanner;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 30, 2022
//This class tests out the Triangle class
public class TestAssignment3 {
	public static void main(String[] args) {
		//Scanner object to take user Input
		Scanner keyboard = new Scanner(System.in);
		
		//vars to hold user input
		double s1;
		double s2;
		double s3;
		String color;
		String uI;
		boolean filled;
		
		//user input for color
		System.out.print("What is the color you want your triangle to be? ");
		color = keyboard.nextLine();
		
		//user input for fill
		System.out.print("\nDo you want your triangle filled in? [y/n] ");
		uI = keyboard.nextLine();
		
		//user input for side 1
		System.out.print("\nWhat is the first side length of your triangle? ");
		s1 = keyboard.nextDouble();
		
		//user input for side 2
		System.out.print("\nWhat is the second side length of your triangle? ");
		s2 = keyboard.nextDouble();
		
		//user input for side 3
		System.out.print("\nWhat is the third side length of your triangle? ");
		s3 = keyboard.nextDouble();
		
		filled = (uI.charAt(0) == 'y' || uI.charAt(0) == 'Y') ? true : false;
		
		String fill = filled ? "" : "not ";
		
		//create triangle object from user input
		Triangle tri = new Triangle(s1, s2, s3, color, filled);
		
		System.out.println();
		
		//print triangle values
		System.out.println("Your Triangle's Area is: " + tri.getArea() + "\nYour Triangle's Perimeter is: " + tri.getPerimeter() + "\nYour Triangle's color is: " + tri.getColor() + "\nYour Triangle is " + fill + "filled.");
		
		keyboard.close();
	}
}
