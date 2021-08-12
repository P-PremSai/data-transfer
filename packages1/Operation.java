import java.util.Scanner;
import ADD.*;
import SUBTRACT.*;
import DIVISION.*;
import MULTIPLICATION.*;

class Operation
{
     public static void main(String args[])
	 {
	     Addition a =new Addition();
		 Subtraction s =new Subtraction();
		 Multiplication m=new Multiplication();
		 Division d =new Division();
		 
		 Scanner input =new Scanner(System.in);
		 double x,y;
		 System.out.println("Enter the number 1");
		 x =input.nextDouble();
		 System.out.println("Enter the number 2");
		 y =input.nextDouble();
		 a.add(x,y);
		 s.subtract(x,y);
		 m.multiply(x,y);
		 d.divide(x,y);
		 a.display();
		 s.display();
		 m.display();
		 d.display();
	 }
}