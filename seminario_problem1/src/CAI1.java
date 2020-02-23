package src;
import java.security.SecureRandom;
import java.util.*;

// Prompts the user to answer basic multiplication problems 
// and displays the question and answer to the screen

public class CAI1 {
	
	// Random and Scanner functions 
	SecureRandom rand = new SecureRandom();
	Scanner sc = new Scanner(System.in);
	
	// Variables 
	int num1, num2, ans, readAns;
	
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
	public void askQuestion()
	{
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		ans = num1 * num2;
		
		System.out.println("Please answer the follow question: ");
		System.out.println("What is " + num1 + " * " + num2 + " ? ");
	}
	
	// Takes the user response to the question 
	public void readResponse()
	{
		readAns = sc.nextInt();
	}
	
	// Checks if the user's answer is correct 
	// returns true or false
	public boolean isAnswerCorrect()
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
	public void displayCorrectResponse()
	{
		System.out.println("Very good!");	
	}
	
	// Prints a incorrect message to the user
	public void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
	
	// Main function makes an instance of CAI1
	// and calls quiz, which prints out everything
	public static void main(String[] args) 
	{
		CAI1 student = new CAI1();
		student.quiz();
	}
}
