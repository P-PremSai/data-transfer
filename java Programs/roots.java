import java.util.Scanner;
class roots
{
   public static void main(String args[])
   {
      int a,b,c;
	  float d;
	  double x1,x2;
	  Scanner input =new Scanner(System.in);
	  System.out.println("Enter the coefficient of x^2");
	  a = input.nextInt();
	  System.out.println("Enter the coefficient of x");
	  b = input.nextInt();
	  System.out.println("Enter the constant");
	  c = input.nextInt();
	  d = ((b*b)-(4*a*c));
	  x1 =((-b+Math.sqrt(d))/2);
	  x2 =((-b-Math.sqrt(d))/2);
	  if(d>0)
	  {
	     System.out.println("Roots are real and distinct");
		 System.out.println("Roots are "+x1+" and"+x2);
	  }
	  else if(d==0)
	  {
	     System.out.println("Roots are real and equal");
		 System.out.println("Roots are "+x1+" and"+x2);
	  }
	  else
	  {
	    System.out.println("There are no real roots");
	  }
   }
}