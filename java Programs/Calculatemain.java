import java.util.Scanner;
class Calculate
{
   private String usn,name;
   private int credits[];
   private int marks[];
   private int n;
    
void acceptDetails()
{    
      System.out.println("Enter the number of subjects");
	   Scanner input =new Scanner(System.in);
	   n = input.nextInt();
	   credits = new int[n];
	   marks = new int [n];
       System.out.println("Enter the student details");
    Scanner s1 = new Scanner(System.in);
	System.out.println("enter the usn and name");
   usn =s1.next();
   name=s1.next();

   for(int j=0;j<n;j++)
   {
	      System.out.println("Enter the marks and credits of subject "+(j+1));
	      marks[j]=s1.nextInt();
		  credits[j] =s1.nextInt();
   }
}

void sgpa()
{  
   System.out.println("Enter the number of subjects");
   Scanner input =new Scanner(System.in);
    n = input.nextInt();
   int k=0,p=0;
   for(int j=0;j<n;j++)
   for(int i=0;i<n;i++)
   {
      k =+(credits[j]*marks[i]);
	  p =+credits[j];
   }
   System.out.println("Your SGPA is : "+(double)(k/p));
   
}

void displayDetails()
{
   System.out.println("Details of Student are :");
   System.out.println("USN : "+usn);
   System.out.println("NAME : "+name);
   
}
}
public class Calculatemain
{
    public static void main(String[] args)
	{
	   Calculate s1 =new Calculate();
	   s1.acceptDetails();
	   s1.displayDetails();
	   s1.sgpa();
	}
}
