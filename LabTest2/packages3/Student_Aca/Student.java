/*Create a user-defined package Student_Aca with a class Student with members- usn, name, age, procid and cgpa. Include
methods to accept and display Student details.Create another class Proctor with members- procid, procname.Include methods
to accept and display Proctor details. Import this package in the default package which includes the main method which  
creates n Students and m Proctors, invoke methods appropriately. */

package Student_Aca;

import java.util.Scanner;

public class Student
{
    Scanner input =new Scanner(System.in);
    public String usn,name,procid;
    public int age;
    public double cgpa;

    public void get_details()
    {
        System.out.println("Enter the USN :");
        usn=input.next();
        System.out.println("Enter the Name :");
        name=input.next();
        System.out.println("Enter the Proctor ID :");
        procid=input.next();
        System.out.println("Enter the Age :");
        age=input.nextInt();
        System.out.println("Enter the cgpa :");
        cgpa=input.nextDouble();
    }

    public void display()
    {
        System.out.println("USN :"+usn+"\nName : "+name+"\nProctor ID : "+procid+"\nAge : "+age+"\nCGPA : "+cgpa);
    }
}

