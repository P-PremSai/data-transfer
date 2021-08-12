/*Write a program which creates four threads to synchronize and display the following

{USN}

{CSE}

{BMSCE}

{BANGALORE} */

class callme
{
    synchronized void call(String msg)
    {
        System.out.println("{"+msg+"}");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println();
    }
}

class caller implements Runnable
{
    String msg;
    callme target;
    Thread t;
    caller(callme targ, String s)
    {
        target =targ;
        msg =s;
        t=new Thread(this);
        t.start();
    }

    public void run()
    {
        target.call(msg);
    }
}

class syn
{
    public static void main(String args[])
    {
        callme target =new callme();
        caller ob1 =new caller(target,"USN");
        caller ob2 =new caller(target,"CSE");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ae)
        {
            System.out.println("error");
        }
        caller ob3 =new caller(target,"BMSCE");
        caller ob4 =new caller(target,"BANGALORE");

        try
        {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
            ob4.t.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interrupted");
        }
    }
}