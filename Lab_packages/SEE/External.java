
package SEE;
import CIE.*;

import java.util.Scanner;

public class External extends CIE.Student
{
     public int external_marks[] =new int[5];
	 //public int tot_marks[]=new int[5];
	 Scanner input =new Scanner(System.in);
	 
	 public void getdetails()
	 {
	     System.out.println("Enter the SEE marks of the student out of 100");
         for(int i=0;i<5;i++)
		 {
			 System.out.println(" in Subject "+(i+1));
		     external_marks[i] =input.nextInt();
		 }
	 }
	
	 
}