//Import Stack class to access stack and stack features
import java.util.Stack;

//Saumil Nalin
//CS 3345.007
//Mohamed Amine Belkoura
//Mar 19, 2023
//This class converts the infix format to postfix format.
public class InfixToPostfix {
	//Final conversion from infix to postfix in a stack.
	public static Stack<String> convert(String exp) {
		//resultant stack
    	Stack<String> result = new Stack<String>();
        
        //use spaces to split exp into string array
        String[] expArray = exp.split(" ");
        
        //another stack to toss elements and reorder the resultant array
        Stack<String> stack = new Stack<String>();
        
        //iterate through all elements of string array
        for (int i = 0; i < expArray.length; i++) {
            String c = expArray[i];
            
            //if statements to perform conversion
            if (isNumeric(c)) {
                result.push(c);
            } else if (c.equals("(")) {
            	stack.push(c);
            } else if (c.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.push(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && opPriority(c) <= opPriority(stack.peek())) {
                    result.push(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        //empty out "stack" into resultant stack
        while (!stack.isEmpty()) {
            result.push(stack.peek());
            stack.pop();
        }
        //return resultant stack
        return result;
    }
	
	//creates a PEMDAS operator priority
	public static int opPriority(String operator) {
        switch (operator) {
        case "+":
            return 1;
            
        case "-":
            return 1;
            
        case "*":
            return 2;
            
        case "/":
            return 2;
            
        case "^":
            return 3;
        }
        return -1;
    }
	
	//checks if a string is numeric
	public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        
        try {
            double test = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}