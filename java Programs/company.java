/*Suppose a company receptionist generates the time token(number) and distribute it to
single client one at a time and repeats this 10 times with the same client. Write a
program to implement this scenario. */

import java.util.Random;

class token
{
    int i=1;
    synchronized void token_number(int n)
    {
        
        System.out.println(i+".Token Number :"+n);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println();
        i++;
    }
}

class token_caller implements Runnable
{
    int num;
    token target;
    Thread t;
    token_caller(token targ,int n)
    {
        target =targ;
        num =n;
        t =new Thread(this);
        t.start();
    }

    public void run()
    {
        target.token_number(num);
    }
}

class company
{
    public static void main(String args[])
    {
        int number;
        token target =new token();
        for(int i=0;i<10;i++)
        {
            Random rand =new Random();
            number =rand.nextInt(100);
            token_caller tc =new token_caller(target,number);
            try
            {
              tc.t.join();
            }
            catch(InterruptedException ie)
            {
               System.out.println("error");
            }
        }
    }
}