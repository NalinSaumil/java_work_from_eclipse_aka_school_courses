//import the nessecary classes for optimal code function
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.text.Format;

//Saumil Nalin
//CS 3345.007
//Mohamed Amine Belkoura
//Apr 2, 2023
//This class defines a patient and gives us different functions that apply to every patient.

class Patient implements Comparable<Patient>{
	//data fields
	   private String firstName;
	   private String lastName;
	   private String docName;
	   private Date[] apt;
	   
	   //constructor with args
	   public Patient(String[] init) {
	      String[] name = init[0].split(" ");
	      firstName = name[1];
	      lastName = name[0];
	      docName = init[1];
	      apt = new Date[init.length - 2];
	      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	      for(int i = 2; i < init.length; i++){
	         try {
	            apt[i-2] = formatter.parse(init[i]);
	         } catch(ParseException ex) {
	            int test = 0;
	         }
	      }
	   }
	   
	   //no-args contructor
	   public Patient() {
		   firstName = "";
		   lastName = "";
		   docName = "";
		   apt = new Date[0];
	   }
	   
	   //returns first name
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   //returns last name
	   public String getLastName() {
	      return lastName;
	   }
	   
	   //returns doctor's name
	   public String getDocName() {
	      return docName;
	   }
	   
	   //returns the array of appointments
	   public Date[] getDateArray() {
	      return apt;
	   }
	   
	   //returns the array of appointments as a numbered list in string type
	   public String dateArrayToString() {
		  String appts = "";
		  Format f = new SimpleDateFormat("MM/dd/yyyy");
		  for (int i = 0; i < apt.length; i++) {
			  if(i == 0)
				  appts = appts + (i+1) + ": " + f.format(apt[i]);
			  else
				  appts = appts + ", " + (i + 1) + ": " + f.format(apt[i]);
		  }
		  return appts;
	   }
	   
	   //gets the days in between 2 dates
	   public long getDaysInBtwn(Date date1, Date date2){
	      long ms1 = date1.getTime();
	      long ms2 = date2.getTime();
	      long msDiff = Math.abs(ms1 - ms2);
	      long dayDiff = TimeUnit.DAYS.convert(msDiff, TimeUnit.MILLISECONDS);;
	      return dayDiff;
	   }
	   
	   //change the appointment date of one of the patient's appointments
	   public void changeDate(String date, int apptNum) {
	      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	      try {
	         apt[apptNum - 1] = formatter.parse(date);
	      } catch(ParseException ex) {
	         int test = 0;
	      }
	   }
	   
	   //add an appointment to the patient
	   public void addDate(String date) {
	      Date[] temp = new Date[apt.length + 1];
	      for(int i = 0; i < apt.length; i++) {
	         temp[i] = apt[i];
	      }
	      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	      try {
	         temp[apt.length] = formatter.parse(date);
	      } catch(ParseException ex) {
	         int test = 0;
	      }
	      this.apt = temp;
	   }
	   
	   //removes an appointment of choice from the patients appointment list
	   public void removeDate(int apptNum) {
	      Date[] temp = new Date[apt.length - 1];
	      int k = 0;
	      for(int i = 0; i < apt.length; i++) {
	         if(i == apptNum - 1) {
	            continue;
	         }
	         temp[k++] = apt[i];
	      }
	      this.apt = temp;
	   }
	   
	   //compares to patients by their last name
	   public int compareTo(Patient patient) {
		   return this.lastName.compareTo(patient.lastName);
	   }
	   
	   //toString method for patient
	   public String toString() {
	      String apts = "";
	      Format f = new SimpleDateFormat("MM/dd/yyyy");
	      for(int i = 0; i < this.apt.length; i++) {
	         if(i == 0) 
	            apts = apts + f.format(apt[i]);
	         else
	            apts = apts + "," + f.format(apt[i]);
	      }
	      return this.lastName + " " + this.firstName + "," + this.docName + "," + apts;
	   }
	}