package basicProgram;

public class ReverseString {

	public static void main(String[] args) 
	{
		String str="I am a java programmer";
		String rvr="";
		String a[]=str.split("");
		
		int n=a.length-1;
		for(int i=n;i>=0;i--)
		{
			rvr=rvr+a[i]+"";
		}

		System.out.println("String is :"+str); 
		System.out.println("Reversed Word String is :"+rvr);
	}

}
