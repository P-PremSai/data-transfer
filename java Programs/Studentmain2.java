import java.util.Scanner;
 class Student
 {
    private int sno;
	private String sname;
	private int sage;
	private double scgpa;
	
	void getDetails()
	{
	   System.out.println("Enter the Student details");
	   Scanner s1=new Scanner(System.in);
	   sno =s1.nextInt();
	   sname=s1.next();
	   sage=s1.nextInt();
	   scgpa=s1.nextDouble();
	}
	void printDetails()
	{
	   
	   System.out.println("sno"+sno);
	   System.out.println("sname"+sname);
	   System.out.println("sage"+sage);
	   System.out.println("scgpa"+scgpa);
	   
	}
 }
  
 class Studentmain
 {
   public static void main(String args[])
   {
       Student s1 =new Student();
       s1.getDetails();
	   Student s2 =new Student();
       s2.getDetails();
	   s1.printDetails();
	   s2.printDetails();
   }
 }