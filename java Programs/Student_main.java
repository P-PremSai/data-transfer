import java.util.Scanner;
class Student
{
   private int usn;
   private String name;
   private int credits[];
   private int marks[];
   private int n=7;

void acceptDetails()
{
	
   System.out.println("Enter the student details");
    Scanner s1 = new Scanner(System.in);
	
   usn =s1.nextInt();
   name=s1.next();
   for(int j=0;j<n;j++)
   {
	   credits[j] =s1.nextInt();
   }
   for(int i=0;i<n;i++)
   {
	   marks[i]=s1.nextInt();
   }
}

void sgpa()
{
   int k=0,p=0;
   for(int j=0;j<n;j++)
   for(int i=0;i<n;i++)
   {
      k =+(credits[j]*marks[i]);
	  p =+credits[j];
   }
   System.out.println("Your SGPA is : "+(k/p));
   
}

void displayDetails()
{
   System.out.println("Details of Student are :");
   System.out.println("USN : "+usn);
   System.out.println("NAME : "+name);
   
}
class Student_main
{
    public static void main(String args[])
	{
	   Student s1 =new Student();
	   s1.acceptDetails();
	   s1.displayDetails();
	   s1.sgpa();
	  
	   
	}
}
}