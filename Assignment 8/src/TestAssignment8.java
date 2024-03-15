//import the nessecary classes for optimal code function
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 30, 2022
//This class creates and operates the patient database for the clinic that is being run.

public class TestAssignment8 {
   public static void main(String[] args) {
	  //Create all the nessecary variables to run the program
	   
	   //enter the file path of only the patient.txt file here. This will change for every computer.
	   //this file will not change. All changes will be made to the newPatient.txt file.
	  String filePath = "C:\\Users\\saumi\\Desktop\\myFiles\\education\\Programming\\Eclipse WorkSpace\\Assignment 8\\src\\Patient.txt";
	  //create an array of patients from patient.txt file and clears newPatient.txt file for changes to be made
	  Patient[] patientList = createPatientList(filePath);
	  //create a binary search tree from the patient array
	  BST<Patient> patientSearchTree = new BST<Patient>(patientList);
	  int count = 0;
	  Patient pointer = new Patient();
	  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	  //assign today's date
	  Date today = new Date();
      try {
         today = formatter.parse("04/01/23");
      } catch(ParseException ex) {
         int test = 0;
      }
	  char finalResponse = '0';
	  //iterator for as many changes as you would like to make to the patient database
	  do {
	  //scanner object to take user input
	  Scanner scan = new Scanner(System.in);
	  //every question in here has a very meticulous response and user needs to be very careful when entering repsonses
	  //all responses are case-sensitive and space-sensitive
	  //This question asks what operation you want to perform on the patient database
	  System.out.println("\nWhat would you like to do with the Patient Database today?\n\nTo just get a list of all the patients, type: \"directory\"\nTo add a new patient, type: \"add patient\""
	  		+ "\nTo delete a patient, type: \"delete patient\"\nTo edit a patient's appointment, type: \"edit patient\""
	  		+ "\nTo get next week's patients for a particular doctor, type: \"next week by doctor\""
	  		+ "\nTo get all of next week's patients, type: \"next week\"\nTo search for a patient, type: \"find patient\""
	  		+ "\nTo find annual appointments for a particular doctor, type: \"annual appointments by doctor\"\n");
	  String input = scan.nextLine();
	  
	  //here each response has its own function defined by switch case
	  //This is why the responses need to follow the formats given very carefully
	  switch(input) {
	  	//inserts a new patient into the database
	  	 case "add patient":
		    System.out.print("\nEnter the new patient in the following format\n[lastName firstName,docName,appt1(MM/DD/YY),appt2,...  & capitalize the initial(s) of all names]: ");
		    Patient toBeAdded = new Patient(scan.nextLine().split(","));
		    patientList = addIntoArray(toBeAdded, patientList);
		    patientSearchTree.insert(toBeAdded);
		    //clear newPatient.txt file and print updated database to it
		    clearFile(filePath);
			writeFile(filePath, patientSearchTree.toArrayList());
	  		break;
	  	//deletes a patient from the database
	  	 case "delete patient":
	  	     System.out.print("\nEnter the name of the patient you want to delete [lastName firstName & capitalize the initial(s)]: ");
	  		 String fullName = scan.nextLine();
	  		 String[] names = fullName.split(" ");
	  	     for(int i = 0; i < patientList.length; i++) {
	  			 if(patientList[i].getFirstName().equals(names[1]) && 
	  			    patientList[i].getLastName().equals(names[0])) {
	  				 pointer = patientList[i];
	  			 }
	  		 }
	  	     patientList = removeFromArray(pointer, patientList);
	  	     patientSearchTree.delete(pointer);
	  	     //clear newPatient.txt file and print updated database to it
	  	     clearFile(filePath);
	  		 writeFile(filePath, patientSearchTree.toArrayList());
	  	     break;
	  	 //edits the appointments of a patients and gives you the choice of adding, deleting or changing appointments
	  	 case "edit patient":
	  		System.out.print("\nEnter the name of the patient whose appointments you want\nto edit [lastName firstName & capitalize the initial(s)]: ");
	  		fullName = scan.nextLine();
	  		names = fullName.split(" ");
	  	    for(int i = 0; i < patientList.length; i++) {
	  			if(patientList[i].getFirstName().equals(names[1]) && 
	  			   patientList[i].getLastName().equals(names[0])) {
	  				pointer = patientList[i];
	  				count = i;
	  			}
	  		}
	  	    System.out.print("\nWould you like to add, change or delete and appointment? type: \"add\",\"change\", or \"delete\" --> ");
	  	    String response = scan.nextLine();
	  	    //here it defines what happens to the appointments of the patient based on your response
	  	    switch(response) {
	  	    	//adds an appointment to the patient
	  	    	case "add":
	  	    		System.out.print("\nType in the date you would like to add in the following format [MM/DD/YY]: ");
	  	    		pointer.addDate(scan.nextLine());
	  	    		patientList[count] = pointer;
	  	    		patientSearchTree = new BST<Patient>(patientList);
	  	    		break;
	  	    	//changes an appointment of the patient
	  	    	case "change":
	  	    		System.out.print("\nYour patient has " + pointer.getDateArray().length + " appointments: \n\n" + pointer.dateArrayToString() + "\n\nWhich appointment number would you like to change\nand what is the date you would like to change it to?\ntype in the following format [appt number,date(MM/DD/YY)]: ");
	  	    		String apptChange = scan.nextLine();
	  	    		String[] changeInfo = apptChange.split(",");
	  	    		pointer.changeDate(changeInfo[1], Integer.parseInt(changeInfo[0]));
	  	    		patientList[count] = pointer;
	  	    		patientSearchTree = new BST<Patient>(patientList);
	  	    		break;
	  	    	//deletes a patients appointment
	  	    	case "delete":
	  	    		System.out.print("\nYour patient has " + pointer.getDateArray().length + " appointments: \n\n" + pointer.dateArrayToString() + "\n\nWhich appointment number would you like to delete? ");
	  	    		pointer.removeDate(scan.nextInt());
	  	    		patientList[count] = pointer;
	  	    		patientSearchTree = new BST<Patient>(patientList);
	  	    		break;
	  	    }
	  	//clear newPatient.txt file and print updated database to it
	  	    clearFile(filePath);
	  	    writeFile(filePath, patientSearchTree.toArrayList());
	  		break;
	  	//gives you a list of patients for a chosen doctor 
	  	 case "next week by doctor":
	  	    System.out.print("\nEnter the last name of the doctor whose appointments you want to find [capitalize the initial(s)]: ");
	  		String docName = scan.nextLine();
	  		Patient[] nextWkApptByDoc = new Patient[0];
	  		for(int i = 0; i < patientList.length; i++) {
	  			Date[] appts = patientList[i].getDateArray();
	  			if(patientList[i].getDocName().equals(docName)
	  			   && patientList[i].getDaysInBtwn(appts[0], today) <= 7) {
	  				nextWkApptByDoc = addIntoArray(patientList[i], nextWkApptByDoc);
	  			}
	  		}
	  		//clear newPatient.txt file and print updated database to it
	  		clearFile(filePath);
		    writeFile(filePath, nextWkApptByDoc);
	  		break;
	  	//gives you a list of all patients with next week appointments
	  	 case "next week":
	  		Patient[] nextWkAppt = new Patient[0];
	  		for(int i = 0; i < patientList.length; i++) {
	  			Date[] appts = patientList[i].getDateArray();
	  			if(patientList[i].getDaysInBtwn(appts[0], today) <= 7) {
	  				nextWkAppt = addIntoArray(patientList[i], nextWkAppt);
	  			}
	  		}
	  	//clear newPatient.txt file and print updated database to it
	  		clearFile(filePath);
		    writeFile(filePath, nextWkAppt);
	  		break;
	  	//finds patients by name
	  	 case "find patient":
	  		System.out.print("\nEnter the name of the patient you would\nlike to find [lastName firstName & capitalize the initial(s)]: ");
	  		fullName = scan.nextLine();
	  		names = fullName.split(" ");
	  	    for(int i = 0; i < patientList.length; i++) {
	  			if(patientList[i].getFirstName().equals(names[1]) && 
	  			   patientList[i].getLastName().equals(names[0])) {
	  			   pointer = patientList[i];
	  			}
	  		}
	  	//clear newPatient.txt file and print updated database to it
	  	    clearFile(filePath);
		    writeFile(filePath, pointer);
	  		break;
	  	//gives you a list of patients that have annual appointments for a chosen doctor
	  	 case "annual appointments by doctor":
	  	    System.out.print("\nEnter the last name of the doctor whose appointments\nyou want to find [capitalize the initial(s)]: ");
	  		docName = scan.nextLine();
	  		Patient[] annualApptByDoc = new Patient[0];
	  		for(int i = 0; i < patientList.length; i++) {
	  			Date[] appts = patientList[i].getDateArray();
	  			if(appts.length == 2 && patientList[i].getDocName().equals(docName)
	  			   && patientList[i].getDaysInBtwn(appts[0], appts[1]) >= 365) {
	  				annualApptByDoc = addIntoArray(patientList[i], annualApptByDoc);
	  			}
	  		}
	  	//gives you a list of all patients
	  	 case "directory":
	  		//clear newPatient.txt file and print updated database to it
	  		clearFile(filePath);
	  	    writeFile(filePath, patientSearchTree.toArrayList());
		    break;
	  }
	  //asks to see if you want to continue working on the database
	  System.out.print("\nIs there anything else you would like to do today with the Patient Databse? [Y/N]: ");
	  finalResponse = scan.next().charAt(0);
	  } while(finalResponse == 'Y' || finalResponse == 'y');
   }
   
   //method to convert patient.txt to patient array and clear newPatient.txt for updated database
   public static Patient[] createPatientList(String filePath) {
      Patient[] patients = new Patient[0];
      try {
         File inputFile = new File(filePath);
         Scanner myReader = new Scanner(inputFile);
         while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] patient = data.split(",");
            Patient nextPatient = new Patient(patient);
            patients = addIntoArray(nextPatient, patients);
         }
         myReader.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
      
      clearFileNoMsg(filePath);
      
      return patients;
   }
   
   //method to add elements to a patient array
   public static Patient[] addIntoArray(Patient patient, Patient[] patientArray) {
	   Patient[] temp = new Patient[patientArray.length + 1];
	   for(int i = 0; i < patientArray.length; i++) {
		   temp[i] = patientArray[i];
	   }
	   temp[patientArray.length] = patient;
	   return temp;
   }
   
   //method to remove elements from a patient array
   public static Patient[] removeFromArray(Patient patient, Patient[] patientArray) {
	   Patient[] temp = new Patient[patientArray.length - 1];
	   int k = 0;
	   for(int i = 0; i < patientArray.length; i++) {
		   if(patientArray[i].getFirstName().equals(patient.getFirstName())
			  && patientArray[i].getLastName().equals(patient.getLastName()))
			   continue;
		   else
			   temp[k++] = patientArray[i];
	   }
	   return temp;
   }
   
   //method to clear a file and return a confirmation message
   public static void clearFile(String filePath) {
	  try{
	     PrintWriter writer = new PrintWriter(filePath.substring(0, filePath.length() - 11) + "newPatient.txt");
	     writer.write("");
	     writer.close();
	     System.out.print("\nnewPatient.txt has been cleared.\n");
	  } catch(FileNotFoundException e) {
	     System.out.println("An error occurred.");
	     e.printStackTrace();
	  }
   }
   
   //method to clear a file but not return a message
   public static void clearFileNoMsg(String filePath) {
		  try{
		     PrintWriter writer = new PrintWriter(filePath.substring(0, filePath.length() - 11) + "newPatient.txt");
		     writer.write("");
		     writer.close();
		  } catch(FileNotFoundException e) {
		     System.out.println("An error occurred.");
		     e.printStackTrace();
		  }
   }
   
   //method to print into a file with information from a patient arrayList -- overloaded
   public static void writeFile(String filePath, ArrayList<Patient> patientList) {
	   try{
		 PrintWriter writer = new PrintWriter(filePath.substring(0, filePath.length() - 11) + "newPatient.txt");
		 for(int i = 0; i < patientList.size(); i++) {
			writer.print(patientList.get(i).toString() + "\n"); 
	     }
		 writer.close();
		 System.out.print("You will find the results of your operation in newPatient.txt\n");
	  } catch(FileNotFoundException e) {
		 System.out.println("An error occurred.");
		 e.printStackTrace();
	  }
   }
   
  //method to print into a file with information from a patient array -- overloaded
   public static void writeFile(String filePath, Patient[] patientList) {
	  try{
		 PrintWriter writer = new PrintWriter(filePath.substring(0, filePath.length() - 11) + "newPatient.txt");
		 for(int i = 0; i < patientList.length; i++) {
			writer.print(patientList[i].toString() + "\n"); 
		 }
		 writer.close();
		 System.out.print("You will find the results of your operation in newPatient.txt\n");
	  } catch(FileNotFoundException e) {
		 System.out.println("An error occurred.");
		 e.printStackTrace();
	  }
   }
   
   //method to print into a file with information from a patient object -- overloaded
   public static void writeFile(String filePath, Patient patient) {
	  try{
		 PrintWriter writer = new PrintWriter(filePath.substring(0, filePath.length() - 11) + "newPatient.txt");
		 writer.print(patient.toString());
		 writer.close();
		 System.out.print("You will find the results of your operation in newPatient.txt\n");
	  } catch(FileNotFoundException e) {
		 System.out.println("An error occurred.");
		 e.printStackTrace();
	  }
   }
}
