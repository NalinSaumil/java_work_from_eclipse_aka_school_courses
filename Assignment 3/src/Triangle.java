//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 30, 2022
//This class uses the geometric object class and creates a triangle object with it
public class Triangle extends GeometricObject {

	//Data Fields
	double side1;
	double side2;
	double side3;
	
	//no-args constructor
	public Triangle() {
		super();
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}
	
	//constructor with 3 side args
	public Triangle(double s1, double s2, double s3) {
		super();
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	
	//constructor with color and filled and super class constructor call
	public Triangle(String color, boolean filled) {
		super(color, filled);
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}
	
	//constructor with color, filled and 3 side args and a super class constructor call
	public Triangle(double s1, double s2, double s3, String color, boolean filled) {
		super(color, filled);
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	
	//accessor for side1
	public double getSide1() {
		return this.side1;
	}
	
	//accessor for side2
	public double getSide2() {
		return this.side2;
	}
	
	//accessor for side3
	public double getSide3() {
		return this.side3;
	}
	
	//returns the area for the triangle object
	public double getArea() {
		double s = (this.side1 + this.side2 + this.side3) / 2.0;
		return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
	}
	
	//returns the perimeter for the triangle object
	public double getPerimeter() {
		return this.side1 + this.side2 + this.side3;
	}
	
	//returns the string description of the triangle object
	public String toString() {
		return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
	}
}