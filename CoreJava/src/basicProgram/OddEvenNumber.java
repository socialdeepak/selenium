package basicProgram;

import java.util.Scanner;

public class OddEvenNumber {

	public static void main(String[] args) 
	{
		int number,i;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number you want to check:");
		number=scan.nextInt();
		if(number%2==0)
		{
		 System.out.println("Number is even number");	
		}	
		else
			System.out.println("Number is odd number");

	}

}
