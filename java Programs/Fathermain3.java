/*Write a program that demonstrates handling of exceptions in inheritance tree. Create a base class
called Father and derived class called Son which extends the base class. In Father class,
implement a constructor which takes the age and throws the exception Wrong Age( ) when the input
age=father’s age.*/
import java.util.Scanner;
class Son extends Father
{
    private int detail;
    Son(int a)
    {
        detail =a;
    }

    public String toString()
    {
        return "Son[" + detail + "]";
    }
}

class Fathermain3
{
    static void compute(int a) throws Son
    {
        if(a>50)
        throw new Son(a);
        System.out.println("Age ok");
    }
    public static void main(String args[])
    {
        
        
       
        try
        {
        compute(30);
        compute(60);
        }
         catch(Son e)
        {
        System.out.println("Wrong age"+e);
        }
    }
}
