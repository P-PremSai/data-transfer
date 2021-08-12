/*Create a package STUD which has a class Student with members Roll,Name,Course_taken .Create another package Faculty which
has a class Staff with memebers Fname,Department and Courses_handled .Import the two packages in a file that prints student 
details along with faculty details who handles Java*/

package STUD;

import java.util.Scanner;

public class Student 
{
    Scanner input =new Scanner(System.in);
    public String Roll,Name,Course_taken;
    public void get_details()
    {
        System.out.println("Enter the Name of Student : ");
        Name =input.next();
        System.out.println("Enter the Rool number : ");
        Roll =input.next();
        System.out.println("Enter the Course taken : ");
        Course_taken =input.next();
    }

    public void display()
    {
        System.out.println("Name : "+Name+"\nRoll Number :"+Roll+"\nCourse Taken :"+Course_taken);
    }
}