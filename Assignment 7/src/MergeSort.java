//import these classes to deal with date objects in an ArrayList for merge sort
import java.util.Date;
import java.util.ArrayList;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Nov 18, 2022
//This class defines merge sort for an int array and an array list of objects of a class that implements the comparable interface.
public class MergeSort {
  /** The method for sorting the numbers */
  public static void mergeSort(int[] list) {
    if (list.length > 1) {
      // Merge sort the first half
      int[] firstHalf = new int[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      // Merge sort the second half
      int secondHalfLength = list.length - list.length / 2;
      int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length / 2,
        secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list);
    }
  }
  
  //This method defines mergeSort for an array list of objects of a class that implements the comparable interface.
  public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
	  if (list.size() > 1) {
	      // Merge sort the first half
	      ArrayList<E> firstHalf = new ArrayList<E>(list.size() / 2);
	      firstHalf = copyArrayList(list, 0, list.size() / 2);
	      mergeSort(firstHalf);

	      // Merge sort the second half
	      int secondHalfLength = list.size() - list.size() / 2;
	      ArrayList<E> secondHalf = new ArrayList<E>(secondHalfLength);
	      secondHalf = copyArrayList(list, list.size() / 2, secondHalfLength);
	      mergeSort(secondHalf);

	      // Merge firstHalf with secondHalf into list
	      merge(firstHalf, secondHalf, list);
	    }
  }

  /** Merge two sorted lists */
  public static void merge(int[] list1, int[] list2, int[] temp) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2])
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }

    while (current1 < list1.length)
      temp[current3++] = list1[current1++];

    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
  }
  
  /** Merge two sorted arraylists of objects of a class that implements the comparable interface. */
  public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> temp) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp

    while (current1 < list1.size() && current2 < list2.size()) {
      if (list1.get(current1).compareTo(list2.get(current2)) < 0)
        temp.set(current3++, list1.get(current1++));
      else
        temp.set(current3++, list2.get(current2++));
    }

    while (current1 < list1.size())
      temp.set(current3++, list1.get(current1++));

    while (current2 < list2.size())
      temp.set(current3++, list2.get(current2++));
  }
  
  //This method's purpose is to divide the src arraylist starting from the beginning index up to the length parameter.
  public static <E extends Comparable<E>> ArrayList<E> copyArrayList(ArrayList<E> src, int begInd, int length) {
	  ArrayList<E> result = new ArrayList<E>(0);
	  
	  if(length <= src.size() - begInd) {
		  for(int i = begInd; i < length + begInd; i++) {
			  result.add(src.get(i));
		  }
	  }
	  return result;
  }
 
  /** A test method */
  public static void main(String[] args) {
	//array of ints to merge sort
    int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    
    //arraylist of dates to merge sort
    ArrayList<Date> datelist = new ArrayList<Date>(0);
    
    //add all date values into the arraylist of dates
    datelist.add(new Date(20025689547l));
    datelist.add(new Date(34446954957l));
    datelist.add(new Date(22990000000l));
    datelist.add(new Date(58585689412l));
    datelist.add(new Date(67956898000l));
    datelist.add(new Date(105687456365l));
    datelist.add(new Date(34987400512l));
    datelist.add(new Date(125146636472l));
    datelist.add(new Date(125412566632l));
    
    //merge sort the ints
    mergeSort(list);
    
    //merge sort the dates
    mergeSort(datelist);
    
    //print the sorted ints
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
    
    System.out.println("\n");
    //print the sorted dates
    for (int i = 0; i < datelist.size(); i++)
    	 System.out.println("Date[" + i + "] = " + datelist.get(i).toString());
  }
}