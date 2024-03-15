import java.util.*;
import java.io.*;


public class TestAssignment7 {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\saumi\\Desktop\\myFiles\\education\\Programming\\Eclipse WorkSpace\\Assignment 7 - CS3345\\src\\EmployeeRecord";
		//System.out.println(Arrays.toString(buildEmpRec(filePath)));
		
		Scanner scanner = new Scanner(System.in);
        Employee[] employees = buildEmpRec(filePath);
        int numEmployees = employees.length;
        // Display the initial list of employee records
        System.out.println("Initial list of employee records (Unsorted):");
        // Build a heap from the employee records using employee number as the key
        EmployeeHeapSort.buildHeap(employees, numEmployees);
        // Print list
        EmployeeHeapSort.displayEmployees(employees);
        // Allow the user to insert or delete records
        boolean done = false;
        while (!done) {
            System.out.println("Enter I to insert a record, D to delete a record, or Q to quit: ");
            String input = scanner.next().toUpperCase();
            switch (input) {
                case "I":
                    System.out.print("\nEnter employee number and hourly rate [separated with a space(X Y.YY)] :: ");
                    int empNum = scanner.nextInt();
                    double hourlyRate = scanner.nextDouble();
                    employees = EmployeeHeapSort.insertRecord(employees, numEmployees, empNum, hourlyRate);
                    numEmployees = employees.length;
                    break;
                case "D":
                    System.out.print("Enter employee number to delete: ");
                    int empNumToDelete = scanner.nextInt();
                    employees = EmployeeHeapSort.deleteRecord(employees, empNumToDelete, numEmployees);
                    numEmployees = employees.length;
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
        // Display the sorted list of employee records
        System.out.println("Updated list of employee records (Sorted):");
        // Sort the list of employee records using heap sort
        EmployeeHeapSort.heapSort(employees, numEmployees);
        //Print List
        EmployeeHeapSort.displayEmployees(employees);
	}
	
	public static Employee[] buildEmpRec(String filePath) {
		List<Employee> employees = new ArrayList<Employee>();
        try {
           File inputFile = new File(filePath);
           Scanner myReader = new Scanner(inputFile);
           while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] edge = data.split(" ");
              Employee nextEmp = new Employee(Integer.parseInt(edge[0]), Double.parseDouble(edge[1]));
              employees.add(nextEmp);
           }
           myReader.close();
        } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
        }
        Employee[] empList = new Employee[employees.size()];
        return employees.toArray(empList);
	}
}
