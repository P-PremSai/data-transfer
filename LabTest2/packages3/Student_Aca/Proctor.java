/*Create a user-defined package Student_Aca with a class Student with members- usn, name, age, procid and cgpa. Include
methods to accept and display Student details.Create another class Proctor with members- procid, procname.Include methods
to accept and display Proctor details. Import this package in the default package which includes the main method which  
creates n Students and m Proctors, invoke methods appropriately. */

package Student_Aca;

import java.util.Scanner;
public class Proctor
{
    Scanner input =new Scanner(System.in);
    public String procid,procname;

    public void get_details2()
    {
        System.out.println("Enter the Proctor ID :");
        procid =input.next();
        System.out.println("Enter the Proctor Name :");
        procname =input.next();
    }

    public void display2()
    {
        System.out.println("Proctor ID :"+procid+"\nProctor Name :"+procname);
    }
}