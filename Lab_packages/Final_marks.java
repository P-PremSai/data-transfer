
import CIE.*;
import SEE.*;
import java.util.Scanner;
class Final_marks
{
     public static void main(String args[])
	 {
	     Scanner input =new Scanner(System.in);
		 int n;
		 System.out.println("Enter the number of students");
		 n =input.nextInt();
		 CIE.Internals I[] =new CIE.Internals[n];
         SEE.External E[] =new SEE.External[n];
		 for(int i=0;i<n;i++)
		 {
		     System.out.println("Student "+(i+1));
		     I[i] =new CIE.Internals();
			 I[i].getdetails1();
			 I[i].getdetails();
			 E[i] =new SEE.External();
			 E[i].getdetails();
		 }
		 
		
		 int final_marks=0,total=0,tot_credits=0;
		 double sgpa=0;
		 int a[] =new int[5];
		 int credits[] =new int[5];

		 for(int i=0;i<n;i++)
		 {
			 System.out.println("Name: "+I[i].name +"\n USN :"+I[i].usn+"\n Sem :"+I[i].sem);
		     System.out.println("Final marks of student "+(i+1));
			 for(int j=0;j<5;j++)
			 {
			     final_marks =I[i].internal_marks[j]+(E[i].external_marks[j]/2);
				 System.out.println("Subject "+(j+1));
				 System.out.println("Enter the credis of the subject");
				 credits[j]=input.nextInt();
			     System.out.println("Marks : "+final_marks);
				 if(final_marks>=90)
				 {
					 System.out.println("S grade");
					 a[j]=10*credits[j];
				 }
				 
				 else if(final_marks>=80 && final_marks<90)
				 {
					 System.out.println("A grade");
					 a[j] =9*credits[j];
				 }
				 else if(final_marks>=70 && final_marks<80)
				 {
					 System.out.println("B grade");
					 a[j]=8*credits[j];
				 }
				 else if (final_marks>=60 && final_marks<70)
				 {
					 System.out.println("C grade");
					 a[j] =7*credits[j];
				 }
				 else if(final_marks>=50 && final_marks<60)
				 {
					 System.out.println("D grade");
					 a[j] =6*credits[j];
				 }
				 else if(final_marks>=40 && final_marks<50)
				 {
					 System.out.println("E grade");
					 a[j] =5*credits[j];
				 }
				 else if (final_marks<40)
				 {
					 System.out.println("Fail");
					 a[j] =0;
				 }
			 }	 
              for (int k=0;k<5;k++)
			  {
				   total +=a[k];
				   tot_credits +=credits[k];
			  }
			  sgpa =total/tot_credits;
			  System.out.println("SGPA IS : "+sgpa);
		 }
	 }
	 
}
