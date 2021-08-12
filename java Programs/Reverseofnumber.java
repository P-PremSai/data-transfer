import java.util.Scanner;
class Reverseofnumber
{
 public static void main(String ags[])
 {
   int n,remainder=0;
   Scanner input =new Scanner(System.in);
   System.out.println("Enter the number");
   
   n =input.nextInt();
   while(n!=0)
   {
	   remainder=remainder*10;
	   remainder =remainder+(n%10);
	   n =n/10;
   }
    System.out.println("reverse number is : "+remainder);
  }
}