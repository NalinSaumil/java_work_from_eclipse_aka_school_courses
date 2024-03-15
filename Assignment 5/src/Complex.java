//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Oct 29, 2022
//This class creates the complex object class to deal with complex numbers. 
//It implements 2 interfaces (cloneable and comparable) and extends the object class
public class Complex implements Cloneable, Comparable<Complex> {
	
	//datafields
	private double real;
	private double imaginary;
	
	//no-args contructor
	public Complex() {
		real = 0;
		imaginary = 0;
	}
	
	//1-arg constructor assigns value to real and keep imaginary to 0
	public Complex(double a) {
		real = a;
		imaginary = 0;
	}
	
	//2-arg constructor assigns value to real and imaginary
	public Complex(double a, double b) {
		real = a;
		imaginary = b;
	}
	
	//adds to complex objects and returns it as a new complex object
	public static Complex add(Complex number1, Complex number2) {
		double newReal =  number1.real + number2.real;
		double newImaginary = number1.imaginary + number2.imaginary;
		return new Complex(newReal, newImaginary);
	}
	
	//subtracts to complex objects and returns it as a new complex object
	public static Complex subtract(Complex number1, Complex number2) {
		double newReal =  number1.real - number2.real;
		double newImaginary = number1.imaginary - number2.imaginary;
		return new Complex(newReal, newImaginary);
	}
	
	//multiplies to complex objects and returns it as a new complex object
	public static Complex multiply(Complex number1, Complex number2) {
		double newReal =  (number1.real * number2.real) - (number1.imaginary * number2.imaginary);
		double newImaginary = (number1.imaginary * number2.real) + (number1.real * number2.imaginary);
		return new Complex(newReal, newImaginary);
	}

	//divides to complex objects and returns it as a new complex object
	public static Complex divide(Complex number1, Complex number2) {
		double newReal = ((number1.real * number2.real) + (number1.imaginary * number2.imaginary)) / (Math.pow(number2.real, 2) + Math.pow(number2.imaginary, 2));
		double newImaginary = ((number1.imaginary * number2.real) - (number1.real * number2.imaginary)) / (Math.pow(number2.real, 2) + Math.pow(number2.imaginary, 2));
		return new Complex(newReal, newImaginary);
	}

	//finds the z-value or the absolute value of the complex number
	public static double abs(Complex number) {
		return Math.sqrt(Math.pow(number.real, 2) + Math.pow(number.imaginary, 2));
	}
	
	//returns the real datafield
	public double getRealPart() {
		return this.real;
	}
	
	//returns the imaginary datafield
	public double getImaginaryPart() {
		return this.imaginary;
	}
	
	//compares the z-value of the current complex object to an inputed complex object and returns 1, 0 or -1 based on 
	//whether the comparison is greater than, equal to, or less than the inputed complex object.
	//This method was needed because of the Comparable interface.
	public int compareTo(Complex number) {
		if(Complex.abs(this) < Complex.abs(number)) {
			return -1;
		} else if (Complex.abs(this) > Complex.abs(number)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	//This is an override of the toString method from the object class.
	//It return the complex object in the "(a + bi)" format.
	public String toString() {
		return "(" + String.format("%.2f", this.real) + " + " + String.format("%.2f", this.imaginary) + "i)";
	}
}
