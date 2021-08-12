import java.util.Scanner;

class Age
{
   int years,months;
   Scanner input =new Scanner(System.in);
   
   void getdetails()
   {
      years =input.nextInt();
	  months =input.nextInt();
   }
   
   int reyears()
   {
     return years;
   }
   
   int remonths()
   {
      return months;
   }
}

class Agemain
{
  public static void main(String args[])
  {
    int years,months;
    Scanner input =new Scanner(System.in);
	System.out.println("Names of students are 1.Ramesh and 2.Suresh");
    Age s1 =new Age();
    System.out.println("Enter the age of student Ramesh in years and months");
    s1.getdetails();
	Age s2 =new Age();
    System.out.println("Enter the age of student Suresh in years and months");
    s2.getdetails();
	if(s1.reyears()>s2.reyears())
	{
	   System.out.println("Ramesh age is greater than Suresh");
	}
	else if(s1.reyears()<s2.reyears())
	{
	    System.out.println("Suresh age is greater than Ramesh");
	}
	else if(s1.reyears()==s2.reyears())
	{
	   if(s1.remonths()>s2.remonths())
	   {
	     System.out.println("Ramesh age is greater than Suresh");
	   }
	   else if(s1.remonths()<s2.remonths())
	   {
	      System.out.println("Suresh age is greater than Ramesh");
	   }
	   else if(s1.remonths()==s2.remonths())
	   {
	      System.out.println("Ramesh and Suresh age are equal");
	   }
	}
  }
  
}