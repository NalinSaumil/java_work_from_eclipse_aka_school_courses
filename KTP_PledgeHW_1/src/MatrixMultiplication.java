import java.util.*;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the the first matrix that you want multiplied\n"
				+ "[separate row values with commas and separate rows with semicolons(no spaces)] :: \n");
		String matA = keyboard.nextLine();
		
		while(!(matA.matches("^([-+]?\\d*\\.?\\d+|\\d+)(,[-+]?\\d*\\.?\\d+|\\d+)*(;([-+]?\\d*\\.?\\d+|\\d+)(,[-+]?\\d*\\.?\\d+|\\d+)*)*$"))) {
			System.out.println("\nPlease enter the first matrix in the format specified\n"
					+ "[separate row values with commas and separate rows with semicolons(no spaces)] :: \n");
			matA = keyboard.nextLine();
		}
		
		System.out.println("\nEnter the the second matrix that you want multiplied\n"
				+ "[separate row values with commas and separate rows with semicolons(no spaces)] :: \n");
		String matB = keyboard.nextLine();
		
		while(!(matB.matches("^([-+]?\\d*\\.?\\d+|\\d+)(,[-+]?\\d*\\.?\\d+|\\d+)*(;([-+]?\\d*\\.?\\d+|\\d+)(,[-+]?\\d*\\.?\\d+|\\d+)*)*$"))) {
			System.out.println("\nPlease enter the second matrix in the format specified\n"
					+ "[separate row values with commas and separate rows with semicolons(no spaces)] :: \n");
			matB = keyboard.nextLine();
		}
		
		keyboard.close();
		
		try {
			List<List<Double>> matrixA = parseMatrix(matA);
			List<List<Double>> matrixB = parseMatrix(matB);
			List<List<Double>> result = multiply(matrixA, matrixB);
			System.out.println(matrixToString(result));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<List<Double>> parseMatrix(String mat) throws MalformedMatrixException{
		List<List<Double>> matrix = new ArrayList<>();
		String[] rows = mat.split(";");
		int r = rows.length;
		int c = rows[0].split(",").length;
		
		for(int i = 0; i < r; i++) {
			String[] elements = rows[i].split(",");
			if(c != elements.length) {
				throw new MalformedMatrixException("\nYour matrix rows don't match in length.");
			}
			List<Double> row = new ArrayList<>();
			for(int j = 0; j < elements.length; j++) {
				row.add(Double.parseDouble(elements[j]));
			}
			matrix.add(row);
		}
		return matrix;
	}
	
	public static List<List<Double>> multiply(List<List<Double>> matA, List<List<Double>> matB) throws IncompatibleMatricesException{
		int matARow = matA.size();
		int matACol = matA.get(0).size();
		int matBRow = matB.size();
		int matBCol = matB.get(0).size();
		
		if(matACol != matBRow) {
			throw new IncompatibleMatricesException("\nYour matrices cannot be multiplied.");
		}
		
		List<List<Double>> result = new ArrayList<>();
		
		for (int i = 0; i < matARow; i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < matBCol; j++) {
                double sum = 0;
                for (int k = 0; k < matACol; k++) {
                    sum += matA.get(i).get(k) * matB.get(k).get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }
		
		return result;
	}
	
	public static String matrixToString(List<List<Double>> matrix) {
		String result = "";
		int r = matrix.size();
		int c = matrix.get(0).size();
		for(int i = 0; i < r; i++) {
			result += "[";
			for(int j = 0; j < c; j++) {
				if(j != c-1) {
					result += String.format("%.2f", matrix.get(i).get(j)) + ", ";
				} else {
					result += String.format("%.2f", matrix.get(i).get(j));
				}
			}
			result += "]\n";
		}
		return result;
	}
}