package src;

// This class does all the math to calculate how much
// money each savings account has in the bank
public class SavingAccount {

	// Variables
	private static double annualInterestRate;
	private double savingBalance;
	
	// In this function it access the private savingBalance variable 
	public SavingAccount(double savingBalance)
	{
		this.savingBalance = savingBalance;
	}
	
	// This function returns the private variable
	// and returns the amount 
	public double getSavingBalance()
	{
		return this.savingBalance;
	}
	
	// This function calculate the amount in the saving account
	public double calculateMonthlyInterest()
	{
		double monthlyInterest = (this.savingBalance * annualInterestRate) / 12;
		this.savingBalance = this.savingBalance + monthlyInterest;
		return monthlyInterest;
	}
	
	// This function modifies the interest rate to the function
	public static void modifyInterestRate(double interestRate)
	{
		annualInterestRate = interestRate / 100;
	}

}
