import java.util.Scanner;
class checkevenodd 
{
     public static void main(String[] args)
	 {
	    int n;
		System.out.println("Enter the number:");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		if(n%2==0)
		{
		   System.out.println("Number is even");
		}
		else if(n%2!=0)
		{
		    System.out.println("Number is odd");
		}
	 }
}