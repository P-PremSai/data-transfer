/*Write a program that demonstrates handling of exceptions in inheritance tree. Assume a company having employees between
 18 to 60 years and company started in 2005. Create a base class called company and derived class called employee
 which extends the base class. In company class, implement a constructor which takes the year of joining of employee in 
 this company and throws the exception Not Possible( ) when the input year of joining <2005. In employee class, implement
  a constructor that  throws an exception if employee’s 18<age >60. */

import java.util.Scanner;

class NotPossible extends Exception
{
    int year;
    NotPossible(int x)
    {
        year =x;
    }
    public String toString()
    {
        return "Year of joining should be greater than 2005.\nYou entered "+year;
    }
}

class AgeCheck extends Exception
{
    int age;
    AgeCheck(int age)
    {
        this.age =age;
    }
    public String toString()
    {
        return "Age should be greater than 18 and less than 60(18<age<60).\nYou entered "+age;
    }
}
class Company 
{
    int year_of_joining;
    Company(int year_of_joining)
    {
        this.year_of_joining =year_of_joining;
    }
    void check_year() throws NotPossible
    {
        if(year_of_joining<2005)
        {
            throw new NotPossible(year_of_joining);
        }
    }
}

class Employee extends Company
{
    int age;
    Employee(int year_of_joining,int age)
    {
        super(year_of_joining);
        this.age =age;
    }

    void check_age() throws AgeCheck
    {
        if(age<18 || age>60)
        {
            throw new AgeCheck(age);
        }
    }

    void display()
    {
        System.out.println("Year of joining is :"+year_of_joining );
        System.out.println("Age is :"+age);
    }
}


class Companymain
{
    public static void main(String args[])
    {
        Scanner input =new Scanner(System.in);
        int year_of_joining,age;
        System.out.println("Enter the year of joining of the Employee");
        year_of_joining =input.nextInt();
        System.out.println("Enter the age :");
        age =input.nextInt();

        Employee e =new Employee(year_of_joining,age);
        try
        {
            e.check_year();
            e.check_age();
        }
        catch(Exception d)
        {
            System.out.println();
            System.out.println(d);
        }    
        System.out.println();
        System.out.println("You entered:");
        e.display();
        
    }
}