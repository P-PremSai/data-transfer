/*Write a Java program to compute the factorial of a number. The input value must be tested
for validity. If it is greater than 15, the method ComputeFactorial( ) should raise an
Userdefined Exception MyException with appropriate messages.*/

import java.util.Scanner;
class GreaterNumber extends Exception
{
    int b;
    GreaterNumber(int a)
    {
        b =a;
    }
    public String toString()
    {
        return"The number you entered is greater than 15";
    }
}
class Factorial
{
    int a;
    Factorial(int num)
    {
        a =num;
    }

void ComputeFactorial() throws GreaterNumber
{
    if(a>15)
    {
         throw new GreaterNumber(a);
    }
    else 
    {
        int factorial=1;
        for(int i=a;i>0;i--)
        {
            factorial=factorial*i;
        }
        System.out.println("Factorial of "+a+" is :"+factorial);
    }
}
}
class factorialexception
{
    public static void main(String args[])
    {
        int num;
        Scanner input =new Scanner(System.in);
        try
        {
            System.out.println("Enter the number:");
            num =input.nextInt();
            Factorial f =new Factorial(num);
            try 
            {
                f.ComputeFactorial();    
            }
            catch(GreaterNumber e)
            {
                System.out.println(e);
            }
        }
        catch(Exception e)
        {
            System.out.println("You should only enter the number");
        }
    }
}