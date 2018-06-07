package basicProgram;

import java.util.Scanner;

public class PallindromeNumber {

	public static void main(String[] args)
	{
       int revert=0,number,newNumber;
		
		Scanner s=new Scanner(System.in);
		System.out.print("Enter any number:");
		number=s.nextInt();
		
		newNumber=number;
		
		while(number>0)
		{
			revert=revert*10+number%10;
			number=number/10;
		
			
		}
		System.out.println("Reverse of the number is:" +revert);
		if(newNumber==number)
		{
		 System.out.println("This number is palimdrome");	
		}
		else
		{
			System.out.println("This number is not a palimdrome");	
		}

	}

}
