/*Develop a Java program to create a class Student whose variables are usn, name and sem.
Derive a class Test from Student to include an array of cie marks of each course and their
corresponding credits in another array. Derive a class Exam from Test which includes an
array of see marks. Derive a class Result which calculates the grade for each course and the
SGPA. Create n student objects and displays all the above details.*/

import java.util.Scanner;

class Student
{
  public String usn,name;
  public int sem;
  Scanner input =new Scanner(System.in);
  void getdetails()
  {
    System.out.println("Enter your usn and name");
    usn =input.next();
    name =input.next();
    System.out.println("Enter your SEM number");
    sem =input.nextInt();
  }
}

class Test extends Student
{
  Scanner input =new Scanner(System.in);
  int num,cie[],credits[],see[];
  void getdetails2()
  {
    System.out.println("Enter the number of subjects");
    num =input.nextInt();
   cie = new int[num];
   credits = new int[num];
   see =new int[num];
  } 
  void getdetails3()
  {  
    //System.out.println("array"+cie.length);
    for(int i=0;i<num;i++)
    {
       System.out.println("Enter the cie marks and credits of subject "+(i+1));
	   cie[i]=input.nextInt();
	   credits[i]=input.nextInt();
    }
  }	
}

class Exam extends Test
{
  void getdetails4()
  {
    for(int i=0;i<num;i++)
    {
      System.out.println("Enter the SEE marks out of 100 in subject"+(i+1));
	  see[i] =input.nextInt();
    }
  }	
}

class Result extends Exam 
{
  int total=0;
  void displayresult()
  {
	System.out.println("*******************");  
	System.out.println("USN :"+usn+"\nName :"+name+"\nSem :"+sem);
    System.out.println("Your CIE marks in the same order which you entered are :");
	for(int i=0;i<num;i++)
	{
	  System.out.print(cie[i]+" ");
	}
	System.out.println();
	System.out.println("Your credits in the same order which you entered are :");
	for(int i=0;i<num;i++)
	{
	  System.out.print(credits[i]+" ");
	}
	System.out.println();
	System.out.println("Your SEE marks in the same order which you entered are :");
	for(int i=0;i<num;i++)
	{
	  System.out.print(see[i]+" ");
	}
	System.out.println();
    for(int i=0;i<num;i++)
    {
      if((cie[i]+see[i])>=90)
	  {
	    System.out.println("Your scored S grade in subject"+(i+1));
	    total =+(credits[i]*10);
	  }
	  else if((cie[i]+see[i])>90 && (cie[i]+see[i])>=80)
	  {
	    System.out.println("Your scored A grade in subject"+(i+1));
	     total =+(credits[i]*9);
	  }
	 else if((cie[i]+see[i])<80 && (cie[i]+see[i])>=70)
	  {
	   System.out.println("Your scored B grade in subject"+(i+1));
	    total =+(credits[i]*8);
	  }
	  else if((cie[i]+see[i])<70 && (cie[i]+see[i])>=60)
	  {
	   System.out.println("Your scored C grade in subject"+(i+1));
	    total =+(credits[i]*7);
	  }
	  else if((cie[i]+see[i])<60 && (cie[i]+see[i])>=50)
	  {
	   System.out.println("Your scored D grade in subject"+(i+1));
	    total =+(credits[i]*6);
	  }
	  else if((cie[i]+see[i])<50 && (cie[i]+see[i])>=40)
	  {
	    System.out.println("Your scored E grade in subject"+(i+1));
	     total =+(credits[i]*5);
	  }
	  else if((cie[i]+see[i])<40)
	  {
	   System.out.println("Your scored F grade in subject"+(i+1));
	   total =+(credits[i]*0);
	  }
    }
    int totalcredits=0;
	for(int i=0;i<num;i++)
	{
		totalcredits =+credits[i];
	}
     System.out.println("Your SGPA is :"+(total/totalcredits));
  }	 
}

class StudentInheritance
{
    public static void main(String args[])
	{
	   int n;
	   Scanner input =new Scanner(System.in);
	   System.out.println("Enter the number of students");
	   n =input.nextInt();
	   Result s[] =new Result[n];
	   for(int i=0;i<n;i++)
	   {
	     s[i] =new Result();
		 s[i].getdetails();
		 s[i].getdetails2();
		 s[i].getdetails3();
		 s[i].getdetails4();
		 s[i].displayresult();
	   }
	}
}