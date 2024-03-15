import java.util.*;

public class EmployeeHeapSort {
    public static void buildHeap(Employee[] employees, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(employees, n, i);
        }
    }
    
    public static void heapifyUp(Employee[] employees, int i) {
        while (i > 0) {
            int parentIndex = getParentIndex(i);
            if (employees[i].empNum < employees[parentIndex].empNum) {
                swap(employees, i, parentIndex);
                i = parentIndex;
            } else {
                break;
            }
        }
    }

    public static void heapifyDown(Employee[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left].empNum > arr[largest].empNum) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right].empNum > arr[largest].empNum) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapifyDown(arr, n, largest);
        }
    }


    public static int getSmallestChildIndex(Employee[] employees, int index, int heapSize) {
        int leftChildIndex = getLeftChildIndex(index);
        if (leftChildIndex >= heapSize) {
            return -1;
        }

        int smallestChildIndex = leftChildIndex;
        int rightChildIndex = getRightChildIndex(index);
        if (rightChildIndex < heapSize && employees[rightChildIndex].hourlyRate < employees[leftChildIndex].hourlyRate) {
            smallestChildIndex = rightChildIndex;
        }

        return smallestChildIndex;
    }

    public static Employee[] insertRecord(Employee[] employees, int n, int empNum, double hourlyRate) {
        Boolean contains = false;
        for(int i = 0; i < employees.length; i++) {
        	if(employees[i].empNum == empNum) {
        		contains = true;
        		break;
        	}
        }
        if(contains) {
        	System.out.println("This Employee already Exists!");
        	return employees;
        } else {
        	Employee[] newEmployees = Arrays.copyOf(employees, n + 1);
            newEmployees[n] = new Employee(empNum, hourlyRate);
            heapifyUp(newEmployees, n);
            System.out.println("\nEmployee " + empNum + " added to system with a " + hourlyRate + "/hr Wage!\n");
            return newEmployees;
        }
    }
    
    public static Employee[] deleteRecord(Employee[] employees, int empNum, int n) {
        boolean found = false;
        int i;
        for (i = 0; i < n; i++) {
            if (employees[i].empNum == empNum) {
                found = true;
                break;
            }
        }
        if (found) {
            employees[i] = employees[n - 1];
            employees[n - 1] = null;
            n--;
            heapifyDown(employees, n, i);
            System.out.println("Employee " + empNum + " deleted from system.");
            return Arrays.copyOf(employees, n);
        } else {
            System.out.println("Employee " + empNum + " not found in system.");
            return employees;
        }
    }


    public static void heapSort(Employee[] arr, int n) {
    	// Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDown(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            heapifyDown(arr, i, 0);
        }
    }
    
    public static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public static void swap(Employee[] employees, int i, int j) {
        Employee temp = employees[i];
        employees[i] = employees[j];
        employees[j] = temp;
    }
    
    public static void displayEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }
}
