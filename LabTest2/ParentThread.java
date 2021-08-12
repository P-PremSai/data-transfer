/*Write a program to create a thread‘Squares’that prints the square of numbers from 1 to 10 along with thread name. 
Create another thread ‘Cubes’ that print the cubes of numbers from 1 to 10 along with thread name.Set the name of main 
thread to 'Parent Thread'. Let this print numbers from 1 to 10 along with thread name. The main thread creates the two 
child threads and wait for them to complete. */

class Square implements Runnable
{
    Thread t1;
    Square()
    {
        t1 =new Thread(this);
        t1.setName("Square");
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interrupted");
        }
        
        t1.start();
    }

    public void run()
    {
        System.out.println("Thread Name : "+t1.getName());
        for(int i=1;i<=10;i++)
        {
            System.out.println(i+" Square  : "+(i*i));
        }
    }
}

class Cube implements Runnable
{
    Thread t2;
    Cube()
    {
        t2 =new Thread(this);
        t2.setName("Cube");
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interrupted");
        }
        
        t2.start();
    }

    public void run()
    {
        System.out.println("Thread Name : "+t2.getName());
        for(int i=1;i<=10;i++)
        {
            System.out.println(i+" Cube is : "+(i*i*i));
        }
    }
}
class ParentThread extends Thread
{
    public void run()
    {
        //
        for(int i=1;i<=10;i++)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        ParentThread p =new ParentThread();
        p.setName("Parent Thread");
        System.out.println("Thread Name : "+p.getName());
        p.start();

        Square s =new Square();
        Cube c =new Cube();

        try
        {
            s.t1.join();
            c.t2.join();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}