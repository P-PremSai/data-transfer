/*Develop a Java program to implement the hierarchy given below. Include atleast one
appropriate member in each of these classes. Set and display details in each of the class
and create objects of the leaf members in the hierarchy.*/

import java.util.Scanner;

class Person 
{
   Scanner input =new Scanner(System.in);
   String name;
   int day,month,year;
   void get_details()
   {
      System.out.println("Enter the name of the person");
	  name =input.next();
	  System.out.println("Enter the date of birth of the person in dd/mm/yy");
	  day =input.nextInt();
	  month=input.nextInt();
	  year =input.nextInt();
   }
}

class Employee extends Person
{
   String institue_name,id;
   void employee_details()
   {
     System.out.println("Enter the institue name where the employee works");
	 institue_name =input.next();
	 System.out.println("Enter the institue id of the employee");
	 id =input.next();
   }
}

class Student extends Person
{
    String institue_name,id;
	void student_details()
	{
	  System.out.println("Enter the institue name where the student studies");
	  institue_name =input.next();
	  System.out.println("Enter the institue id of the student");
	  id =input.next();
	}
}

class Teaching extends Employee
{
   String subject_name;
   int experience;
   
   void teaching_details()
   {
     System.out.println("Enter the subject they teach");
	 subject_name=input.next();
	 System.out.println("Enter the number of years of experience ");
	 experience=input.nextInt();
   }
   void display()
   {
	 System.out.println("Details of the Employee are :");   
     System.out.println("Name :"+name+"\nDOB :"+day+"/"+month+"/"+year+"\nInstitue name :"+institue_name+"\nInstitue ID :"+id+"\nSubject name :"+subject_name);
     System.out.println(" Number of years of experience :"+experience);
   }
}

class Non_teaching extends Employee
{
   String type_of_work;
   int experience;
   void non_teaching_details()
   {
      System.out.println("Enter the type of work does the employee do");
	  type_of_work =input.next();
	  System.out.println("Enter the number of years of experience of the employee");
	  experience =input.nextInt();
   }
   void display()
   {
	 System.out.println("Details of the Employee are :");  
     System.out.println("Name :"+name+"\nDOB :"+day+"/"+month+"/"+year+"\nInstitue name :"+institue_name+"\nInstitue ID :"+id+"\nType of work :"+type_of_work);
	 System.out.println(" Number of years of experience :"+experience);
   }
}

class UG extends Student
{
	int sem;
	String branch;
	String section;
	void UG_details()
	{
	    System.out.println("Enter the branch of UG student");
		branch =input.next();
		System.out.println("Enter the sem number of the UG student");
		sem =input.nextInt();
		System.out.println("Enter the section of the UG student");
		section =input.next();
	}
    void display()
	{
		 System.out.println("Details of the Studunt are :"); 
	    System.out.println("Name :"+name+"\nDOB :"+day+"/"+month+"/"+year+"\nInstitue name :"+institue_name+"\nInstitue ID :"+id+"\nBranch :"+branch+"\nSem :"+sem+"\nSection :"+section);
	}
}

class PG extends Student
{
    int sem;
	String branch;
	String section;
	void PG_details()
	{
	    System.out.println("Enter the branch of PG student");
		branch =input.next();
		System.out.println("Enter the sem number of the PG student");
		sem =input.nextInt();
		System.out.println("Enter the section of the PG student");
		section =input.next();
	}
    void display()
	{
		 System.out.println("Details of the Student are :"); 
	    System.out.println("Name :"+name+"\nDOB :"+day+"/"+month+"/"+year+"\nInstitue name :"+institue_name+"\nInstitue ID :"+id+"\nBranch :"+branch+"\nSem :"+sem+"\nSection :"+section );
	}
}

class Personmain
{
	 public static void main(String args[])
	 {
		 Scanner input =new Scanner(System.in);
		 int choice1,choice2,choice3;
		 Loop1:for(;;)
		 {	 
		     System.out.println("1.Employee  2.Student  3.Done");
		     System.out.println("Enter your choice");
		     choice1 =input.nextInt();
			 switch(choice1)
			 {   case 1:
			     {
				 Loop2:for(;;)
				 {
					 System.out.println("1.Teaching   2.Non-Teaching   3.Done");
					 System.out.println("Enter your choice");
		             choice2 =input.nextInt();
					 switch(choice2)
					 {
						 case 1:
						 {
						 Teaching t =new Teaching();
						 t.get_details();
						 t.employee_details();
						 t.teaching_details();
						 t.display();
						 System.out.println("********************");
			             break;
						 }
						 case 2:
						 {
							 Non_teaching nt =new Non_teaching();
							 nt.get_details();
						     nt.employee_details();
						     nt.non_teaching_details();
						     nt.display();		                 
							 System.out.println("********************");
							 break;
						 }
						 case 3:
						 {
							 System.out.println("********************");
							 break Loop2;
						 }
					 }
				 }
				 break;
                 }
				 case 2:
				 {
					 Loop3 :for(;;)
					 {
						 System.out.println("1.UG   2.PG  3.Done");
						 System.out.println("Enter your choice");
						 choice3 =input.nextInt();
						 switch(choice3)
						 {
							 case 1:
							 {
								 UG u =new UG();
								 u.get_details();
								 u.student_details();
								 u.UG_details();
								 u.display();
								 System.out.println("********************");
								 break;				 
							 }
							 case 2 :
							 {
								 PG p =new PG();
								 p.get_details();
								 p.student_details();
								 p.PG_details();
								 p.display();
								 System.out.println("********************");
								 break;				 
							 }
							 case 3:
							 {
								 System.out.println("********************");
								 break Loop3;
							 }
						 }
					 }
					 break;
				 }
				 case 3:
				 {
					 break Loop1;
				 }
			 }	  
		 }
	 }
}