//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 7, 2022
//The bank operations class will run a bank simulation using the Account object class by creating an object of the account class and using methods from the account class to regulate and get information about the account of the account object.

public class BankOperations {
	//main method (what the compiler runs)
	public static void main(String[] args) {
		//creating the account object with initial values in the constructor
		Account sN = new Account(1122, 20000.0, 4.5);
		//using methods to "mutate" account data fields of sN
		sN.withdraw(2500);
		sN.deposit(3000);
		//finding monthly interest of the account by "accessing" information about the account and performing nessecary calculations
		double monthlyInterest = (sN.getMonthlyInterestRate() / 100) * sN.getBalance();
		//printing account details
		System.out.println("Balance: $" + sN.getBalance() + "\nMonthly Interest: $" + monthlyInterest + "\nDate Created: " + sN.getDate());
	}
}