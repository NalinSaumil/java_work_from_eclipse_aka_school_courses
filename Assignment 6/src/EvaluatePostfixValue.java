//Import Stack class to access stack and stack features
import java.util.Stack;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Nov 10, 2022
//This class evaluates the postfix expression to give you a value.
public class EvaluatePostfixValue {
	//This method solves a postfix expression
	public static double calculate(String[] array)
    {
        //double stack to perform the necessary calculations
		Stack<Double> stack = new Stack<Double>();
         
		//iterate through the input array
        for(int i = 0; i < array.length; i++)
        {
            String c = array[i];
             
            //add to stack if its numbers
            if(isNumeric(c)) {
            	stack.push(Double.parseDouble(c));
            //perform operation if iteration comes across an operator
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();
                 
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
                    stack.push(Math.pow(val2, val1));
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