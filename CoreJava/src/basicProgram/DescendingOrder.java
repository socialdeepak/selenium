package basicProgram;

import java.util.Scanner;

public class DescendingOrder {

	public static void main(String[] args)
	{
		int n,temp;
		Scanner s=new Scanner(System.in);
		//n=s.nextInt();
		System.out.print("Enter the numbers u want to enter in a array:");
		n=s.nextInt();
		int a[]=new int[n];
		System.out.println("Enter all the elements u want to enter:");
		for (int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		for(int i=0;i<n;i++)
		{
		  for(int j=i+1;j<n;j++)
		  {
			while(a[i]<a[j])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}	
		  }  
		}	
		System.out.println("Numbers in descending order:"); 
		for (int i=0;i<n;i++)
		{
			System.out.println(a[i]);
			
		}
		
		
		

	}

}
