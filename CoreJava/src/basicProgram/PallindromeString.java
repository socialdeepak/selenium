package basicProgram;

import java.util.Scanner;

public class PallindromeString {

	public static void main(String[] args) 
	{
		       System.out.println("Enter string to reverse:");
		        
		        Scanner read = new Scanner(System.in);
		        String str = read.nextLine();
		        
		        String newStr=str;
		        String reverse = "";
		        
		        
		        for(int i = str.length() - 1; i >= 0; i--)
		        {
		            reverse = reverse + str.charAt(i);
		        }
		        
		        System.out.println("Reversed string is:");
		        System.out.println(reverse);
		        System.out.println(newStr);
		        if(reverse.equals(newStr))
		        {
		        	System.out.println("The number is a pallindrome");
		        }
		        else
		        	System.out.println("The number is not a pallindrome");
		    }
	
		

	

}
