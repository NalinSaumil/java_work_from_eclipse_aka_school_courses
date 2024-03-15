import java.util.Scanner;
import java.util.Arrays;

public class SortList {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the integers [Format: a,b,c,...] :: \n");
		String input = keyboard.nextLine();
		while(!(input.matches("^\\d+(,\\d+)*$"))) {
			System.out.println("\nPlease enter the integers with the correct format [Format: a,b,c,...] :: \n");
			input = keyboard.nextLine();
		}
		String[] init = input.split(",");
		
		int[] ints = new int[init.length];
		
		for(int i = 0; i < init.length; i++) {
			ints[i] = Integer.parseInt(init[i]);
		}
		
		if(ints.length % 3 != 0) {
			System.out.println();
			bubbleSort(ints);
		} else {
			System.out.println();
			selectionSort(ints);
		}
		keyboard.close();
	}
	
	public static void selectionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	            if (arr[j] < arr[minIndex]) {
	                minIndex = j;
	            }
	        }
	        int temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	    System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (arr[j] > arr[j + 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	            }
	        }
	    }
	    System.out.println(Arrays.toString(arr));
	}
}
