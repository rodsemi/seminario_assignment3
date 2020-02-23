package src;

// This class prints out all the information on to the screen 
public class SavingAccountTest {

	public static void main(String[] args) {
		
		// Variables
		SavingAccount saver1, saver2;
		
		// Makes an instance of the SavingAccount class and gives
		// it a value for savings
		saver1 = new SavingAccount(2000);
		saver2 = new SavingAccount(3000);
		
		// Gives the modifyInterestRate an amount 
		SavingAccount.modifyInterestRate(4);
		
		// Prints month, saver 1, and saver 2 to screen 
		System.out.println("Month\tSaver 1\t\tSaver 2");
		
		// Loops through 12 months and displays the different ammount
		// to the screen 
		for(int i = 1; i <= 12; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("%d\t$%.2f\t%.2f\n", i, saver1.getSavingBalance(), saver2.getSavingBalance());
		}
		
		// Changes the modifyInterestRate to 5
		SavingAccount.modifyInterestRate(5);
		
		// Calls function from SavingAccount class
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		// Prints all values to screen 
		System.out.println("\nNew Balances \n");
		System.out.printf("Saver 1: $%.2f\t", saver1.getSavingBalance());
		System.out.printf("Saver 2: $%.2f", saver2.getSavingBalance());
	}

}
