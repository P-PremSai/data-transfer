import java.util.Scanner;
 
 class Employee
 {
    String empid,empname;
	int empnohrs;
	double empbasic,emphra,empda,empit,empgross;
	Scanner input =new Scanner(System.in);
	void getdetails()
	{
	   System.out.println("Enter the employee id");
	   empid =input.next();
	   System.out.println("Enter the employee name");
	   empname =input.next();
	   System.out.println("Enter the number of hours you worked");
	   empnohrs =input.nextInt();
	   System.out.println("Enter your  basic salary");
	   empbasic =input.nextDouble();
	   System.out.println("Enter your hra in percentage");
	   emphra =input.nextDouble();
	   System.out.println("Enter your da in percentage");
	   empda =input.nextDouble();
	   System.out.println("Enter your it in percentage");
	   empit =input.nextDouble();
	   
	}
	void grosssalary()
	{
	   empgross =empbasic+((empbasic*emphra)/100)+((empbasic*empda)/100)-((empbasic*empit)/100);
	   System.out.println("Gross salary is : "+empgross);
	}
	/*int reempnohrs()
	{
	  return empnohrs;
	}*/
	void finalsalary()
	{
	   if(empnohrs>200)
	   {
	      empgross =empgross+((empnohrs-200)*100);
		  System.out.println("Final Gross salary is : "+empgross);
	   }
	    else if(empnohrs<200)
	   {
	      empgross =empgross-((200-empnohrs)*100);
		  System.out.println("Final Gross salary is : "+empgross);
	   }
	   else 
	   {
	      System.out.println("Final Gross salary is : "+empgross);
	   }
	}
 }
 
 class Employeemain
 {
    public static void main(String args[])
	{
	    Employee e1 =new Employee();
		e1.getdetails();
		e1.grosssalary();
		e1.finalsalary();
	}
 }