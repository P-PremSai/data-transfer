/*Create a package STUD which has a class Student with members Roll,Name,Course_taken .Create another package Faculty which
has a class Staff with memebers Fname,Department and Courses_handled .Import the two packages in a file that prints student 
details along with faculty details who handles Java*/

package Faculty;

import java.util.Scanner;

public class Staff 
{
    public String Fname,Department,Courses_handled;
    Scanner input =new Scanner(System.in);
    public void get_details()
    {
        System.out.println("Enter the Name of the Faculty : ");
        Fname =input.next();
        System.out.println("Enter the Department : ");
        Department =input.next();
        System.out.println("Enter the Courses handled : ");
        Courses_handled =input.next();
    }
    
    public void display()
    {
        System.out.println("Name : "+Fname+"\nDepartment : "+Department+"\nCourses handled : "+Courses_handled);
    }
}