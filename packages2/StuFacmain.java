/*Create a package STUD which has a class Student with members Roll,Name,Course_taken .Create another package Faculty which
has a class Staff with members Fname,Department and Courses_handled .Import the two packages in a file that prints student 
details along with faculty details who handles Java*/

import STUD.*;
import Faculty.*;
import java.util.Scanner;
class StuFacmain
{
    public static void main(String args[])
    {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the number of Students : ");
        int m =input.nextInt();
        System.out.println("Enter the number of Staff members : ");
        int n =input.nextInt();

        Student s[] =new Student[m];
        Staff f[] =new Staff[n];
        for(int i=0;i<m;i++)
        {
            s[i] =new Student();
            System.out.println("Enter the details of Student "+(i+1));
            s[i].get_details();
            System.out.println();
        }
        for(int i=0;i<n;i++)
        {
            f[i] =new Staff();
            System.out.println("Enter the details of Staff member "+(i+1));
            f[i].get_details();
            System.out.println();
        }
        System.out.println("Details of the students are : ");
        for(int i=0;i<m;i++)
        {
            s[i].display();
        }
        String a  ="Java";
        System.out.println();
        System.out.println("Details of the Staff who handles Java are : ");
        for(int i=0;i<n;i++)
        {
            boolean ab =f[i].Courses_handled.equals(a);
            if(ab==true)
            {
                f[i].display();
            }
        }
    }
}