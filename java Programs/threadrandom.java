/*Develop a multithreaded Java program to create three threads. First thread generates
random integer for every second and if the value is even, second thread computes the
square of number and prints. If the value is odd, the third thread will print the value of
cube of number. */
import java.util.Random;
class evenNumber implements Runnable
{
    Thread even;
    long square;
    int c;

    evenNumber(int a)
    {
        c=a;
        even =new Thread(this,"Even thread");
        even.start();
    }
    public void run()
    {
        try
        {
            square =c*c;
            System.out.println("Square of the even number is :"+square);
        }
        catch(Exception e)
        {
            System.out.println("Error in even square"+e);
        }
    }
}
class oddNumber implements Runnable
{
    Thread  odd;
    long cube;
    int d;
    oddNumber(int a)
    {
        d=a;
        odd =new Thread(this,"Odd thread");
        odd.start();
    }
    public void run()
    {
        try
        {
            cube = d*d*d;
            System.out.println("Cube of the Odd number is :"+cube);
        }
        catch(Exception e)
        {
            System.out.println("Error in odd cube"+e);
        }
    }
}

class threadrandom
{
    public static void main(String args[])
    {
    
        
        try
        {
            for(int i=0;i<5;i++)
            {
                Random r =new Random();
        int a;
        a =r.nextInt(100);
        System.out.println("Random Number is :"+a);
        if(a%2==0)
        {
            new evenNumber(a);
        }
        else if(a%2!=0)
        {
            new oddNumber(a);
        }
               Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in number"+e);
        }
    }
}