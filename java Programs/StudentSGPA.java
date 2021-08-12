import java.util.Scanner;
class student 
{
   private String name,usn;
   private double marks[] =new double[7];
   private double credits[] =new double[7];
   private double total=0,a=0.0,totalc=0.0,totalmc=0.0;
 
 void getdetails(){
     Scanner input =new Scanner(System.in);
	 System.out.println("Enter your USN : ");
	 usn =input.next();
	  System.out.println("Enter your Name : ");
	  name =input.next();
	  for(int i=0;i<7;i++)
	  {
	     System.out.println("Enter the marks and credits of subject"+(i+1));
		 marks[i] =input.nextDouble();
		 credits[i] =input.nextDouble();
	  }
 }
 
 void displaydetails(){
    System.out.println("USN : "+usn);
	System.out.println("NAME : "+name);
 }
 void sgpa(){
    for(int i=0;i<7;i++)
	{
	   total =+marks[i];
	}
	for(int i=0;i<7;i++)
	{
	  if (marks[i]>=90)
	     a =10.0;
	  else if (marks[i]>=80 && marks[i]<90)
         a =9.0;
	  else if (marks[i]>=70 && marks[i]<80)
         a =8.0;
	  else if (marks[i]>=60 && marks[i]<70)
         a =7.0;	
	  else if (marks[i]>=50 && marks[i]<60)
         a =6.0;
	  else if (marks[i]>=40 && marks[i]<50)
         a =5.0;
      else 
          a=0.0;	  
	}
	for(int i=0;i<7;i++)
	{
	   totalc=+credits[i];
	   totalmc=+(marks[i]*credits[i]);
	}
System.out.println("Your SGPA is : "+(totalmc/(totalc*10)));
 }
}

 class StudentSGPA
 {
    public static void main(String[] args)
	{
	   student s1=new student();
	   s1.getdetails();
	   s1.displaydetails();
	   s1.sgpa();
	}
 }
