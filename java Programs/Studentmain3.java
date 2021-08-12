/*Create a class Student with members – Rollno, name ,marks1, marks2, marks3, totmarks.
Create n students. Include the following methods:
1. to accept the details
2. to display the details
3. Calculate the total marks of each student and update the member
4. Accept a value say cutoff marks through command line and display the details of all
students who have scored total marks greater than the cutoff marks*/

import java.util.Scanner;

class Student
{
     Scanner input =new Scanner(System.in);
     int Rollno;
     String name;
     int marks1,marks2,marks3,totmarks;
   
     void get_details()
	 {
	     System.out.println("Enter the Rool number");
		 Rollno =input.nextInt();
		 System.out.println("Enter the name of the student");
		 name =input.next();
		 System.out.println("Enter the marks of subject 1");
		 marks1= input.nextInt();
		 System.out.println("Enter the marks of subject 2");
		 marks2= input.nextInt();
		 System.out.println("Enter the marks of subject 3");
		 marks3= input.nextInt();
	 }
     void total_marks()
	 {
	     totmarks =marks1+marks2+marks3;
	 }
	 void display()
	 {
	     System.out.println("Rool number        :"+Rollno);
		 System.out.println("Name               :"+name);
		 System.out.println("Marks of subject 1 :"+marks1);
		 System.out.println("Marks of subject 2 :"+marks2);
		 System.out.println("Marks of subject 3 :"+marks3);
		 System.out.println("Total marks        :"+totmarks);
	 }
	 int return_total()
	 {
	     return totmarks;
	 }
	 
}

class Studentmain3
{
     public static void main(String args[])
	 {
	     Scanner input =new Scanner(System.in);
		 int n,cutoff,count=0;
		 cutoff =Integer.parseInt(args[0]);
		 System.out.println("Enter the number of students");
		 n =input.nextInt();
		 
		 Student s[] =new Student[n];
		 for(int i=0;i<n;i++)
		 {
		     s[i] =new Student();
			 System.out.println("Enter the details of student "+(i+1));
			 s[i].get_details();
			 System.out.println();
			 s[i].total_marks();
		 }
		 for(int i=0;i<n;i++)
		 {
			 System.out.println();
		     System.out.println("Details of student "+(i+1)+" are :");
			 s[i].display();
			 System.out.println("*************************************");
		 }
		 System.out.println("Details of the students who scored above cutoff marks are");
		 for(int i=0;i<n;i++)
		 {
		   if(s[i].return_total()>cutoff)
		   {
		      s[i].display();
			  count++;
			  System.out.println("*************************************");
		   }
		 }
		 System.out.println("Number of Students who scored above cutoff marks are :"+count);
	 }
}