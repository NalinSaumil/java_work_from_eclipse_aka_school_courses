//import the scanner class so that you can take user input
import java.util.Scanner;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Oct 19, 2022
//This class implements the custom HexFormatException into Hex2Dec method
public class TestAssignment4 {
	public static void main(String[] args) {
		//Scanner object for user input
        Scanner keyboard = new Scanner(System.in);
        
        //initial variables to test the expection
        boolean done = false;
        String hex = "";
        int decimal = 0;
        //keep doing the loop until it runs without error or exception
        while(!done) {
        	//ask for a hex input and check if the input is in fact a hexadecimal value
        	try {
        		System.out.print("Enter a hexadecimal number: ");
        		hex = keyboard.nextLine();
        		decimal = hexToDecimal(hex);
        		done = true;
        	// if not a hexadecimal value do the following after the excpetion is thrown otherwise exit loop
        	} catch(HexFormatException ex) {
        		System.out.println(ex.getLocalizedMessage());
        		System.out.print("Try again.\n");
        	}
        }
        
        //print result
        System.out.println("The decimal value for the hexadecimal value " + hex + " is " + decimal);
        
        keyboard.close();
	}
	
	//Hex2Dec method
	public static int hexToDecimal(String hex) throws HexFormatException {
		
		//throw exception if input string isn't a hexadecimal value
		if(!(hex.matches("-?[0-9a-fA-F]+"))) {
			throw new HexFormatException("This is not a Hexadecimal Number.");
		}
		
		//return string as an int decimal value
		return Integer.parseInt(hex,16);
	}
}