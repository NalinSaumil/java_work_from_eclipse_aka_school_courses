//imported the Date class because it was nessecary for the dateCreated data field
import java.util.Date;

//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 7, 2022
//The account class is an object class that is created to regulate and obtain information about the account of the initiated object of this class.

public class Account {
	
	//Data Fields (default values)
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated = new Date();
	
	//no-args constructor
	public Account() {
	}
	
	//constructor with values for id and balance
	public Account(int id_val, double bal_val) {
		this.id = id_val;
		this.balance = bal_val;
	}
	
	//constructor with values for id, balance and annualInterestRate
	public Account(int id_val, double bal_val, double annualInterestRate_val) {
		this.id = id_val;
		this.balance = bal_val;
		this.annualInterestRate = annualInterestRate_val;
	}
	
	//accessor for id
	public int getId() {
		return this.id;
	}
	
	//accessor for balance
	public double getBalance() {
		return this.balance;
	}
	
	//accessor for annualInterestRate
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	//mutator for id
	public void setId(int id_val) {
		this.id = id_val;
	}
	
	//mutator for id
	public void setBal(double bal_val) {
		this.balance = bal_val;
	}
	
	//mutator for annualInterestRate
	public void setAnnualInterestRate(double annualInterestRate_val) {
		this.annualInterestRate = annualInterestRate_val;
	}
	
	//accessor for dateCreated
	public String getDate() {
		return this.dateCreated.toString();
	}
	
	//returns the monthly interest rate by taking annual interest rate and dividing by 12 months
	public double getMonthlyInterestRate() {
		return this.annualInterestRate/12;
	}
	
	//decreases money from balance to show a withdrawal
	public void withdraw(double withdraw_amt) {
		this.balance = this.balance - withdraw_amt;
	}
	
	//increases money in balance to show a deposit
	public void deposit(double deposit_amt) {
		this.balance = this.balance + deposit_amt;
	}
}
