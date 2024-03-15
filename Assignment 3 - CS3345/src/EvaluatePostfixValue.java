//Import Stack class to access stack and stack features
import java.util.Stack;

//Saumil Nalin
//CS 3345.007
//Mohamed Amine Belkoura
//Mar 19, 2023
//This class evaluates the postfix expression to give you a value.
public class EvaluatePostfixValue {
	//This method solves a postfix expression
	public static int calculate(String[] array)
    {
        //double stack to perform the necessary calculations
		Stack<Integer> stack = new Stack<Integer>();
         
		//iterate through the input array
        for(int i = 0; i < array.length; i++)
        {
            String c = array[i];
             
            //add to stack if its numbers
            if(isNumeric(c)) {
            	stack.push(Integer.parseInt(c));
            //perform operation if iteration comes across an operator
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c){
                case "+":
                	stack.push(val2 + val1);
                	break;
                     
                case "-":
                    stack.push(val2 - val1);
                    break;
                     
                case "/":
                    stack.push(val2 / val1);
                    break;
                     
                case "*":
                    stack.push(val2 * val1);
                    break;
                
                case "^":
                    stack.push((int)Math.pow(val2, val1));
                    break;
              }
            }
        }
        //return the final stack element which is the answer
        return stack.pop();   
    }
	
	//checks to see if a string is numeric
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