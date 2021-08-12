/*Create a user-defined package Student_Aca with a class Student with members- usn, name, age, procid and cgpa. Include
methods to accept and display Student details.Create another class Proctor with members- procid, procname.Include methods
to accept and display Proctor details. Import this package in the default package which includes the main method which  
creates n Students and m Proctors, invoke methods appropriately. */

import Student_Aca.*;
import java.util.Scanner;

class StuPromain
{
    public static void main(String args[])
    {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the number of Students :");
        int n =input.nextInt();
        System.out.println("Enter the number of Proctors :");
        int m =input.nextInt();

        Student s[] =new Student[n];
        Proctor p[] =new Proctor[m];

        for(int i=0;i<n;i++)
        {
            s[i] =new Student();
            System.out.println("Enter the details of Student "+(i+1));
            s[i].get_details();
            System.out.println();
        }
        for(int i=0;i<m;i++)
        {
            p[i] =new Proctor();
            System.out.println("Enter the details of Proctor "+(i+1));
            p[i].get_details2();
            System.out.println();
        }
        System.out.println("Details of the Students are :");
        for(int i=0;i<n;i++)
        {
            s[i].display();
            System.out.println();
        }
        System.out.println("Details of the Proctors are :");
        for(int i=0;i<m;i++)
        {
            p[i].display2();
            System.out.println();
        }
    }
}