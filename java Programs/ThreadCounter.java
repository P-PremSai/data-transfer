/*Create a class as shown 
class Counter{
    int count;
    void inc()
    {
        count =count+1;
    }
    int getCount(){
        return count;
    }
}
Create three threads that will call the inc() method on the same Counter object .Start them all and wait for all the threads to terminate .
Assign different priority to threads .Justify your output*/

import java.lang.*;

class Counter{
    int count,y;
    void inc(int x)
    {
        y=x;
        count =count+1;
        System.out.println("Incremented by thread "+y);
    }
    int getCount(){
        return count;
    }
}

class call implements Runnable
{
    Thread t;
    Counter cou;
    int x;
    call(Counter c,int o)
    {   
        cou =c;
        x=o;
        if(x==1)
        {
            t =new Thread(this);
            t.setPriority(9);
        }
        if(x==2)
        {
            t =new Thread(this);
            t.setPriority(5);
        }
        if(x==3)
        {
            t =new Thread(this);
            t.setPriority(7);
        }
           
        t.start();
    }

    public void run()
    {
        cou.inc(x);
    }
}



class ThreadCounter
{
    public static void main(String args[])
    {
        int a=1,d=3,b=2;
        Counter c =new Counter();

        call c1 =new call(c,a);
        call c2 =new call(c,b);
        call c3 =new call(c,d);
        
        try
        {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interupted");
        }
        int count_no = c.getCount();
        System.out.println("Count is : "+ count_no);
    }
    
}