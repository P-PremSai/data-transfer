import java.util.Scanner;
 
 class Sumofdigits
 {
   public static void main(String args[])
   {
     int n,sum=0,remainder;
     System.out.println("Enter the number ");
	 Scanner input =new Scanner(System.in);
	 n =input.nextInt();
	 while(n!=0)
	 {
	    remainder =n%10;
		n =n/10;
		sum =sum +remainder;
	 }
	 System.out.println("Sum of digits is "+sum);
   }
 }