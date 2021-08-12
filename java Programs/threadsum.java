/*Write a program to create a thread and find the sum of odd numbers from 1 to 100 in
this thread. Find the sum of even numbers for the same range in the main thread.*/
class Sum implements Runnable
{
    Thread mythread;
    int sum;
    Sum()
    {
        mythread =new Thread(this,"odd sum thread");
        mythread.start();
    }
    public void run()
    {
        try
        {
            for(int i=1;i<=100;i++)
            {
                if(i%2!=0)
                {
                    sum+=i;
                }
            }
            System.out.println("Sum of Odd numbers from 1 tpo 100 is :"+sum);
        }
        catch(Exception e)
        {
            System.out.println("ERROR in odd sum "+e);
        }
    }
}

class threadsum
{
    public static void main(String args[])
    {
        Sum s =new Sum();
        int sum=0;
        try
        {
            for(int i=1;i<=100;i++)
            {
                if(i%2==0)
                {
                    sum+=i;
                }
            }
            System.out.println("Sum of Even numbers from 1 to 100 is :"+sum);
        }
        catch(Exception e)
        {
            System.out.println("ERROR in even sum");
        }
    }
}