package src;

import java.security.SecureRandom;
import java.util.Scanner;

// Prompts the user to answer basic multiplication problems
// and displays the question and answer to the screen

// Update - Adds more responses to the user when answer question 

public class CAI2 {

	// Random and Scanner functions 
	private SecureRandom rand = new SecureRandom();
	private Scanner sc = new Scanner(System.in);
	
	// Variables
	private int num1, num2, ans, readAns;
	private int randResponse = rand.nextInt(4);
	
	// The function quiz first prints a welcome to the user
	// then calls askQuestion to display
	// a do while is used to call readResponse and checks 
	// to see if the user gets the answer right or wrong
	public void quiz()
	{	
		System.out.println("Welcome to Orlando Knights Elementary School Math Online Program!");
		System.out.println("In this part of the program we will be testing out your multiplication skills!");
		askQuestion();
		
		do
		{
			readResponse();
			if(isAnswerCorrect() == true)
			{
				displayCorrectResponse();
			}
			else
			{
				displayIncorrectResponse();
			}
		}while(isAnswerCorrect() == false);	
	}
	
	// The two number variables are given the SecureRandom function 
	// prints the question to screen for the user to answer
	private void askQuestion()
	{
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		ans = num1 * num2;
		
		System.out.println("Please answer the follow question: ");
		System.out.println("What is " + num1 + " * " + num2 + " ? ");
	}
	
	// Takes the user response to the question
	private void readResponse()
	{
		readAns = sc.nextInt();
	}
	
	// Checks if the user's answer is correct 
	// returns true or false
	private boolean isAnswerCorrect()
	{
		if(ans == readAns)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	// Prints a correct message to the user 
	// Add three more positive replies for the user
	private void displayCorrectResponse()
	{
		switch(randResponse)
		{
			case 1: System.out.println("Very good!");
			break;
			case 2: System.out.println("Excellent");
			break;
			case 3: System.out.println("Nice work!");
			break;
			case 4: System.out.println("Keep up the good work!");
			break;
			default:
				break;			
		}
	}
	
	// Prints a incorrect message to the user
	// Adds three more negative replies to the user
	private void displayIncorrectResponse()
	{
		switch(randResponse)
		{
			case 0: System.out.println("No. Please try again.");
			break;
			case 1: System.out.println("Wrong. Try once more");
			break;
			case 2: System.out.println("Don't give up!");
			break;
			case 3: System.out.println("No. Keep trying.");
			break;
			default:
				break;
		}
	}
	
	// Main function makes an instance of CAI2
	// and calls quiz, which prints out everything
	public static void main(String[] args) 
	{
		CAI2 student = new CAI2();
		student.quiz();
	}
}
