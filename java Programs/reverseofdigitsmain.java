import java.util.Scanner;

class reverseofdigits
{
   int count=0;
   
   void digits(int n)
   {
      while(n!=0)
	  {
	     count++;
		 n =n/10;
	  }
	  
   }
   
   int recount()
   {
      return count;
   }
}

class reverseofdigitsmain
{
   public static void main(String args[])
   {
       int n,s[],remainder;
	   Scanner input =new Scanner(System.in);
	   System.out.println("Enter the number");
	   n =input.nextInt();
	   reverseofdigits e1 =new reverseofdigits();
	   e1.digits(n);
	   s =new int[e1.recount()];
	   for(int i=0;i<e1.recount();i++)
	   {
	      remainder =n%10;
		  s[i] =remainder;
		  n =n/10;
	   }
	   System.out.print("Reverse number is : ");
	   for(int i=0;i<e1.recount();i++)
	   {
	     System.out.print(s[i]);
	   }
   }
}