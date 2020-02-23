package src;

import java.security.SecureRandom;
import java.util.Scanner;

// Prompts the user to answer basic multiplication problems
// and displays the question and answer to the screen

// Updates - Gives the user a total of 10 questions to answer
// after the 10 questions are completed the user gets a % total
// a new reply is print to screen telling the user "Congrats" or "Seek help"
public class CAI3 {
	
	// Random and Scanner functions
	private SecureRandom rand = new SecureRandom();
	private Scanner sc = new Scanner(System.in);
	
	// Variables
	private int num1, num2, ans, readAns, correctAns;
	private int randResponse = rand.nextInt(4);
	private int questions = 10;
	private double finalScore;
	
	// The function quiz first prints a welcome to the user
	// the do while loop does the same function like CAI2 but
	// this time it has a for loop that give the user 10 questions to answer
	// then reads the response, checks how many the user gets right and
	// after gives the user a completion response
	public void quiz()
	{	
		char userChoice;
		
		System.out.println("Welcome to Orlando Knights Elementary School Math Online Program!");
		System.out.println("In this part of the program we will be testing out your multiplication skills!");
		
		do
		{
			correctAns = 0;
			
			for(int i = 0; i < questions; i++)
			{
				askQuestion();
				readResponse();
				
				if(isAnswerCorrect() == true)
				{
					correctAns++;
					displayCorrectResponse();
				}
				else
				{
					displayIncorrectResponse();
				}
			}
			displayCompletionMessage();
			
			System.out.println("Awesome job! Would you like to tackle another problem?");
			userChoice = sc.next().charAt(0);
			
		}while(userChoice == 'Y' || userChoice =='y');	
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
	
	// This function checks if the user got a score greater or less than 0.75
	// a message will be displayed to the screen telling the user 
	// "Congrats" or "Seek help"
	private void displayCompletionMessage()
	{
		finalScore = (double)correctAns/questions;
		
		System.out.printf("Your final score is: %.0f%%!\n", finalScore * 100);
		
		if(finalScore > 0.75)
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else
		{
			System.out.println("Please ask your teacher for extra help.");
		}	
	}
	
	// Main function makes an instance of CAI3
	// and calls quiz, which prints out everything
	public static void main(String[] args) 
	{
		CAI3 student = new CAI3();
		student.quiz();
	}
}
