package basicProgram;

import java.util.Scanner;

public class AscendingOrder {

	public static void main(String[] args) 
	{
		int n,temp;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of lements in the array:");
		n=s.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the number of lements in the array:");
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				while(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}	
			}
		}
      System.out.println("numbers in descending order are:");
      for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
	}

}
