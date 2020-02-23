package src;

import java.security.SecureRandom;
import java.util.Scanner;

//Prompts the user to answer basic and hard multiplication problems
//and displays the question and answer to the screen 

// Updates - Gives the user a difficulty setting to test their skills 
// difficulty settings are from easy(1) - hard(4)
public class CAI4 {
	
	// Random and Scanner functions
	private SecureRandom rand = new SecureRandom();
	private Scanner sc = new Scanner(System.in);
	
	// Variables
	private int num1, num2, ans, readAns, correctAns, levelOfDifficulty;
	private int randResponse = rand.nextInt(4);
	private int questions = 10;
	private double finalScore;
	
	// The function quiz first prints a welcome to the user
	// the do while loop does the same function like CAI3 but
	// prompts the user to choose a difficulty setting and then 
	// it has a for loop that give the user 10 questions to answer
	// then reads the response, checks how many the user gets right and
	// after gives the user a completion response
	// finally the program asks the user if they would like to try again 
	// which brings them back to the beginning of the quiz 
	public void quiz()
	{	
		char userChoice;
		
		System.out.println("Welcome to Orlando Knights Elementary School Math Online Program!");
		System.out.println("In this part of the program we will be testing out your multiplication skills!");
		
		do
		{
			correctAns = 0;
			
			readDifficulty();
			
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
	
	// Prompts the user to pick a difficulty setting for their quiz 
	private void readDifficulty()
	{
		int userChoiceDiff;
		
		System.out.println("Choose a difficulty setting between 1 and 4: ");
		
		do
		{
			userChoiceDiff = sc.nextInt();
			
			if(userChoiceDiff < 1 || userChoiceDiff > 4)
			{
				System.out.println("Please try again. Choose a difficulty setting between 1 and 4: ");
			}
		}while(userChoiceDiff < 1 || userChoiceDiff > 4);
		
		levelOfDifficulty = userChoiceDiff;
	}
	
	// This function holds a switch statement that determines which 
	// difficulty setting the user picks 
	private void generateQuestionArgument()
	{
		switch(levelOfDifficulty)
		{
			case 1:
				num1 = rand.nextInt(10);
				num2 = rand.nextInt(10);
				ans = num1 * num2;
				
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " * " + num2 + " ? ");
				break;
				
			case 2:
				num1 = rand.nextInt(100);
				num2 = rand.nextInt(100);
				ans = num1 * num2;
				
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " * " + num2 + " ? ");
				break;
				
			case 3:
				num1 = rand.nextInt(1000);
				num2 = rand.nextInt(1000);
				ans = num1 * num2;
				
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " * " + num2 + " ? ");
				break;
			
			case 4:
				num1 = rand.nextInt(10000);
				num2 = rand.nextInt(10000);
				ans = num1 * num2;
				
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " * " + num2 + " ? ");
				break;
			default:
				break;
		}
	}
	
	// This function now calls the generateQuestionArgument to be 
	// displayed on screen 
	private void askQuestion()
	{
		generateQuestionArgument();
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
	
	// Main function makes an instance of CAI4
	// and calls quiz, which prints out everything
	public static void main(String[] args) 
	{
		CAI4 student = new CAI4();
		student.quiz();
	}
}
