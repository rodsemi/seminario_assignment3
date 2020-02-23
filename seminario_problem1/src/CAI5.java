package src;

import java.security.SecureRandom;
import java.util.Scanner;

// The final part of the quiz program
// This program prompts the user to answer different types of mathematical problems 
// ranging from easy to hard difficulty settings 
// it now also provides the user with a mix setting to test their skills 
public class CAI5 {
	
	// Random and Scanner functions
	private SecureRandom rand = new SecureRandom();
	private Scanner sc = new Scanner(System.in);
	
	// Variables
	private int num1, num2, ans, readAns, correctAns, levelOfDifficulty, problemType;
	private int randResponse = rand.nextInt(4);
	private final int  questions = 10;
	private double finalScore;
	
	// This function is pretty similar to the other programs but
	// now calls readProblemType and generateQuestionArgument
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
			
			readProblemType();
			
			for(int i = 0; i < questions; i++)
			{
				generateQuestionArgument();
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
	
	// Displays a menu to the screen which prompts the user to pick 
	// between 5 options
	private void readProblemType()
	{
		int userChoiceProblem;
		
		System.out.println("Please choose the problem type you will be tackling today!");
		System.out.println("1. Addition");
		System.out.println("2. Multiplication");
		System.out.println("3. Subtraction");
		System.out.println("4. Division");
		System.out.println("5. Mixed set of problems");
		
		do
		{
			userChoiceProblem = sc.nextInt();
			
			if(userChoiceProblem < 1 || userChoiceProblem > 5)
			{
				System.out.println("Please try again. Choose a problem set between 1 and : ");
			}
		}while(userChoiceProblem < 1 || userChoiceProblem > 5);
		
		problemType = userChoiceProblem;	
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
				break;
				
			case 2:
				num1 = rand.nextInt(100);
				num2 = rand.nextInt(100);
				break;
				
			case 3:
				num1 = rand.nextInt(1000);
				num2 = rand.nextInt(1000);
				break;
			
			case 4:
				num1 = rand.nextInt(10000);
				num2 = rand.nextInt(10000);
				break;
			default:
				break;		
		}
	}
	
	// This function was updated with a switch case to determine 
	// the type of problem the user will tackle in this quiz
	// option 5 was given a switch inception to randomize between 
	// the four mathematical choices 
	private void askQuestion()
	{
		switch(problemType)
		{
			case 1:
				ans = num1 + num2;
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " + " + num2 + " ? ");
				break;
			case 2:
				ans = num1 * num2;
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " * " + num2 + " ? ");
				break;
			case 3:
				ans = num1 - num2;
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " - " + num2 + " ? ");
				break;
			case 4:
				
				while(num2 == 0)
				{
					generateQuestionArgument();
				}
				
				ans = num1 / num2;
				System.out.println("Please answer the follow question: ");
				System.out.println("What is " + num1 + " / " + num2 + " ? ");
				break;
			case 5: 
				
				switch(rand.nextInt(4))
				{
				case 1:
					ans = num1 + num2;
					System.out.println("Please answer the follow question: ");
					System.out.println("What is " + num1 + " + " + num2 + " ? ");
					break;
				case 2:
					ans = num1 * num2;
					System.out.println("Please answer the follow question: ");
					System.out.println("What is " + num1 + " * " + num2 + " ? ");
					break;
				case 3:
					ans = num1 - num2;
					System.out.println("Please answer the follow question: ");
					System.out.println("What is " + num1 + " - " + num2 + " ? ");
					break;
				case 4:
					while(num2 == 0)
					{
						generateQuestionArgument();
					}
					
					ans = num1 / num2;
					System.out.println("Please answer the follow question: ");
					System.out.println("What is " + num1 + " / " + num2 + " ? ");
					break; 	
				}
				default:
					break;				
		}
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
	
	// Main function makes an instance of CAI5
	// and calls quiz, which prints out everything
	public static void main(String[] args) 
	{
		CAI5 student = new CAI5();
		student.quiz();
	}
}
