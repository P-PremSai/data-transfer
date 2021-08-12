/*Create a package CIE which has two classes- Student and Internals. The class Personal has members like usn, name, sem. The class Internals has an array that stores the internal marks 
scored in five courses of the current semester of the student. Create another package SEE which has the class External which is a derived class of Student. This class has an array that
stores the SEE marks scored in five courses of the current semester of the student. Import the two packages in a file that declares the final marks of n students in all five courses.*/


package CIE;
import java.util.Scanner;

 public class Student
{
   public String usn,name;
   public int sem;
   
   Scanner input =new Scanner(System.in);
   
   public void getdetails1()
   {
      System.out.println("Enter the usn of the student");
	  usn =input .next();
	  System.out.println("Enter the name of the student");
	  name =input.next();
	  System.out.println("Enter the sem of the student");
	  sem =input.nextInt();
   }
}

 /*
package SEE;
import java.util.Scanner;

public class External extends Student
{
     public int external_marks[] =new int[5];
	 Scanner input =new Scanner(System.in);
	 
	 void getdetails()
	 {
	     System.out.println("Enter the SEE marks of the student");
         for(int i=0;i<5;i++)
		 {
		     external_marks[i] =input.nextInt();
		 }
	 }
}
import java.util.Scanner;

class Final_marks
{
     public static void main(String args[])
	 {
	     Scanner input =new Scanner(System.in);
		 int n;
		 System.out.println("Enter the number of students");
		 n =input.nextInt();
		 Internals I[] =new Internals[n];
		 
		 for(int i=0;i<n;i++)
		 {
		     System.out.println("Student "+(i+1));
		     I[i] =new Internals();
			 I[i].getdetails();
		 }
		 
		 Externals E[] =new Externals[n];
		 for(Int i=0;i<n;i++)
		 {
		     System.out.println("Student "+(i+1));
			 E[i] =new Externals();
			 E[i].getdetails();
		 }
		 int final_marks[] =new Int[n];
		 for(int i=0;i<n;i++)
		 {
		     System.out.println("Final marks of student "+(i+1));
			 final_marks[i] =internal_marks[i]+(external_marks[i]/2);
			 System.out.println(final_marks[i]);
		 }
	 }
	 
}*/
